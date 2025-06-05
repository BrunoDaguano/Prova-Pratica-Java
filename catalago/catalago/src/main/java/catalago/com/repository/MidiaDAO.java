package catalago.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalago.com.entity.Midia;

@Repository
public interface MidiaDAO extends JpaRepository<Midia, Integer> {

}
