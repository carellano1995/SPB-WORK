package workshop.spring.boot.workshopspringboot.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import workshop.spring.boot.workshopspringboot.models.Player;

public interface PlayerService {

	Player create(Player player);

	Player update(Integer id, Player player);

	void delete(Integer id);

	Page<Player> findAll(Pageable pageable);

	List<Player> findAll();

	Player findById(Integer id);

	Player addTeam(Integer id, Integer teamId);
}
