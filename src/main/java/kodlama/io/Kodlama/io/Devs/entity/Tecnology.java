package kodlama.io.Kodlama.io.Devs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/*
    Java Serialization API sayesinde bir nesnenin birebir kopyasını, Java platformu dışında da depolayabiliriz.
     Bu mekanizma ile daha sonra, nesneyi depolanan yerden çekip, aynı durum (state) ve özellikleri ile
     kullanmaya devam edebiliriz. Tüm bu sisteme, Object Serialization (Nesne Serileştirme) adı verilir.
 */
@Entity
@Table(name = "tecnologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tecnology{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tecnologyId;
    private String tecnologyName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProgrammingLanguage programmingLanguage;
}
