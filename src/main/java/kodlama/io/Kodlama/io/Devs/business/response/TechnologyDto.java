package kodlama.io.Kodlama.io.Devs.business.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnologyDto  implements Serializable {
    private Long technologyId;
    private String technologyName;
}
