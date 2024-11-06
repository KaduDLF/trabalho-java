
package biblioteca;

public class BibliUsuario {
    private String nome; // nome
    private String sexo;
    private String contato;
    private int idade;
    private int id;
    public String email;
    //public Emprestimos emprestimos; // vai puxar o emprestimo dentro de main para saber quem esta com o livro!
    private int quantidadeEmprs;
    
    
    public BibliUsuario(String nome, String sexo, String contato, int idade, int id, String email){
        this.nome = nome;
        this.sexo = sexo;
        this.contato = contato;
        this.idade = idade;
        this.id = id;
        this.email = email;
    }
    String getNome(){
        return this.nome;
        
    }

    public int getQuantidadeEmprs() {
        return quantidadeEmprs;
    }

    public void setQuantidadeEmprs(int quantidadeEmprs) {
        this.quantidadeEmprs += quantidadeEmprs;
    } // adicionar quando houver devolução 
    
    public void diminuirEmp(int quantidadeEmprs) {
        this.quantidadeEmprs -= quantidadeEmprs;
    } // subtrair quando houver emprestimos 
    
    
    int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + " id: " + this.id + "\n Email: " + this.email; 
    }   
        
     
    
   
    
}
