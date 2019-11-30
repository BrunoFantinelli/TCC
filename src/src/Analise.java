package src;

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
    Contrato c = new Contrato();
    Escrita e = new Escrita();
    public Contrato iniciarAnalise(String path) throws FileNotFoundException, IOException {
        
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
        return c;
    }
    
    public void determinarActions(String linha){
        String quebraInicial[] = linha.split(":");
        String actions[] = quebraInicial[1].split(";");
        for (String action : actions) {
            c.Actions.add(action);
        }
    }
    
    public void determinarPartes(String linha){
        String quebraInicial[] = linha.split(":");
        String partes[] = quebraInicial[1].split(";");
        for (String parte : partes) {
            c.PartesEnvolvidas.add(parte);
        }
    }
    
    public void determinarEstados(String linha){
        String quebraInicial[] = linha.split(":");
        String estados[] = quebraInicial[1].split(";");
        for (String estado : estados) {
            c.Estados.add(estado);
        }
    }

    public void determinarEstadoValido(String linha){
        String quebraInicial[] = linha.split(":");
        String estadosValidos[] = quebraInicial[1].split(";");
        for(String estado : estadosValidos){
            c.EstadosValidos.add(estado);
        }
    }
    
    public void determinarEstadoInvalido(String linha){
        String quebraInicial[] = linha.split(":");
        String estadosInvalidos[] = quebraInicial[1].split(";");
        for(String estado : estadosInvalidos){
            c.EstadosInvalidos.add(estado);
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
                String sepFinal[] = acao.split("[?]");
                aux.From = sepFinal[0];
                aux.Action = sepFinal[1];
                aux.To = sepFinal[2];
                if(!c.Transicoes.contains(aux)){
                    c.Transicoes.add(aux);
                }
                if(!c.Actions.contains(aux.Action)){
                    c.Actions.add(aux.Action);
                }
            }
            
        }
    }
    
    
    
    public void LogTXT(String path) throws IOException{
        String nome = arrumarNome(path);
        path = path.replace(nome, "LOGContrato.txt");
        FileWriter LogTXT = new FileWriter(path);
        PrintWriter EscreverLog = new PrintWriter(LogTXT);
        
        
        EscreverLog.printf("Partes: \n");
        for(int i = 0; i < c.PartesEnvolvidas.size(); i++){
            EscreverLog.printf(c.PartesEnvolvidas.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Acoes: \n");
        for(int i = 0; i < c.Actions.size(); i++){
            EscreverLog.printf(c.Actions.get(i) + "\n");
        }
        EscreverLog.print("\n");
        
        EscreverLog.printf("Estados: \n");
        for(int i = 0; i < c.Estados.size(); i++){
            EscreverLog.printf(c.Estados.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Estados Validos: \n");
        for(int i = 0; i < c.EstadosValidos.size(); i++){
            EscreverLog.printf(c.EstadosValidos.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Estados Invalido: \n");
        for(int i = 0; i < c.EstadosInvalidos.size(); i++){
            EscreverLog.printf(c.EstadosInvalidos.get(i) + "\n");
        }
        EscreverLog.printf("\n");
        
        EscreverLog.printf("Transicoes: \n");
        for(int i = 0; i < c.Transicoes.size(); i++){
            EscreverLog.printf("Do Estado: " + c.Transicoes.get(i).FromState + "\n");
            EscreverLog.printf("Para Estado: " + c.Transicoes.get(i).ToState + "\n");
            EscreverLog.printf("Da Parte: " + c.Transicoes.get(i).From + "\n");
            EscreverLog.printf("Para Parte: " + c.Transicoes.get(i).To + "\n");
            EscreverLog.printf("Acao: " + c.Transicoes.get(i).Action + "\n\n");
        }
        
        LogTXT.close();
    }
    
    public String arrumarNome(String path){
        String result = path.substring(path.lastIndexOf(System.getProperty("file.separator"))+1,path.length());
        return result;
    }
}