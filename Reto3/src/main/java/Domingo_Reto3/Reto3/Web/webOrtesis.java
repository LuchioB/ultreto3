package Domingo_Reto3.Reto3.Web;



import Domingo_Reto3.Reto3.Service.ortesisService;
import Domingo_Reto3.Reto3.model.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class webOrtesis {

    @Autowired
    private ortesisService servicios;

    @GetMapping("/all")
    public List<Ortopedic> getOrtopedic(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id") int id){
        return servicios.getOrtesis(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save(@RequestBody Ortopedic ort){
        return servicios.save(ort);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ort){
        return servicios.update(ort);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteOrtopedic(@PathVariable("id") int id){
        return servicios.deleteOrtopedic(id);
    }






}
