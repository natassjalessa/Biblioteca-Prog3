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
    private static Long proximoNumero = 1L;
    private LocalDate dataAquisicao;
    private List<Livro> livros;

    public Exemplar(LocalDate dataAquisicao) {
        this.codigo = proximoNumero;
        proximoNumero++;
        this.livros = new ArrayList<Livro>();
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

    @Override
    public String toString() {
        return dataAquisicao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
