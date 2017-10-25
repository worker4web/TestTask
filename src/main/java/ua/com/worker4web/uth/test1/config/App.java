package ua.com.worker4web.uth.test1.config; /**
 * Created by worker4web on 10/25/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "ua.com.worker4web.uth.test1")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
