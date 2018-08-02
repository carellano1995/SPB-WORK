package workshop.spring.boot.workshopspringboot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import workshop.spring.boot.workshopspringboot.models.Team;
import workshop.spring.boot.workshopspringboot.repositories.TeamRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {

	TeamRepository repository;

	public TeamController(TeamRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	@ResponseBody
	public List<Team> findAll() {
		return this.repository.findAll();
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Team> create(@Valid @RequestBody Team team) {
		Team savedTeam = this.repository.save(team);

		return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
	}

}
