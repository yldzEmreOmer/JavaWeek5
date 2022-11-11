package kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreatePogrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/prgrammingLanguages")
public class ProgrammingLanguageController {

	private LanguageService languageService;

	@Autowired
	public ProgrammingLanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@GetMapping("/getAll")
	public List<GetAllProgrammingLanguageResponse> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreatePogrammingLanguageRequest createPogrammingLanguageRequest)throws Exception {
		languageService.add(createPogrammingLanguageRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		languageService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception{
		languageService.update(updateProgrammingLanguageRequest);
	}

	@GetMapping("/getById")
	public GetAllProgrammingLanguageResponse getById(@PathVariable int id) throws Exception{
		return languageService.getById(id);
	}
}
