package kodlama.io.ProgramingLanguagesAdvanced.business.concretes;

import kodlama.io.ProgramingLanguagesAdvanced.business.abstracts.ProgramingLanguageService;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.CreateProgramingLanguageRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.requests.UpdateProgramingLanguageRequest;
import kodlama.io.ProgramingLanguagesAdvanced.business.responses.GetProgramingLanguageResponse;
import kodlama.io.ProgramingLanguagesAdvanced.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.ProgramingLanguage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {

    private ProgramingLanguageRepository programingLanguageRepository;

    @Autowired
    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
        this.programingLanguageRepository = programingLanguageRepository;
    }

    @Override
    public List<GetProgramingLanguageResponse> getAll() {
        List<ProgramingLanguage> languages = programingLanguageRepository.findAll();
        List<GetProgramingLanguageResponse> languageResponses = new ArrayList<>();
        for (ProgramingLanguage language : languages) {
            GetProgramingLanguageResponse getProgramingLanguageResponse = new GetProgramingLanguageResponse();
            setProgramingLanguageFields(language, getProgramingLanguageResponse);
            languageResponses.add(getProgramingLanguageResponse);
        }
        return languageResponses;
    }

    private static void setProgramingLanguageFields(ProgramingLanguage language, GetProgramingLanguageResponse getProgramingLanguageResponse) {
        getProgramingLanguageResponse.setId(language.getId());
        getProgramingLanguageResponse.setName(language.getName());
    }

    @Override
    public GetProgramingLanguageResponse add(CreateProgramingLanguageRequest createProgramingLanguageRequest) {
        isNameEmpty(createProgramingLanguageRequest.getName());
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setName(createProgramingLanguageRequest.getName());
        ProgramingLanguage savedLanguage = programingLanguageRepository.save(programingLanguage);
        GetProgramingLanguageResponse getProgramingLanguageResponse = new GetProgramingLanguageResponse();
        setProgramingLanguageFields(savedLanguage, getProgramingLanguageResponse);
        return getProgramingLanguageResponse;
    }

    private void isNameEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("İsim boş bırakılamaz!");
        }
    }

    @Override
    public GetProgramingLanguageResponse findById(int id) {
        Optional<ProgramingLanguage> programingLanguageOptional = programingLanguageRepository.findById(id);
        GetProgramingLanguageResponse programingLanguageResponse = new GetProgramingLanguageResponse();
        setProgramingLanguageFields(programingLanguageOptional.get(),programingLanguageResponse);
        return programingLanguageResponse;
    }

    @Override
    public GetProgramingLanguageResponse update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
        isNameEmpty(updateProgramingLanguageRequest.getName());
        Optional<ProgramingLanguage> programingLanguageRepositoryById = programingLanguageRepository.findById(updateProgramingLanguageRequest.getId());
        programingLanguageRepositoryById.get().setName(updateProgramingLanguageRequest.getName());
        programingLanguageRepository.save(programingLanguageRepositoryById.get());
        GetProgramingLanguageResponse languageResponse = new GetProgramingLanguageResponse();
        BeanUtils.copyProperties(programingLanguageRepositoryById.get(),languageResponse);
        return languageResponse;
    }

    @Override
    public void deleteById(int id) {
        programingLanguageRepository.deleteById(id);
    }
}
