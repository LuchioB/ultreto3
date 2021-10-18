package Domingo_Reto3.Reto3.Service;

import Domingo_Reto3.Reto3.Repository.OrtesisRepository;
import Domingo_Reto3.Reto3.model.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ortesisService {

    @Autowired
    private OrtesisRepository metodsCrud;

    public List<Ortopedic> getAll(){
        return metodsCrud.getAll();
    }

    public Optional<Ortopedic> getOrtesis(int id){
        return metodsCrud.getOrtesis(id);
            }

    public Ortopedic save(Ortopedic ortopedic){
        if(ortopedic.getId()==null){
            return metodsCrud.save(ortopedic);
        }else{
            Optional<Ortopedic> paux=metodsCrud.getOrtesis(ortopedic.getId());
            if(paux.isEmpty()){
                return metodsCrud.save(ortopedic);
            }else{
                return ortopedic;
            }
        }
    }

    public Ortopedic update(Ortopedic Ort){
        if(Ort.getId()!=null){
            Optional<Ortopedic>g=metodsCrud.getOrtesis(Ort.getId());
            if(!g.isEmpty()){
                if(Ort.getBrand()!=null){
                    g.get().setBrand(Ort.getBrand());
                }
                if(Ort.getDescription()!=null){
                    g.get().setName(Ort.getName());
                }

                if(Ort.getYear()!=null){
                    g.get().setYear(Ort.getYear());
                }
                if(Ort.getDescription()!=null){
                    g.get().setDescription(Ort.getDescription());
                }
                return metodsCrud.save(g.get());
            }
        }
        return Ort;

    }

    public boolean deleteOrtopedic(int id){
        Optional<Ortopedic> Ort=getOrtesis(id);
        if(!Ort.isEmpty()){
            metodsCrud.delete(Ort.get());
            return true;
        }
        return false;

    }

}
