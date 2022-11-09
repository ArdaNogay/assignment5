package kodlama.io.ProgramingLanguagesAdvanced.business.requests;

import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.Framework;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateProgramingLanguageRequest {
    private int id;
    private String name;
}
