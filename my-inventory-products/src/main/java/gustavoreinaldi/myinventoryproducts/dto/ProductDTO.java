package gustavoreinaldi.myinventoryproducts.dto;

import gustavoreinaldi.myinventoryproducts.collections.ProductDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private String observation;
    private String brand;
    private String model;
    private String color;
    private ProductDocument.Dimensions dimensions;
    private String size;
    private String capacity;
    private String category;
    private Date creationDate;

}
