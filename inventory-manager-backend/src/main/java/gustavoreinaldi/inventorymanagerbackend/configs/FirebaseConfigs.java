package gustavoreinaldi.inventorymanagerbackend.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import gustavoreinaldi.inventorymanagerbackend.InventoryManagerBackendApplication;
import io.netty.util.internal.ObjectUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Configuration
public class FirebaseConfigs {
    @PostConstruct
    public FirebaseApp initializeFirebaseApp() throws IOException {
        InputStream serviceAccount = ClassLoader.getSystemResourceAsStream("firestore-admin-sdk.json");
        assert serviceAccount != null;

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);
    }
    @Bean
    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}
