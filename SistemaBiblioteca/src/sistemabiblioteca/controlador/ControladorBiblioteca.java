
package sistemabiblioteca.controlador;

import sistemabiblioteca.Config;

public class ControladorBiblioteca {
    public Config getConfiguracoes(){
        return BD.biblioteca.getConfiguracoes();
    }
    public void salvarLivros(){
        BD.biblioteca.salvarLivros();
    }
    public void recuperarLivros(){
        BD.biblioteca.recuperarLivros();
    }
}
