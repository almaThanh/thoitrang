package sanpham.thoitrang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sanpham.thoitrang.enity.Products;
import sanpham.thoitrang.services.CategoryService;
import sanpham.thoitrang.services.ProductsServices;
import sanpham.thoitrang.services.ProducesService;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsServices productsServices;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProducesService producesService;

    @GetMapping
    public String showAllProducts(Model model){
        List<Products> products = productsServices.getAllProducts();
        model.addAttribute("products",products);
        return "products/list";
    }
    @GetMapping("/add")
    public String addProductsForm(Model model)
    {
        model.addAttribute("products",new Products());
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("produces", producesService.getAllProduces());
        model.addAttribute("listProducts", productsServices.getAllProducts());
        return "products/add";
    }
    @PostMapping("/add")
    public String addProducts(@Valid @ModelAttribute("products")Products products, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("produces", producesService.getAllProduces());
            model.addAttribute("listProducts", productsServices.getAllProducts());
            return "products/add";
        }
        productsServices.addProducts(products);
//return "redirect:/products";
        return "redirect:/products/list";
    }
    @GetMapping("/edit/{id}")
    public String editProductsForm(@PathVariable("id") Long id, Model model)
    {
        Products editProducts = productsServices.getProductsById(id);
        if (editProducts != null)
        {
            model.addAttribute("products",editProducts);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "products/edit";
        }
        else
        {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editProducts(@ModelAttribute("products")Products products)
    {
        productsServices.updateProducts(products);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProducts(@PathVariable("id") Long id){
        productsServices.deleteProducts(id);
        return "redirect:/products";
    }
}
