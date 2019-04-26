package modelo;

public class Terreno {
	
	private int id;
	
	private String latitude;
	private String longetude;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongetude() {
		return longetude;
	}
	public void setLongetude(String longetude) {
		this.longetude = longetude;
	}
	public String getBairro() {
		return bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}


}
