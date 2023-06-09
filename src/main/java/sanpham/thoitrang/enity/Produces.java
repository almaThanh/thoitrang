package sanpham.thoitrang.enity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name="produces")
public class Produces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "produces", cascade = CascadeType.ALL)
    private List<Products> products;
}
