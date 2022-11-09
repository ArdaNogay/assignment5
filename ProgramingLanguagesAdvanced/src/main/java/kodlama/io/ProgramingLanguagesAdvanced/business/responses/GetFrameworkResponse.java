package kodlama.io.ProgramingLanguagesAdvanced.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFrameworkResponse {
    private int id;
    private String name;
    private int programingLanguageId;
}
