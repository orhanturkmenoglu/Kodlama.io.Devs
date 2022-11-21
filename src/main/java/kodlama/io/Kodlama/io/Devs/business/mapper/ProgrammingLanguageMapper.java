package kodlama.io.Kodlama.io.Devs.business.mapper;

import kodlama.io.Kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.response.ProgrammingLanguageDto;
import kodlama.io.Kodlama.io.Devs.business.response.TechnologyDto;
import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entity.Technology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProgrammingLanguageMapper {
    private final TechnologyMapper technologyMapper;
    public List<ProgrammingLanguageDto> mapToProgrammingLanguageDto(List<ProgrammingLanguage> programmingLanguageList) {
        return programmingLanguageList.stream()
                .map(this::mapToProgrammingLanguageDto)
                .collect(Collectors.toList());
    }

    public ProgrammingLanguageDto mapToProgrammingLanguageDto(ProgrammingLanguage programmingLanguage) {

        if (programmingLanguage == null) {
            return ProgrammingLanguageDto.builder().build();
        }

        return ProgrammingLanguageDto.builder()
                .id(programmingLanguage.getId())
                .language(programmingLanguage.getLanguage())
                .build();
    }

    public ProgrammingLanguage mapToProgrammingLanguage (CreateProgrammingLanguageRequest request){
        return ProgrammingLanguage.builder()
                .language(request.getLanguage())
                .build();
    }


    public ProgrammingLanguageDto mapToProgrammingLanguageDto (ProgrammingLanguage programmingLanguage, List<TechnologyDto> technologyList){
        return ProgrammingLanguageDto.builder()
                .id(programmingLanguage.getId())
                .language(programmingLanguage.getLanguage())
                .technologies(technologyList)
                .build();
    }
}
