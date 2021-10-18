/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Service;

import Domingo_Reto3.Reto3.Repository.MessageRepositorio;
import Domingo_Reto3.Reto3.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PERSONALCASA
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepositorio metodsCrud;
    public List<Message>getAll(){
        return metodsCrud.getAll();
    }
    
    public Optional<Message>getMessage(int idMessage){
        return metodsCrud.getMessages(idMessage);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodsCrud.save(message);
        }else{
            Optional<Message> paux=metodsCrud.getMessages(message.getIdMessage());
            if(paux.isEmpty()){
                return metodsCrud.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message mes){
        if(mes.getIdMessage()!=null){
            Optional<Message>g=metodsCrud.getMessages(mes.getIdMessage());
            if(!g.isEmpty()){
                if(mes.getMessageText()!=null){
                    g.get().setMessageText(mes.getMessageText());
                }
                return metodsCrud.save(g.get());
            }
        }
        return mes;

    }

    public boolean deleteMessage(int id){
        Optional<Message> mess=getMessage(id);
        if(!mess.isEmpty()){
            metodsCrud.delete(mess.get());
            return true;
        }
        return false;
}
    
}

