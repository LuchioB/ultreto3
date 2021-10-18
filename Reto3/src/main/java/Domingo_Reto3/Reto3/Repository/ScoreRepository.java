/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Repository;


import Domingo_Reto3.Reto3.Interface.ScoreInterface;
import Domingo_Reto3.Reto3.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PERSONALCASA
 */
@Repository
public class ScoreRepository {

    /**
     *
     */
    @Autowired
     private ScoreInterface crud5;
    
    public List<Score> getAll(){
        return (List<Score>) crud5.findAll();
    }

    public Optional <Score> getScore(int id){
        return crud5.findById(id);
    }

    /**
     *
     * @param score
     * @return
     */
    public Score save(Score score){
        return crud5.save(score);
    }
    public void delete(Score score){
        crud5.delete(score);
    }
}
