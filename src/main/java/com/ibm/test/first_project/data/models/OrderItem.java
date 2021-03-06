package com.ibm.test.first_project.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity
public class OrderItem implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private OrderItemKey id = new OrderItemKey();

    @ManyToOne
    @MapsId("orderId")
    @ToString.Exclude
    @JsonBackReference
    private SalesOrder salesOrder;

    @ManyToOne
    @MapsId("bikeId")
    @ToString.Exclude
    private Bike bike;

    @Column(nullable = false)
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) &&
                salesOrder.equals(orderItem.salesOrder) &&
                bike.equals(orderItem.bike) &&
                quantity.equals(orderItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salesOrder, bike, quantity);
    }
}
