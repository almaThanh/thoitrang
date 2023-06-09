package sanpham.thoitrang.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private Double price;

    @Column(name="description")
    private String description;

    @Column(length = 64)
    private String image;

    @Column(name="publish_date")
    private Date publish_date;

    @Column(name = "last_update_time")
    private  Date last_update_time;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "produce_id")
    private Produces produces;
}
