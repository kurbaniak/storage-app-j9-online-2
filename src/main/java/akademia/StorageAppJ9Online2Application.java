package akademia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:dbconfig.properties")
@SpringBootApplication
public class StorageAppJ9Online2Application {

    public static void main(String[] args) {
        SpringApplication.run(StorageAppJ9Online2Application.class, args);
    }

}
