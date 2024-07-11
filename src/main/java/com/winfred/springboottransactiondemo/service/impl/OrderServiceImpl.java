package com.winfred.springboottransactiondemo.service.impl;

import com.winfred.springboottransactiondemo.dto.OrderRequest;
import com.winfred.springboottransactiondemo.dto.OrderResponse;
import com.winfred.springboottransactiondemo.entity.Order;
import com.winfred.springboottransactiondemo.entity.Payment;
import com.winfred.springboottransactiondemo.exception.PaymentException;
import com.winfred.springboottransactiondemo.repository.OrderRepository;
import com.winfred.springboottransactiondemo.repository.PaymentRepository;
import com.winfred.springboottransactiondemo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order =orderRequest.getOrder();
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        order.setStatus("INPROGRESS");
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type is not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");


        return orderResponse;
    }
}
