package com.example.AgenciaAutos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, ObjectId> {
    // Aquí puedes definir métodos adicionales si es necesario
}
