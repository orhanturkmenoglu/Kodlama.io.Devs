package kodlama.io.Kodlama.io.Devs;

import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entity.Tecnology;
import kodlama.io.Kodlama.io.Devs.repositories.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.repositories.TecnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TecnologyRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        ProgrammingLanguage programmingLanguage = ProgrammingLanguage.builder()
                .language("C#")
                .build();

        Tecnology tecnology  = Tecnology.builder()
                .tecnologyName("Asp.net")
                .programmingLanguage(programmingLanguage)
                .build();


        repository.save(tecnology);

    }
}
