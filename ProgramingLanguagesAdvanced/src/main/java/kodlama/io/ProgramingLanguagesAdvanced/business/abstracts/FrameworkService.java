package kodlama.io.ProgramingLanguagesAdvanced.business.abstracts;

import kodlama.io.ProgramingLanguagesAdvanced.business.requests.CreateFrameworkRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.UpdateFrameworkRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.responses.GetFrameworkResponse;

import java.util.List;

public interface FrameworkService {
    List<GetFrameworkResponse> getAll();
    GetFrameworkResponse add(CreateFrameworkRequest createFrameworkRequest);
    GetFrameworkResponse findById(int id);
    GetFrameworkResponse update(UpdateFrameworkRequest updateFrameworkRequest);
    void deleteById(int id);
}
