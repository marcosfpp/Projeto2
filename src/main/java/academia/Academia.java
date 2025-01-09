package academia;
/**
 * Classe definida como academia com funções de APP.
 * @author Marcus Vinícius, Marcos Felipe, Dheniel Rodrigues, Kaua Luiz
 * since 25/12/2024 at 14:08 PM
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Academia {
    /**
     * Estabelecimento de funcoes de verificacao, validacao e definicao.
     * Neste caso, verificação de ID existente
     * @param idProcurado
     * @return Retorno de verdadeiro se o ID for verificado com sucesso e falso se falhar
     */
    public static boolean verificarId(int idProcurado) {
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT COUNT(*) FROM aluno WHERE id = ?";

        boolean existe = false;

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, idProcurado);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    int quantidade = resultado.getInt(1);
                    existe = quantidade > 0;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar id!" + e.getMessage());
        }
        return existe;
    }
    /**
     * Método para exportar dados dos sistema
     * @param nomeArquivo nome do arquivo txt para exportar os dados
     * @return Retorna um arquivo com todos os dados do banco de dados
     */
    public static void exportarDados(String nomeArquivo){
        Connection conexao = new Conexao().getConexao();
        
        String sqlAluno = "SELECT * FROM aluno";
        String sqlPag = "SELECT * FROM pagamentos";
        
        try(FileWriter fw = new FileWriter(nomeArquivo);
            PrintWriter pw = new PrintWriter(fw);
            PreparedStatement comandoAluno = conexao.prepareStatement(sqlAluno);
            PreparedStatement comandoPagamentos = conexao.prepareStatement(sqlPag);
            ResultSet resultadoAluno = comandoAluno.executeQuery();
            ResultSet resultadoPag = comandoPagamentos.executeQuery();){
            
            pw.println("ID\tNome\nIdade\nEmail\tMatricula\tAula");
            pw.println("===============================================================================");
            
            while(resultadoAluno.next()){
                int id = resultadoAluno.getInt("id");
                String nome = resultadoAluno.getString("nome");
                int idade = resultadoAluno.getInt("idade");
                String email = resultadoAluno.getString("email");
                String matricula = resultadoAluno.getString("matricula");
                String aula = resultadoAluno.getString("tipo_aula");

                pw.printf("%d\t%s\t%d\t%s\t%s\t%s%n", id, nome, idade, email, matricula, aula);
            }
            
            pw.println("\nID\tData\nForma\nAluno");
            pw.println("===============================================================================");
            
            while(resultadoPag.next()){
                int id = resultadoPag.getInt("id");
                String data = resultadoPag.getString("dataPag");
                String formaPag = resultadoPag.getString("formaPag");
                int idAluno = resultadoPag.getInt("id_aluno");
                
                pw.printf("%d\t%s\t%s\t%d%n", id, data, formaPag, idAluno);
            }
            
            System.out.println("Arquivos exportados com sucesso!");
        }catch(Exception e){
            System.out.println("Erro ao exportar arquivos: " + e.getMessage());
        }
    }
        /**
     * Estabelecimento de funcao de validacao da matricula 
     * @param matricula Parametro usado para confirmar a matricula
     * @param idAluno Parametro usado para identificacao do aluno
     * 
     */
    public static void validarMatricula(String matricula, int idAluno) {
        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE aluno SET matricula = ? WHERE id = ?";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, matricula);
            comando.setInt(2, idAluno);

            comando.executeUpdate();

            comando.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao validar matricula!" + e.getMessage());
        }
    }
    
    /**
     * Estabelecimento de funcao de definicao de aula, após escolha do usuario.
     * @param tipoAula Parametro usado para diferenciacao dos tipos de aula
     * @param idAluno Parametro usado para identificacao do aluno
     * 
     */
    public static void definirAula(String tipoAula, int idAluno) {
        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE aluno SET tipo_aula = ? WHERE id = ?";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, tipoAula);
            comando.setInt(2, idAluno);

            comando.executeUpdate();
            
            System.out.println("Voce esta inscrito nas aulas de "+ tipoAula +", aproveite o treinamento!");
            
            comando.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao validar matricula!" + e.getMessage());
        }
    }
    
     /**
     * Estabelecimento de funcao de verificacao de matricula existente, aluno ja cadastrado.
     * @param idAluno Parametro usado para identifcacao do aluno
     * @return Retornara verdadeiro caso a matricula do aluno esta ativa e falso caso o contrario.
     * 
     */
    public static boolean verificarMatriculaAtiva(int idAluno){
        Connection conexao = new Conexao().getConexao();
       
        String sql = "SELECT matricula FROM aluno WHERE id = ?";
        boolean matriculaAtiva = false;
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, idAluno);
            
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                String statusMatricula = resultado.getString("matricula");
                if("Ativa".equalsIgnoreCase(statusMatricula)){
                    matriculaAtiva = true;
                }
            }
            resultado.close();
            comando.close();
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro ao verificar matricula: " + e.getMessage());
        }
        return matriculaAtiva;
    }
    
     /**
     * Estabelecimento de funcao de verificacao de aula, para pesquisa em qual tipo
     * o aluno esta matriculado
     * @param idAluno Parametro para identifcacao do aluno
     * @return Retornara posiivo se caso o aluno estiver inscrito na aula e falso caso o contrario.
     * 
     */
    public static boolean verificarAula(int idAluno){
        Connection conexao = new Conexao().getConexao();
       
        String sql = "SELECT tipo_aula FROM aluno WHERE id = ?";
        boolean aulaInscrita = false;
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, idAluno);
            
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                String statusMatricula = resultado.getString("tipo_aula");
                if("Parado".equalsIgnoreCase(statusMatricula)){
                    aulaInscrita = true;
                }
            }
            resultado.close();
            comando.close();
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro ao verificar matricula: " + e.getMessage());
        }
        return aulaInscrita;
    }
    /**
     * Método principal que exibe o menu de opções e executa ações conforme a escolha do usuário.
     *
     */
    public static void main(String[] args) {
        int opcMenu = 0; // Variável que armazena a opção escolhida pelo usuário no menu
        int posAlunos = 0; // Posição de cadastro de alunos
        int posPag = 0; // Posição de cadastro de pagamentos
        String opc_sec = "";
        Aluno[] alunos = new Aluno[50]; // Array para armazenar os alunos
        Pagamentos[] pagamentos = new Pagamentos[50]; // Array para armazenar os pagamentos
        Scanner scan = new Scanner(System.in); // Scanner para ler as entradas do usuário

        do {
            // Exibição do menu de opções
            System.out.println("\n1 - Cadastro aluno");
            System.out.println("2 - Realizar pagamento de mensalidade");
            System.out.println("3 - Alterar cadastro de aluno");
            System.out.println("4 - Excluir cadastro de aluno");
            System.out.println("5 - Inscrever em aula");
            System.out.println("6 - Listar alunos");
            System.out.println("7 - Pagamentos");
            System.out.println("8 - Exportar relatorios");
            System.out.println("9 - Sair");

            System.out.print("Digite uma opcao: ");
            opcMenu = scan.nextInt();
            scan.nextLine();

             // Processamento conforme a opção escolhida
            switch (opcMenu) {
                case 1:
                    // Cadastro de aluno
                    try {
                        System.out.println("\nCADASTRO DE ALUNOS\n");

                        // Conta a quantidade de alunos cadastrados
                        for (int i = 0; i < alunos.length; i++) {
                            if (alunos[i] != null) {
                                posAlunos++;
                            }
                        }

                        System.out.print("Digite o nome do aluno: ");
                        String nome = scan.nextLine();

                        System.out.print("\nDigite a idade do aluno: ");
                        int idade = scan.nextInt();
                        scan.nextLine();

                        System.out.print("\nDigite o email do aluno: ");
                        String email = scan.nextLine();

                        Aluno infoAlunos = new Aluno(nome, idade, email); // Criação de um novo objeto Aluno
                        alunos[posAlunos] = infoAlunos; // Armazena o aluno na posição disponível
                        alunos[posAlunos].inserirBanco(); // Salva no banco de dados
                        scan.nextLine();

                    } catch (Exception e) {
                        System.out.println("\nErro ao tentar cadastrar aluno: " + e.getMessage());
                    }
                    break;
                case 2:
                    // Realização de pagamento
                    try {
                        System.out.println("\nPAGAMENTO DE MENSALIDADE\n");
                        System.out.println("VALOR = R$50,00");

                        System.out.println("Digite o id do aluno");
                        int idBusca = scan.nextInt();
                        scan.nextLine();

                        // Verifica se o ID do aluno existe
                        boolean existe = verificarId(idBusca);

                        if (existe) {
                            // Conta a quantidade de pagamentos realizados
                            for (int i = 0; i < pagamentos.length; i++) {
                                if (pagamentos[i] != null) {
                                    posPag++;
                                }
                            }

                            System.out.println("Digite a data atual: ");
                            String dataAtual = scan.nextLine();

                            System.out.println("Digite a forma de pagamento: ");
                            String formaPagamento = scan.nextLine();

                            Pagamentos infoPagamentos = new Pagamentos(dataAtual, formaPagamento, idBusca);
                            pagamentos[posPag] = infoPagamentos; // Armazena o pagamento
                            pagamentos[posPag].inserirBanco(); // Salva o pagamento no banco
                            
                            // Valida matrícula após pagamento
                            validarMatricula("Ativa", idBusca);
                        } else {
                            System.out.println("O ID " + idBusca + " nao foi encontrado!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar pagamento: " + e.getMessage());
                    }
                    break;
                case 3:
                    // Alteração de cadastro de aluno
                    try{    
                        System.out.println("\nALTERACAO CADASTRO DE ALUNO\n");
                        
                        System.out.println("Digite o id do aluno");
                        int idBusca = scan.nextInt();
                        scan.nextLine();

                        boolean existe = verificarId(idBusca);
                        
                        if(existe){
                            System.out.println("\nDigite o novo nome: ");
                            String novoNome = scan.nextLine();
                            
                            System.out.println("Digite a nova idade: ");
                            int novaIdade = scan.nextInt();
                            scan.nextLine();
                            
                            System.out.println("Digite o email do aluno: ");
                            String novoEmail = scan.nextLine();
                            
                            Aluno aluno = new Aluno();
                            aluno.alterarAluno(novoNome, novaIdade, novoEmail, idBusca);
                            scan.nextLine();
                        }else{
                            System.out.println("O ID " + idBusca + " nao foi encontrado!");
                        }
                    }catch(Exception e){
                        System.out.println("Erro a alterar cadastro de aluno: " + e.getMessage());
                    }
                    break;
                case 4:
                    // Exclusão de cadastro de aluno
                    try{
                        System.out.println("\nEXCLUIR CADASTRO DE ALUNOS\n");
                        
                        System.out.println("Digite o id do aluno: ");
                        int idBusca = scan.nextInt();
                        scan.nextLine();
                        
                        boolean existe = verificarId(idBusca);
                        
                        if(existe){
                            Aluno aluno = new Aluno();
                            aluno.excluirAluno(idBusca);
                            scan.nextLine();
                        } else{
                            System.out.println("O ID " + " nao foi encontrado!");
                        }
                    }catch(Exception e){
                        System.out.println("Erro ao excluir aluno: " + e.getMessage());
                    }
                    break;
                case 5:
                    // Matrícula em aula
                    try{
                        System.out.print("\nMATRICULAR EM AULA\n");
                        System.out.println("Veja as informacoes das aulas a seguir: ");
                        
                        // Exemplo de aulas disponíveis
                        Musculacao infoMusc = new Musculacao("15:00h","17:00h","Marcos Felipe");
                        Crossfit infoCross = new Crossfit("9:00h","11:00h","Marcus Vinicius");
                        
                        // Exibe informações sobre as aulas
                        System.out.println(infoMusc.toString());
                        System.out.println(infoCross.toString());
                        
                        System.out.println("1 - Crossfit");
                        System.out.println("2 - Musculacao");
                        System.out.println("Escolha o tipo de aula desejado! ");
                        int escolha = scan.nextInt();
                        scan.nextLine();
                        
                        System.out.println("Digite o id do aluno");
                        int idBusca = scan.nextInt();
                        scan.nextLine();
                        
                        boolean existe = verificarId(idBusca);
                        boolean pagamento = verificarMatriculaAtiva(idBusca);
                        boolean inscricaoAula = verificarAula(idBusca);
                        
                        if(existe){
                            if(pagamento){
                                if(inscricaoAula){
                                    switch (escolha){
                                        case 1: 
                                            definirAula("Crossfit", idBusca);
                                            scan.nextLine();
                                            break;
                                        case 2: 
                                            definirAula("Musculacao", idBusca);
                                            scan.nextLine();
                                            break;
                                        default:
                                            System.out.println("Digite uma opcao valida!");
                                            break;
                                    }
                                }else {
                                    System.out.println("o usuário já está inscrito em uma aula!");
                                }
                            }else {
                                System.out.println("O usuário não realizou o pagamento! ");
                            }
                        }else{
                            System.out.println("O ID " + " nao foi encontrado!");
                        }
                    }catch(Exception e){
                        System.out.println("Erro ao matricular em aula: " + e.getMessage());
                    }
                    break;
                case 6:
                    // Listar alunos
                    Aluno aluno = new Aluno();
                    aluno.listarAlunos();
                    scan.nextLine();
                    break;
                case 7:
                    // Listar pagamentos
                    Pagamentos pagamento = new Pagamentos();
                    pagamento.listaPagamentos();
                    scan.nextLine();
                        scan.nextLine();
                    break;
                case 8:
                    // Exportação de relatórios (não implementado)
                    System.out.print("\nEXPORTAR DADOS\n");
                    try{
                        System.out.println("Deseja exportar os dados?, digite S ou N");
                        opc_sec = scan.nextLine();
                        System.out.println("\n");
                        
                        if ("S".equals(opc_sec) || "s".equals(opc_sec) || "Sim".equals(opc_sec) || "sim".equals(opc_sec)){
                            exportarDados("dados_exportados.txt");
                            scan.nextLine();
                        }
                    }catch(Exception e){
                        System.out.println("Erro ao exportar os dados!" + e.getMessage());
                    }
                    break;
                case 9:
                    // Mensagem de despedida
                    System.out.println("\nObrigado pela preferencia!");
                    scan.nextLine();
                    break;
                default:
                    System.out.println("\nDigite uma opcao valida");
                    scan.nextLine();
                    break;
            }

        } while (opcMenu != 9);
    }

}
