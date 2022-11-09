package kodlama.io.ProgramingLanguagesAdvanced.business.responses;

import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.Framework;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgramingLanguageResponse {
    private int id;
    private String name;
}
