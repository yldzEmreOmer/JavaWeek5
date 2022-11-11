package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreatePogrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
		List<GetAllProgrammingLanguageResponse> getProgrammingLanguageResponses = new ArrayList<>();
		programmingLanguages = languageRepository.findAll();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse getAllProgrammingLanguageResponse = new GetAllProgrammingLanguageResponse();
			getAllProgrammingLanguageResponse.setId(programmingLanguage.getId());
			getAllProgrammingLanguageResponse.setName(programmingLanguage.getName());
			getProgrammingLanguageResponses.add(getAllProgrammingLanguageResponse);
		}
		
		return getProgrammingLanguageResponses;
	}

	@Override
	public void add(CreatePogrammingLanguageRequest createPogrammingLanguageRequest) throws Exception {
		if(createPogrammingLanguageRequest.getName().isEmpty() || createPogrammingLanguageRequest.getName().isBlank()) {
			throw new Exception("Name cannot be null");
		}
		else if(languageRepository.existsProgrammingLanguageByName(createPogrammingLanguageRequest.getName())) {
			throw new Exception(createPogrammingLanguageRequest.getName() + " is already exist!");
		}
		else {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createPogrammingLanguageRequest.getName());
			languageRepository.save(programmingLanguage);
		}
		
	}

	@Override
	public void delete(int id) {
		
		languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		if(updateProgrammingLanguageRequest.getName().isEmpty() || updateProgrammingLanguageRequest.getName().isBlank()) {
			throw new Exception("Name cannot be null");
		}
		else if(languageRepository.existsProgrammingLanguageByName(updateProgrammingLanguageRequest.getName())) {
			throw new Exception(updateProgrammingLanguageRequest.getName() + " is already exist!");
		}
		else {
			ProgrammingLanguage programmingLanguage = languageRepository.findById(updateProgrammingLanguageRequest.getId()).orElseThrow(() -> new Exception("Id does not exist!"));
			programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
			languageRepository.save(programmingLanguage);
		}
			
		
	}

	@Override
	public GetAllProgrammingLanguageResponse getById(int id) throws Exception {
		
		ProgrammingLanguage programmingLanguage = languageRepository.findById(id).orElseThrow(() -> new Exception("Id does not exist"));
		GetAllProgrammingLanguageResponse getAllProgrammingLanguageResponse = new GetAllProgrammingLanguageResponse();
		getAllProgrammingLanguageResponse.setId(programmingLanguage.getId());
		getAllProgrammingLanguageResponse.setName(programmingLanguage.getName());
		return getAllProgrammingLanguageResponse;
		
	}

	
	

}
