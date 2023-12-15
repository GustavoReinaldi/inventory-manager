package gustavoreinaldi.myinventoryproducts.controllers.v1;

import gustavoreinaldi.myinventoryproducts.dto.ProductDTO;
import gustavoreinaldi.myinventoryproducts.useCases.ProductCreationUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Tag(name="Product Resources", description = "All resources about Products")
@Controller
@RequestMapping("v1/products")
public class ProductController {
    private ProductCreationUseCase productCreationUseCase;

    @Autowired
    public ProductController(ProductCreationUseCase productCreationUseCase) {
        this.productCreationUseCase = productCreationUseCase;
    }

    @Operation(
            summary = "Create product",
            description = "Resource that create products"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping()
    ResponseEntity<Object> createProduct(@RequestBody ProductDTO newProduct){
        productCreationUseCase.createProduct(newProduct);
        return ResponseEntity.ok().body("Product created!");
    }
}
