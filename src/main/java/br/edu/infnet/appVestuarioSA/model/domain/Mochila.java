package br.edu.infnet.appVestuarioSA.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appVestuarioSA.model.exceptions.TipoDeAtividadeNaoPreenchidaException;

@Entity
public class Mochila extends Produto {

	private String materialMochila;
	private String cor;
	private int quantidadeDeParticoes;
	private String tipoDeAtividade; //espotiva, estudante, escritório
	
	
	public Mochila() {
		
	}
	
	
	public Mochila( String descricao, float valor, String materialMochila, String cor, int quantidadeDeParticoes, String tipoDeAtividade ) {
		super( descricao, valor);
		
		this.materialMochila = materialMochila;
		this.cor = cor;
		this.quantidadeDeParticoes = quantidadeDeParticoes;
		this.tipoDeAtividade = tipoDeAtividade;
			
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.materialMochila);
		sb.append(";");
		sb.append(this.cor);
		sb.append(";");
		sb.append(this.quantidadeDeParticoes);
		sb.append(";");
		sb.append(this.tipoDeAtividade);
		
		
		return sb.toString();
	}

	@Override
	public float calcularValorPromocional() throws TipoDeAtividadeNaoPreenchidaException {
		
		
		if(this.tipoDeAtividade.isBlank()) {
			   throw new TipoDeAtividadeNaoPreenchidaException("Não tem informação do tecido");
			}		
		
		float valorReturn;
		
		if ("estudante".equalsIgnoreCase(tipoDeAtividade)) {
			valorReturn = (float) (this.valor * 0.85);
		}else {
			valorReturn = this.valor;
		}
		
		return valorReturn;
	}

	public String getMaterialMochila() {
		return materialMochila;
	}

	public void setMaterialMochila(String materialMochila) {
		this.materialMochila = materialMochila;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQuantidadeDeParticoes() {
		return quantidadeDeParticoes;
	}

	public void setQuantidadeDeParticoes(int quantidadeDeParticoes) {
		this.quantidadeDeParticoes = quantidadeDeParticoes;
	}

	public String getTipoDeAtividade() {
		return tipoDeAtividade;
	}

	public void setTipoDeAtividade(String tipoDeAtividade) {
		this.tipoDeAtividade = tipoDeAtividade;
	}


}
