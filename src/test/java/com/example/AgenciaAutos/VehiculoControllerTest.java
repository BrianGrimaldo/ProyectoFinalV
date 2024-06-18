package com.example.AgenciaAutos;

import org.bson.types.ObjectId;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class VehiculoControllerTest {
  @Mock
  private VehiculoService vehicleService;

  @InjectMocks
  private VehiculoController vehiculoController;

  private Vehicle exampleVehicle;

  @BeforeEach
  void setUp() {

    exampleVehicle = new Vehicle();
    exampleVehicle.setId(new ObjectId("666fae27a432b458307b9cc4"));
    exampleVehicle.setMarca("Toyota");
    exampleVehicle.setModelo("Yaris");
    exampleVehicle.setAño(2018);
    exampleVehicle.setPrecio(50000);
    exampleVehicle.setStatus("Disponible");

  }

  @Test
  void getAllVehicles() {
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(exampleVehicle);

    when(vehicleService.findAll()).thenReturn(vehicles);

    ResponseEntity<List<Vehicle>> response = vehiculoController.getAllVehicles();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(1, response.getBody().size());
    assertEquals("Toyota", response.getBody().get(0).getMarca());
    verify(vehicleService).findAll();
  }

  @Test
  void getVehicleById() {
    ObjectId id = new ObjectId("666fae27a432b458307b9cc4");
    when(vehicleService.findById(id)).thenReturn(Optional.of(exampleVehicle));

    ResponseEntity<Vehicle> response = vehiculoController.getVehicleById(id);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("Yaris", response.getBody().getModelo());
    verify(vehicleService).findById(id);
  }

  @Test
  void saveVehicle() {
    when(vehicleService.save(any(Vehicle.class))).thenReturn(exampleVehicle);

    ResponseEntity<Vehicle> response = vehiculoController.saveVehicle(exampleVehicle);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(2018, response.getBody().getAño());
    verify(vehicleService).save(any(Vehicle.class));
  }

  @Test
  void updateVehicle() {
    ObjectId id = new ObjectId("666fae27a432b458307b9cc4");
    when(vehicleService.update(eq(id), any(Vehicle.class))).thenReturn(Optional.of(exampleVehicle));

    ResponseEntity<Optional<Vehicle>> response = vehiculoController.updateVehicle(id, exampleVehicle);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(response.getBody().isPresent());
    assertEquals("Disponible", response.getBody().get().getStatus());
    verify(vehicleService).update(eq(id), any(Vehicle.class));
  }





}


