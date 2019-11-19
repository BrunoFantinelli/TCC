package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import tela.TelaPrincipal;

/**
 *
 * @author bruno
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
    }
    
}
