package modelo;

import java.sql.Date;

public class Vistoria {
	private int id;
	private Usuario estagiarioResp;
	private Terreno terreno;
	private Date dataEntrega;
	private String estado;
	private String obsevacoes;
	
	public Vistoria()
	{
		this.estado = "Executando";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getEstagiarioResp() {
		return estagiarioResp;
	}
	public void setEstagiarioResp(Usuario estagiarioResp) {
		this.estagiarioResp = estagiarioResp;
	}
	public Terreno getTerreno() {
		return terreno;
	}
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObsevacoes() {
		return obsevacoes;
	}
	public void setObsevacoes(String obsevacoes) {
		this.obsevacoes = obsevacoes;
	}
	
	

}
