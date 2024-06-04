/**
 * 
 */
package com.ecommerce.shoppingcart.service;

import java.util.List;

import com.ecommerce.shoppingcart.payload.request.ProductRequest;
import com.ecommerce.shoppingcart.payload.response.ProductResponse;

/**
 * 
 */
public interface ProductService {
	
	ProductResponse addProduct(ProductRequest productRequest);
	ProductResponse updateProduct(long productId, ProductRequest productRequest);
	ProductResponse getProductById(long productId);
	List<ProductResponse> getAllProducts();
	void deleteProduct(long productId);

}
