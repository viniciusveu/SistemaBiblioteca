package sistemabiblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Biblioteca {

    private Config configuracoes;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Livro> livros;

    public Biblioteca() {
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
        this.livros = new ArrayList<Livro>();
        this.configuracoes = new Config();
    }

    public void loadUsuarios() throws FileNotFoundException, IOException {
//        JFileChooser chooser = new JFileChooser();
//        int resultado = chooser.showOpenDialog(null);
//        if (resultado != JFileChooser.APPROVE_OPTION) {
//            return;
//        }
//        File file = chooser.getSelectedFile();

        FileReader arq = new FileReader("/home/vedovotto/Documentos/usuarios.txt");
        BufferedReader leitor = new BufferedReader(arq);

        while (true) {
            String curso, titulacao;
            int ano;
            String str_tipo = leitor.readLine();
            if (str_tipo == null) {
                break;
            }
            int tipo = Integer.parseInt(str_tipo);
            String codUsuario = leitor.readLine();
            String nome = leitor.readLine();
            int diasEmprestimos = Integer.parseInt(leitor.readLine());
            if (tipo == 0) { //aluno
                curso = leitor.readLine();
                ano = Integer.parseInt(leitor.readLine());
                this.addAluno(codUsuario, nome, curso, ano);
            } else {//professor
                titulacao = leitor.readLine();
                this.addProfessor(codUsuario, nome, titulacao);
            }
        }
    }

    public void loadLivros() throws FileNotFoundException, IOException {
//        JFileChooser chooser = new JFileChooser();
//        int resultado = chooser.showOpenDialog(null);
//        if (resultado != JFileChooser.APPROVE_OPTION) {
//            return;
//        }
//        File file = chooser.getSelectedFile();

        FileReader arq = new FileReader("/home/vedovotto/Documentos/livros.txt");
        BufferedReader leitor = new BufferedReader(arq);

        while (true) {
            int ano;
            String nome, str_ano, codLivro;

            codLivro = leitor.readLine();
            if (codLivro == null) {
                break;
            }
            nome = leitor.readLine();
            ano = Integer.parseInt(leitor.readLine());

            this.addLivro(codLivro, nome, ano);
        }

    }
    
    public Config getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(Config configuracoes) {
        this.configuracoes = configuracoes;
    }

    public void addAluno(String codUsuario, String nome, String curso, int ano) {
        Aluno aluno = new Aluno(curso, ano, codUsuario, nome, configuracoes.getDiasAluno());
        this.usuarios.add(aluno);
    }

    public void addProfessor(String codUsuario, String nome, String titulacao) {
        Professor prof = new Professor(codUsuario, nome, titulacao, configuracoes.getDiasProfessor());
        this.usuarios.add(prof);
    }

    public void addLivro(String codLivro, String nome, int ano) {
        Livro livro = new Livro(codLivro, nome, ano);
        this.livros.add(livro);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void salvarLivros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void recuperarLivros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String listarUsuarios() {
        String lista = "";
        for (int i = 0; i < usuarios.size(); i++) {
            lista += usuarios.get(i).toString() + "\n";
        }
        return lista;
    }

    public String listarAlunos() {
        String lista = "";
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Aluno) {
                lista += usuarios.get(i).toString() + "\n";
            }
        }
        return lista;
    }

    public String listarProfessor() {
        String lista = "";
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Professor) {
                lista += usuarios.get(i).toString() + "\n";
            }
        }
        return lista;
    }

    public String listarUsuariosComAtraso() {
        return "";
    }

    public String listarLivros() {
        String lista = "";
        for (int i = 0; i < livros.size(); i++) {
            lista += livros.get(i).toString() + "\n\n\n";
        }
        return lista;
    }

}
