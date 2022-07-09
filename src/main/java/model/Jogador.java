package model;

public class Jogador {
	
	private String descricao;
	private String nome;
	private int id;
	private int idSelecao;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSelecao() {
		return idSelecao;
	}
	public void setIdSelecao(int idSelecao) {
		this.idSelecao = idSelecao;
	}
	@Override
	public String toString() {
		return "Jogador [descricao=" + descricao + ", nome=" + nome + ", id=" + id + ", idSelecao=" + idSelecao + "]";
	}
	
	
	

}
