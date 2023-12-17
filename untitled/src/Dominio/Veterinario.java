package Dominio;

public class Veterinario {
    private int veterinarioId;
    private String nome;
    private String especialidade;
    private String crm;

    public Veterinario(){}
    public Veterinario(int veterinarioId, String nome, String especialidade, String crm){
        this.veterinarioId = veterinarioId;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public int getVeterinarioId(){
        return veterinarioId;
    }
    public void setVeterinarioId(int veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getCrm(){
        return crm;
    }
    public void setCrm(String crm){
        this.crm = crm;
    }
}
