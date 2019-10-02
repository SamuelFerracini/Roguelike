package Class;

class Produto {
    private String nome;
    private int preco;
    private int buff;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public Produto(String nome, int buff, int preco) {
        this.nome = nome;
        this.buff = buff;
        this.preco = preco;

    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public int getBuff() {
        return buff;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço:" + preco;
    }
    
    
    
}
