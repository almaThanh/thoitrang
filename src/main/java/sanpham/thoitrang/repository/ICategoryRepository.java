package sanpham.thoitrang.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sanpham.thoitrang.enity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
