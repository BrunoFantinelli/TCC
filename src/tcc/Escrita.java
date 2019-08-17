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
        
        for(int i = 0; i < Contrato.PartesEnvolvidas.size(); i++){
            EscreverContrato.printf("\taddress " + Contrato.PartesEnvolvidas.get(i) + ";\n");
        }
        
        for(int i = 0; i < Contrato.PartesEnvolvidas.size(); i++){
            EscreverContrato.print("modifier only" + Contrato.PartesEnvolvidas.get(i).toString().toUpperCase() + "(){\n");
            EscreverContrato.print("\trequire(msg.sender == " + Contrato.PartesEnvolvidas.get(i) + ");\n");
            EscreverContrato.print("\t_;\n");
            EscreverContrato.print("}\n");
        }
        EscreverContrato.printf("}\n");   
        ContratoInteligente.close();
    }
    
}
