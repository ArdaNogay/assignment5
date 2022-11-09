package kodlama.io.ProgramingLanguagesAdvanced.dataAccess.abstracts;

import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage,Integer> {
}
