package com.ibm.test.first_project.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(indexes = {
        @Index(columnList = "name")
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Color {

    public Color(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Color color = (Color) o;
        return id != null && Objects.equals(id, color.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
