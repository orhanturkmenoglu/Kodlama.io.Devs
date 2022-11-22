package kodlama.io.Kodlama.io.Devs.business.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTechnologyRequest {
    @NotBlank (message = "technologyName type shouldn't be NULL OR EMPTY")
    private String technologyName;
}
