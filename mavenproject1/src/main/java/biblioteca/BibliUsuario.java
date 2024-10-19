
package biblioteca;

public class BibliUsuario {
    private String nome; // nome
    private String sexo;
    private String contato;
    private int idade;
    private int id;
    private Emprestimos emprestimos;
    
    
    public BibliUsuario(String nome, String sexo, String contato, int idade, int id){
        this.nome = nome;
        this.sexo = sexo;
        this.contato = contato;
        this.idade = idade;
        this.id = idade;
    }
    
    String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return this.id; 
    }   
        
     
    
    
    
}
