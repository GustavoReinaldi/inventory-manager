package gustavoreinaldi.myinventoryproducts.useCases.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import gustavoreinaldi.myinventoryproducts.collections.ProductDocument;
import gustavoreinaldi.myinventoryproducts.dto.ProductDTO;
import gustavoreinaldi.myinventoryproducts.exceptions.GenericUnrecognizedErrorException;
import gustavoreinaldi.myinventoryproducts.repositories.ProductRepository;
import gustavoreinaldi.myinventoryproducts.useCases.ProductCreationUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class ProductCreationUseCaseImpl implements ProductCreationUseCase {
    private ObjectMapper mapper;
    private ProductRepository productRepository;

    @Autowired
    public ProductCreationUseCaseImpl(ProductRepository productRepository) {
        this.mapper = new ObjectMapper();
        this.productRepository = productRepository;
    }
    @Override
    public void createProduct(ProductDTO newProduct) {
        try {
            ProductDocument newProductDocument = mapper.convertValue(newProduct, ProductDocument.class);
            newProductDocument.setCreationDate(new Date());
            log.info("Creating new product...");
            productRepository.save(newProductDocument);
            log.info("Product created");
        }catch(Exception ex) {
            log.error(ex.getMessage());
            throw new GenericUnrecognizedErrorException();
        }
    }
}
