
package sistemabiblioteca;

public class Aluno extends Usuario {
    protected String curso;
    protected int ano;

    public Aluno(String curso, int ano, String codUsuario, String nome, int diasEmprestimo) {
        super(codUsuario, nome, diasEmprestimo);
        this.curso = curso;
        this.ano = ano;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
