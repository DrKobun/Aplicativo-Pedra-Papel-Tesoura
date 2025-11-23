package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int placarJogadorNumero = 0;
    int placarAplicativoNumero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){


        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        TextView placarJogador = findViewById(R.id.placarJogador);
        TextView placarMaquina = findViewById(R.id.placarMaquina);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoDoAplicativo = opcoes[numero];

        switch(opcaoDoAplicativo){
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if((opcaoDoAplicativo.equals("Tesoura") && Objects.equals(opcaoSelecionada, "Papel")) ||
           (opcaoDoAplicativo.equals("Papel") && Objects.equals(opcaoSelecionada, "Pedra")) ||
           (opcaoDoAplicativo.equals("Pedra") && Objects.equals(opcaoSelecionada, "Tesoura")))
        {
            placarAplicativoNumero++;
            placarMaquina.setText(String.valueOf(placarAplicativoNumero));
            textResultado.setText("Você perdeu!!!");
        }
        else if((Objects.equals(opcaoSelecionada, "Tesoura") && opcaoDoAplicativo.equals("Papel")) ||
                (Objects.equals(opcaoSelecionada, "Papel") && opcaoDoAplicativo.equals("Pedra")) ||
                (Objects.equals(opcaoSelecionada, "Pedra") && opcaoDoAplicativo.equals("Tesoura")))
        {
            placarJogadorNumero++;
            placarJogador.setText(String.valueOf(placarJogadorNumero));
            textResultado.setText("Você ganhou!!!");
        }
        else
        {
            textResultado.setText("Empate!!!");
        }

    }
}
