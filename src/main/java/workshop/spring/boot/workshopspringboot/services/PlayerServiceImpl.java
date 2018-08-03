package workshop.spring.boot.workshopspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import workshop.spring.boot.workshopspringboot.models.Player;
import workshop.spring.boot.workshopspringboot.models.Team;
import workshop.spring.boot.workshopspringboot.repositories.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	private PlayerRepository repository;
	private TeamService teamService;

	@Autowired
	public PlayerServiceImpl(PlayerRepository repository, TeamService teamService) {
		this.repository = repository;
		this.teamService = teamService;

	}

	@Override
	public Player create(Player player) {

		Team team = this.teamService.findById(player.getTeam().getId());

		player.setTeam(team);

		return this.repository.save(player);
	}

	@Override
	public Player update(Integer id, Player player) {

		Player savedPlayer = this.findById(id);
		Team team = this.teamService.findById(player.getTeam().getId());
		savedPlayer.setName(player.getName());
		savedPlayer.setTeam(team);

		return this.repository.save(savedPlayer);

	}

	@Override
	public Player addTeam(Integer id, Integer teamId) {

		Player savedPlayer = this.findById(id);
		Team savedTeam = this.teamService.findById(teamId);
		savedPlayer.setTeam(savedTeam);

		return this.repository.save(savedPlayer);

	}

	@Override
	public void delete(Integer id) {
		Player deletePlayer = this.findById(id);

		this.repository.delete(deletePlayer);

	}

	@Override
	public Page<Player> findAll(Pageable pageable) {

		return this.repository.findAll(pageable);
	}

	@Override
	public List<Player> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Player findById(Integer id) {
		Optional<Player> possiblePlayer = this.repository.findById(id);

		if (!possiblePlayer.isPresent()) {
			throw new PlayerNotFoundException();
		}

		return possiblePlayer.get();
	}

}
