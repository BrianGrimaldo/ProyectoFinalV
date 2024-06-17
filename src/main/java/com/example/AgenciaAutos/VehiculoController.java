package com.example.AgenciaAutos;


import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehiculoController {

    @Autowired
    private VehiculoService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable ObjectId id) {
        return vehicleService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/Crear")
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> updateVehicle(@PathVariable ObjectId id, @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.update(id, vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable ObjectId id) {
        vehicleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
