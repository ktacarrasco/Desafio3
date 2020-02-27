package com.desafios.clase3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.desafios.clase3.api.Api;
import com.desafios.clase3.api.RetrofitClient;
import com.desafios.clase3.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

        private TextView pregunta ,categoria,dificultad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getAllQuestions();
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
               // response.body().getResponseCode();
                pregunta.setText(response.body().getResults().get(0).getQuestion());
                categoria.setText(response.body().getResults().get(0).getCategory());
                dificultad.setText(response.body().getResults().get(0).getDifficulty());


            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo fallo, vuelva a intentar", Toast.LENGTH_SHORT).show();
            }
        });
       // question.setText("hola");

    }

    private void initializeViews(){
        pregunta= findViewById(R.id.pregunta);
        categoria = findViewById(R.id.categoria);
        dificultad = findViewById(R.id.Dificultad);

    }

}
