package kodlama.io.Kodlama.io.Devs.repositories;

import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {

    List<ProgrammingLanguage> findBylanguage(String languageName);
}