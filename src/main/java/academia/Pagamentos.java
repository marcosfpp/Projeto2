
package academia;

c class Pagamentos {
     private int idPagamento; // Identificador único do pagamento
    private String dataPagamento;  // Data em que o pagamento foi realizado
    private double valorPagamento; // Valor do pagamento 
    private String formaPagamento;  // Forma de pagamento (ex: cartão, dinheiro, pix)
    private int idAluno; // identificador do aluno relacionado ao pagamento 
    
    // Construtor para inicializat os atributos
    public Pagamentos(int idPagamento, String dataPagamento, double valorPagamento, String formaPagamento, int idAluno) {
        this.idPagamento = idPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.formaPagamento = formaPagamento;
        this.idAluno = idAluno;
    }
    
    // Getters e Setters
    public int getIdPagamento() {
        return idPagamento;
    }
    public String getDataPagamentio() {
        return dataPagamento;
    }
    public void
}
