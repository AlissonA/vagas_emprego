package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Emprego {

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}
	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getContatos() {
		return contatos;
	}
	public void setContatos(String contatos) {
		this.contatos = contatos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Size(min = 5, max = 20)
	private String nomeEmpresa;
	
	@Size(min = 11)
	private String cnpj;
	
	@NotBlank
	@Size(min = 5)
	private String funcao;
	
	@Min(1)
	private int vagasDisponiveis;
	
	@Size(min = 1)
	private String cargaHoraria;
	
	@Size(min = 1, max = 15)
	private String salario;
	
	@Size(min = 1)
	private String requisitos;
	
	@Size(min = 1, max = 15)
	private String contatos;
	@Id
	@GeneratedValue
	private Integer id;
	
	public Emprego() {

	}
	
}