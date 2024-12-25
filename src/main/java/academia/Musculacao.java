
package academia;

/**
 * Subclasse para objetos do tipo Musculação que é herdado da superclasse Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 25/12/2024 at 14:07 PM
 */
public class Musculacao extends Aula {
    private String idAtividade; //Identificador da atividade.
    private String nomeAtividade; // Nome da atividade.
    
    /**
     * Construtor que inicializa as informações da musculação.
     * @param idAula Identificador da aula.
     * @param horarioInicio Horário de início da aula.
     * @param horarioFim Horário do fim da aula.
     * @param aluno Objeto aluno associado a aula.
     * @param idAtividade Identificador da atividade.
     * @param nomeAtividade Nome da atividade.
     */
    public Musculacao(int idAula, String horarioInicio, String horarioFim, Aluno aluno, String idAtividade, String nomeAtividade) {
        super(idAula, horarioInicio, horarioFim, aluno);
        this.idAtividade = idAtividade;
        this.nomeAtividade = nomeAtividade;
    }

    //Get
    
    /**
     * Método para retornar o id da atividade.
     * @return idAtividade id da atividade
     */
    public String getIdAtividade() {
        return this.idAtividade;
    }
    
    /**
     * Método para retornar o nome da atividade.
     * @return nomeAtividade nome da atividade
     */
    public String getNomeAtividade() {
        return this.nomeAtividade;
    }
    
    //Set
    /**
     * Método para permitir a alteração da atividade após a criação.
     * @param idAtividade Identificador da atividade
     */
    public void setIdAtividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }
    
    /**
    * Retorna uma representação textual do objeto Musculação.
    * @return uma string com os detalhes da aula
    */
    @Override
    public String toString() {
        return super.toString() +
                "Atividade:" + nomeAtividade + "\n";
    }
}
