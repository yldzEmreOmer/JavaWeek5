package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = languageRepository
				.findById(createTechnologyRequest.getProgrammingLanguageId())
				.orElseThrow(() -> new Exception("Programming language id does not exist"));
		Technology subTechnology = new Technology();
		subTechnology.setTechnologyName(createTechnologyRequest.getName());
		subTechnology.setProgrammingLanguage(programmingLanguage);
		technologyRepository.save(subTechnology);
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = languageRepository
				.findById(updateTechnologyRequest.getProgrammingLanguageId()).orElseThrow(null);
		Technology subTechnology = technologyRepository.findById(updateTechnologyRequest.getId()).orElse(null);
		subTechnology.setProgrammingLanguage(programmingLanguage);
		subTechnology.setTechnologyName(updateTechnologyRequest.getName());
		technologyRepository.save(subTechnology);
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> subTechnologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<>();
		for (Technology technology : subTechnologies) {
			GetAllTechnologyResponse getAllTechnologyResponse = new GetAllTechnologyResponse();
			getAllTechnologyResponse.setId(technology.getTechnologyId());
			getAllTechnologyResponse.setName(technology.getTechnologyName());
			getAllTechnologyResponse.setProgrammingLanguageId(technology.getProgrammingLanguage().getId());
			getAllTechnologyResponses.add(getAllTechnologyResponse);
		}
		return getAllTechnologyResponses;

	}

}
