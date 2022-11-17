package kodlama.io.Kodlama.io.Devs.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/*
 @JsonManagedReference : alt üst nesneleri belirmek ve api kullanımı sırasında jsondan dönen türün
 sonsuz döngüye girmemesi için
 parent ve child nesneleri belirtmemizi sağlar
 @JsonManagedReference : parent nesneyi işaret eder
 @JsonBackReference     : child nesneyi işaret eder

 alternatif olarak dto design pattern ile birlikte object mapper da kullanılabilir.
 */
@Entity
@Table(name = "programmingLanguages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString (exclude = "technologies")
public class ProgrammingLanguage  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;

    /*@JsonManagedReference*/
    @OneToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "programmingLanguage")
    private List<Technology> technologies;
}
