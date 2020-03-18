package br.com.lheme.cache.model;

import java.io.Serializable;

public class Plano implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nomePlano;
	
	private String identificacao;
	
	private String dicaDePreenchimento;

	
	public Plano() {
		
	}
	
	public Plano(String nomePlano, String identificacao, String dicaDePreenchimento) {
		this.nomePlano = nomePlano;
		this.identificacao = identificacao;
		this.dicaDePreenchimento = dicaDePreenchimento;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getDicaDePreenchimento() {
		return dicaDePreenchimento;
	}

	public void setDicaDePreenchimento(String dicaDePreenchimento) {
		this.dicaDePreenchimento = dicaDePreenchimento;
	}

	@Override
	public String toString() {
		return "Plano [nomePlano=" + nomePlano + ", identificacao=" + identificacao + ", dicaDePreenchimento="
				+ dicaDePreenchimento + "]";
	}
}
