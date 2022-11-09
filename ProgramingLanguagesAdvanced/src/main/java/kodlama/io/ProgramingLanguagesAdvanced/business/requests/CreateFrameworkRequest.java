package kodlama.io.ProgramingLanguagesAdvanced.business.requests;

import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.Framework;
import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.ProgramingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateFrameworkRequest {
    private String name;
    private int programingLanguageId;
}
