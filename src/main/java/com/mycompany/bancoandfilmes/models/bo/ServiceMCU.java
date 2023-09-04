/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancoandfilmes.models.bo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.bancoandfilmes.models.vo.NewsMCU;
import com.mycompany.bancoandfilmes.models.vo.Util;

/**
 *
 * @author Williams Bruce
 */
public class ServiceMCU {
    static String webService = "https://www.whenisthenextmcufilm.com/api";
    static int codigoSucesso = 200;

    public NewsMCU newsMCU() throws Exception {
        String urlParaChamada = webService;

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            ObjectMapper objectMapper = new ObjectMapper();

            NewsMCU news = objectMapper.readValue(jsonEmString, NewsMCU.class);
            return news;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
