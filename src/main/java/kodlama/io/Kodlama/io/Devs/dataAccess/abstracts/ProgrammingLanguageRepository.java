package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository  {

    List<ProgrammingLanguage> getAll ();

    ProgrammingLanguage getById (int id);

    void create(ProgrammingLanguage programmingLanguage);

    void delete(int id);

}
