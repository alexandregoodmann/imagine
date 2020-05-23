package br.com.goodmann.imagine.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<T extends BaseModel, ID> {

	@Autowired
	private BaseRepository<T, ID> repo;

	@PostMapping
	public ResponseEntity<T> create(@RequestBody T model) {
		return new ResponseEntity<T>(repo.save(model), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable(required = true, name = "id") ID id, @RequestBody T model) {
		return new ResponseEntity<T>(repo.save(model), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true, name = "id") ID id) {
		this.repo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable(required = true, name = "id") ID id) {
		Optional<T> model = this.repo.findById(id);
		if (model.isPresent()) {
			return new ResponseEntity<T>(model.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<T>> findAll() {
		return new ResponseEntity<List<T>>(this.repo.findAll(), HttpStatus.OK);
	}

}
