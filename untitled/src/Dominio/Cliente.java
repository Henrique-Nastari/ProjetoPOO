package Dominio;

public class Cliente {
    private String cpf;
    private String nome;
    private String dataNascimento;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String telefone;

    public Cliente() {}
    public Cliente(String cpf, String n, String dn, String r, String b, String Cep, String c, String t){
        this.cpf = cpf;
        nome = n;
        dataNascimento = dn;
        rua = r;
        bairro = b;
        cep = Cep;
        cidade = c;
        telefone = t;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public String getRua(){
        return rua;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public String getCep(){
        return cep;
    }
    public void setCEP(String cep){
        this.cep = cep;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
