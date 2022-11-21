package kodlama.io.Kodlama.io.Devs.controller;

import kodlama.io.Kodlama.io.Devs.business.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.response.ProgrammingLanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class ProgrammingLanguageController {
    private final ProgrammingLanguageService programmingService;

    @PostMapping
    public ResponseEntity<ProgrammingLanguageDto> createProgrammingLanguage(@Valid @RequestBody CreateProgrammingLanguageRequest request)  {
        ProgrammingLanguageDto programmingLanguageDto = programmingService.createProgrammingLanguage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(programmingLanguageDto);
    }

    @GetMapping
    public ResponseEntity<List<ProgrammingLanguageDto>> getAllProgrammingLanguages(@RequestParam(value = "name", required = false) String name) {
        List<ProgrammingLanguageDto> programmingLanguageDtoList = programmingService.getAllProgrammingLanguages(name);
        return ResponseEntity.ok(programmingLanguageDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguageDto> findById(@PathVariable("id") long id) {
        ProgrammingLanguageDto findById = programmingService.findById(id);
        return new ResponseEntity<>(findById, HttpStatus.OK);
    }


   /* @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<CreateProgrammingLanguageRequest> deleteById(@PathVariable("id") Long id) {
        CreateProgrammingLanguageRequest deleteById = programmingService.deleteById(id);
        return new ResponseEntity<>(deleteById, HttpStatus.NO_CONTENT);
    }*/
}
