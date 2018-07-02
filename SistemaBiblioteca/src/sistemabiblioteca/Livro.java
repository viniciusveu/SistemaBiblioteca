
package sistemabiblioteca;

public class Livro {
    private String codLivro;
    private String nome;
    private int ano;
    private boolean emprestado;

    public Livro(String codLivro, String nome, int ano) {
        this.codLivro = codLivro;
        this.nome = nome;
        this.ano = ano;
    }

    public String getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    
    @Override
    public String toString(){
        return "Código do Livro: " + this.codLivro + "\nNome: " + this.nome + "\nAno: " + this.ano;
    }
    
    
}
