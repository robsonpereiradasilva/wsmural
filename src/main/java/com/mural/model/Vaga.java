package com.mural.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "vagas")
@Entity
public class Vaga {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String empresa;
	private String vaga;
	private String descricao;
	private float salario;
	
	
	public Vaga() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getVaga() {
		return vaga;
	}


	public void setVaga(String vaga) {
		this.vaga = vaga;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getSalario() {
		return salario;
	}


	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	

}
