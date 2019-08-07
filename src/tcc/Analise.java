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
import static tcc.Analise.PartesEnvolvidas;

/**
 *
 * @author bruno
 */
public class Analise {

    //Array com as partes envolvidas
    public static ArrayList<Character> PartesEnvolvidas = new ArrayList<>();
    public static ArrayList<String> Funcoes = new ArrayList<>();

    public void iniciarAnalise(String path) throws FileNotFoundException, IOException {
        //Carregar contrato
        BufferedReader br = new BufferedReader(new FileReader(path));
        //Ler contrato linha por linha
        while (br.ready()) {
            String linha = br.readLine();
            //Retirar espaços da linha
            linha = linha.replace(" ", "");
            detectarPartes(linha);
            detectarFuncoes(linha);
        }
        br.close();
    }

    public void detectarPartes(String linha) {
        for (int i = 0; i < linha.length(); i++) {
            //Detecta a abertura para as partes do contrato
            if (linha.charAt(i) == '{') {
                //Detectar se a parte já não foi adicionado na lista
                if (!PartesEnvolvidas.contains(linha.charAt(i + 1))) {
                    PartesEnvolvidas.add(linha.charAt(i + 1));
                }
                if (!PartesEnvolvidas.contains(linha.charAt(i + 3))) {
                    PartesEnvolvidas.add(linha.charAt(i + 3));
                }
            }
        }
    }

    public void detectarFuncoes(String linha) {
        for (int i = 0; i < linha.length(); i++) {
            //Inicio de um evento ou função
            if (linha.charAt(i) == '(' || linha.charAt(i) == '[') {
                int j = i + 1;
                //Caso a abertura do paretenses esteja no fim da linha
                if(j >= linha.length()){
                    return;
                }
                String novaFunc = "";
                //Até encontrar o fim da função
                while (Character.isLetter(linha.charAt(j))) {
                    novaFunc += linha.charAt(j);
                    j++;
                }
                //Adiciona na lista se não estiver vazia e ainda não estiver na lista
                if (!novaFunc.isEmpty() && !Funcoes.contains(novaFunc)) {
                    System.out.println(novaFunc);
                    Funcoes.add(novaFunc);
                }
            }
        }
    }
}
