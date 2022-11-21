package kodlama.io.Kodlama.io.Devs.entity;

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

/*
    @ToString(exclude ="programmingLanguage") : programmingLanguage özelliği dize gösteriminde
    hariç tutuldu.
 */
@Entity
@Table(name = "technologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Technology implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technologyId;

    private String technologyName;
    private Long programmingLanguageId;
}

