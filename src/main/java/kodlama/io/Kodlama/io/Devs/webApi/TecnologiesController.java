package kodlama.io.Kodlama.io.Devs.webApi;

import kodlama.io.Kodlama.io.Devs.business.TecnologyService;
import kodlama.io.Kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.request.CreateTecnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.response.GetAllTecnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tecnologies")
public class TecnologiesController {

    private TecnologyService tecnologyService;

    @Autowired
    public TecnologiesController(TecnologyService tecnologyService) {
        this.tecnologyService = tecnologyService;
    }

    @GetMapping("/findall")
    public ResponseEntity<List<GetAllTecnologyResponse>> findAll() {

        List<GetAllTecnologyResponse> findAll = tecnologyService.findAll();
        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<GetAllTecnologyResponse> findById(Long id) {

        GetAllTecnologyResponse findById = tecnologyService.findById(id);
        return new ResponseEntity<>(findById, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<CreateTecnologyRequest> deleteById(@PathVariable("id") Long id) {

        CreateTecnologyRequest deleteById = tecnologyService.deleteById(id);
        return new ResponseEntity<>(deleteById, HttpStatus.OK);
    }
}
