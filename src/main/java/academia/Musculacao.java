
package academia;

/**
 * Subclasse para objetos do tipo Musculação que é herdado da superclasse Aula.
 * @author Marcus Vinícius Nunes Silva
 * @since 25/12/2024 at 14:07 PM
 */

public class Musculacao extends Aula {
    private String idAtividade;
    private String horario;

    public Musculacao(int aula, String nome, String horario, int aluno) {
        super(aula, nome, horario, aluno);
        this.idAtividade = idAtividade;
    }
}
