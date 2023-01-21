package com.carsapi.api.model;

import java.util.Date;

import com.carsapi.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarDTO data){
        this.modelo = data.modelo();
        this.fabricante = data.fabricante();
        this.anoModelo = data.anoModelo();
        this.dataFabricacao = data.dataFabricacao();
        this.valor = data.valor();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String modelo;

    @Column(length = 50, nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Date dataFabricacao;

    @Column(nullable = false)
    private Double valor;

    @Column(length = 4, nullable = false)
    private String anoModelo;
}