package Domingo_Reto3.Reto3.Repository;


import Domingo_Reto3.Reto3.Interface.OrtesisInterface;
import Domingo_Reto3.Reto3.model.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class OrtesisRepository {

    @Autowired
    private OrtesisInterface crud;

    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) crud.findAll();
    }

    public Optional <Ortopedic> getOrtesis(int id){
        return crud.findById(id);
    }
    public Ortopedic save(Ortopedic ortesis){
        return crud.save(ortesis);
    }

        public void delete(Ortopedic p){
        crud.delete(p);
    }

}
