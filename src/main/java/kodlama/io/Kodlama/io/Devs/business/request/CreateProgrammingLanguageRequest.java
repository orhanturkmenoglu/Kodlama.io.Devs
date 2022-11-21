package kodlama.io.Kodlama.io.Devs.business.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProgrammingLanguageRequest {
    private String language;
    private List<CreateTechnologyRequest> technologyRequestList;
}
