
package academia;

/**
 * Subclasse para objetos do tipo Crossfit que é herdado da superclasse Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 25/12/2024 at 15:09 PM
 */
public class Crossfit extends Aula {
    private String idAtividade; // Identificador da atividade.
    private String nomeAtividade; // Nome da atividade.
    
    /**
     * Construtor que inicializa as informações da aula.
     * @param idAula
     * @param horarioInicio
     * @param horarioFim
     * @param aluno 
     */
    public Crossfit(int idAula, String horarioInicio, String horarioFim, Aluno aluno, String idAtividade, String nomeAtividade) {
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
    * Retorna uma representação textual do objeto Crossfit.
    * @return uma string com os detalhes da aula
    */
    @Override
    public String toString() {
        return super.toString() +
                "Atividade:" + nomeAtividade + "\n";
    }
}
