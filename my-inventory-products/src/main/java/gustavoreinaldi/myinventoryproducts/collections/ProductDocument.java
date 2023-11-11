package gustavoreinaldi.myinventoryproducts.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Product")
public class ProductDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private String observation;
    private String brand;
    private String model;
    private String color;
    private Dimensions dimensions;
    private String size;
    private String capacity;
    private String category;
    private Date creationDate;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Dimensions {
        private double height;
        private double width;
        private double length;
    }
}