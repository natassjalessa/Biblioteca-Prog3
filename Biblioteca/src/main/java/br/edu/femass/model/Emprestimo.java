package br.edu.femass.model;

import br.edu.femass.dao.DaoEmprestimo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao = null;
    private LocalDate dataDevolucao = null;
    private Exemplar exemplar;
    private Leitor leitor;
    private Livro livro;
    private String testeEmprestimo;
    private Exemplar nomeEmprestimo;

    List<Emprestimo> listaEmprestimo = new ArrayList<>();

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
        return  this.getExemplar() + " | Data Devolucao: " + this.getDataPrevistaDevolucao().toString();
    }
}
