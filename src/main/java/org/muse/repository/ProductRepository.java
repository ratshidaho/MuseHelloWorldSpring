package org.muse.repository;

import org.muse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where name like %:name% OR description like %:name%")
    List<Product> findAllByName2(@Param("name") String name);

    List<Product> findAllByNameOrDescription(String name, String description);

    List<Product> findAllByPriceIsLessThan(double price);

    @Query("select p from Product p where price < :price")
    List<Product> findAllWherePriceIsLessThan2(@Param("price") double price);
}
