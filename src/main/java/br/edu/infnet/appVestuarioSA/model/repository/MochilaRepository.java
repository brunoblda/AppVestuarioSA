package br.edu.infnet.appVestuarioSA.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appVestuarioSA.model.domain.Mochila;

@Repository
public interface MochilaRepository extends CrudRepository<Mochila, Integer> {

	@Query("from Mochila m where m.usuario.id = :userId")
	public List<Mochila> obterLista(Integer userId);
}