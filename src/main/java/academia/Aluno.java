package academia;

/**
 * Classe definida para tratar de usuarios cadastrados, alunos.
 * @author Marcus Vinícius, Marcos Felipe, Dheniel Rodrigues, Kaua Luiz
 * since 25/12/2024 at 14:08 PM
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

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
        this.tipoAula = "Parado";
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

    /**
     * Insere um novo aluno no banco de dados.
     * Os dados do aluno são inseridos na tabela 'aluno', incluindo o ID, nome, idade, email, matrícula e tipo de aula.
     * 
     * @throws SQLException Se houver um erro na execução.
     */
    
    public void inserirBanco() {
        Connection conexao = new Conexao().getConexao();

        String sql = "INSERT INTO aluno (id, nome, idade, email, matricula, tipo_aula) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, this.idAluno);
            comando.setString(2, this.nomeAluno);
            comando.setInt(3, this.idadeAluno);
            comando.setString(4, this.emailAluno);
            comando.setString(5, this.matricula);
            comando.setString(6, this.tipoAula);

            comando.execute();
            comando.close();

            conexao.close();

            System.out.println("\n\nPerfeito, complete sua matricula efetuando o pagamento!\n");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    
    
    /**
     * Altera os dados de um aluno existente no banco de dados.
     * O nome, a idade e o email do aluno são atualizados com base no ID fornecido.
     *
     * @param novoNome O novo nome do aluno.
     * @param novaIdade A nova idade do aluno.
     * @param novoEmail O novo email do aluno.
     * @param idAluno O ID do aluno cujos dados serão alterados.
     * 
     * @throws SQLException Se houver um erro na execução.
     */
    
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

    /**
     * Lista todos os alunos cadastrados no banco de dados.
     * Exibe informações como ID, nome, idade, email, matrícula e tipo de aula de cada aluno.
     * 
     * @throws SQLException Se houver um erro na execução.
     */
    
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
                String tipoAula = resultado.getString("tipo_aula");

                System.out.printf("ID Aluno: %d | Nome = %s | Idade = %s | Email: %s | Situacao matricula: %s | Tipo de aula: %s%n", idAluno, nomeAluno, idadeAluno, emailAluno, matricula, tipoAula);

            }
            resultado.close();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos!" + e.getMessage());

        }
    }
    
    /**
     * Exclui um aluno do banco de dados com base no ID fornecido.
     * Também exclui os registros de pagamentos associados a esse aluno.
     * 
     * @param idAluno O ID do aluno que será excluído.
     * 
     * @throws SQLException Se houver um erro na execução.
     */
    
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
}
