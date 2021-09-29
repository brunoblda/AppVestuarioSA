package br.edu.infnet.appVestuarioSA.model.domain;

import br.edu.infnet.appVestuarioSA.model.exceptions.MaterialSapatoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TecidoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TipoDeAtividadeNaoPreenchidaException;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String descricao;
	protected float valor;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;
	
	public Produto() {
		
	}

	public abstract float calcularValorPromocional() throws TecidoNaoPreenchidoException, MaterialSapatoNaoPreenchidoException, TipoDeAtividadeNaoPreenchidaException;
	
	public Produto( String descricao, float valor) {
		
		this.descricao = descricao;
		this.valor = valor;
	}
	
	

	public String informarProduto() throws TecidoNaoPreenchidoException, TipoDeAtividadeNaoPreenchidaException, MaterialSapatoNaoPreenchidoException {
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.calcularValorPromocional());
		
		return sb.toString();
		
	}
	
	@Override
	public String toString() {
		
		return String.format("%d;%s;%f", this.id, this.descricao, this.valor);
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}