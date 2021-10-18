/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Repository;


import Domingo_Reto3.Reto3.Interface.ClientsInterface;
import Domingo_Reto3.Reto3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PERSONALCASA
 */
@Repository
public class ClientsRepositorio {
    @Autowired
    private ClientsInterface crud3;

    public List<Client> getAll(){
        return (List<Client>) crud3.findAll();
    }

    public Optional <Client> getClients(int id){
        return crud3.findById(id);
    }
    public Client save(Client clients){
        return crud3.save(clients);
    }
    public void delete(Client client){
        crud3.delete(client);
    }
   
}
