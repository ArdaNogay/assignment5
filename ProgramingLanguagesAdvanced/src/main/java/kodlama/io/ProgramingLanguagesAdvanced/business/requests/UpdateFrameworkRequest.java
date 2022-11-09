package kodlama.io.ProgramingLanguagesAdvanced.business.requests;

import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.ProgramingLanguage;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateFrameworkRequest {
    private int id;
    private String name;
    private int programingLanguageId;
}
