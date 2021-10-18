package Domingo_Reto3.Reto3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(length =45 )
    private String name;
    @Column(length =250 )
    private String description;

    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Ortopedic> ortopedic;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ortopedic> getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(List<Ortopedic> ortopedic) {
        this.ortopedic = ortopedic;
    }

   
}