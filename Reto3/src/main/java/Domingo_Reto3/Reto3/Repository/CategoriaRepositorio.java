package Domingo_Reto3.Reto3.Repository;


import Domingo_Reto3.Reto3.Interface.CategoryInterfae;
import Domingo_Reto3.Reto3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class CategoriaRepositorio {
      @Autowired
    private CategoryInterfae crud1;

    public List<Category>getAll(){
        return (List<Category>) crud1.findAll();
    }

    public Optional<Category>getCategoria(int id){
        return crud1.findById(id);
    }
    public Category save(Category categoria){
        return crud1.save(categoria);
    }
    public void delete(Category categoria){
        crud1.delete(categoria);
    }
}
