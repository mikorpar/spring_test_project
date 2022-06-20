package com.ibm.test.first_project.data.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
@Entity
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp

    private Instant createdAt;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private List<OrderItem> items;

    @Transient
    private BigDecimal totalPrice;

    @PostLoad
    private void onLoad() {
        calcTotalPrice();
    }

    private void calcTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0.00);

        for (OrderItem item: items) {
            total = total.add(item.getBike().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        this.totalPrice = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder salesOrder = (SalesOrder) o;
        return id.equals(salesOrder.id) &&
                createdAt.equals(salesOrder.createdAt) &&
                Objects.equals(items, salesOrder.items) &&
                Objects.equals(totalPrice, salesOrder.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, items, totalPrice);
    }
}
