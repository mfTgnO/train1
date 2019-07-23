package com.example.demo.controller;

import com.example.demo.dao.solr.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        Iterator<Product> iterator = products.iterator();
        List<Product> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return new JsonResult(list);
    }

    @GetMapping("findById")
    public JsonResult findById(@RequestParam(value = "id") String id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.map((Function<Product, JsonResult>) JsonResult::new).orElseGet(JsonResult::new);
    }

    @GetMapping("/count")
    public JsonResult count() {
        long count = productRepository.count();
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setCount((int) count);
        return jsonResult;
    }

    @DeleteMapping("/deleteById")
    public JsonResult deleteById(@RequestParam(value = "id") String id) {
        productRepository.deleteById(id);
        return new JsonResult();
    }

    @DeleteMapping("/deleteByEntity")
    public JsonResult delete(@RequestParam(value = "id") String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    @DeleteMapping("/deleteAll")
    public JsonResult deleteAll() {
        productRepository.deleteAll();
        return new JsonResult();
    }

    @RequestMapping("/existsById")
    public JsonResult existsById(@RequestParam(value = "id") String id) {
        boolean existsById = productRepository.existsById(id);
        if (existsById) {
            return new JsonResult();
        } else {
            return new JsonResult.Builder().build(JsonResult.Code.FAIL);
        }
    }
}
