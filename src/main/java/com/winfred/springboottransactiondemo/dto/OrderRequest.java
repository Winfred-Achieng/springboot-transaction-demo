package com.winfred.springboottransactiondemo.dto;

import com.winfred.springboottransactiondemo.entity.Order;
import com.winfred.springboottransactiondemo.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
