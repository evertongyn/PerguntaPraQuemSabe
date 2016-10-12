package br.com.alura.perguntapraquemsabe;

/**
 * Created by Everton on 25/09/2016.
 */
public class Juro {

    private double porcentagemDeJuros;

    private TipoIncidenciaDeJuros tipoIncidenciaDeJuros;

    private String descricao;

    public Juro(String Descricao, double PorcentagemDeJuros, TipoIncidenciaDeJuros TipoDeIncidencia){
        this.descricao = Descricao;
        this.porcentagemDeJuros = PorcentagemDeJuros;
        this.tipoIncidenciaDeJuros = TipoDeIncidencia;
    }

    public double getPorcentagemDeJuros() {
        return porcentagemDeJuros;
    }

    public TipoIncidenciaDeJuros getTipoIncidenciaDeJuros() {
        return tipoIncidenciaDeJuros;
    }

    public String getDescricao() {
        return descricao;
    }

    public Juro(double PorcentagemDeJuros){
        this.porcentagemDeJuros = PorcentagemDeJuros;
    }
}
