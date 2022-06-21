package com.ibm.test.first_project.data.repositories;

import com.ibm.test.first_project.data.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike,Long> {
    List<Bike> findAll();
    List<Bike> findAllByBrand(String brand);

    @Query(value = "SELECT B FROM Bike AS B " +
            "JOIN OrderItem AS OI ON B.id = OI.id.bikeId " +
            "JOIN SalesOrder SA ON SA.id = OI.id.orderId " +
            "WHERE B.brand = ?1 AND B.color = ?2 AND " +
            "YEAR (SA.createdAt) >= YEAR (CURRENT_DATE) AND YEAR (SA.createdAt) < YEAR (CURRENT_DATE) + 1")
    List<Bike> findAllByBrandAndColorAndOrderedThisYear(String brand, String color);

    @Query(value = "SELECT B FROM Bike AS B " +
            "JOIN OrderItem AS OI ON B.id = OI.id.bikeId " +
            "JOIN SalesOrder SA ON SA.id = OI.id.orderId " +
            "WHERE B.brand = ?1 AND YEAR (SA.createdAt) >= YEAR (CURRENT_DATE) AND YEAR (SA.createdAt) < YEAR (CURRENT_DATE) + 1")
    List<Bike> findAllByBrandAndOrderedThisYear(String color);

    @Query(value = "SELECT B FROM Bike AS B " +
            "JOIN OrderItem AS OI ON B.id = OI.id.bikeId " +
            "JOIN SalesOrder SA ON SA.id = OI.id.orderId " +
            "WHERE B.color = ?1 AND " +
            "YEAR (SA.createdAt) >= YEAR (CURRENT_DATE) AND YEAR (SA.createdAt) < YEAR (CURRENT_DATE) + 1")
    List<Bike> findAllByColorAndOrderedThisYear(String color);
}
