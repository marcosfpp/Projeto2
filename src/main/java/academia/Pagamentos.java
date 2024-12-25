
package academia;

public class Pagamentos {
    private int idPagamento; // Identificador único do pagamento
    private String dataPagamento;  // Data em que o pagamento foi realizado
    private double valorPagamento; // Valor do pagamento 
    private String formaPagamento;  // Forma de pagamento (ex: cartão, dinheiro, pix)
    private int idAluno; // identificador do aluno relacionado ao pagamento 
    private boolean situacaoPagamento;
    
    // Construtor para inicializat os atributos
    public Pagamentos(int idPagamento, String dataPagamento, double valorPagamento, String formaPagamento, int idAluno) {
        this.idPagamento = idPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.formaPagamento = formaPagamento;
        this.idAluno = idAluno;
        this.situacaoPagamento = false;
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
    public void setValorPagamento(double valorPagamento){
        this.valorPagamento = valorPagamento;
    }
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento (String FormaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    public void setPagarMensalidade(boolean mensalidade){
        this.situacaoPagamento = true;      
    }
    public boolean getSiuacaoPagamento(){
        return this.situacaoPagamento;
    }
    
    //Método para exibir os detalhes do pagamento 
    @Override
    public String toString() {
        return "Pagamentos{" +
                "idPagamento=" + idPagamento +
                ", dataPagamento='" + dataPagamento + '\'' +
                ", valorPagamento=" + valorPagamento +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", idAluno=" + idAluno +
                '}';
    }
    
}