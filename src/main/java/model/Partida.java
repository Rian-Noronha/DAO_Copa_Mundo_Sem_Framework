package model;

public class Partida {
	
	private String fase;
	private String descricao;
	private String data;
	private String local;
	private String horario;
	private int id;
	private int idSelecaoUm;
	private int idSelecaoDois;
	
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSelecaoUm() {
		return idSelecaoUm;
	}
	public void setIdSelecaoUm(int idSelecao) {
		this.idSelecaoUm = idSelecao;
	}
	
	public int getIdSelecaoDois() {
		return this.idSelecaoDois;
	}
	
	public void setIdSelecaoDois(int idSelecaoDois) {
		this.idSelecaoDois = idSelecaoDois;
	}
	@Override
	public String toString() {
		return "Partida [fase=" + fase + ", descricao=" + descricao + ", data=" + data + ", local=" + local
				+ ", horario=" + horario + ", id=" + id + ", idSelecaoUm=" + idSelecaoUm + ", idSelecaoDois="
				+ idSelecaoDois + "]";
	}
	
	
	

}
