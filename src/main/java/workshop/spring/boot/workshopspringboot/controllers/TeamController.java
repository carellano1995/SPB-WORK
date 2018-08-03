package workshop.spring.boot.workshopspringboot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import workshop.spring.boot.workshopspringboot.models.Team;
import workshop.spring.boot.workshopspringboot.services.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

	private TeamService service;

	@Autowired
	public TeamController(TeamService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseBody
	public Page<Team> findAll(Pageable pageable) {
		return this.service.findAll(pageable);
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Team> findAll() {
		return this.service.findAll();
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Team> create(@Valid @RequestBody Team team) {
		Team savedTeam = this.service.create(team);

		return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Team> update(@PathVariable(value = "id") Integer id, @RequestBody Team team) {
		Team savedTeam = this.service.update(id, team);

		return new ResponseEntity<>(savedTeam, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Team> delete(@PathVariable(value = "id") Integer id) {
		this.service.delete(id);

		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
