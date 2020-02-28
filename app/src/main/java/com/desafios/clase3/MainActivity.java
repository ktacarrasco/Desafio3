package com.desafios.clase3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.desafios.clase3.api.Api;
import com.desafios.clase3.api.RetrofitClient;
import com.desafios.clase3.fragmento.PreguntaFragment;
import com.desafios.clase3.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

private String pregunta, categoria, dificultad, correctAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retrofit
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        //api.get es el metodo que esta en la interface
        Call<RespuestaApi> call = api.getAllQuestions();
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
               // response.body().getResponseCode();
                pregunta = response.body().getResults().get(0).getQuestion();
                categoria = response.body().getResults().get(0).getCategory();
                dificultad = response.body().getResults().get(0).getDifficulty();
                correctAnswer = response.body().getResults().get(0).getCorrect_answer();
                InitializeFragment(pregunta,categoria, dificultad, correctAnswer);

            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo fallo, vuelva a intentar", Toast.LENGTH_SHORT).show();
            }
        });
       // question.setText("hola");

    }
        //este metodo inicializa y añade un fragmento
        private void InitializeFragment(String pregunta, String categoria, String dificultad, String correctAnswer){
            PreguntaFragment preguntaFragment = PreguntaFragment.newInstance(pregunta,categoria,dificultad,correctAnswer);
            getSupportFragmentManager().beginTransaction().add(R.id.fl1,preguntaFragment,"PREGUNTAFRAGMENTO").commit();
        }


}
