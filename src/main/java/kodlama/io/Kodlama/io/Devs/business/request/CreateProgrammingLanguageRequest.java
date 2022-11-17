package kodlama.io.Kodlama.io.Devs.business.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProgrammingLanguageRequest {
    private Long id;
    private String language;
}
