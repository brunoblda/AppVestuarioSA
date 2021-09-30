package br.edu.infnet.appVestuarioSA.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;


import br.edu.infnet.appVestuarioSA.model.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	@Query("from Pedido p where p.usuario.id = :userId")
	public List<Pedido> obterLista(Integer userId, Sort sort);
}
