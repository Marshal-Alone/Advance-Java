package edu.learningspringboot.controller;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
//http:localhost:8080/api/v1/products
@RequiredArgsConstructor
public class Product_Controller {
    private final ProductService productService;

    //handler methods
    @GetMapping("/{id}")
    //http:localhost:8080/api/v1/products/:id
    public ProductResponseDto findProductById( @PathVariable Long id){

        return productService.findProductById(id);
    }

    @GetMapping("/name-and-category")
    public ProductResponseDto findByNameAndCategory(
            @RequestParam
            @NotBlank(message = "name is required")
            String name,

            @RequestParam
            @NotBlank(message = "category is required")
            String Category){
        return productService.findByNameAndCategory(name,Category);
    }

    @GetMapping
    //http:localhost:8080/api/v1/products
    public List<ProductResponseDto> findAllProducts(){

        return productService.findAllProducts();
    }

    @PostMapping
    public ProductResponseDto addProduct
            (
                @RequestBody
                @Valid //enable the validation
                ProductRequestDto productRequestDto
            )
    {
        System.out.println("Added product " + productRequestDto);
        System.out.println("Added product " + productRequestDto.getName());
        return productService.addProduct(productRequestDto);
    }

    @PostMapping("/addMulti")
    public ArrayList <ProductResponseDto> addMultipleProduct
            (
                @RequestBody
                @Valid //enable the validation
                ArrayList<ProductRequestDto> productRequestDto
            )
    {
        System.out.println("Added product " + productRequestDto);
//        System.out.println("Added product " + productRequestDto.getName());
        return productService.addMultipleProduct(productRequestDto);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct
            (
                @PathVariable
                Long id,

                @RequestBody @Valid
                ProductRequestDto productRequestDto
            )
    {
        System.out.println("Updated product " + productRequestDto);
        return productService.updateProduct(id, productRequestDto);
    }

    @PatchMapping("/{id}")
    public ProductResponseDto updateProductPrice
            (
                    @PathVariable Long id,
                    @RequestBody @Valid
                    UpdateProductPrice updateProductPrice
            )
    {
        System.out.println("Price updated to : "+updateProductPrice.getPrice());
        return productService.updateProductPrice(id, updateProductPrice);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        System.out.println("Id : "+id+" deleted");
        productService.deleteProductById(id);
        return "Id : "+id+" deleted";
    }
}
