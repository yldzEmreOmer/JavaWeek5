package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologyResponse;

public interface TechnologyService {

	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void delete(int id);
	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	List<GetAllTechnologyResponse> getAll();
}
