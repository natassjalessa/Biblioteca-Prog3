package br.edu.femass.model;

public class Leitor {

    private Long codigo;
    private static Long proximoCodigo = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    private Integer prazoMaximoDevolucao;

    public Leitor() {

    }

    public Leitor(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        //this.prazoMaximoDevolucao = prazoMaximoDevolucao;
        this.codigo = proximoCodigo;
        proximoCodigo++;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setPrazoMaximoDevolucao(Integer prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }
    public String toString() {
        return prazoMaximoDevolucao.toString();
    }

    public boolean equals(Object obj) {
        Leitor leitor = (Leitor) obj;
        return this.prazoMaximoDevolucao.equals(leitor.getPrazoMaximoDevolucao());
    }

}
