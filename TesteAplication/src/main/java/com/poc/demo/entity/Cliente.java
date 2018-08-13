package com.poc.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "cliente_cod_cliente_seq", allocationSize = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_CLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	private Long codCliente;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "DATA_NASC")
	private Date dataNascimento;

	@Column(name = "DATA_INCLUSAO")
	private Date dataInclusao;

	@Column(name = "NACIONALIDADE")
	private String nacionalidade;

	@Column(name = "DEFICIENTE")
	private Boolean deficiente;

	@Column(name = "RG")
	private String rg;

	@Column(name = "DATA_ALTERACAO")
	private Date dataAlteracao;

	@Column(name = "TITULAR")
	private Boolean titular;

	@Column(name = "NATURALIDADE")
	private String naturalidade;

	@Column(name = "ESCOLARIDADE")
	private String escolaridade;

	@Column(name = "UNIDADE")
	private String unidade;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SITUACAO")
	private String situacao;

	@Column(name = "NUMERO_CARTEIRA")
	private String numCarteira;

	@Column(name = "SERIE")
	private String serie;

	@Column(name = "VL_RENDA")
	private String vlRenda;

	@Column(name = "UF")
	private String uf;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "COD_CATEGORIA", nullable = false)
	private Categoria categoria;

	@OneToMany
	@JoinTable(name = "CONTATO", joinColumns = @JoinColumn(name = "CODIGO_CONTATO"), inverseJoinColumns = @JoinColumn(name = "COD_CLIENTE"))
	private List<Contato> contatos;

	@OneToMany
	@JoinTable(name = "ENDERECO", joinColumns = @JoinColumn(name = "COD_ENDERECO_CLIENTE"), inverseJoinColumns = @JoinColumn(name = "COD_CLIENTE"))
	private List<Endereco> enderecos;

	@Transient
	private List<Cliente> dependentes;

	@Transient
	private Cliente titularInfo;

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Boolean getDeficiente() {
		return deficiente;
	}

	public void setDeficiente(Boolean deficiente) {
		this.deficiente = deficiente;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Boolean getTitular() {
		return titular;
	}

	public void setTitular(Boolean titular) {
		this.titular = titular;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNumCarteira() {
		return numCarteira;
	}

	public void setNumCarteira(String numCarteira) {
		this.numCarteira = numCarteira;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getVlRenda() {
		return vlRenda;
	}

	public void setVlRenda(String vlRenda) {
		this.vlRenda = vlRenda;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Cliente> getDependentes() {
		if (dependentes == null) {
			dependentes = new ArrayList<Cliente>();
		}
		return dependentes;
	}

	public Cliente getTitularInfo() {
		return titularInfo;
	}

	public void setTitularInfo(Cliente titularInfo) {
		this.titularInfo = titularInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		return true;
	}

}
