package workshop.spring.boot.workshopspringboot.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import workshop.spring.boot.workshopspringboot.models.Player;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {
	List<Player> findAll();
}
