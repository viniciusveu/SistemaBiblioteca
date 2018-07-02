
package sistemabiblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Biblioteca {

    private Config configuracoes;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Livro> livros;
    String local = "C:\\Users\\JohnnyBaptista\\Desktop\\Sistem biblio\\SistemaBiblioteca\\SistemaBiblioteca\\src\\arquivos";

    public Biblioteca() {
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
        this.livros = new ArrayList<Livro>();
        this.configuracoes = new Config();
        try {
            this.loadUsuarios();
            this.loadLivros();
            JOptionPane.showMessageDialog(null, "Arquivos carregados automaticamente com sucesso!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao abrir o arquivo: " + ex.getMessage());
        }
    }

    public void loadUsuarios() throws FileNotFoundException, IOException {
//        JFileChooser chooser = new JFileChooser();
//        int resultado = chooser.showOpenDialog(null);
//        if (resultado != JFileChooser.APPROVE_OPTION) {
//            return;
//        }
//        File file = chooser.getSelectedFile();

        FileReader arq = new FileReader(local+"\\usuarios.txt");
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

        FileReader arq = new FileReader(local+"\\livros.txt");
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

    public void salvarLivros() throws IOException { //JP
        FileWriter arq = new FileWriter(local+"\\livros.txt");
        
        for(Livro l: livros){
            arq.write(l.getCodLivro() + System.getProperty("line.separator"));
            arq.write(l.getAno() + System.getProperty("line.separator"));
            arq.write(l.getNome() + System.getProperty("line.separator"));
        }
    }

    public void recuperarLivros() {
        
    }

    public String listarUsuarios() {
        String lista = "";
        for (int i = 0; i < usuarios.size(); i++) {
            lista += usuarios.get(i).toString() + "\n";
        }
        return lista;
    }
    
    public void salvarUsuarios() throws IOException{ //JP
        FileWriter arq = new FileWriter(local+"\\usuarios.txt");
        
        for(Usuario u: usuarios){
            if(u instanceof Aluno){
                arq.write("0" + System.getProperty("line.separator"));
            }else{
                arq.write("1" + System.getProperty("line.separator"));
            }
            arq.write(u.getCodUsuario() + System.getProperty("line.separator"));
            arq.write(u.getNome()+ System.getProperty("line.separator"));
            arq.write(u.getDiasEmprestimo()+ System.getProperty("line.separator"));
            if (u instanceof Aluno) {
                arq.write(((Aluno) u).getCurso()+ System.getProperty("line.separator"));
                arq.write(((Aluno) u).getAno()+ System.getProperty("line.separator"));
            }else{
                arq.write(((Professor) u).getTitulacao() + System.getProperty("line.separator"));
            }
        }
        arq.close();
    }
    
    public void salvarEmprestimos() throws IOException{ //JP
        FileWriter arq = new FileWriter(local+"\\emprestimos.txt");
        for(Emprestimo e: emprestimos){
            arq.write(e.getCodEmprestimo() + System.getProperty("line.separator"));
            arq.write(e.getCodUsuario() +System.getProperty("line.separator"));
            arq.write(e.getDataEmprestimo() +System.getProperty("line.separator"));
            for(Item i: e.getItens()){
                arq.write(i.getCodLivro()+ System.getProperty("line.separator"));      
                arq.write(i.getDataDevolução()+ System.getProperty("line.separator"));
            }
        }
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
