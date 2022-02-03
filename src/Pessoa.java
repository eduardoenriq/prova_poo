public class Pessoa {
    
    public static int length;
    //atributos da classe, ou métodos
    private String nome;
    private String cpf;
        
    public Pessoa (){
        
    }
    
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    //get e set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return cpf;
    }
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }


}
