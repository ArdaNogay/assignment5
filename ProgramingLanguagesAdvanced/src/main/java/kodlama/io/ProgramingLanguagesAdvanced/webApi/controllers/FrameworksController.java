package kodlama.io.ProgramingLanguagesAdvanced.webApi.controllers;

import kodlama.io.ProgramingLanguagesAdvanced.business.abstracts.FrameworkService;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.CreateFrameworkRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.UpdateFrameworkRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.responses.GetFrameworkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworksController {

    private FrameworkService frameworkService;

    @Autowired
    public FrameworksController(FrameworkService frameworkService) {
        this.frameworkService = frameworkService;
    }

    @GetMapping("/getAll")
    public List<GetFrameworkResponse> getAll() {
        return frameworkService.getAll();
    }

    @GetMapping("/getById")
    public GetFrameworkResponse findById(@RequestParam int id) {
        return frameworkService.findById(id);
    }

    @PostMapping("/add")
    public GetFrameworkResponse add(@RequestBody CreateFrameworkRequest createFrameworkRequest) {
        return frameworkService.add(createFrameworkRequest);
    }

    @PutMapping("/update")
    public GetFrameworkResponse update(@RequestBody UpdateFrameworkRequest updateFrameworkRequest) {
        return frameworkService.update(updateFrameworkRequest);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam int id) {
        frameworkService.deleteById(id);
    }
}