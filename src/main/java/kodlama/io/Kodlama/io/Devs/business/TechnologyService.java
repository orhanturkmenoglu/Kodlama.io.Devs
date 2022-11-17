package kodlama.io.Kodlama.io.Devs.business;

import kodlama.io.Kodlama.io.Devs.business.mapper.TechnologyMapper;
import kodlama.io.Kodlama.io.Devs.business.request.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.response.TechnologyDto;
import kodlama.io.Kodlama.io.Devs.entity.Technology;
import kodlama.io.Kodlama.io.Devs.repositories.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnologyService {

    private final TechnologyMapper technologyMapper;
    private final TechnologyRepository repository;

    public  TechnologyDto createTechnology (CreateTechnologyRequest request){
        Technology technology = technologyMapper.mapToTechnology(request);
        Technology createdTechnology = repository.save(technology);
        return technologyMapper.mapToTechnologyDto(createdTechnology);
    }

    public List<TechnologyDto> getAllTechnologies(String name) {
        if (name != null && name.trim().length() > 0) {
            List<Technology> technologyList = repository.findByTechnologyName(name);
            return  technologyMapper.mapToTechnologyDtoList(technologyList);
        }

        List<Technology> technologyList = repository.findAll();
      /*  List<TechnologyDto> technologyDtoList = new ArrayList<>();

        technologyList.forEach(technology -> technologyDtoList.add(TechnologyDto.builder()
                .technologyId(technology.getTecnologyId())
                .technologyName(technology.getTecnologyName())
                .build()));

        technologyList.stream()
                .map(technology -> TechnologyDto.builder()
                        .technologyId(technology.getTecnologyId())
                        .technologyName(technology.getTecnologyName())
                        .build())
                .collect(Collectors.toList());
*/
        return technologyMapper.mapToTechnologyDtoList(technologyList);
    }

    public TechnologyDto getTechnologyById(Long id) {
        Optional<Technology> technology = repository.findById(id);
        technology.orElseThrow(() -> new IllegalArgumentException("Technology not found for id: " + id));
        return technologyMapper.mapToTechnologyDto(technology.get());
    }

    public void deleteTechnologyById(Long id) {
        Optional<Technology> technology = repository.findById(id);
        technology.orElseThrow(() -> new IllegalArgumentException("Technology not found for id: " + id));
        repository.deleteById(id);
    }

}
