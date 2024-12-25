
package academia;

/**
 * Subclasse para objetos do tipo Musculação que é herdado da superclasse Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 25/12/2024 at 14:07 PM
 */
public class Musculacao extends Aula {
    private String idAtividade;
    private String nomeAtividade;

    public Musculacao(int idAula, String horarioInicio, String horarioFim, Aluno aluno, String idAtividade, String nomeAtividade) {
        super(idAula, horarioInicio, horarioFim, aluno);
        this.idAtividade = idAtividade;
        this.nomeAtividade = nomeAtividade;
}

    //Get
    
    public String getIdAtividade() {
        return this.idAtividade;
    }
    
    public void setIdAtividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "Atividade:" + nomeAtividade + "\n";
        
    }
}
