package kodlama.io.ProgramingLanguagesAdvanced.dataAccess.abstracts;

import kodlama.io.ProgramingLanguagesAdvanced.entities.concretes.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
}
