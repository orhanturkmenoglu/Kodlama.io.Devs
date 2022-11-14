package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> languages;

    public InMemoryLanguageRepository() {
        this.languages = new ArrayList<ProgrammingLanguage>();
        languages.add(new ProgrammingLanguage(1, "C#"));
        languages.add(new ProgrammingLanguage(2, "Java"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return languages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
       for (ProgrammingLanguage  language : languages) {
           if (language.getId() == id) {
               return language;
           }
       }

       return null;
    }

    @Override
    public void create(ProgrammingLanguage programmingLanguage) {
        languages.add(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        languages.remove(id);
    }
}
