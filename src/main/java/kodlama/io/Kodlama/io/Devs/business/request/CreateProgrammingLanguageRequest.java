package kodlama.io.Kodlama.io.Devs.business.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProgrammingLanguageRequest {
    @NotBlank(message = "language type shouldn't be NULL OR EMPTY")
    private String language;
    @NotEmpty(message = "technologyRequestList type shouldn't be NULL OR EMPTY")
    private List<CreateTechnologyRequest> technologyRequestList;
}
