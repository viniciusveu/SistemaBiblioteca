
package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Calendar;

public class Emprestimo {
    
    private String codEmprestimo;
    private String codUsuario;
    private Calendar dataEmprestimo;
    private Calendar dataDevolucao;
    private ArrayList<Item> itens;

    public Emprestimo(String codEmprestimo, String codUsuario) {
        this.codEmprestimo = codEmprestimo;
        this.codUsuario = codUsuario;
    }
    
    public void addItem(Item e){
        this.itens.add(e);
    }
    
    public String getCodEmprestimo() {
        return codEmprestimo;
    }

    public void setCodEmprestimo(String codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Calendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Calendar dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    
}
