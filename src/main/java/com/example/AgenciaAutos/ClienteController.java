package com.example.AgenciaAutos;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClienteController {

    @Autowired
    private ClienteService clientService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable ObjectId id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable ObjectId id, @RequestBody Cliente client) {
        return clientService.update(id, client)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable ObjectId id) {
        if (clientService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
