/**
 * 
 */
package com.ecommerce.shoppingcart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppingcart.payload.request.ProductRequest;
import com.ecommerce.shoppingcart.payload.response.ProductResponse;
import com.ecommerce.shoppingcart.payload.response.RoleResponse;
import com.ecommerce.shoppingcart.service.ProductService;

/**
 * 
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {
	
	
	private ProductService productService;
	
	ProductController(ProductService productService){
		this.productService = productService;
	}
	
	
	@PostMapping("/addProduct")
	public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
		return productService.addProduct(productRequest);
		
		
	}
	
	@PutMapping("/{productId}")
	public ProductResponse updateProducts(@PathVariable long id, @RequestBody ProductRequest productRequest) {
		return productService.updateProduct(id, productRequest);
		
	}
	
	@GetMapping("/allProducts")
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}
	
	@GetMapping("/{productId}")
	public ProductResponse getProductById(@PathVariable long Id) {
		return productService.getProductById(Id);
	}
	
}
