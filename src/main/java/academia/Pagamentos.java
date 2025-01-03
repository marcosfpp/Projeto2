package academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pagamentos {
    private int idPagamento; // Identificador único do pagamento
    private String dataPagamento;  // Data em que o pagamento foi realizado
    private String formaPagamento;  // Forma de pagamento (ex: cartão, dinheiro, pix)
    private int idAluno;
    
    // Construtor para inicializat os atributos
    public Pagamentos(String dataPagamento, String formaPagamento, int idAluno) {
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.idAluno = idAluno;
    }
    Pagamentos(){
    }
    
    // Getters e Setters
    public int getIdPagamento() {
        return idPagamento;
    }
    public String getDataPagamentio() {
        return dataPagamento;
    }
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public double getValorPagamento(double valorPagamento) {
        return valorPagamento;
    }
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento (String FormaPagamento) {
        this.formaPagamento = formaPagamento;
    }
   
    public void inserirBanco() {
        Connection conexao = new Conexao().getConexao();

        String sql = "INSERT INTO pagamentos (id, dataPag, formaPag, id_aluno) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, this.idPagamento);
            comando.setString(2, this.dataPagamento);
            comando.setString(3, this.formaPagamento);
            comando.setInt(4, this.idAluno);

            comando.execute();
            comando.close();

            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }
    
    //Método para exibir os detalhes do pagamento 
    @Override
    public String toString() {
        return "Pagamentos{" +
                "idPagamento=" + idPagamento +
                ", dataPagamento='" + dataPagamento + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
    
}