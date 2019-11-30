package src;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Contrato {
    
    public ArrayList<String> PartesEnvolvidas = new ArrayList<>();
    public ArrayList<String> Actions = new ArrayList<>();
    public ArrayList<String> Estados = new ArrayList<>();
    public ArrayList<String> EstadosValidos = new ArrayList<>();
    public ArrayList<String> EstadosInvalidos = new ArrayList<>();
    public ArrayList<Transicao> Transicoes = new ArrayList<>();
    
}
