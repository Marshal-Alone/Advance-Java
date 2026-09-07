package edu.learningspringboot.service.impl;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.entity.Product;
import edu.learningspringboot.mapper.ProductMapper;
import edu.learningspringboot.repository.ProductRepository;
import edu.learningspringboot.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    //INJECT DEPENDENCY
    //use this or @AllArgsConstructor
    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponseDto findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Product not found for given ID")
                );
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> findAllProducts() {
        List<Product> products = productRepository.findAll() ;//returns list -> convert stream into list using map

        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        //convert ProductRequestDto--> entity
        Product product =  productMapper.toEntity(productRequestDto);

        //save the entity and return the saved product back to user
        Product savedProduct = productRepository.save(product);
        return  productMapper.toDto(savedProduct);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Product not found for given ID")
                );

        productMapper.updateProduct(productRequestDto,product);

        /*  MANUAL  WAY
            existing_product.setName(productRequestDto.getName());
            existing_product.setPrice(productRequestDto.getPrice());
            existing_product.setCategory(productRequestDto.getCategory());
        */

        //can skip saving using @Transactional annotation
        //save the product
        //Product saved_product = productRepository.save(product);

        //return the saved product
        return productMapper.toDto(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProductPrice(Long id, UpdateProductPrice updateProductPrice) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Product not found for given ID")
                );

        product.setPrice(updateProductPrice.getPrice());

        //can skip saving using @Transactional annotation
//        Product saved_product = productRepository.save(existing_product);
        return productMapper.toDto(product);
    }
}
