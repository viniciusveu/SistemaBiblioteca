
package sistemabiblioteca.controlador;

import java.io.IOException;
import sistemabiblioteca.Config;

public class ControladorBiblioteca {
    public Config getConfiguracoes(){
        return BD.biblioteca.getConfiguracoes();
    }
    public void salvarLivros() throws IOException{
        BD.biblioteca.salvarLivros();
    }
    public void recuperarLivros(){
        BD.biblioteca.recuperarLivros();
    }
}
