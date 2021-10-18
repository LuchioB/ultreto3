package Domingo_Reto3.Reto3.Service;


import Domingo_Reto3.Reto3.Repository.CategoriaRepositorio;
import Domingo_Reto3.Reto3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServie {
    @Autowired
    private CategoriaRepositorio metodsCrud;

    public List<Category>getAll(){
        return metodsCrud.getAll();
    }
    public Optional<Category>getCategoria(int id){
        return metodsCrud.getCategoria(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return metodsCrud.save(category);
        }else{
            Optional<Category> paux=metodsCrud.getCategoria(category.getId());
            if(paux.isEmpty()){
                return metodsCrud.save(category);
            }else{
                return category;
            }
        }
    }
    public Category update(Category cat){
        if(cat.getId()!=null){
            Optional<Category>g=metodsCrud.getCategoria(cat.getId());
            if(!g.isEmpty()){
                if(cat.getName()!=null){
                    g.get().setName(cat.getName());
                }
                if(cat.getDescription()!=null){
                    g.get().setDescription(cat.getDescription());
                }
                return metodsCrud.save(g.get());

            }
        }
        return cat;

    }
    public boolean deleteCategory2(int id){
        Optional<Category> cat=getCategoria(id);
        if(!cat.isEmpty()){
            metodsCrud.delete(cat.get());
            return true;
        }
        return false;

    }


}
