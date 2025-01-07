package academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

/**
 *
 * @author Dheniel
 * @since 19/12/2024 20:00 PM
 */
public class Aluno {

    private int idAluno;
    private String nomeAluno;
    private int idadeAluno;
    private String emailAluno;
    private String matricula;
    private String tipoAula;


    /**
     *
     * @return Método construtor para forçar a entrada dos atributos na classe
     * @param nomeAluno nome do aluno
     * @param idadeAluno recebe a idade do aluno
     * @param emailAluno recebe o email do aluno
     * @param statusMatriculaAluno recebe a situação da matricula do aluno
     */
    Aluno(String nomeAluno, int idadeAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.idadeAluno = idadeAluno;
        this.emailAluno = emailAluno;
        this.matricula = "Inativa";  
        this.tipoAula = "Desmatriculado";
    }

    Aluno() {
    }

    /**
     *
     * @return Método que verifica se o cliente efetuou o pagamento para definir
     * a situação de mátricula como verdadeira
     * @param situacaoPagamento situação se o aluno efetuou o ou não o pagamento
     * @param statusMatriculaAluno define o status da matrícula
     */
    public String getMatricula() {
        return this.matricula;
    }

    public void inserirBanco() {
        Connection conexao = new Conexao().getConexao();

        String sql = "INSERT INTO aluno (id, nome, idade, email, matricula) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, this.idAluno);
            comando.setString(2, this.nomeAluno);
            comando.setInt(3, this.idadeAluno);
            comando.setString(4, this.emailAluno);
            comando.setString(5, this.matricula);

            comando.execute();
            comando.close();

            conexao.close();

            System.out.println("\n\nPerfeito, complete sua matricula efetuando o pagamento!\n");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    
    public void alterarAluno(String novoNome, int novaIdade, String novoEmail, int idAluno) {

        Connection conexao = new Conexao().getConexao();

        String sql = "UPDATE aluno SET nome = ?, idade = ?, email = ? WHERE id = ?";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, novoNome);
            comando.setInt(2, novaIdade);
            comando.setString(3, novoEmail);
            comando.setInt(4, idAluno);

            comando.executeUpdate();
            comando.close();
            conexao.close();

            System.out.println("Dados alterados!\n");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro de aluno!" + e.getMessage());
        }

    }

    public void listarAlunos() {
        Connection conexao = new Conexao().getConexao();

        String sql = "SELECT * FROM aluno";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            System.out.println("\nAlunos cadastrados:");
            System.out.println("=======================================");

            while (resultado.next()) {
                int idAluno = resultado.getInt("id");
                String nomeAluno = resultado.getString("nome");
                int idadeAluno = resultado.getInt("idade");
                String emailAluno = resultado.getString("email");
                String matricula = resultado.getString("matricula");

                System.out.printf("ID Aluno: %d | Nome = %s | Idade = %s | Email: %s | Situacao matricula: %s%n", idAluno, nomeAluno, idadeAluno, emailAluno, matricula);

            }
            resultado.close();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos!" + e.getMessage());

        }
    }

    public void excluirAluno(int idAluno) {
        Connection conexao = new Conexao().getConexao();

        try {
            String sqlPagamentos = "DELETE FROM pagamentos WHERE id_aluno = ?";
            PreparedStatement comandoPagamentos = conexao.prepareStatement(sqlPagamentos);
            comandoPagamentos.setInt(1, idAluno);
            
            int pagamentosRemovidos = comandoPagamentos.executeUpdate();
            comandoPagamentos.close();
 
            
            String sqlAluno = "DELETE FROM aluno WHERE id = ?";
            PreparedStatement comandoAluno = conexao.prepareStatement(sqlAluno);
            comandoAluno.setInt(1, idAluno);

            int alunosRemovidos = comandoAluno.executeUpdate();
            comandoAluno.close();

            if (alunosRemovidos> 0) {
                System.out.println("\nCadastro excluido com sucesso");
                if(pagamentosRemovidos > 0){
                    System.out.println("Dados de pagamentos do aluno removido com sucesso!");
                }
            } else {
                System.out.println("Nao foi encontrado aluno com o id dado!");
            }

        } catch (Exception e) {
            System.out.println("Erro a excluir aluno" + e.getMessage());
        }
    }
    public boolean verificarMatriculaAtiva(int idAluno){
        Connection conexao = new Conexao().getConexao();
       
        String sql = "SELECT matricula FROM aluno WHERE id = ?";
        boolean matriculaAtiva = false;
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, idAluno);
            
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                String statusMatricula = resultado.getString("matricula");
                if("Ativa".equalsIgnoreCase(statusMatricula)){
                    matriculaAtiva = true;
                }
            }
            resultado.close();
            comando.close();
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro ao verificar matricula: " + e.getMessage());
        }
        return matriculaAtiva;
    }
}
