package catalago.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import catalago.com.entity.Plataforma;

public class MidiaForm {

	private Integer id;
	private String titulo;
	private Date dataLancamento;
	private String descricao;
	private String genero;
	private Integer classificacao;
	private Double nota;
	private Integer duracao;
	private String diretor;
	private List<String> atores;
	private PlataformaForm plataforma;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public List<String> getAtores() {
		if (atores == null) {
			atores = new ArrayList<String>();
		}
		return atores;
	}

	public void setAtores(List<String> atores) {
		this.atores = atores;
	}

	public PlataformaForm getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(PlataformaForm plataforma) {
		this.plataforma = plataforma;
	}

}
