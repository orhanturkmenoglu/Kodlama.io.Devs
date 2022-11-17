package kodlama.io.Kodlama.io.Devs.business.mapper;

import kodlama.io.Kodlama.io.Devs.business.request.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.response.TechnologyDto;
import kodlama.io.Kodlama.io.Devs.entity.Technology;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TechnologyMapper {

    public List<TechnologyDto> mapToTechnologyDtoList(List<Technology> technologyList) {
        return technologyList.stream()
                .map(this::mapToTechnologyDto)
                .collect(Collectors.toList());
    }

    public TechnologyDto mapToTechnologyDto(Technology technology) {
        if (technology == null) {
            return TechnologyDto.builder().build();
        }

        return TechnologyDto.builder()
                .technologyId(technology.getTecnologyId())
                .technologyName(technology.getTecnologyName())
                .build();
    }

    public Technology mapToTechnology(CreateTechnologyRequest request) {
        return Technology.builder()
                .tecnologyName(request.getTecnologyName())
                .build();
    }
}
