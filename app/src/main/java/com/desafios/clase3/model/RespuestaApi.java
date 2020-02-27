package com.desafios.clase3.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RespuestaApi {
    @SerializedName("response_code")
    private int responseCode;
    private List <Results> results;

    public RespuestaApi(int responseCode, List<Results> results) {
        this.responseCode = responseCode;
        this.results = results;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
