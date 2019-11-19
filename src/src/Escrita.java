package src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bruno
 */
public class Escrita {

    public static String funcoes;
    public static int op;

    public void EscreverContrato(String path) throws IOException {

        FileWriter ContratoInteligente = new FileWriter(path);
        PrintWriter EscreverContrato = new PrintWriter(ContratoInteligente);

        String nomeDoContrato = separarNomeContrato(path);

        EscreverContrato.printf("pragma solidity ^0.5.11;\n\n");
        EscreverContrato.printf("contract " + nomeDoContrato + " {\n\n");
        EscreverContrato.print("\tenum Stages {\n");
        for (int i = 0; i < Contrato.Estados.size(); i++) {
            if (i + 1 == Contrato.Estados.size()) {
                EscreverContrato.printf("\t\testado" + Contrato.Estados.get(i) + "\n");
            } else {
                EscreverContrato.printf("\t\testado" + Contrato.Estados.get(i) + ",\n");
            }

        }
        EscreverContrato.print("\t}\n\n");

        EscreverContrato.print("\tStages public stage = Stages.estado0;\n");
        for (int i = 0; i < Contrato.PartesEnvolvidas.size(); i++) {
            EscreverContrato.printf("\taddress " + Contrato.PartesEnvolvidas.get(i) + ";\n");
        }

        for (int i = 0; i < Contrato.PartesEnvolvidas.size(); i++) {
            EscreverContrato.print("\n\tmodifier only" + Contrato.PartesEnvolvidas.get(i).toUpperCase() + "(){\n");
            EscreverContrato.print("\t\trequire(msg.sender == " + Contrato.PartesEnvolvidas.get(i) + ");\n");
            EscreverContrato.print("\t\t_;\n");
            EscreverContrato.print("\t}\n");
        }

        EscreverContrato.print("\n\tmodifier atStage(Stages _stage) {\n");
        EscreverContrato.print("\t\trequire(stage == _stage);\n");
        EscreverContrato.print("\t\t_;\n");
        EscreverContrato.print("\t}\n");

        if (op == 0) {
            for (int i = 0; i < Contrato.Actions.size(); i++) {
                EscreverContrato.print("\n\tfunction " + Contrato.Actions.get(i) + "() public {\n");
                EscreverContrato.print("\n\t//TODO Escreva a funcao aqui\n\n");
                EscreverContrato.print("\t}\n");
            }
        } else if (op == 1) {
            EscreverContrato.print(funcoes);
        }

        EscreverContrato.printf("}\n");
        ContratoInteligente.close();
        limparContrato();
    }

    public String separarNomeContrato(String path) {
        String result = path.substring(path.lastIndexOf(System.getProperty("file.separator")) + 1, path.length());
        result = result.replace(".", "!");
        String nome[] = result.split("!");
        return nome[0];
    }

    public void limparContrato(){
        Contrato.Actions.clear();
        Contrato.Estados.clear();
        Contrato.EstadosInvalidos.clear();
        Contrato.EstadosValidos.clear();
        Contrato.PartesEnvolvidas.clear();
        Contrato.Transicoes.clear();
    }
}
