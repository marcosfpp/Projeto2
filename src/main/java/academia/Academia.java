package academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Academia {

    public static void main(String[] args) {
        int opcMenu = 0;

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                    
                case 6:
                    break;
                case 7:
                    break;  
                case 8:
                    break;
                case 9:
                    break;
                default:
                    break;
            }

        } while (opcMenu != 0);
    }

}
