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
public class ReceiptItemsId implements Serializable {

    private Long receiptId;
    private Long bikeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItemsId that = (ReceiptItemsId) o;
        return receiptId.equals(that.receiptId) && bikeId.equals(that.bikeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, bikeId);
    }
}
