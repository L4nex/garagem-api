package br.com.senior.api.entity;

import br.com.senior.api.entity.enums.VehicleType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String year;

    private BigDecimal price;

    private Date PurchaseDate;

    private Integer vehicleType;

    @ManyToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    private Brand brand;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType.getCod();
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType.getCod();
    }

    public VehicleType getTipo() {
        return VehicleType.toEnum(vehicleType);
    }
}
