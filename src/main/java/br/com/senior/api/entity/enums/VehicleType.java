package br.com.senior.api.entity.enums;

import lombok.Getter;

@Getter
public enum VehicleType {

    CARRO(1, "Carro"),
    MOTO(2, "Moto"),
    LANCHA(3, "Lancha"),
    CAMINHAO(4, "Caminhão"),
    JETSKI(5, "Jetski");

    private int cod;
    private String description;

    private VehicleType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static VehicleType toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (VehicleType x : VehicleType.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("ID inválido" + cod);
    }

}
