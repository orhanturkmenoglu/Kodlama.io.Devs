package kodlama.io.Kodlama.io.Devs.webApi;

import kodlama.io.Kodlama.io.Devs.business.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.response.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingService) {
        this.programmingService = programmingService;
    }


    @GetMapping("/findall")
    public ResponseEntity<List<GetAllProgrammingLanguageResponse>> findAll() {

        List<GetAllProgrammingLanguageResponse> findAll = programmingService.findAll();
        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<GetAllProgrammingLanguageResponse> findById(@PathVariable("id") long id) {

        GetAllProgrammingLanguageResponse findById = programmingService.findById(id);
        return new ResponseEntity<>(findById, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CreateProgrammingLanguageRequest> save(ProgrammingLanguage programmingLanguage) throws Exception {

        CreateProgrammingLanguageRequest save = programmingService.save(programmingLanguage);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<CreateProgrammingLanguageRequest> deleteById(@PathVariable("id") Long id) {

        CreateProgrammingLanguageRequest deleteById = programmingService.deleteById(id);
        return new ResponseEntity<>(deleteById, HttpStatus.OK);
    }
}
