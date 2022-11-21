package kodlama.io.Kodlama.io.Devs.business.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammingLanguageDto {
    private Long id;
    private String language;
    private List<TechnologyDto> technologies;
}
