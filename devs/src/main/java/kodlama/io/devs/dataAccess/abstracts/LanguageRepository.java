package kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface LanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	boolean existsProgrammingLanguageByName(String name);
}
