package com.ibm.test.first_project.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemKey implements Serializable {

    private Long orderId;
    private Long bikeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemKey that = (OrderItemKey) o;
        return orderId.equals(that.orderId) && bikeId.equals(that.bikeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, bikeId);
    }
}
