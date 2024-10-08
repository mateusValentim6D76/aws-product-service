package br.com.mv.cloud.aws.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"invoiceNumber"})})
@Entity
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 32, nullable = false)
    private String invoiceNumber;
    @Column(length = 32, nullable = false)
    private String customerName;
    private float totalValue;
    private long productId;
    private int quantity;
}
