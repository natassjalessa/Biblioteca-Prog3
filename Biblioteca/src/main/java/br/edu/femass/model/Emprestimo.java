package br.edu.femass.model;

import java.time.LocalDate;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao = null;
    private LocalDate dataDevolucao;
    private Exemplar exemplar;
    private Leitor leitor;
    private Livro livro;

    public Emprestimo() {

    }

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao
            , Exemplar exemplar, Leitor leitor, Livro livro) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.livro = exemplar.getLivro();
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


}
