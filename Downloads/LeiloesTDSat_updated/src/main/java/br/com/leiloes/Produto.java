package br.com.leiloes;

public class Produto {
    private Long id;
    private String nome;
    private Integer valor;
    private String status;

    public Produto() {}

    public Produto(Long id, String nome, Integer valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getValor() { return valor; }
    public void setValor(Integer valor) { this.valor = valor; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
