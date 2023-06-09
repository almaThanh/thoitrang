package sanpham.thoitrang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sanpham.thoitrang.enity.Produces;
import sanpham.thoitrang.repository.IProducesRepository;
import java.util.List;

@Service
public class ProducesService {
    @Autowired
    private IProducesRepository producesRepository;
    public List<Produces> getAllProduces(){return producesRepository.findAll();}
    public Produces getProducesById(Long id){return producesRepository.findById(id).orElse(null);}
    public Produces saveProduces(Produces produces){return producesRepository.save(produces);}
    public void updateProduces(Produces produces){producesRepository.save(produces);}
    public void deleteProduces(Long id){producesRepository.deleteById(id);}
}
