package br.edu.femass.model;

import java.text.DateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exemplar {

    private Long codigo;
    private static Long proximoNumero = 10L;
    private LocalDate dataAquisicao;
    private Livro livro;


    public Exemplar(LocalDate dataAquisicao, Livro livro) {
        this.codigo = proximoNumero;
        proximoNumero++;
        this.livro = livro;
        this.dataAquisicao = LocalDate.now(Clock.systemDefaultZone());
    }

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

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Livro: " + this.getLivro();
    }

}
