package org.muse.resource;

import org.muse.entities.Product;
import org.muse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/product/save", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
    public @ResponseBody Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/product/filter/name", method = RequestMethod.GET)
    public List<Product> filterByName(String name) {
        return productRepository.findAllByNameOrDescription(name, name);
    }

    @RequestMapping(value = "/product/filter/name2", method = RequestMethod.GET)
    public List<Product> filterByName2(String name) {
        return productRepository.findAllByName2(name);
    }

    @RequestMapping(value = "/product/filter/price/less")
    public List<Product> findAllByPriceLessThan(double price) {
        return productRepository.findAllByPriceIsLessThan(price);
    }

    @RequestMapping(value = "/product/filter/price/less2")
    public List<Product> findAllByPriceLessThan2(double price) {
        return productRepository.findAllWherePriceIsLessThan2(price);
    }
}
