package br.com.alura.perguntapraquemsabe;

import java.text.DecimalFormat;

/**
 * Created by Everton on 25/09/2016.
 */
public class CalculadoraFinanceira {

    public Juro ObtemTaxaDeJurosReal(double capital, double montante, int quantidadeDeParcelas){

        double montantePeloCapital = montante / capital;

        double expoenteDaFormula = 1 / (double)quantidadeDeParcelas;

        double resultadoElevadoAoExpoente = (Math.pow(montantePeloCapital, expoenteDaFormula));

        double jurosReal = resultadoElevadoAoExpoente - 1;

        DecimalFormat formatadorDeJuros = new DecimalFormat("0.000");

        String jurosPreformatado = formatadorDeJuros.format(jurosReal).replace(',','.');
        double jurosFormatado = Double.parseDouble(jurosPreformatado);

        return new Juro(jurosFormatado);
    }

    public double ObtemElasticidadeDoPreco(double precoAnterior, double precoAtual, int quantidadeItensVendidosAnterior, int quantidadeDeItensVendidosAtual){

        double elasticidade = ((precoAtual-precoAnterior)/precoAnterior) / ((quantidadeDeItensVendidosAtual-quantidadeItensVendidosAnterior)/quantidadeItensVendidosAnterior);


    return elasticidade;

    }
}
