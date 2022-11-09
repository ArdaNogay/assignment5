package kodlama.io.ProgramingLanguagesAdvanced.business.concretes;

import kodlama.io.ProgramingLanguagesAdvanced.business.abstracts.FrameworkService;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.CreateFrameworkRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.UpdateFrameworkRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.responses.GetFrameworkResponse;
import kodlama.io.ProgramingLanguagesAdvanced.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.ProgramingLanguagesAdvanced.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.Framework;
import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.ProgramingLanguage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FrameworkManager implements FrameworkService {

    private FrameworkRepository frameworkRepository;
    private ProgramingLanguageRepository programingLanguageRepository;

    @Autowired
    public FrameworkManager(FrameworkRepository frameworkRepository, ProgramingLanguageRepository programingLanguageRepository) {
        this.frameworkRepository = frameworkRepository;
        this.programingLanguageRepository = programingLanguageRepository;
    }

    @Override
    public List<GetFrameworkResponse> getAll() {
        List<Framework> frameworks = frameworkRepository.findAll();
        List<GetFrameworkResponse> frameworkResponses = new ArrayList<>();
        for (Framework framework : frameworks) {
            GetFrameworkResponse response = new GetFrameworkResponse();
            setFrameworkFields(framework, response);
            frameworkResponses.add(response);
        }
        return frameworkResponses;
    }

    private void setFrameworkFields(Framework framework, GetFrameworkResponse response) {
        response.setId(framework.getId());
        response.setName(framework.getName());
        response.setProgramingLanguageId(framework.getProgramingLanguage().getId());
    }

    @Override
    public GetFrameworkResponse add(CreateFrameworkRequest createFrameworkRequest) {
        isNameEmpty(createFrameworkRequest.getName());
        Framework framework = new Framework();
        framework.setName(createFrameworkRequest.getName());
        framework.setProgramingLanguage(programingLanguageRepository.findById(createFrameworkRequest.getProgramingLanguageId()).get());
        Framework savedFramework = frameworkRepository.save(framework);
        GetFrameworkResponse getFrameworkResponse = new GetFrameworkResponse();
        setFrameworkFields(savedFramework, getFrameworkResponse);
        return getFrameworkResponse;
    }

    private void isNameEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("İsim boş bırakılamaz!");
        }
    }

    @Override
    public GetFrameworkResponse findById(int id) {
        Optional<Framework> frameworkOptional = frameworkRepository.findById(id);
        GetFrameworkResponse frameworkResponse = new GetFrameworkResponse();
        setFrameworkFields(frameworkOptional.get(), frameworkResponse);
        return frameworkResponse;
    }

    @Override
    public GetFrameworkResponse update(UpdateFrameworkRequest updateFrameworkRequest) {
        isNameEmpty(updateFrameworkRequest.getName());
        Optional<Framework> frameworkRepositoryById = frameworkRepository.findById(updateFrameworkRequest.getId());
        frameworkRepositoryById.get().setName(updateFrameworkRequest.getName());
        frameworkRepositoryById.get().setProgramingLanguage(programingLanguageRepository.findById(updateFrameworkRequest.getProgramingLanguageId()).get());
        frameworkRepository.save(frameworkRepositoryById.get());
        GetFrameworkResponse frameworkResponse = new GetFrameworkResponse();
        BeanUtils.copyProperties(frameworkRepositoryById.get(), frameworkResponse);
        frameworkResponse.setProgramingLanguageId(frameworkRepositoryById.get().getProgramingLanguage().getId());
        return frameworkResponse;
    }

    @Override
    public void deleteById(int id) {
        frameworkRepository.deleteById(id);
    }
}
