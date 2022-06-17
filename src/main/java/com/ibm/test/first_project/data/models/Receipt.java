package com.ibm.test.first_project.data.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity
public class Receipt {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Instant createdAt;

    @OneToMany(mappedBy = "receipt")
    @ToString.Exclude
    private List<ReceiptItems> items;

    @Transient
    private BigDecimal totalPrice;

    @PostLoad
    private void onLoad() {
        calcTotalPrice();
    }

    private void calcTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0.00);

        for (ReceiptItems item: items) {
            total = total.add(item.getBike().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        this.totalPrice = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return id.equals(receipt.id) &&
                createdAt.equals(receipt.createdAt) &&
                Objects.equals(items, receipt.items) &&
                Objects.equals(totalPrice, receipt.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, items, totalPrice);
    }
}
