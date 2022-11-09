package kodlama.io.ProgramingLanguagesAdvanced.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "programingLanguages")
@NoArgsConstructor
@AllArgsConstructor
public class ProgramingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "programingLanguage", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Framework> framework;
}
