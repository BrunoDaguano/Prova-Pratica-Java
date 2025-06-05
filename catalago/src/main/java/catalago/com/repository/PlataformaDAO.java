package catalago.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalago.com.entity.Plataforma;

@Repository
public interface PlataformaDAO extends JpaRepository<Plataforma, Integer>{
	
}
