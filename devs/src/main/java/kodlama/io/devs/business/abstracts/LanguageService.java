package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreatePogrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;

public interface LanguageService {

	List<GetAllProgrammingLanguageResponse> getAll();

	void add(CreatePogrammingLanguageRequest createPogrammingLanguageRequest) throws Exception;

	void delete(int id);

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

	GetAllProgrammingLanguageResponse getById(int id) throws Exception;
}
