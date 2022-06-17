package com.ibm.test.first_project.data.models;

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
public class ReceiptItems implements Serializable {

    @EmbeddedId
    private ReceiptItemsId id;

    @ManyToOne
    @MapsId("receiptId")
    @ToString.Exclude
    private Receipt receipt;

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
        ReceiptItems that = (ReceiptItems) o;
        return receipt.equals(that.receipt) && bike.equals(that.bike) && quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receipt, bike, quantity);
    }
}
