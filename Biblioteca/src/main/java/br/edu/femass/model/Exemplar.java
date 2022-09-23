package br.edu.femass.model;

import java.time.LocalDate;

public class Exemplar {

    private Long codigo;
    private LocalDate dataAquisicao;

    public Exemplar() {

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
}
