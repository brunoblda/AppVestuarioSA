package br.edu.infnet.appVestuarioSA.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appVestuarioSA.model.domain.Roupa;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Integer> {

	@Query("from Roupa r where r.usuario.id = :userId")
	public List<Roupa> obterLista(Integer userId);
}