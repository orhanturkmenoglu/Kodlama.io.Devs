package kodlama.io.Kodlama.io.Devs.webApi;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/languages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping ("/getall")
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping ("/getbyid/{id}")
    public  ProgrammingLanguage getById(@PathVariable("id") int id)  {
        return programmingLanguageService.getById(id);
    }

     @PostMapping ("/create")
    public void create ( ProgrammingLanguage programmingLanguage) throws Exception{
        programmingLanguageService.create(programmingLanguage);
     }
}
