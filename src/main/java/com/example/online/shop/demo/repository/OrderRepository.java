package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.model.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long id);

    @Query(value = "select sum(sum_price) as sumPrices,created_date as creationDate,code " +
            "from orders o join customer c " +
            "on c.id=o.customer_id " +
            "where c.email =?1 " +
            "group by code; ",nativeQuery = true)
    List<GrouppedOrders> getSumOrder(String email);

    interface GrouppedOrders{
        double getSumPrices();
        String getCreationDate();
        String getCode();
    };

    List<Order> findByCode(String code);

}
