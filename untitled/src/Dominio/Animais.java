package Dominio;

public class Animais {
    private int animalId;
    private String nome;
    private int idade;
    private String especie;
    private String raca;

    public Animais(){}
    public Animais(int animalId, String nome, int idade, String especie, String raca){
        this.animalId = animalId;
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
    }

    public int getAnimalId(){
        return animalId;
    }
    public void setAnimalId(int animalId){
        this.animalId = animalId;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getEspecie(){
        return especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }
    public String getRaca(){
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
}
