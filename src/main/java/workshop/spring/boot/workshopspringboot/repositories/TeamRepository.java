package workshop.spring.boot.workshopspringboot.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import workshop.spring.boot.workshopspringboot.models.Team;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Integer> {

	List<Team> findAll();

}
