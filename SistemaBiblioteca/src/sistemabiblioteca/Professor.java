
package sistemabiblioteca;

public class Professor extends Usuario {
    protected String titulacao;

    public Professor(String codUsuario, String nome, int diasEmprestimo) {
        super(codUsuario, nome, diasEmprestimo);
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
}
