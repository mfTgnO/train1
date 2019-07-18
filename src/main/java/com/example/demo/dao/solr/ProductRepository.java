package com.example.demo.dao.solr;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * @package: com.example.demo.dao.solr
 * @author:
 * @email:
 * @createDate: 2019-07-17 16:56
 * @description:
 */
public interface ProductRepository extends SolrCrudRepository<Product, String> {
//    List<Product> findByName();

    @Query("id:*?0* OR name:*?0*")
    Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);

    /*@Query(name = "Product.findByNamedQuery")
    Page<Product> findByNameQuery(String searchTerm, Pageable pageable);*/
}
