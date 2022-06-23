package com.ibm.test.first_project.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(indexes = {
        @Index(columnList = "brand_id"),
        @Index(columnList = "color_id"),
        @Index(columnList = "brand_id, color_id")
})
@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @ToString.Exclude
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @ToString.Exclude
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @OneToMany(mappedBy = "bike")
    @ToString.Exclude
    @JsonIgnore
    private List<OrderItem> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return id.equals(bike.id) &&
                name.equals(bike.name) &&
                brand.equals(bike.brand) &&
                price.equals(bike.price) &&
                color.equals(bike.color) &&
                Objects.equals(items, bike.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, price, color , items);
    }
}
