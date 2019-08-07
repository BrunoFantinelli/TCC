/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Analise {

    //Array com as partes envolvidas
    public static ArrayList<Character> PartesEnvolvidas = new ArrayList<>();

    public void DetectarPartes(String path) throws FileNotFoundException, IOException {
        //Carregar contrato
        BufferedReader br = new BufferedReader(new FileReader(path));
        //Ler contrato linha por linha
        while (br.ready()) {
            String linha = br.readLine();
            //Retirar espaços da linha
            linha = linha.replace(" ", "");
            for (int i = 0; i < linha.length(); i++) {
                //Detecta a abertura para as partes do contrato
                if (linha.charAt(i) == '{') {
                    //Detectar se a parte já não foi adicionado na lista
                    if (!PartesEnvolvidas.contains(linha.charAt(i+1))) {
                        PartesEnvolvidas.add(linha.charAt(i+1));
                    }
                    if (!PartesEnvolvidas.contains(linha.charAt(i+3))) {
                        PartesEnvolvidas.add(linha.charAt(i+3));
                    }
                }
            }
        }
        br.close();

    }
}
