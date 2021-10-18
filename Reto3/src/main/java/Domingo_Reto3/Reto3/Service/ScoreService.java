/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Service;

import Domingo_Reto3.Reto3.Repository.ScoreRepository;
import Domingo_Reto3.Reto3.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PERSONALCASA
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository metodsCrud;

    public List<Score> getAll(){
        return metodsCrud.getAll();
    }
    public Optional<Score> getScore(int id){
        return metodsCrud.getScore(id);
            }
    public Score save (Score score){
        if (score.getIdScore()==null) {
            return metodsCrud.save(score);           
        }else{
            Optional<Score> paux=metodsCrud.getScore(score.getIdScore());
            if(paux.isEmpty()){
                return metodsCrud.save(score);
            }else{
                return score;               
            }
        }
}
    public Score update(Score scor){
        if(scor.getIdScore()!=null){
            Optional<Score>g=metodsCrud.getScore(scor.getIdScore());
            if(!g.isEmpty()){
                if(scor.getStars()!=null){
                    g.get().setStars(scor.getStars());
                }
                if(scor.getMessageText()!=null){
                    g.get().setMessageText(scor.getMessageText());
                }
                return metodsCrud.save(g.get());
            }
        }
        return scor;

    }

    public boolean deleteScore(int id){
        Optional<Score> scors=getScore(id);
        if(!scors.isEmpty()){
            metodsCrud.delete(scors.get());
            return true;
        }
        return false;
    }
}
