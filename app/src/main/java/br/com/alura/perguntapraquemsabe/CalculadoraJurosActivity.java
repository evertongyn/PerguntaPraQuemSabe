package br.com.alura.perguntapraquemsabe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraJurosActivity extends AppCompatActivity {

    private CalculadoraFinanceira calculadoraFinanceira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_juros);

        calculadoraFinanceira = new CalculadoraFinanceira();
        Button botaoDeCalcular = (Button) findViewById(R.id.botao_calcular);
        botaoDeCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Juro jurosReal = CalculaJurosReal();

                EditText campoJurosInformado = (EditText)findViewById(R.id.juros_informado);
                String jurosInformadoParaFormatar = campoJurosInformado.getText().toString();
                double jurosInformado = ConverteStringParaDouble(jurosInformadoParaFormatar);
                jurosInformado = jurosInformado / 100;

                TipoDeComparacaoDeJuros resultadoDaComparacao = ComparaJurosRealComInformado(jurosReal.getPorcentagemDeJuros(), jurosInformado);

                InformaUsuarioResultado(resultadoDaComparacao);

                AdicionaJurosRealNaTela(jurosReal.getPorcentagemDeJuros());
            }
        });
    }

    private void AdicionaJurosRealNaTela(double porcentagemDeJuros) {
        double porcentagemDeJurosParaUsuario = porcentagemDeJuros * 100;

        TextView campoDeResultadoNaTela = (TextView)findViewById(R.id.campo_resultado);

        String resultadoParaUsuario = String.format("O juros real é %1$.3f", porcentagemDeJurosParaUsuario);
        campoDeResultadoNaTela.setText(resultadoParaUsuario);
        campoDeResultadoNaTela.setVisibility(View.VISIBLE);
    }

    private void InformaUsuarioResultado(TipoDeComparacaoDeJuros resultadoDaComparacao) {
        Toast mensagemParaUsuario;

        if(resultadoDaComparacao.equals(TipoDeComparacaoDeJuros.REAL_MENOR_INFORMADO)){
            mensagemParaUsuario = Toast.makeText(this, "ATENÇÃO: O juros real é MENOR que o juros informado!", Toast.LENGTH_LONG);
        }
        else if(resultadoDaComparacao.equals(TipoDeComparacaoDeJuros.REAL_IGUAL_INFORMADO)){
            mensagemParaUsuario = Toast.makeText(this, "Tudo certo, o juros real é IGUAL ao informado!", Toast.LENGTH_LONG);
        }
        else{
            mensagemParaUsuario = Toast.makeText(this, "ATENÇÃO: O juros real é MAIOR que o informado!", Toast.LENGTH_LONG);
        }

        mensagemParaUsuario.show();
    }

    private TipoDeComparacaoDeJuros ComparaJurosRealComInformado(double jurosReal, double jurosInformado) {

        if(jurosReal == jurosInformado){
            return TipoDeComparacaoDeJuros.REAL_IGUAL_INFORMADO;
        }
        if(jurosReal > jurosInformado){
            return TipoDeComparacaoDeJuros.REAL_MAIOR_INFORMADO;
        }

        return TipoDeComparacaoDeJuros.REAL_MENOR_INFORMADO;
    }

    private double ConverteStringParaDouble(String campoParaConverter){

        double campoConvertido = campoParaConverter == null
                || campoParaConverter.equals("") ?
                0 : Double.parseDouble(campoParaConverter);

        return campoConvertido;
    }

    private Juro CalculaJurosReal(){

        EditText campoCapital = (EditText)findViewById(R.id.capital);
        double capital = Double.parseDouble(campoCapital.getText().toString());

        EditText campoMontante = (EditText)findViewById(R.id.montante);
        double montante = Double.parseDouble(campoMontante.getText().toString());

        EditText campoQuantidadeDeParcelas = (EditText)findViewById(R.id.quantidade_parcelas);
        int quantidadeDeParcelas = Integer.parseInt(campoQuantidadeDeParcelas.getText().toString());

        Juro jurosReal = calculadoraFinanceira.ObtemTaxaDeJurosReal(capital, montante, quantidadeDeParcelas);

        return jurosReal;
}
}
