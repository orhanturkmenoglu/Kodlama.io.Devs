package kodlama.io.Kodlama.io.Devs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programmingLanguages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    @OneToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "programmingLanguage")
    private List<Tecnology> tecnologies ;
}
