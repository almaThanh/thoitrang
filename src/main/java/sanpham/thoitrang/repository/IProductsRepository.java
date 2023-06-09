package sanpham.thoitrang.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sanpham.thoitrang.enity.Products;

@Repository
public interface IProductsRepository extends JpaRepository<Products,Long>  {
}
