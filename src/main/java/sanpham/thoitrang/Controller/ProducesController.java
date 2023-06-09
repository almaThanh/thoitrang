package sanpham.thoitrang.Controller;

import sanpham.thoitrang.enity.Produces;

import sanpham.thoitrang.services.ProducesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/produces")
public class ProducesController {
    @Autowired
    private ProducesService producesService;

    @GetMapping
    public String showAllProduces(Model model){
        List<Produces> produces = producesService.getAllProduces();
        model.addAttribute("produces",produces);
        return  "produces/list";
    }
    @GetMapping("/add")
    public String addProducesForm(Model model) {
        model.addAttribute("produces", new Produces());
        return "produces/add";
    }

    @PostMapping("/add")
    public String addProduces(@ModelAttribute("produces") Produces produces) {
        producesService.saveProduces(produces);
        return "redirect:/produces";
    }

    @GetMapping("/edit/{id}")
    public String editProducesForm (@PathVariable("id") Long id, Model model){
        Produces editProduces = producesService.getProducesById(id);
        model.addAttribute("produces", editProduces);
        return "produces/edit";
    }
    @PostMapping("/edit/{id}")
    public String editProduces(@PathVariable("id") Long id, @Valid @ModelAttribute("produces") Produces updatedProduces, BindingResult result, Model model) {
        if (updatedProduces == null) {
            return "redirect:/produces";
        }
        producesService.updateProduces(updatedProduces);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduces(@PathVariable("id") Long id) {
        Produces produces = producesService.getProducesById(id);
        if (produces != null) {
            producesService.deleteProduces(id);
        }
        return "redirect:/produces";
    }
}
