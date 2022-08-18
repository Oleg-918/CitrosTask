package com.oleg.document.flow.document.repository;

import com.oleg.document.flow.document.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//    public List<Order> getAttributeOrder() {
//    }
}
