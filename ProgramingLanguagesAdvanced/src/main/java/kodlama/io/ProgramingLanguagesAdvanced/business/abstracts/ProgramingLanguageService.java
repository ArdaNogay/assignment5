package kodlama.io.ProgramingLanguagesAdvanced.business.abstracts;

import kodlama.io.ProgramingLanguagesAdvanced.business.requests.CreateProgramingLanguageRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.UpdateProgramingLanguageRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.responses.GetProgramingLanguageResponse;

import java.util.List;

public interface ProgramingLanguageService {
    List<GetProgramingLanguageResponse> getAll();
    GetProgramingLanguageResponse add(CreateProgramingLanguageRequest createProgramingLanguageRequest);
    GetProgramingLanguageResponse findById(int id);
    GetProgramingLanguageResponse update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest);
    void deleteById(int id);
}
