package sanpham.thoitrang.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sanpham.thoitrang.enity.Produces;
import org.springframework.stereotype.Repository;


@Repository
public interface IProducesRepository extends JpaRepository<Produces,Long>{
}
