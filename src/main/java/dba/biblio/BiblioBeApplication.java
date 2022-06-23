package dba.biblio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BiblioBeApplication {




        public static void main(String[] args) {
        SpringApplication.run(BiblioBeApplication.class, args);

    }



}
