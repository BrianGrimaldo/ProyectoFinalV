package com.example.AgenciaAutos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "transactions")
@Data
public class Transaccion {
    @Id
    private String id;
    private String vehicleId;
    private String clientId;
    private double transactionAmount;
    private String transactionDate; // Considerar usar java.time.LocalDate
}
