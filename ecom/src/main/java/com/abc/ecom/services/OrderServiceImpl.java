package com.abc.ecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Order;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public Order saveOrder(Order order) 
	{
		Order saveOrder= orderRepository.save(order);
		return saveOrder;
	}

	@Override
	public Order getOrderDetails(int orderId) 
	{
		Optional<Order> order=  orderRepository.findById(orderId);
		if(order.isEmpty())
		{
			throw new ResourceNotFoundException("order not found with order id");
		}
		return null;
	}

}
