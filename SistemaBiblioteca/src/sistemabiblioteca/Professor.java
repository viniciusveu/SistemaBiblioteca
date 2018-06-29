package sistemabiblioteca;

public class Professor extends Usuario {

    protected String titulacao;

    public Professor(String codUsuario, String nome, String titulacao, int diasEmprestimo) {
        super(codUsuario, nome, diasEmprestimo);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String toString() {
        return "\nCodigo de Usuario: " + super.getCodUsuario()
                + "\nNome: " + super.getNome()
                + "\nDias de Empréstimo: " + super.getDiasEmprestimo()
                + "\nTitulação: " + this.titulacao;
    }

}
