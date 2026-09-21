package edu.learningspringboot.controller;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.ApiResponseDto;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class Product_Controller {

    private final ProductService productService;


    // =========================================================
    // 1. GET PRODUCT BY ID
    // GET /api/v1/products/{id}
    // =========================================================

    @GetMapping("/{id}")
    public ApiResponseDto<ProductResponseDto> findProductById(
            @PathVariable Long id,
            HttpServletRequest request) {

        return ApiResponseDto.success(
                "Product fetched successfully",
                HttpStatus.OK.value(),
                productService.findProductById(id),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 2. GET ALL PRODUCTS
    // GET /api/v1/products
    // =========================================================

    @GetMapping
    public ApiResponseDto<?> findAllProducts(
            HttpServletRequest request) {

        return ApiResponseDto.success(
                "Products fetched successfully",
                HttpStatus.OK.value(),
                productService.findAllProducts(),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 3. FIND BY NAME AND CATEGORY
    // GET /api/v1/products/name-and-category
    // =========================================================

    @GetMapping("/name-and-category")
    public ApiResponseDto<ProductResponseDto> findByNameAndCategory(
            @RequestParam
            @NotBlank(message = "name is required")
            String name,

            @RequestParam
            @NotBlank(message = "category is required")
            String Category,

            HttpServletRequest request) {

        return ApiResponseDto.success(
                "Product fetched successfully",
                HttpStatus.OK.value(),
                productService.findByNameAndCategory(
                        name,
                        Category
                ),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 4. ADD PRODUCT
    // POST /api/v1/products
    // =========================================================

    @PostMapping
    public ApiResponseDto<ProductResponseDto> addProduct(
            @RequestBody
            @Valid
            ProductRequestDto productRequestDto,

            HttpServletRequest request) {

        System.out.println(
                "Added product " + productRequestDto
        );

        return ApiResponseDto.success(
                "Product added successfully",
                HttpStatus.CREATED.value(),
                productService.addProduct(productRequestDto),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 5. ADD MULTIPLE PRODUCTS
    // POST /api/v1/products/addMulti
    // =========================================================

    @PostMapping("/addMulti")
    public ApiResponseDto<ArrayList<ProductResponseDto>> addMultipleProduct(
            @RequestBody
            @Valid
            ArrayList<ProductRequestDto> productRequestDto,

            HttpServletRequest request) {

        System.out.println(
                "Added products " + productRequestDto
        );

        return ApiResponseDto.success(
                "Products added successfully",
                HttpStatus.CREATED.value(),
                productService.addMultipleProduct(
                        productRequestDto
                ),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 6. UPDATE PRODUCT
    // PUT /api/v1/products/{id}
    // =========================================================

    @PutMapping("/{id}")
    public ApiResponseDto<ProductResponseDto> updateProduct(
            @PathVariable Long id,

            @RequestBody
            @Valid
            ProductRequestDto productRequestDto,

            HttpServletRequest request) {

        System.out.println(
                "Updated product " + productRequestDto
        );

        return ApiResponseDto.success(
                "Product updated successfully",
                HttpStatus.OK.value(),
                productService.updateProduct(
                        id,
                        productRequestDto
                ),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 7. UPDATE PRODUCT PRICE
    // PATCH /api/v1/products/{id}
    // =========================================================

    @PatchMapping("/{id}")
    public ApiResponseDto<ProductResponseDto> updateProductPrice(
            @PathVariable Long id,

            @RequestBody
            @Valid
            UpdateProductPrice updateProductPrice,

            HttpServletRequest request) {

        System.out.println(
                "Price updated to : "
                        + updateProductPrice.getPrice()
        );

        return ApiResponseDto.success(
                "Product price updated successfully",
                HttpStatus.OK.value(),
                productService.updateProductPrice(
                        id,
                        updateProductPrice
                ),
                request.getRequestURI()
        );
    }


    // =========================================================
    // 8. DELETE PRODUCT
    // DELETE /api/v1/products/{id}
    // =========================================================

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteProductById(
            @PathVariable Long id,
            HttpServletRequest request) {

        System.out.println(
                "Id : " + id + " deleted"
        );

        productService.deleteProductById(id);

        return ApiResponseDto.success(
                "Product deleted successfully",
                HttpStatus.OK.value(),
                null,
                request.getRequestURI()
        );
    }
}