package edu.learningspringboot.mapper;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

public class ProductMapper {
    //dependency injection
    private final ModelMapper mapper;

    //----------------> actual logic

    //method to convert RequestDto --> entity
    public Product toEntity(ProductRequestDto  productRequestDto) {
        return mapper.map(productRequestDto,Product.class);
    }

    //method to convert entity --> ResponseDto
    public ProductResponseDto toDto(Product product) {
        return mapper.map(product,ProductResponseDto.class);
    }

    //update product entity using existing obj and productRequestDto
    public void updateProduct(ProductRequestDto productRequestDto, Product product) {
        mapper.map(productRequestDto, product);
    }


}
