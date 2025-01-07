package academia;

import java.util.Scanner;

/**
 * Classe para objetos do tipo Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 23-12-2024 at 11:13 AM
 */
public class Aula {
    private String horarioInicio; // Horário da aula.
    private String horarioFim; //Horário do fim da aula.
    private String instrutor; // Diferenciacao de aula

    /**
    * Construtor que inicializa as informações da aula.
    * @param horarioInicio Horário do início da aula.
    * @param horarioFim Horário do fim da aula.
    * @param aluno Objeto aluno associado a aula.
    */
    public Aula(String horarioInicio, String horarioFim,Aluno aluno) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }
    
    public void cadastroAula() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite seu nome:\n");
            //get nome usuário no código do Dheniel, porém validar se vai ser criado outra váriavel
            System.out.println("Digite seu e-mail:\n");
            //get e-mail do usuário no código do Dheniel, porém validar se vai ser criado outra váriavel
            System.out.println("Você deseja praticar qual atividade\n" + "1 - Masculação | 2 - Crossfit");
            int idAtividade = scan.nextInt();
            if (idAtividade > 2 || idAtividade < 1) {
                System.out.println("Digite um número correto!");
            } else {
                System.out.println("Digite o horário que deseja iniciar a atividade:\n");
                String horarioInicio = scan.nextLine();
                System.out.println("Digite o horário que deseja finalizar a atividade:\n");
                String horarioFim = scan.nextLine();
            }
            
        }catch (Exception e) {
            System.out.println("Erro no cadastro da aula, por favor tente novamente.");
        }
    }
    
    //Get
    
    /**
    * Método para retornar o horário do início da aula.
    * @return String o horário da aula no formato especificado.
    */
    public String getHorarioInicioAula() {
        return this.horarioInicio;
    }
    
    /**
     * Método para retornar o horário do fim da aula.
     * @return String o horário do fim da aula no formato especificado.
     */
    public String getHorarioFimAula() {
        return this.horarioFim;
    }
    
    /**
     * Verificar pagamento = designar aula
     */
    

            
    //Set
    
    /**
    * Método para permitir a definição do horário do inicío da aula do aluno.
    * @param horarioInicio horário do inicío da aula a definir. 
    * @throws IllegalArgumentException caso o usuário forneça o horário nulo ou vazio.
    */
    public void setHorarioInicioAula(String horarioInicio) {
        if (horarioInicio == null || horarioInicio.trim().isEmpty()) {
            throw new IllegalArgumentException("O horário não pode ser nulo ou vazio. Por favor, preencha-o corretamente.");
        }
        this.horarioInicio = horarioInicio;
    }
    
    /**
    * Método para permitir a definição do horário do fim da aula do aluno.
    * @param horarioFim horário do fim da aula a definir. 
    * @throws IllegalArgumentException caso o usuário forneça o horário nulo ou vazio.
    */
    public void setHorarioFimAula(String horarioFim) {
        if (horarioFim == null || horarioFim.trim().isEmpty()) {
            throw new IllegalArgumentException("O horário não pode ser nulo ou vazio. Por favor, preencha-o corretamente.");
        }
        this.horarioFim = horarioFim;
    }

    /**
    * Retorna uma representação textual do objeto Aula.
    * @return uma string com os detalhes da aula
    */
    @Override
    public String toString() {
        return "Informações da aula: " +
                "Horário do início da aula: " + horarioInicio + "\n" +
                "Horario do fim da aula: " + horarioFim + "\n";
                //aqui puxar um toString de aluno, para concatenar essa barra
                //Ex: "Info aluno: " + aluno.toString();    
    }
}
