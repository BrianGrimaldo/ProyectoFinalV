package com.example.AgenciaAutos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    // Aquí puedes definir métodos adicionales si es necesario
}
