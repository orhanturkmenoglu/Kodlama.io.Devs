package kodlama.io.Kodlama.io.Devs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tecnologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tecnology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tecnologyId;
    private String tecnologyName;

    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ProgrammingLanguage programmingLanguage;
}
