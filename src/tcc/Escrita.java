/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bruno
 */
public class Escrita {
    
    public void EscreverPartes(String path) throws IOException{
        //Começar escrita do Contrato Inteligente
        FileWriter ContratoInteligente = new FileWriter(path);
        PrintWriter EscreverContrato = new PrintWriter(ContratoInteligente);
 
        EscreverContrato.printf("pragma solidity ^0.4.11;\n");
        EscreverContrato.printf("contract EstudoDeCaso {\n");
        for(int i = 0; i < Analise.PartesEnvolvidas.size(); i++){
            EscreverContrato.printf("  address " + Analise.PartesEnvolvidas.get(i) + ";\n");
        }
        EscreverContrato.printf("}\n");   
        ContratoInteligente.close();
    }
    
}
