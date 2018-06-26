
package sistemabiblioteca;

import java.util.Calendar;

public class Item {
    private String codEmprestimo;
    private String codLivro;
    private Calendar dataDevolução;

    public Item() {
    }

    public Item(String codEmprestimo, String codLivro) {
        this.codEmprestimo = codEmprestimo;
        this.codLivro = codLivro;
    }

    public String getCodEmprestimo() {
        return codEmprestimo;
    }

    public void setCodEmprestimo(String codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }

    public String getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public Calendar getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(Calendar dataDevolução) {
        this.dataDevolução = dataDevolução;
    }
    
    
}
