package com.gestion.g04;

import com.gestion.g04.entities.Product;
import com.gestion.g04.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class G04ApplicationTests {


	@Autowired
	ProductRepository productRepository;

	@Test
	public void testCreateProduct(){
		Product product = new Product("LG",300.00,new Date());
		productRepository.save(product);
	}

	@Test
	public void testUpdateProduct(){
		Product product = productRepository.findById(1L).get();
		product.setPrixProduct(2500.00);
		productRepository.save(product);
	}
	@Test
	public void testFindProductById(){
		Product product = productRepository.findById(1L).get();
		System.out.println(product.toString());

	}
	@Test
	public void testFindAllProduct(){
		List<Product> LP = productRepository.findAll();
//		for ( Product p : LP ){
//			System.out.println(p.toString());
//		}
		LP.forEach(System.out::println);
	}

	@Test
	public void testDeleteProduct(){
		productRepository.deleteById(6L);
	}

	@Test
	public void testDeleteAllProduct(){
		productRepository.deleteAll();
	}


}
