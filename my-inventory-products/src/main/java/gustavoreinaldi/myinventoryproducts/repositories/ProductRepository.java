package gustavoreinaldi.myinventoryproducts.repositories;

import gustavoreinaldi.myinventoryproducts.collections.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDocument, String> {
}
