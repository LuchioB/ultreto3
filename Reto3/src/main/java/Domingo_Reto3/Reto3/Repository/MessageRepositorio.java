/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Repository;


import Domingo_Reto3.Reto3.Interface.MessageInterface;
import Domingo_Reto3.Reto3.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PERSONALCASA
 */
@Repository
public class MessageRepositorio {
    
    @Autowired
    private MessageInterface crud2;
    
    public List<Message> getAll(){
        return (List<Message>) crud2.findAll();
    }
    public Optional <Message> getMessages(int id){
        return crud2.findById(id);
    }
    public Message save(Message messages){
        return crud2.save(messages);
    }
    public void delete(Message message){
        crud2.delete(message);
    }
}
