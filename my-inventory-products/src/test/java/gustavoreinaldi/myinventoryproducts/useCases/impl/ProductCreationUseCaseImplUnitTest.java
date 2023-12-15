package gustavoreinaldi.myinventoryproducts.useCases.impl;

import gustavoreinaldi.myinventoryproducts.collections.ProductDocument;
import gustavoreinaldi.myinventoryproducts.dto.ProductDTO;
import gustavoreinaldi.myinventoryproducts.exceptions.GenericUnrecognizedErrorException;
import gustavoreinaldi.myinventoryproducts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ProductCreationUseCaseImplUnitTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductCreationUseCaseImpl useCase;

    @Test
    void whenCreationFail(){
        when(productRepository.save(any())).thenThrow(new RuntimeException("MOCKED EXCEPTION"));
        assertThrows(GenericUnrecognizedErrorException.class, () -> useCase.createProduct(new ProductDTO()));
    }
    @Test
    void whenCreationSuccess(){
        when(productRepository.save(any())).thenReturn(new ProductDocument());
        assertDoesNotThrow(() -> useCase.createProduct(new ProductDTO()));
    }
}