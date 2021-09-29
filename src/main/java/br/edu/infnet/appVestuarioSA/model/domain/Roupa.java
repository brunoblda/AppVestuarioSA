package br.edu.infnet.appVestuarioSA.model.domain;

import javax.persistence.Entity;


import br.edu.infnet.appVestuarioSA.model.exceptions.TecidoNaoPreenchidoException;

@Entity
public class Roupa extends Produto {

	private String tipoDeRoupa; // saia, short, camiseta
	private String cor;
	private String tecido;
	private String tamanho;
	private boolean infantil;
	
	public Roupa() {
		
	}
	
	public Roupa( String descricao, float valor, String tipoDeRoupa, String cor, String tecido, String tamanho, boolean infantil) {
		super( descricao, valor);
		
		this.tipoDeRoupa = tipoDeRoupa;
		this.cor = cor;
		this.tecido = tecido;
		this.tamanho = tamanho;
		this.infantil = infantil;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.tipoDeRoupa);
		sb.append(";");
		sb.append(this.cor);
		sb.append(";");
		sb.append(this.tecido);
		sb.append(";");
		sb.append(this.tamanho);
		sb.append(";");
		sb.append(this.infantil ? "S" : "N");
		
		
		return sb.toString();
	}
	


	public String getTipoDeRoupa() {
		return tipoDeRoupa;
	}


	public void setTipoDeRoupa(String tipoDeRoupa) {
		this.tipoDeRoupa = tipoDeRoupa;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getTecido() {
		return tecido;
	}


	public void setTecido(String tecido) {
		this.tecido = tecido;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public boolean isInfantil() {
		return infantil;
	}


	public void setInfantil(boolean infantil) {
		this.infantil = infantil;
	}


	@Override
	public float calcularValorPromocional() throws TecidoNaoPreenchidoException {
		
		if(this.tecido.isBlank()) {
		   throw new TecidoNaoPreenchidoException("Não tem informação do tecido");
		}
	
		float valorReturn;
		
		if ("algodao".equalsIgnoreCase(tecido)) {
			valorReturn = (float) (this.valor * 0.90);
		}else {
			valorReturn = this.valor;
		}
		
		
		return  valorReturn;
	}

}
