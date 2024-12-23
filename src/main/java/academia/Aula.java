package academia;

/**
 * Classe para objetos do tipo Aula.
 * @author Marcus Vinícius
 * @since 23-12-2024 at 11:13 AM
 */

    public class Aula {
        private int idAula; // Identificador da aula
        private String nome; // Nome do aluno
        private String horario; // Horário da aula
        private int idAluno; // FK - Identificador do aluno
    
/**
* Construtor que inicializa as informações da aula.
* @param aula Identificador único da aula.
* @param nome Nome do aluno.
* @param horario Horário da aula.
* @param aluno Identificador do aluno.
*/  
    public Aula(int aula, String nome, String horario, int aluno) {
        this.idAula = aula;
        this.nome = nome;
        this.horario = horario;
        this.idAluno = aluno;
    }
    
    //Get
    
/**
* Método para retornar o id do aula.
* @return int id da aula.
*/
    public int getIdAula() {
        return this.idAula;
    }
    
/**
* Método para retornar o nome do aluno.
* @return String nome do aluno.
*/
    public String getNome() {
        return this.nome;
    }
    
/**
* Método para retornar o horário da aula.
* @return String o horário da aula no formato especificado.
*/
    public String getHorarioAula() {
        return this.horario;
    }
    
/**
* Método para retornar o id do aluno.
* @return int id do aluno.
*/
    
    public int getIdAluno() {
        return this.idAluno;
    }
    
    //Set
    
/**
* Método para permitir a definição do horário de aula do aluno.
* @param horario horário da aula a definir. 
* @throws IllegalArgumentException caso o usuário forneça o horário nulo ou vazio.
*/
    public void setHorarioAula(String horario) {
        if (horario == null || horario.trim().isEmpty()) {
            throw new IllegalArgumentException("O horário não pode ser nulo ou vazio. Por favor, preencha-o corretamente.");
        }
        this.horario = horario;
    }
    
/**
* Retorna uma representação textual do objeto Aula.
* @return uma string com os detalhes da aula
*/
    
    @Override
    public String toString() {
        return "Informações da aula:\n" +
                "Número da aula: " + idAula + "\n" +
                "Nome do aluno: " + nome + "\n" +
                "Horário da aula: " + horario + "\n" +
                "Número do aluno: " + idAluno + "\n";
        }
    
}
