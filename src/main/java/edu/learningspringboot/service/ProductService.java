package edu.learningspringboot.service;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    //==========> Business Logic Plan

    //fetch project based on gven id
    public ProductResponseDto findProductById(Long id);

    //fetch all the products
    public List<ProductResponseDto> findAllProducts();

    //add product
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto);

    //update
    public ProductResponseDto updateProduct(Long id,ProductRequestDto productRequestDto);

    //delete
    public void deleteProductById(Long id);

    //update product price
    public ProductResponseDto updateProductPrice(UpdateProductPrice updateProductPrice);

}
