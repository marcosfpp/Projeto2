package academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Academia {

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

    public static void main(String[] args) {
        int opcMenu = 0;
        int posAlunos = 0;
        int posPag = 0;
        Aluno[] alunos = new Aluno[50];
        Pagamentos[] pagamentos = new Pagamentos[50];
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n1 - Cadastro aluno");
            System.out.println("2 - Realizar pagamento de mensalidade");
            System.out.println("3 - Alterar cadastro de aluno");
            System.out.println("4 - Excluir cadastro de aluno");
            System.out.println("5 - Listar alunos");
            System.out.println("6 - Pagamentos");
            System.out.println("9 - Sair");

            System.out.print("Digite uma opcao: ");
            opcMenu = scan.nextInt();
            scan.nextLine();

            switch (opcMenu) {
                case 1:
                    try {
                        System.out.println("\nCADASTRO DE ALUNOS\n");

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

                        Aluno infoAlunos = new Aluno(nome, idade, email);
                        alunos[posAlunos] = infoAlunos;
                        alunos[posAlunos].inserirBanco();
                        scan.nextLine();

                    } catch (Exception e) {
                        System.out.println("\nErro ao tentar cadastrar aluno!" + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("\nPAGAMENTO DE MENSALIDADE\n");
                        System.out.println("VALOR = R$50,00");

                        System.out.println("Digite o id do aluno");
                        int idBusca = scan.nextInt();

                        boolean existe = verificarId(idBusca);

                        if (existe) {
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
                            pagamentos[posPag] = infoPagamentos;
                            pagamentos[posPag].inserirBanco();
                            validarMatricula("Ativa", idBusca);
                        } else {
                            System.out.println("O ID " + idBusca + " nao foi encontrado!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar pagamento" + e.getMessage());
                    }
                    break;
                case 3:
                    try{    
                        System.out.println("\nALTERACAO CADASTRO DE ALUNO\n");
                        
                        System.out.println("Digite o id do aluno");
                        int idBusca = scan.nextInt();

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
                        System.out.println("Erro a alterar cadastro de aluno! " + e.getMessage());
                    }
                    break;
                case 4:
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
                        System.out.println("Erro ao excluir aluno! " + e.getMessage());
                    }
                    break;
                case 5:
                    Aluno aluno = new Aluno();
                    aluno.listarAlunos();
                    scan.nextLine();
                    break;
                case 6:
                    Pagamentos pagamento = new Pagamentos();
                    pagamento.listaPagamentos();
                    scan.nextLine();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("\nObrigado pela preferencia!");
                    scan.nextLine();
                    break;
                default:
                    System.out.println("\nDigite uma opcao valida");
                    scan.nextLine();
                    break;
            }

        } while (opcMenu != 0);
    }

}
