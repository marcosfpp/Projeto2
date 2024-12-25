package academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private boolean statusMatriculaAluno; 
    
    /**
     * 
     * @return Método construtor para forçar a entrada dos atributos na classe
     * @param idAluno recebe o id do aluno para identificação precisa
     * @param nomeAluno nome do aluno
     * @param idadeAluno recebe a idade do aluno
     * @param emailAluno recebe o email do aluno
     * @param statusMatriculaAluno recebe a situação da matricula do aluno
     */
    Aluno(int idAluno, String nomeAluno, int idadeAluno, String emailAluno) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.idadeAluno = idadeAluno;
        this.emailAluno = emailAluno;
        this.statusMatriculaAluno = false;
    }
    /**
     * 
     * @return Método que verifica se o cliente efetuou o pagamento para definir a situação de mátricula como verdadeira
     * @param situacaoPagamento situação se o aluno efetuou o ou não o pagamento
     * @param statusMatriculaAluno define o status da matrícula
     */
    public void setRenovarMatricula(boolean situacaoPagamento){
        if(situacaoPagamento){
            this.statusMatriculaAluno = true;
        } 
    }
    
    public void setCadastroAluno(){
        try {
            Scanner scan = new Scanner(System.in);
       
            System.out.println("Digite o nome do aluno: ");
            String nome = scan.nextLine();
            
            System.out.println("Digite a idade do aluno: ");
            int idade = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Digite o email do aluno: ");
            String email = scan.nextLine();
            
            
        }catch(Exception e){
            System.out.println("Erro no cadastro");         
        }
    }
}
