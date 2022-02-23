package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Order;
import com.abc.ecom.entity.Product;

public interface OrderRepository extends  JpaRepository<Order,Integer>
{

}
