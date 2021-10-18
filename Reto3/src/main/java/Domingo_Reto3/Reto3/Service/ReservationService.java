/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Service;

import Domingo_Reto3.Reto3.Repository.ReservationRepository;
import Domingo_Reto3.Reto3.model.Reservation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PERSONALCASA
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository metodsCrud1;
    
    public List<Reservation> getAll(){
        return metodsCrud1.getAll();
    }
    public Optional<Reservation> getReservation(int idReservation){
        return metodsCrud1.getReservation(idReservation);
    }
   public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodsCrud1.save(reservation);
        }else{
            Optional<Reservation> paux=metodsCrud1.getReservation(reservation.getIdReservation());
            if(paux.isEmpty()){
                return metodsCrud1.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation res){
        if(res.getIdReservation()!=null){
            Optional<Reservation>g=metodsCrud1.getReservation(res.getIdReservation());
            if(!g.isEmpty()){
                if(res.getStartDate()!=null){
                    g.get().setStartDate(res.getStartDate());
                }
                if(res.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(res.getDevolutionDate());
                }
                return metodsCrud1.save(g.get());
            }
        }
        return res;

    }

    public boolean deleteReservation(int id){
        Optional<Reservation> ress=getReservation(id);
        if(!ress.isEmpty()){
            metodsCrud1.delete(ress.get());
            return true;
        }
        return false;
}
}

