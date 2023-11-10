package gustavoreinaldi.inventorymanagerbackend;

import com.google.firebase.cloud.FirestoreClient;
import gustavoreinaldi.inventorymanagerbackend.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class InventoryManagerBackendApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(InventoryManagerBackendApplication.class, args);
		ProductService service = new ProductService(FirestoreClient.getFirestore());
				service.createRandomTestProduct();
				service.getAllDocuments();
	}

}
