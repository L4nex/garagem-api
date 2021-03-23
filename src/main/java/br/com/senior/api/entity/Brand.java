package br.com.senior.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date brandCreationDate;

    @Size(max = 250, message = "A cidade de criação pode ter no máximo 250 caracteres")
    private String brandCreationCity;

    @Size(max = 5, message = "A sigla pode ter no máximo 5 caracteres")
    private String abbreviation;

    @OneToMany(targetEntity = Vehicle.class, fetch = FetchType.LAZY, mappedBy = "brand")
    private List<Vehicle> vehicles = new ArrayList<>();

}
