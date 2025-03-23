package Utils;

import Domain.Endereco;
import com.google.gson.Gson;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Utils {
    private static final String VIACEP_URL = "https://viacep.com.br/ws/%s/json/";
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|");

    public static boolean isCPF(String CPF) {
        if (CPF == null) {
            return false;
        }

        // Remove caracteres não numéricos
        CPF = CPF.replaceAll("\\D", "");

        // Verifica se tem 11 dígitos e não é uma sequência repetida
        if (CPF.length() != 11 || CPF.matches("(\\d)\\1{10}")) {
            return false;
        }

        return validarDigitos(CPF);
    }

    private static boolean validarDigitos(String CPF) {
        int sm, num, peso, r;
        char dig10, dig11;

        try {
            // Cálculo do 1º dígito verificador
            sm = 0;
            peso = 10;
            for (int i = 0; i < 9; i++) {
                num = CPF.charAt(i) - '0'; // Converte caractere numérico para inteiro
                sm += (num * peso);
                peso--;
            }

            r = 11 - (sm % 11);
            dig10 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

            // Cálculo do 2º dígito verificador
            sm = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                num = CPF.charAt(i) - '0';
                sm += (num * peso);
                peso--;
            }

            r = 11 - (sm % 11);
            dig11 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

            return (dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public static String imprimeCPF(String CPF) {
        CPF = CPF.replaceAll("\\D", ""); // Remove caracteres não numéricos
        if (CPF.length() != 11) {
            return CPF;
        }

        return String.format("%s.%s.%s-%s", CPF.substring(0, 3), CPF.substring(3, 6), CPF.substring(6, 9), CPF.substring(9, 11));
    }
    
    public static Endereco searchAddress(String cep) {
        String jsonResponse = SearchCep(cep);
        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return null;
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, Endereco.class);
    }
    
    private static String SearchCep(String cep) {
        try {
            cep = cep.replaceAll("\\D", ""); // Remove caracteres não numéricos
            if (cep.length() != 8) {
                return null; // CEP inválido
            }
            
            URL url = new URL(String.format(VIACEP_URL, cep));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            return response.toString();
        } catch (Exception e) {
            return null;
        }
    }
}

