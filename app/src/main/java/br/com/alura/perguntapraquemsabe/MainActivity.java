package br.com.alura.perguntapraquemsabe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoAtividade2 = (Button)findViewById(R.id.button_atividade2);
        botaoAtividade2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentVaiParaCalculadoraJuros = new Intent(MainActivity.this, CalculadoraJurosActivity.class);
                startActivity(intentVaiParaCalculadoraJuros);
            }
        });


    }
}
