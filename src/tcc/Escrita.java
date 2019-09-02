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
    
    public static String funcoes;
    
    public void EscreverContrato(String path) throws IOException{

        //Começar escrita do Contrato Inteligente
        FileWriter ContratoInteligente = new FileWriter(path);
        PrintWriter EscreverContrato = new PrintWriter(ContratoInteligente);
 
        String nomeDoContrato = separarNomeContrato(path);
        
        EscreverContrato.printf("pragma solidity ^0.5.11;\n\n");
        EscreverContrato.printf("contract " + nomeDoContrato + " {\n\n");
        EscreverContrato.print("\tenum Stages {\n");
        for(int i = 0; i < Contrato.Estados.size(); i++){
            if(i + 1 == Contrato.Estados.size()){
                EscreverContrato.printf("\t\testado" + Contrato.Estados.get(i) + "\n");
            }else{
                EscreverContrato.printf("\t\testado" + Contrato.Estados.get(i) + ",\n");
            }
            
        }
        EscreverContrato.print("\t}\n\n");
        
        //Define os estados do automato no contrato 
        EscreverContrato.print("\tStages public stage = Stages.estado0;\n");
        for(int i = 0; i < Contrato.PartesEnvolvidas.size(); i++){
            EscreverContrato.printf("\taddress " + Contrato.PartesEnvolvidas.get(i) + ";\n");
        }
        
        for(int i = 0; i < Contrato.PartesEnvolvidas.size(); i++){
            EscreverContrato.print("\n\tmodifier only" + Contrato.PartesEnvolvidas.get(i).toUpperCase() + "(){\n");
            EscreverContrato.print("\t\trequire(msg.sender == " + Contrato.PartesEnvolvidas.get(i) + ");\n");
            EscreverContrato.print("\t\t_;\n");
            EscreverContrato.print("\t}\n");
        }
        
        EscreverContrato.print("\n\tmodifier atStage(Stages _stage) {\n");
        EscreverContrato.print("\t\trequire(stage == _stage);\n");
        EscreverContrato.print("\t\t_;\n");
        EscreverContrato.print("\t}\n");
        
        EscreverContrato.printf("}\n");   
        ContratoInteligente.close();
    }
    
    public String separarNomeContrato(String path){
        String result = path.substring(path.lastIndexOf(System.getProperty("file.separator"))+1,path.length());
        result = result.replace(".", "!");
        String nome[] = result.split("!");
        return nome[0];
    }
    
}