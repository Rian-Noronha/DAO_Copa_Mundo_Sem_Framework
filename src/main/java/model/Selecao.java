package model;

public class Selecao {
	
	
	private String nome;
	private String descricao;
	private int id;
	private int idCopa;
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCopa() {
		return idCopa;
	}
	public void setIdCopa(int idCopa) {
		this.idCopa = idCopa;
	}

	@Override
	public String toString() {
		return "Selecao [nome=" + nome + ", descricao=" + descricao + ", id=" + id + ", idCopa=" + idCopa + "]";
	}
	
	
	
	

}
