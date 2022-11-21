package kodlama.io.Kodlama.io.Devs.business.request;

import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTechnologyRequest {

    private String technologyName;
}
