package kodlama.io.Kodlama.io.Devs.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.Kodlama.io.Devs.business.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.request.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.response.TechnologyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    @RequiredArgsConstructor : final fieldları constructorda oluşturur
 */
@RestController
@RequestMapping("/api/v1/technologies")
@RequiredArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @PostMapping
    public ResponseEntity<TechnologyDto> createTechnology(@RequestBody CreateTechnologyRequest request){
        TechnologyDto technologyDto = technologyService.createTechnology(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(technologyDto);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyDto>> getAllTechnologies(@RequestParam(value = "name",required = false) String name){
        List<TechnologyDto> technologyList= technologyService.getAllTechnologies(name);
        return ResponseEntity.ok(technologyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyDto> getTechnologyById(@PathVariable("id") Long id) {
        TechnologyDto technologyDto = technologyService.getTechnologyById(id);
        return ResponseEntity.ok(technologyDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnologyById(@PathVariable("id") Long id) {
        technologyService.deleteTechnologyById(id);
        return ResponseEntity.noContent().build();
    }
}
