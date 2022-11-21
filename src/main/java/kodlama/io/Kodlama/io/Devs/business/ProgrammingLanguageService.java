package kodlama.io.Kodlama.io.Devs.business;

import kodlama.io.Kodlama.io.Devs.business.mapper.ProgrammingLanguageMapper;
import kodlama.io.Kodlama.io.Devs.business.mapper.TechnologyMapper;
import kodlama.io.Kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.response.ProgrammingLanguageDto;
import kodlama.io.Kodlama.io.Devs.business.response.TechnologyDto;
import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.repositories.ProgrammingLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageService {

    private final TechnologyService technologyService;
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final ProgrammingLanguageMapper programmingLanguageMapper;

    private final TechnologyMapper technologyMapper;

    @Transactional
    public ProgrammingLanguageDto createProgrammingLanguage(CreateProgrammingLanguageRequest request) {
        ProgrammingLanguage programmingLanguage = programmingLanguageMapper.mapToProgrammingLanguage(request);
        ProgrammingLanguage savedProgrammingLanguage = programmingLanguageRepository.save(programmingLanguage);
        List<TechnologyDto> technologyList = technologyService.createTechnology(request.getTechnologyRequestList(), savedProgrammingLanguage.getId());
        return programmingLanguageMapper.mapToProgrammingLanguageDto(savedProgrammingLanguage, technologyList);
    }
    public List<ProgrammingLanguageDto> getAllProgrammingLanguages(String name) {
        if (name != null && name.length() > 0) {
            List<ProgrammingLanguage> programmingLanguageList = programmingLanguageRepository.findBylanguage(name);
            return programmingLanguageMapper.mapToProgrammingLanguageDto(programmingLanguageList);
        }

        List<ProgrammingLanguage> programmingLanguageList = programmingLanguageRepository.findAll();
        return programmingLanguageMapper.mapToProgrammingLanguageDto(programmingLanguageList);
    }
    public ProgrammingLanguageDto findById(long id) {
        Optional<ProgrammingLanguage> findById = programmingLanguageRepository.findById(id);
        ProgrammingLanguageDto response = new ProgrammingLanguageDto();
        if (findById.isPresent()) {
            programmingLanguageMapper.mapToProgrammingLanguageDto(findById.get());
        }

        return response;
    }

    public void deleteProgrammingLanguageById(Long id) {
        return;
    }

}
