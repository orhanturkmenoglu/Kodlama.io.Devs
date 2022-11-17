package kodlama.io.Kodlama.io.Devs.business.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kodlama.io.Kodlama.io.Devs.entity.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTecnologyRequest {

    private Long tecnologyId;
    private String tecnologyName;

}
