package sanpham.thoitrang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sanpham.thoitrang.enity.Products;
import sanpham.thoitrang.repository.IProductsRepository;

import java.util.List;

@Service
public class ProductsServices {
    @Autowired
    private IProductsRepository productsRepository;
    public List<Products> getAllProducts(){return productsRepository.findAll();}
    public  Products getProductsById(Long id) {return productsRepository.findById(id).orElse(null);}
    public void addProducts(Products products) {productsRepository.save(products);}
    public void deleteProducts(Long id){productsRepository.deleteById(id);}
    public void updateProducts(Products products){productsRepository.save(products);}

}
