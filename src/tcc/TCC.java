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
public class TCC {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\TCC\\EstudoDeCaso.rcl"));
        ArrayList<Character> PartesEnvolvidas = new ArrayList<>();
        while(br.ready()){
            String linha = br.readLine();
            linha = linha.replace(" ", "");
            if(!PartesEnvolvidas.contains(linha.charAt(1)) && Character.isLetter(linha.charAt(1))){
                PartesEnvolvidas.add(linha.charAt(1));    
            }
            if(!PartesEnvolvidas.contains(linha.charAt(3)) && Character.isLetter(linha.charAt(3))){
                PartesEnvolvidas.add(linha.charAt(3));
            }
        }

        br.close();
        for(int i = 0; i < PartesEnvolvidas.size(); i++){
            System.out.println(PartesEnvolvidas.get(i));
        }
    }
    
}
