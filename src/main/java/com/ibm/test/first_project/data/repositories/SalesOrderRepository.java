package com.ibm.test.first_project.data.repositories;

import com.ibm.test.first_project.data.models.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

    List<SalesOrder> findOrdersByCreatedAtBetween(Instant startDate, Instant endDate);
}
