package workshop.spring.boot.workshopspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import workshop.spring.boot.workshopspringboot.models.Team;
import workshop.spring.boot.workshopspringboot.repositories.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository repository;

	@Autowired
	public TeamServiceImpl(TeamRepository repository) {
		this.repository = repository;
	}

	@Override
	public Team create(Team team) {
		return this.repository.save(team);
	}

	@Override
	public Team update(Integer id, Team team) {
		Team savedTeam = this.findById(id);
		savedTeam.setName(team.getName());
		savedTeam.setStadium(team.getStadium());
		return this.repository.save(savedTeam);

	}

	@Override
	public void delete(Integer id) {
		Team deleteTeam = this.findById(id);
		this.repository.delete(deleteTeam);
	}

	@Override
	public Page<Team> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public Team findById(Integer id) {
		Optional<Team> possibleTeam = this.repository.findById(id);

		if (!possibleTeam.isPresent()) {
			// throw new TeamNotFoundException();
		}

		return possibleTeam.get();
	}

	@Override
	public List<Team> findAll() {
		return this.repository.findAll();
	}

}
