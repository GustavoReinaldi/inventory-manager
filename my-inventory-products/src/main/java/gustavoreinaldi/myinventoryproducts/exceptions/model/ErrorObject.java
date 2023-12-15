package gustavoreinaldi.myinventoryproducts.exceptions.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorObject {
    private String error;
}
