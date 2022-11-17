package kodlama.io.Kodlama.io.Devs.webApi;

import kodlama.io.Kodlama.io.Devs.business.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.response.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/languages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingService) {
        this.programmingService = programmingService;
    }


    @GetMapping("/findall")
    public List<GetAllProgrammingLanguageResponse> findAll (){
       return  programmingService.findAll();
    }

    @GetMapping ("/findById/{id}")
    public GetAllProgrammingLanguageResponse findById (@PathVariable("id") long id) {
        return programmingService.findById(id);
    }

    @PostMapping ("/save")
    public CreateProgrammingLanguageRequest save ( ProgrammingLanguage programmingLanguage){
        return  programmingService.save(programmingLanguage);
    }

    @DeleteMapping ("/deleteById/{id}")
    public CreateProgrammingLanguageRequest deleteById (@PathVariable("id") long id) {
        return programmingService.deleteById(id);
    }
}
