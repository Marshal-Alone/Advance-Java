package edu.learningspringboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;


@Entity
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

     @Column(nullable = false,length = 50)
    private String Category;

     @Column(precision = 10,scale = 2,nullable = false)
    private BigDecimal price; //in RT prefer BigDecimal

    @CreationTimestamp
     @Column(nullable = false,updatable = false)
    private Instant createdAt;
}
