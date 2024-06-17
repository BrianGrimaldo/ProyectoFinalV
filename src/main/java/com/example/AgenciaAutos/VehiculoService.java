package com.example.AgenciaAutos;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Obtener todos los vehículos
    public List<Vehicle> findAll() {
        return vehiculoRepository.findAll();
    }

    // Obtener un vehículo por su ID
    public Optional<Vehicle> findById(ObjectId id) {
        return vehiculoRepository.findById(id);
    }

    // Guardar un vehículo
    public Vehicle save(Vehicle vehicle) {
        return vehiculoRepository.save(vehicle);
    }

    // Actualizar un vehículo
    public Optional<Vehicle> update(ObjectId id, Vehicle vehicleDetails) {
        return vehiculoRepository.findById(id)
            .map(vehicle -> {
                vehicle.setMarca(vehicleDetails.getMarca()); // Asumiendo que tienes setMarca
                vehicle.setModelo(vehicleDetails.getModelo()); // Asumiendo que tienes setModelo
                vehicle.setAño(vehicleDetails.getAño()); // Asumiendo que tienes setAño
                vehicle.setPrecio(vehicleDetails.getPrecio()); // Asumiendo que tienes setPrecio
                vehicle.setStatus(vehicleDetails.getStatus()); // Asumiendo que tienes setStatus
                return vehiculoRepository.save(vehicle);
            });
    }

    // Eliminar un vehículo
    public boolean delete(ObjectId id) {
        if (vehiculoRepository.existsById(id)) {
            vehiculoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
