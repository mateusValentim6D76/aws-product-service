package br.com.mv.cloud.aws.model;

import br.com.mv.cloud.aws.enums.ColorEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 32, nullable = false)
    private String productName;

    @Column(length = 24, nullable = false)
    private String model;

    @Column(length = 8, nullable = false)
    private String code;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated
    private ColorEnum color;


    @Column(nullable = false)
    private String username;

//    @ManyToMany
//    @JoinTable(
//            name = "product_manufacturer",
//            joinColumns =
//            @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
//    private List<Manufacturer> manufacturer;

    private LocalDateTime createdAt;

    @PrePersist
    protected void prePersistLocalDateTime() {
        this.createdAt = LocalDateTime.now();
    }
}