package com.ibm.test.first_project.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(indexes = {
        @Index(columnList = "name")
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Brand {

    public Brand(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "brand")
    @ToString.Exclude
    @JsonIgnore
    private List<Bike> bikes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Brand brand = (Brand) o;
        return id != null && Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
