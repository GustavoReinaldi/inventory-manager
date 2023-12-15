package gustavoreinaldi.myinventoryproducts.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import gustavoreinaldi.myinventoryproducts.dto.ProductDTO;
import gustavoreinaldi.myinventoryproducts.useCases.ProductCreationUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class ProductControllerUnitTest {
    private MockMvc mockMvc;
    @Mock
    private ProductCreationUseCase productCreationUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productCreationUseCase))
                .build();
    }
    @Test
    void createProduct() throws Exception {
        doNothing().when(productCreationUseCase).createProduct(any());
        RequestBuilder request = MockMvcRequestBuilders
                .post("/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(ProductDTO.builder()
                                .brand("Brand").build()));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Product created!"));
    }
}