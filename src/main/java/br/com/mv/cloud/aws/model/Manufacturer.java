//package br.com.mv.cloud.aws.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//
//@Data
//@Entity
//public class Manufacturer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(length = 32, nullable = false)
//    private String manufacturerName;
//
//    @ManyToMany(mappedBy = "manufacturer" )
//    private List<Product> products;
//
//}
