package model;

public class CopaMundo {
	
	
	private String nome;
	private String dataInicio;
	private String dataFim;
	private String lugar;
	private int id;
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "CopaMundo [nome=" + nome + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", lugar=" + lugar
				+ ", id=" + id + "]";
	}
	
	
	
	
	
	

}
