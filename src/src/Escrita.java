package src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bruno
 */
public class Escrita {

    private String funcoes;


    public void EscreverContrato(String path, int opEscrita, Contrato contrato) throws IOException {
        //System.out.println(Contrato.Transicoes.size());
        FileWriter ContratoInteligente = new FileWriter(path);
        PrintWriter EscreverContrato = new PrintWriter(ContratoInteligente);

        String nomeDoContrato = separarNomeContrato(path);

        EscreverContrato.printf("pragma solidity ^0.5.11;\n\n");
        EscreverContrato.printf("contract " + nomeDoContrato + " {\n\n");
        EscreverContrato.print("\tenum Stages {\n");
        for (int i = 0; i < contrato.Estados.size(); i++) {
            if (i + 1 == contrato.Estados.size()) {
                EscreverContrato.printf("\t\testado" + contrato.Estados.get(i) + "\n");
            } else {
                EscreverContrato.printf("\t\testado" + contrato.Estados.get(i) + ",\n");
            }

        }
        EscreverContrato.print("\t}\n\n");

        EscreverContrato.print("\tStages public stage = Stages.estado0;\n");
        for (int i = 0; i < contrato.PartesEnvolvidas.size(); i++) {
            EscreverContrato.printf("\taddress " + contrato.PartesEnvolvidas.get(i) + ";\n");
        }

        for (int i = 0; i < contrato.PartesEnvolvidas.size(); i++) {
            EscreverContrato.print("\n\tmodifier only" + contrato.PartesEnvolvidas.get(i).toUpperCase() + "(){\n");
            EscreverContrato.print("\t\trequire(msg.sender == " + contrato.PartesEnvolvidas.get(i) + ");\n");
            EscreverContrato.print("\t\t_;\n");
            EscreverContrato.print("\t}\n");
        }

        EscreverContrato.print("\n\tmodifier atStage(Stages _stage) {\n");
        EscreverContrato.print("\t\trequire(stage == _stage);\n");
        EscreverContrato.print("\t\t_;\n");
        EscreverContrato.print("\t}\n");

        if (opEscrita == 0) {
            for (int i = 0; i < contrato.Actions.size(); i++) {
                EscreverContrato.print("\n\tfunction " + contrato.Actions.get(i) + "() public {\n");
                EscreverContrato.print("\n\t//TODO Escreva a funcao aqui\n\n");
                EscreverContrato.print("\t}\n");
            }
        } else if (opEscrita == 1) {
            EscreverContrato.print(funcoes);
        }

        EscreverContrato.printf("}\n");
        ContratoInteligente.close();
    }

    public String separarNomeContrato(String path) {
        String result = path.substring(path.lastIndexOf(System.getProperty("file.separator")) + 1, path.length());
        result = result.replace(".", "!");
        String nome[] = result.split("!");
        return nome[0];
    }
    
     public String getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(String funcoes) {
        this.funcoes = funcoes;
    }

}
