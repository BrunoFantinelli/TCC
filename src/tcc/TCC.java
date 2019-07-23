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
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class TCC {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Carregar contrato
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\TCC\\EstudoDeCaso.rcl"));
        //Array com as partes envolvidas
        ArrayList<Character> PartesEnvolvidas = new ArrayList<>();
        //Ler contrato linha por linha
        while(br.ready()){
            String linha = br.readLine();
            //Retirar espaços da linha
            linha = linha.replace(" ", "");
            //Detectar se a parte já não foi adicionado na lista, e que o caracter é uma parte envolvida no contrato
            if(!PartesEnvolvidas.contains(linha.charAt(1)) && Character.isLetter(linha.charAt(1))){
                PartesEnvolvidas.add(linha.charAt(1));    
            }
            if(!PartesEnvolvidas.contains(linha.charAt(3)) && Character.isLetter(linha.charAt(3))){
                PartesEnvolvidas.add(linha.charAt(3));
            }
        }
        br.close();
    
        //Começar escrita do Contrato Inteligente
        FileWriter ContratoInteligente = new FileWriter("C:\\Users\\bruno\\Documents\\NetBeansProjects\\TCC\\EstudoDeCaso.sol");
        PrintWriter EscreverContrato = new PrintWriter(ContratoInteligente);
 
        EscreverContrato.printf("pragma solidity ^0.4.11;\n");
        EscreverContrato.printf("\n");
        EscreverContrato.printf("contract EstudoDeCaso {\n");
        EscreverContrato.printf("\n");
        for(int i = 0; i < PartesEnvolvidas.size(); i++){
            EscreverContrato.printf("  address " + PartesEnvolvidas.get(i) + ";\n");
        }
        EscreverContrato.printf("}\n");   
        ContratoInteligente.close();
 
    }
    
}
