package br.edu.infnet.appVestuarioSA.model.domain;

import javax.persistence.Entity;


import br.edu.infnet.appVestuarioSA.model.exceptions.MaterialSapatoNaoPreenchidoException;

@Entity
public class Sapato extends Produto {

	private String materialSapato;
	private String cor;
	private Integer tamanho;
	private boolean ecologico;
	
	
	public Sapato() {
		
	}
	
	public Sapato( String descricao, float valor, String materialSapato, String cor, Integer tamanho, boolean ecologico) {
		super( descricao, valor);
		
		this.materialSapato = materialSapato;
		this.cor = cor;
		this.tamanho = tamanho;
		this.ecologico = ecologico;
		
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.materialSapato);
		sb.append(";");
		sb.append(this.cor);
		sb.append(";");
		sb.append(this.tamanho);
		sb.append(";");
		sb.append(ecologico);
		
		return sb.toString();
	}

	@Override
	public float calcularValorPromocional() throws MaterialSapatoNaoPreenchidoException {
		
		
		if(this.materialSapato.isBlank()) {
			   throw new MaterialSapatoNaoPreenchidoException("Sem informações sobre o material do sapato");
			}	
		
		float valorReturn;
		
		if ("couro".equalsIgnoreCase(materialSapato)) {
			valorReturn = (float) (this.valor * 0.75);
		}else {
			valorReturn = this.valor;
		}
		
		return valorReturn;
	}

	public String getMaterialSapato() {
		return materialSapato;
	}

	public void setMaterialSapato(String materialSapato) {
		this.materialSapato = materialSapato;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isEcologico() {
		return ecologico;
	}

	public void setEcologico(boolean ecologico) {
		this.ecologico = ecologico;
	}

	
	
}
