/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Service;


import Domingo_Reto3.Reto3.Repository.ClientsRepositorio;
import Domingo_Reto3.Reto3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PERSONALCASA
 */
@Service
public class ClientsService {
     @Autowired
   private ClientsRepositorio metodsCrud2;
    public List<Client>getAll(){
        return metodsCrud2.getAll();
    }
    
    public Optional<Client>getClients(int idClient){
        return metodsCrud2.getClients(idClient);
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodsCrud2.save(client);
        }else{
            Optional<Client> paux=metodsCrud2.getClients(client.getIdClient());
            if(paux.isEmpty()){
                return metodsCrud2.save(client);
            }else{
                return client;
            }   
        }  
}
    public Client update(Client cli){
        if(cli.getIdClient()!=null){
            Optional<Client>g=metodsCrud2.getClients(cli.getIdClient());
            if(!g.isEmpty()){
                if(cli.getName()!=null){
                    g.get().setName(cli.getName());
                }
                if(cli.getEmail()!=null){
                    g.get().setEmail(cli.getEmail());
                }

                if(cli.getAge()!=null){
                    g.get().setAge(cli.getAge());
                }
                if(cli.getPassword()!=null){
                    g.get().setPassword(cli.getPassword());
                }
                return metodsCrud2.save(g.get());
            }
        }
        return cli;

    }

    public boolean deleteClient(int id){
        Optional<Client> clie=getClients(id);
        if(!clie.isEmpty()){
            metodsCrud2.delete(clie.get());
            return true;
        }
        return false;
}
}
