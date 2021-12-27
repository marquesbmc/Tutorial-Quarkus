package com.github.marquesbmc.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OBRTBO01_OPERACAO")
public class Operacao {

	public Operacao(Integer nuOperacao, String uf) {
		super();

	}

	@Id
	@GeneratedValue
	@Column(name = "`NU_OPERACAO`")
	private Integer nuOperacao;

	@Column(name = "`NU_DV_OPERACAO`")
	private Integer nuDvOperacao;

	@Column(name = "`NU_PROPOSTA`")
	private Integer nuProposta;

	@Column(name = "`NU_REPASSE`")
	private Integer nuRepasse;

	@Column(name = "`DT_RECEBIMENTO`")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ano;

	@Column(name = "`DT_CONTRATACAO`")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataContrato;

	@Column(name = "`SG_FEDERACAO`")
	private String uf;

	@Column(name = "`NO_PROPONENTE`")
	private String proponente;

	@Column(name = "`NU_LOCALIDADE`")
	private Integer nuLocalidade;

	@Column(name = "`NO_LOCALIDADE`")
	private String cidade;

	@Column(name = "`NU_ORIGEM_RECURSO`")
	private Integer nuOrigemRecurso;

	@Column(name = "`NO_ORIGEM_RECURSO`")
	private String origemRecurso;

	@Column(name = "`NO_EMPREENDIMENTO`")
	private String objetoContrato;

	@Column(name = "`VR_REPASSE`")
	private BigDecimal vrRepasse;

	@Column(name = "`VR_LIBERADO`")
	private BigDecimal vrLiberado;

	@Column(name = "`CO_PROGRAMA_ACAO`")
	private String coProgramaAcao;

	@Column(name = "`NO_PROGRAMA_ACAO`")
	private String noProgramaAcao;

	// Contratada / Descontinuada / Em Estudo
	@Column(name = "`DE_SITUACAO_CONTRATO`")
	private String situacao;

	// 1-APF / 2-IGF
	@Column(name = "`NU_ORIGEM_BASE`")
	private Integer nuOrigemBase;

	@Column(name = "`VR_EMPRESTIMO`")
	private BigDecimal vrEmprestimo;

	@Column(name = "`DE_OBJETO_CONTRATO`")
	private String deObjetoContrato;

	@Column(name = "`DT_APROVACAO_REPASSE`")
	private Date dtRepasse;

	@Column(name = "`DE_GESTOR_EXTERNO`")
	private String deGestorExterno;

	// R-Repasse / F-Financiamento
	@Column(name = "`CO_TIPO_OPERACAO`")
	private String tipoRecurso;

	// 0-ativo (importado) / 1-inativo (não importado)
	@Column(name = "`IC_ATIVO`")
	private String icAtivo;

	public Operacao() {
		super();
	}

	public Integer getNuOperacao() {
		return nuOperacao;
	}

	public void setNuOperacao(Integer nuOperacao) {
		this.nuOperacao = nuOperacao;
	}

	public Integer getNuDvOperacao() {
		return nuDvOperacao;
	}

	public void setNuDvOperacao(Integer nuDvOperacao) {
		this.nuDvOperacao = nuDvOperacao;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getProponente() {
		return proponente;
	}

	public void setProponente(String proponente) {
		this.proponente = proponente;
	}

	public Integer getNuLocalidade() {
		return nuLocalidade;
	}

	public void setNuLocalidade(Integer nuLocalidade) {
		this.nuLocalidade = nuLocalidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNuOrigemRecurso() {
		return nuOrigemRecurso;
	}

	public void setNuOrigemRecurso(Integer nuOrigemRecurso) {
		this.nuOrigemRecurso = nuOrigemRecurso;
	}

	public String getOrigemRecurso() {
		return origemRecurso;
	}

	public void setOrigemRecurso(String origemRecurso) {
		this.origemRecurso = origemRecurso;
	}

	public String getObjetoContrato() {
		return objetoContrato;
	}

	public void setObjetoContrato(String objetoContrato) {
		this.objetoContrato = objetoContrato;
	}

	public BigDecimal getVrRepasse() {
		return vrRepasse;
	}

	public void setVrRepasse(BigDecimal vrRepasse) {
		this.vrRepasse = vrRepasse;
	}

	public BigDecimal getVrLiberado() {
		return vrLiberado;
	}

	public void setVrLiberado(BigDecimal vrLiberado) {
		this.vrLiberado = vrLiberado;
	}

	public String getCoProgramaAcao() {
		return coProgramaAcao;
	}

	public void setCoProgramaAcao(String coProgramaAcao) {
		this.coProgramaAcao = coProgramaAcao;
	}

	public String getNoProgramaAcao() {
		return noProgramaAcao;
	}

	public void setNoProgramaAcao(String noProgramaAcao) {
		this.noProgramaAcao = noProgramaAcao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getNuOrigemBase() {
		return nuOrigemBase;
	}

	public void setNuOrigemBase(Integer nuOrigemBase) {
		this.nuOrigemBase = nuOrigemBase;
	}

	public BigDecimal getVrEmprestimo() {
		return vrEmprestimo;
	}

	public void setVrEmprestimo(BigDecimal vrEmprestimo) {
		this.vrEmprestimo = vrEmprestimo;
	}

	public String getDeObjetoContrato() {
		return deObjetoContrato;
	}

	public void setDeObjetoContrato(String deObjetoContrato) {
		this.deObjetoContrato = deObjetoContrato;
	}

	public String getDeGestorExterno() {
		return deGestorExterno;
	}

	public void setDeGestorExterno(String deGestorExterno) {
		this.deGestorExterno = deGestorExterno;
	}

	public Integer getNuProposta() {
		return nuProposta;
	}

	public void setNuProposta(Integer nuProposta) {
		this.nuProposta = nuProposta;
	}

	public Integer getNuRepasse() {
		return nuRepasse;
	}

	public void setNuRepasse(Integer nuRepasse) {
		this.nuRepasse = nuRepasse;
	}

	public Date getDtRepasse() {
		return dtRepasse;
	}

	public void setDtRepasse(Date dtRepasse) {
		this.dtRepasse = dtRepasse;
	}

	public String getTipoRecurso() {
		return tipoRecurso;
	}

	public void setTipoRecurso(String tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}

	public String getIcAtivo() {
		return icAtivo;
	}

	public void setIcAtivo(String icAtivo) {
		this.icAtivo = icAtivo;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

}
