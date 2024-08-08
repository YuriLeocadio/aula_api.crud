package com.api.aula_crud.service;

import com.api.aula_crud.classes.Endereco;
import okhttp3.*;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

@Service
public class ViaCepService {

    public Endereco getEnderecoByCep(String cep) {

        Endereco endereco = new Endereco();
        OkHttpClient client = new OkHttpClient();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null){
                String result = response.body().string();

                // Mapper
                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);

            } else {
                System.out.println("Erro ao buscar o CEP: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
        }
        return endereco;
    }
}