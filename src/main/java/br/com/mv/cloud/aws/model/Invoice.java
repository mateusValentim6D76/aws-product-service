package br.com.mv.cloud.aws.model;

import jakarta.persistence.*;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"invoiceNumber"})})
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 32, nullable = false)
    private String invoiceNumber;
    @Column(length = 32, nullable = false)
    private String customName;
    private float totalValue;
    private long productId;
    private int quantity;
}
