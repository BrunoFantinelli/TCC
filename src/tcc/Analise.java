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
        LogConsole();
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
        Transicao aux = new Transicao();
        String quebraInicial[] = linha.split(":");
        String transicoes[] = quebraInicial[1].split(";");
        for(String transicao : transicoes){
            String separacao[] = transicao.split("-");
            aux.FromState = separacao[0];
            aux.ToState = separacao[2];
            
            String acoes[] = separacao[1].split(",");
            for(String acao : acoes){
                String sepFinal[] = acao.split("!");
                aux.From = sepFinal[0];
                aux.Action = sepFinal[1];
                aux.To = sepFinal[2];
                Contrato.Transicoes.add(aux);
            }
            
        }
    }
    
    
    
    public void LogConsole(){
        System.out.println("Partes: ");
        for(int i = 0; i < Contrato.PartesEnvolvidas.size(); i++){
            System.out.println(Contrato.PartesEnvolvidas.get(i));
        }
        
        System.out.println("Estados: ");
        for(int i = 0; i < Contrato.Estados.size(); i++){
            System.out.println(Contrato.Estados.get(i));
        }
        
        System.out.println("Estados Validos: ");
        for(int i = 0; i < Contrato.EstadosValidos.size(); i++){
            System.out.println(Contrato.EstadosValidos.get(i));
        }
        
        System.out.println("Estados Invalidos: ");
        for(int i = 0; i < Contrato.EstadosInvalidos.size(); i++){
            System.out.println(Contrato.EstadosInvalidos.get(i));
        }
        
        System.out.println("Transicoes: ");
        for(int i = 0; i < Contrato.Transicoes.size(); i++){
            System.out.println("Do Estado: ");
            System.out.println(Contrato.Transicoes.get(i).FromState);
            System.out.println("Para Estado: ");
            System.out.println(Contrato.Transicoes.get(i).ToState);
            System.out.println("Da Parte: ");
            System.out.println(Contrato.Transicoes.get(i).From);
            System.out.println("Para Parte: ");
            System.out.println(Contrato.Transicoes.get(i).To);
            System.out.println("Acao: ");
            System.out.println(Contrato.Transicoes.get(i).Action);
        }
    }
}