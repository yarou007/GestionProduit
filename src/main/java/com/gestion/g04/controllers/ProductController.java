package com.gestion.g04.controllers;



import com.gestion.g04.entities.Product;
import com.gestion.g04.services.ProductService;
import com.gestion.g04.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

   @Autowired
    ProductService productService;


    @RequestMapping("/")
    public String home(){
       return "home";
    }

    @RequestMapping("/createProduct")
    public String createProduct(){
        return "CreateProduct";
    }
    @RequestMapping("/saveProduct")
    public String SaveProduct(@ModelAttribute("product") Product product, @RequestParam("dateJsp") String dateController,
                              ModelMap modelMap)
     throws ParseException
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation =  dateFormat.parse(String.valueOf(dateController));
        product.setDateProduct(dateCreation);

        Product p = productService.saveProduct(product);

        String messageController = "The product ID "+p.getIdProduct()+" price :  "+p.getPrixProduct()+" saved";
        modelMap.addAttribute("messageJsp",messageController);

        return "CreateProduct";
        }


     @RequestMapping("/productsList")
    public String ProdcutList(ModelMap modelMap ){
         List<Product> products = productService.getAllProduct();
         modelMap.addAttribute("Products",products);
        return "ProductsList";
     }

     @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long productId,
                                ModelMap modelMap){
            productService.deleteProductById(productId);
         List<Product> products = productService.getAllProduct();
         modelMap.addAttribute("Products",products);
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
    public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("dateJsp") String dateController,
                              ModelMap modelMap)
            throws ParseException
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation =  dateFormat.parse(String.valueOf(dateController));
        product.setDateProduct(dateCreation);

        Product p = productService.saveProduct(product);

        String messageController = "The product ID "+p.getIdProduct()+" price :  "+p.getPrixProduct()+" saved";
        modelMap.addAttribute("messageJsp",messageController);
        List<Product> products = productService.getAllProduct();
        modelMap.addAttribute("Products",products);
        return "ProductsList";
    }


}
