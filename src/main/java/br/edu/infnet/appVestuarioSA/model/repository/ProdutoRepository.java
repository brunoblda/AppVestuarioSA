package br.edu.infnet.appVestuarioSA.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;


import br.edu.infnet.appVestuarioSA.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query("from Produto p where p.usuario.id = :userId")
	public List<Produto> obterLista(Integer userId, Sort sort);
}
