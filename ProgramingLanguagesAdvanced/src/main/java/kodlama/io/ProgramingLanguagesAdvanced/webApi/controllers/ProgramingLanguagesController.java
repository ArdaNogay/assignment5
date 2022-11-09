package kodlama.io.ProgramingLanguagesAdvanced.webApi.controllers;

import kodlama.io.ProgramingLanguagesAdvanced.business.abstracts.ProgramingLanguageService;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.CreateProgramingLanguageRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.UpdateProgramingLanguageRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.responses.GetProgramingLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programingLanguages")
public class ProgramingLanguagesController {

    private ProgramingLanguageService programingLanguageService;

    @Autowired
    public ProgramingLanguagesController(ProgramingLanguageService programingLanguageService) {
        this.programingLanguageService = programingLanguageService;
    }

    @GetMapping("/getAll")
    public List<GetProgramingLanguageResponse> getAll() {
        return programingLanguageService.getAll();
    }

    @GetMapping("/getById")
    public GetProgramingLanguageResponse findById(@RequestParam int id) {
        return programingLanguageService.findById(id);
    }

    @PostMapping("/add")
    public GetProgramingLanguageResponse add(@RequestBody CreateProgramingLanguageRequest createProgramingLanguageRequest) {
        return programingLanguageService.add(createProgramingLanguageRequest);
    }

    @PutMapping("/update")
    public GetProgramingLanguageResponse update(@RequestBody UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
        return programingLanguageService.update(updateProgramingLanguageRequest);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam int id) {
        programingLanguageService.deleteById(id);
    }

}
