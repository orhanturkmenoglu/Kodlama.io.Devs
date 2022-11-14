package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public void create(ProgrammingLanguage programmingLanguage) throws Exception {

        if (programmingLanguage.getLanguage().isEmpty() || programmingLanguage.getLanguage() == null) {
            throw new NullPointerException("Program Dili Boş Veya Null Olamaz !!");
        }

        if (isCheckProgrammingLanguage(programmingLanguage)) {
            throw new Exception("Aynı isimde birden fazla programlama dili olamaz !");
        }

        programmingLanguageRepository.create(programmingLanguage);
    }

    public boolean isCheckProgrammingLanguage(ProgrammingLanguage programmingLanguage) {

        for (ProgrammingLanguage language : programmingLanguageRepository.getAll()) {
            if (language.getLanguage().equalsIgnoreCase(programmingLanguage.getLanguage())) {
                return false;
            }
        }

        return true;
    }
}
