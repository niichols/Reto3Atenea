package com.example.reto3.Repository;

import com.example.reto3.Model.Client;
import com.example.reto3.Repository.CRUD.ClientCrudRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> findAll() { //Metodo para la lista de carros que retorne todos los carros.
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){ //Metodo para trae un carro en especifico.
        return clientCrudRepository.findById(id);
    }
    public Client save (Client client){  //Metodo Guardar (Este metodo guarda, actualiza y crea)
        return clientCrudRepository.save(client);
    }
    public void delete(Client client){ //Metodo Eliminar
        clientCrudRepository.delete(client);
    }

}
