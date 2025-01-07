
package academia;

/**
 * Subclasse para objetos do tipo Musculação que é herdado da superclasse Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 25/12/2024 at 14:07 PM
 */
public class Musculacao extends Aula {
    private String nomeAtividade = "Musculacao"; // Nome da atividade.
    
    /**
     * Construtor que inicializa as informações da musculação.
     * @param horarioInicio Horário de início da aula.
     * @param horarioFim Horário do fim da aula.
     * @param instrutor Nome do instrutor.
     * @param nomeAtividade Nome da atividade.
     */
    public Musculacao(String horarioInicio, String horarioFim, String instrutor) {
        super(horarioInicio, horarioFim, instrutor);
        this.nomeAtividade = nomeAtividade;
    }

    //Get
    
    /**
     * Método para retornar o nome da atividade.
     * @return nomeAtividade nome da atividade
     */
    public String getNomeAtividade() {
        return this.nomeAtividade;
    }
    
    //Set
    /**
    * Retorna uma representação textual do objeto Musculação.
    * @return uma string com os detalhes da aula
    */
    @Override
    public String toString() {
        return "Atividade: " + nomeAtividade + ",\n" +
                "Horario de incio: " + getHorarioInicioAula() + ", \n" +
                "Horario fim: " + getHorarioFimAula() + ", \n" + 
                "Instrutor: " + getInstrutor() + "\n"
                ;
    }
}
