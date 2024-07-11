package com.winfred.springboottransactiondemo.controller;


import com.winfred.springboottransactiondemo.dto.OrderRequest;
import com.winfred.springboottransactiondemo.dto.OrderResponse;
import com.winfred.springboottransactiondemo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {

        return new ResponseEntity<>(orderService.placeOrder(orderRequest), HttpStatus.OK);
    }


}
