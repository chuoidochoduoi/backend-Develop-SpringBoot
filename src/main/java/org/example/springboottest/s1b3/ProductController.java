package org.example.springboottest.s1b3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/test1")
public class ProductController {

    @Autowired
    ProductService productService;

@GetMapping("/api/get")
    public List<Product> getProductList(){

     return    productService.getAllProducts();
    }

}
