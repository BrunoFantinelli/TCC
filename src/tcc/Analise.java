/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bruno
 */
public class Analise {

    public void iniciarAnalise(String path) throws FileNotFoundException, IOException {
        //Carregar contrato
        BufferedReader br = new BufferedReader(new FileReader(path));
        //Ler contrato linha por linha
        while (br.ready()) {
            String linha = br.readLine();
            if(linha.startsWith("A")){
                determinarActions(linha);
            }else if(linha.startsWith("I")){
                determinarPartes(linha);
            }else if(linha.startsWith("Q")){
                determinarEstados(linha);
            }else if(linha.startsWith("V")){
                determinarEstadoValido(linha);
            }else if(linha.startsWith("S")){
                determinarEstadoInvalido(linha);
            }else if(linha.startsWith("T")){
                determinarTransicoes(linha);
            }            
        }
        LogTXT(path);
        br.close();
    }
    
    public void determinarActions(String linha){
        String quebraInicial[] = linha.split(":");
        String actions[] = quebraInicial[1].split(";");
        for (String action : actions) {
            Contrato.Actions.add(action);
        }
    }
    
    public void determinarPartes(String linha){
        String quebraInicial[] = linha.split(":");
        String partes[] = quebraInicial[1].split(";");
        for (String parte : partes) {
            Contrato.PartesEnvolvidas.add(parte);
        }
    }
    
    public void determinarEstados(String linha){
        String quebraInicial[] = linha.split(":");
        String estados[] = quebraInicial[1].split(";");
        for (String estado : estados) {
            Contrato.Estados.add(estado);
        }
    }

    public void determinarEstadoValido(String linha){
        String quebraInicial[] = linha.split(":");
        String estadosValidos[] = quebraInicial[1].split(";");
        for(String estado : estadosValidos){
            Contrato.EstadosValidos.add(estado);
        }
    }
    
    public void determinarEstadoInvalido(String linha){
        String quebraInicial[] = linha.split(":");
        String estadosInvalidos[] = quebraInicial[1].split(";");
        for(String estado : estadosInvalidos){
            Contrato.EstadosInvalidos.add(estado);
        }
    }
   
    public void determinarTransicoes(String linha){

        String quebraInicial[] = linha.split(":");
        String transicoes[] = quebraInicial[1].split(";");
        for(String transicao : transicoes){
            Transicao aux = new Transicao();
            String separacao[] = transicao.split("-");
            aux.FromState = separacao[0];
            aux.ToState = separacao[2];
            
            String acoes[] = separacao[1].split(",");
            for(String acao : acoes){
                String sepFinal[] = acao.split("!");
                aux.From = sepFinal[0];
                aux.Action = sepFinal[1];
                aux.To = sepFinal[2];
                if(!Contr6ato.Transicoes.contains(aux)){
                    Contrato.Transicoes.add(aux);
                }
            }
            
        }
    }
    
    
    
    public void LogTXT(String path) throws IOException{
        path += "LOGTXT.txt";
        FileWriter LogTXT = new FileWriter(path);
        PrintWriter EscreverLog = new PrintWriter(LogTXT);
        
        
        EscreverLog.printf("Partes: \n");
        for(int i = 0; i < Contrato.PartesEnvolvidas.size(); i++){
            EscreverLog.printf(Contrato.PartesEnvolvidas.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Estados: \n");
        for(int i = 0; i < Contrato.Estados.size(); i++){
            EscreverLog.printf(Contrato.Estados.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Estados Validos: \n");
        for(int i = 0; i < Contrato.EstadosValidos.size(); i++){
            EscreverLog.printf(Contrato.EstadosValidos.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Estados Invalido: \n");
        for(int i = 0; i < Contrato.EstadosInvalidos.size(); i++){
            EscreverLog.printf(Contrato.EstadosInvalidos.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Transicoes: \n");
        for(int i = 0; i < Contrato.Transicoes.size(); i++){
            EscreverLog.printf("Do Estado: " + Contrato.Transicoes.get(i).FromState + "\n");
            EscreverLog.printf("Para Estado: " + Contrato.Transicoes.get(i).ToState + "\n");
            EscreverLog.printf("Da Parte: " + Contrato.Transicoes.get(i).From + "\n");
            EscreverLog.printf("Para Parte: " + Contrato.Transicoes.get(i).To + "\n");
            EscreverLog.printf("Acao: " + Contrato.Transicoes.get(i).Action + "\n\n");
        }
        
        LogTXT.close();
    }
}