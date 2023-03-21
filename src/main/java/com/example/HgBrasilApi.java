package com.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class HgBrasilApi {
    public static Double getCurrencyQuote(String symbol) throws Exception {
        // faz uma solicitação GET para a API do HG Brasil para obter a cotação da moeda desejada
        HttpResponse<String> response = Unirest.get("https://api.hgbrasil.com/finance/quotations")
            .queryString("key", "29633f9c")
            .queryString("format", "json-cors")
            .queryString("symbol", symbol)
            .asString();
    
        // verifica se a solicitação foi bem-sucedida
        if (response.getStatus() == 200) {
            // analisa a resposta JSON retornada pela API do HG Brasil
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.getBody());
            JSONObject results = (JSONObject) jsonObject.get("results");
            JSONObject currencies = (JSONObject) results.get("currencies");
            JSONObject currency = (JSONObject) currencies.get(symbol);
            Double currencyQuote = (Double) currency.get("buy");
    
            return currencyQuote;
        } else {
            throw new Exception("Erro ao acessar a API do HG Brasil: " + response.getStatus());
        }
    }
    
    
}
