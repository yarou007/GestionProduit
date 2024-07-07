package com.gestion.g04.controllers;



import com.gestion.g04.entities.Product;
import com.gestion.g04.services.ProductService;
import com.gestion.g04.services.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

   @Autowired
    ProductService productService;


    @GetMapping("/")
    public String home(){
       return "redirect:/productsList";
    }

    @RequestMapping("/createProduct")
    public String createProduct(){
        return "CreateProduct";
    }
    @RequestMapping("/saveProduct")
    public String SaveProduct(@Valid Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "CreateProduct";

        Product p = productService.saveProduct(product);
        return "CreateProduct";
        }


     @RequestMapping("/productsList")
    public String ProductsList(ModelMap modelMap,
                              @RequestParam (name="page", defaultValue = "0") int page ,
                              @RequestParam (name="size", defaultValue = "3")  int size ){

         Page<Product> products = productService.getAllProductByPage(page,size);
         modelMap.addAttribute("Products",products);
         modelMap.addAttribute("pages",new int[products.getTotalPages()]);
         modelMap.addAttribute("currentPage",page);
        return "ProductsList";
     }

     @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long productId,ModelMap modelMap,
                                @RequestParam (name="page", defaultValue = "0") int page ,
                                @RequestParam (name="size", defaultValue = "3")  int size){
            productService.deleteProductById(productId);
         Page<Product> products = productService.getAllProductByPage(page,size);
         modelMap.addAttribute("Products",products);
         modelMap.addAttribute("pages",new int[products.getTotalPages()]);
         modelMap.addAttribute("currentPage",page);
         return "ProductsList";
     }

     @RequestMapping("/showProduct")
    public String showProduct(@RequestParam("id") Long productId,
                              ModelMap modelMap){
          Product p =  productService.getProduct(productId);
         modelMap.addAttribute("Product",p);
         return "EditProduct";
     }
    @RequestMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product, ModelMap modelMap,
                                @RequestParam (name="page", defaultValue = "0") int page ,
                                @RequestParam (name="size", defaultValue = "3")  int size)
    {


        Product p = productService.saveProduct(product);

        List<Product> products = productService.getAllProduct();
        modelMap.addAttribute("Products",products);
        Page<Product> productsPage = productService.getAllProductByPage(page,size);
        modelMap.addAttribute("Products",productsPage);
        modelMap.addAttribute("pages",new int[productsPage.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ProductsList";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
