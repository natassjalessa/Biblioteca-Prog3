package br.edu.femass.model;

import java.time.LocalDate;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao = null;
    private LocalDate dataDevolucao;
    private Exemplar exemplar;
    private Leitor leitor;
    private Livro livro;
    private Exemplar nomeEmprestimo;


    public Emprestimo() {

    }

    public Emprestimo(Exemplar exemplar, Leitor leitor) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        this.exemplar = exemplar;
        this.nomeEmprestimo = this.getExemplar();
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Nome Livro: " + exemplar.getLivro().toString() +
                " " +
                "Data Devolucao: " + getDataPrevistaDevolucao().toString();
    }
}
