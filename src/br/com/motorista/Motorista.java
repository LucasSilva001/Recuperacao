package br.com.motorista;

import java.util.Calendar;
import java.util.List;

import br.com.veiculo.Veiculo;

public class Motorista {
	
	private String nome;
	private int anoDeNascimento;
	private int idade;
	private String categoriaHabilitacao;
	private Veiculo veiculo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoDeNascimento() {
		return anoDeNascimento;
	}
	public void setAnoDeNascimento(int anoDeNascimento) {
		this.anoDeNascimento = anoDeNascimento;
		setIdade();
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade() {
		Calendar calendar = Calendar.getInstance();
		this.idade = calendar.get(Calendar.YEAR) - getAnoDeNascimento() ;
	}
	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	}
