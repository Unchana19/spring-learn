package ku.cs.kafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Menu> menus;
}
