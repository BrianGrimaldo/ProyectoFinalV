package com.example.AgenciaAutos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "Vehiculos")
public class Vehicle {
    @Id
    private ObjectId id;
    private String marca; 
    private String modelo; 
    private int año; 
    private double precio;
    private String status;
}
