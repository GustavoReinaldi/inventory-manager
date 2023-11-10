package gustavoreinaldi.inventorymanagerbackend.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import gustavoreinaldi.inventorymanagerbackend.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    private Firestore firestore;
    private final String COLLECTION_NAME = "PRODUCT";

    @Autowired
    public ProductService(Firestore firestore) {
        this.firestore = firestore;
    }
    public void createRandomTestProduct() {
        ProductEntity productEntity = ProductEntity.builder().name("new test product").creationDate(new Date()).build();
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection(COLLECTION_NAME).document().set(productEntity);
    }
    public void getAllDocuments() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println(document.getId() + " => " + document.getData());
        }
    }
}
