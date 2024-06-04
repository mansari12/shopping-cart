/**
 * 
 */
package com.ecommerce.shoppingcart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingcart.model.Product;
import com.ecommerce.shoppingcart.payload.request.ProductRequest;
import com.ecommerce.shoppingcart.payload.response.ProductResponse;
import com.ecommerce.shoppingcart.repository.ProductRepository;
import com.ecommerce.shoppingcart.service.ProductService;
import com.ecommerce.shoppingcart.service.exception.CustomException;

/**
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponse addProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());
		product.setTaxRate(productRequest.getTaxRate());
		product.setCreatedBy(productRequest.getCreatedBy());
		product.setCreatedDate(productRequest.getCreatedDate());
		product.setUpdatedBy(productRequest.getUpdatedBy());
		product.setUpdatedDate(productRequest.getUpdatedDate());
		
		Product saveddProduct = productRepository.save(product);
		
		return mapToResponse(saveddProduct);

	}

	@Override
	public ProductResponse updateProduct(long productId, ProductRequest productRequest) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new CustomException("Product not found"));
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());
		product.setTaxRate(productRequest.getTaxRate());
		product.setUpdatedBy(productRequest.getUpdatedBy());
		product.setUpdatedDate(productRequest.getUpdatedDate());
		
		Product updatedProduct = productRepository.save(product);
		
		return mapToResponse(updatedProduct);
	}
	

	@Override
	public ProductResponse getProductById(long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new CustomException("Product not found"));
		
		return mapToResponse(product);
	}
	

	@Override
	public List<ProductResponse> getAllProducts() {
		
		return productRepository.findAll().stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	

	@Override
	public void deleteProduct(long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new CustomException("Product not found"));
		
		productRepository.delete(product);
		
	}
	
	
	private ProductResponse mapToResponse(Product product) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductId(product.getProductId());
		productResponse.setProductName(product.getProductName());
		productResponse.setProductPrice(product.getProductPrice());
		productResponse.setTaxRate(product.getTaxRate());
		productResponse.setCreatedBy(product.getCreatedBy());
		productResponse.setCreatedDate(product.getCreatedDate());
		productResponse.setUpdatedBy(product.getUpdatedBy());
		productResponse.setUpdatedDate(product.getUpdatedDate());
		
		return productResponse;
		
	}

}
