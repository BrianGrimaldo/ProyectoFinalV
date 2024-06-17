package com.example.AgenciaAutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> update(String id, Cliente clienteDetails) {
        return clienteRepository.findById(id)
            .map(cliente -> {
                cliente.setNombre(clienteDetails.getNombre()); // Asume que hay un campo nombre
                // Actualizar otros campos necesarios
                return clienteRepository.save(cliente);
            });
    }

    public boolean delete(String id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}


