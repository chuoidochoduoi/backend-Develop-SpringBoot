package org.example.springboottest.baitap.s1b3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    List<Product> products = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        products.add(new Product(1,"A",2));

        return products;
    }

}
