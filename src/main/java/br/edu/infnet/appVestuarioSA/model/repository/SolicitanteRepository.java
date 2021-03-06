package br.edu.infnet.appVestuarioSA.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;


import br.edu.infnet.appVestuarioSA.model.domain.Solicitante;

@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante, Integer> {

	@Query("from Solicitante s where s.usuario.id = :userId")
	public List<Solicitante> obterLista(Integer userId, Sort sort);
	
	
}
