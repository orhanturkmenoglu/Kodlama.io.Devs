package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguage> getAll ();

    ProgrammingLanguage getById (int id);

    void create(ProgrammingLanguage programmingLanguage) throws Exception;

}
