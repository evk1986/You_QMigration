package ua.kravchenko.youq.config;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Egor on 27.01.2017.
 */
@Configuration
public class FirebaseConfig {

    /**
     * @Todo
     * @return
     */
  /*  @Bean
    public DatabaseReference firebaseDatabse() {
        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
        return firebase;
    }*/
    @PostConstruct
    public void init() throws FileNotFoundException {
        /**
         * https://firebase.google.com/docs/server/setup
         *
         * Create service account , download json
         */
        FileInputStream serviceAccount = null;
        serviceAccount = new FileInputStream("src/main/webapp/WEB-INF/resource/wakeodessa-firebase-adminsdk-holpx-7c429a2eee.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://wakeodessa.firebaseio.com")
                .build();
       /* FirebaseApp.initializeApp(options);*/
    }

}
