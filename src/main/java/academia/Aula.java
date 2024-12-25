package academia;

/**
 * Classe para objetos do tipo Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 23-12-2024 at 11:13 AM
 */
public class Aula {
    private int idAula; // Identificador da aula.
    private String nome; // Nome do aluno.
    private String horarioInicio; // Horário da aula.
    private String horarioFim; //Horário do fim da aula.
    private int idAluno; // FK - Identificador do aluno.

    /**
    * Construtor que inicializa as informações da aula.
    * @param idAula Identificador único da aula.
    * @param nome Nome do aluno.
    * @param horarioInicio Horário do início da aula.
    * @param horarioFim Horário do fim da aula.
    * @param aluno Identificador do aluno.
    */
    public Aula(int idAula, String nome, String horarioInicio, String horarioFim,int aluno) {
        this.idAula = idAula;
        this.nome = nome;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
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
    * Método para retornar o id do aluno.
    * @return int id do aluno.
    */
    public int getIdAluno() {
        return this.idAluno;
    }
    
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
                "Número da aula: " + idAula + "\n" +
                "Nome do aluno: " + nome + "\n" +
                "Horário do início da aula: " + horarioInicio + "\n" +
                "Horario do fim da aula:" + horarioFim + "\n" +
                "Número do aluno: " + idAluno + "\n";
    }
}
