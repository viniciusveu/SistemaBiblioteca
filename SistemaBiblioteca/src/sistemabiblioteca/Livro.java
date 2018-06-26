
package sistemabiblioteca;

public class Livro {
    private String codLivro;
    private String nome;
    private int ano;
    private boolean imprestado;

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

    public boolean isImprestado() {
        return imprestado;
    }

    public void setImprestado(boolean imprestado) {
        this.imprestado = imprestado;
    }
    
    
}
