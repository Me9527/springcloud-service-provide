package com.zzp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zzp.dao.ProductMapper;
import com.zzp.pojo.Product;

@Repository
public class ProductImpl implements ProductMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(Product prouct) {
        jdbcTemplate.update("INSERT INTO P_PRODUCT(NAME, DESCRIPT, PRICE) VALUES (?, ?, ?)", prouct.getName(), prouct.getDescrpit(), prouct.getPrice());
    }

    @Override
    public Product getProduct(Long id) {
        List<Product> products = jdbcTemplate.query("select ID, NAME, descrpit, PRICE from P_PRODUCT where ID = ? ", new Object[]{id}, new BeanPropertyRowMapper(Product.class));
        if(products != null && products.size() > 0){
        	Product p = products.get(0);
            return p;
        }else {
            return null;
        }
    }
    
    @Override
    public List<Product> getAllProduct(){
        List<Product> products = jdbcTemplate.query("select ID, NAME, descrpit, PRICE from P_PRODUCT ", new BeanPropertyRowMapper(Product.class));
        return products;
    }
    
    @Override
    public void deleteProductById(Long id) {
        jdbcTemplate.update("DELETE FROM P_PRODUCT WHERE id = ?", id);
    }
}
