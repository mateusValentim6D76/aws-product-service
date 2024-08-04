package br.com.mv.cloud.aws.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Data
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String manufacturerName;

    @ManyToMany(mappedBy = "manufacturer" )
    private List<Product> products;

}
