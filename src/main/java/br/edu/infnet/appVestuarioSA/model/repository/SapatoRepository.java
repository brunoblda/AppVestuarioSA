package br.edu.infnet.appVestuarioSA.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;


import br.edu.infnet.appVestuarioSA.model.domain.Sapato;

@Repository
public interface SapatoRepository extends CrudRepository<Sapato, Integer> {

	@Query("from Sapato s where s.usuario.id = :userId")
	public List<Sapato> obterLista(Integer userId, Sort sort);
}
