package com.desafios.clase3.api;

import com.desafios.clase3.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api.php?amount=10&category=15&difficulty=easy")
    Call<RespuestaApi> getAllQuestions();
}
