package com.example.demo.controller;

import com.example.demo.dao.solr.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Function;

/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-07-17 17:20
 * @description:
 */
@RestController
@RequestMapping("/solr/product")
public class SolrProductController {
    private ProductRepository productRepository;

    @Autowired
    public SolrProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/save")
    public JsonResult save() {
        productRepository.save(new Product("1", "AAA"));
        productRepository.save(new Product("2", "BBB"));
        productRepository.save(new Product("3", "CCC"));
        productRepository.save(new Product("4", "DDD"));
        productRepository.save(new Product("5", "EEE"));
        return new JsonResult();
    }

    @GetMapping("/findAll")
    public JsonResult findAll() {
        Iterable<Product> products = productRepository.findAll();
        return new JsonResult(products);
    }

    @GetMapping("findById")
    public JsonResult findById(@RequestParam(value = "id") String id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.map((Function<Product, JsonResult>) JsonResult::new).orElseGet(JsonResult::new);
    }
}
