package br.com.indtexbr.sigo.gestaodenormas.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.indtexbr.sigo.gestaodenormas.models.Norma;

public class NormaDTO {

	private Long id;
	private String norma;
	private String titulo;
	private String tipoDeNorma;
	private String url;	

	
	public String getNorma() {
		return norma;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTipoDeNorma() {
		return tipoDeNorma;
	}

	public String getUrl() {
		return url;
	}

	@Deprecated
	public NormaDTO() {}
	
	public NormaDTO(Norma norma) {
		this.id = norma.getId();
		this.norma = norma.getNorma();
		this.titulo = norma.getTitulo();
		this.tipoDeNorma = norma.getTipoDeNorma();
		this.url = norma.getUrl();
	}
	
	public NormaDTO(Long id, String norma, String titulo, String tipoDeNorma, String url) {
		this.id = id;
		this.norma = norma;
		this.titulo = titulo;
		this.tipoDeNorma = tipoDeNorma;
		this.url = url;
	}
	public Long getId() {
		return id;
	}

		
}
