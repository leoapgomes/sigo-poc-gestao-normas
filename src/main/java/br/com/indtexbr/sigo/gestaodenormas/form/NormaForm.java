package br.com.indtexbr.sigo.gestaodenormas.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.indtexbr.sigo.gestaodenormas.models.Norma;

public class NormaForm {

		
	@NotNull @NotEmpty
	private String norma;
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
	private String tipoDeNorma;
	@NotNull @NotEmpty
	private String url;	
	
	public String getNorma() {
		return norma;
	}

	public void setNorma(String norma) {
		this.norma = norma;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipoDeNorma() {
		return tipoDeNorma;
	}

	public void setTipoDeNorma(String tipoDeNorma) {
		this.tipoDeNorma = tipoDeNorma;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
		
	public Norma toNorma() {
		Norma norma = new Norma();
		norma.setNorma(this.norma);
		norma.setTitulo(this.titulo);
		norma.setTipoDeNorma(this.tipoDeNorma);
		norma.setUrl(this.url);
		
		return norma;
		
	}
		

}
