package com.example.AgenciaAutos;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends MongoRepository<Vehicle,ObjectId> {
    // Métodos adicionales si se necesitan
}
