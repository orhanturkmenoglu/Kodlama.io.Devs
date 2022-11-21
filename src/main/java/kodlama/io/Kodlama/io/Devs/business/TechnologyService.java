package kodlama.io.Kodlama.io.Devs.business;

import kodlama.io.Kodlama.io.Devs.business.mapper.TechnologyMapper;
import kodlama.io.Kodlama.io.Devs.business.request.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.response.TechnologyDto;
import kodlama.io.Kodlama.io.Devs.entity.Technology;
import kodlama.io.Kodlama.io.Devs.repositories.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TechnologyService {

    private final TechnologyMapper technologyMapper;
    private final TechnologyRepository technologyRepository;

    public  TechnologyDto createTechnology (CreateTechnologyRequest request){
        log.info("TechnologyService::createTechnology started");
        Technology technology = technologyMapper.mapToTechnology(request);
        Technology createdTechnology = technologyRepository.save(technology);
        log.info("TechnologyService::createTechnology finished ");
        return technologyMapper.mapToTechnologyDto(createdTechnology);
    }

    public  List<TechnologyDto> createTechnology (List<CreateTechnologyRequest> request,Long programmingLanguageId){
        log.info("TechnologyService::createTechnology started");
        List<Technology> technologyList = technologyMapper.mapToTechnologyList(request);
        technologyList.forEach(technology -> technology.setProgrammingLanguageId(programmingLanguageId));
        List<Technology> savedTechnologyList = technologyRepository.saveAll(technologyList);
        log.info("TechnologyService::createTechnology finished");
        return technologyMapper.mapToTechnologyDtoList(savedTechnologyList);
    }

    public List<TechnologyDto> getAllTechnologies(String name) {
        log.info("TechnologyService::getAllTechnologies started");
        if (name != null && name.trim().length() > 0) {
            List<Technology> technologyList = technologyRepository.findByTechnologyName(name);
            return  technologyMapper.mapToTechnologyDtoList(technologyList);
        }

        List<Technology> technologyList = technologyRepository.findAll();
        log.info("TechnologyService::getAllTechnologies finished");
        return technologyMapper.mapToTechnologyDtoList(technologyList);
    }

    public TechnologyDto getTechnologyById(Long id) {
        log.info("TechnologyService::getTechnologyById started");
        Optional<Technology> technology = technologyRepository.findById(id);
        technology.orElseThrow(() -> new IllegalArgumentException("Technology not found for id: " + id));
        log.info("TechnologyService::getTechnologyById finished");
        return technologyMapper.mapToTechnologyDto(technology.get());
    }

    public void deleteTechnologyById(Long id) {
        log.info("TechnologyService::deleteTechnologyById started");
        Optional<Technology> technology = technologyRepository.findById(id);
        technology.orElseThrow(() -> new IllegalArgumentException("Technology not found for id: " + id));
        technologyRepository.deleteById(id);
        log.info("TechnologyService::deleteTechnologyById finished");
    }

}
