package com.winfred.springboottransactiondemo.service;

import com.winfred.springboottransactiondemo.dto.OrderRequest;
import com.winfred.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
