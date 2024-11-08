

package biblioteca;


public class BibliLivro {
    private String titulo;
    private String autor;
    private String anoPub;
    private int exemplares;
    private int codigo;
    public double preco;
    private boolean disponivel;
    
    public BibliLivro(String titulo, String autor, String anoPub, int exemplares, int codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        this.exemplares = exemplares;
        this.codigo = codigo;
        this.disponivel = true;
    }
    
    public BibliLivro (String titulo, String autor, String anoPub, int exemplares, int codigo, double preco){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        this.exemplares = exemplares;
        this.codigo = codigo;
        this.preco = preco;
        this.disponivel = true;
        
    }
    
    public boolean getDisponivel(){
        return this.disponivel;
    }
    
    public String getTitulo() {
        return titulo;
    }
    

   
    public String getAutor(){
       return autor;
    }
    

    public String getAnoPub(){
        return anoPub;
    }
    
    
    public int getExemplares(){ 
        return exemplares;
    }
    
    public void setExemplares(int exemplarDisponivel){
        this.exemplares = exemplarDisponivel;
    }
    
    public void exemplares0(){
        this.disponivel = false;
    }
    
    
    public int getCodigo(){
        return  codigo;
    }
    
    
    public int emprestarExemplares(int livEmp){
        return this.exemplares -= livEmp;
    }
    public boolean verificarDisponibilidade(){
        if(this.exemplares > 0){
            this.disponivel = true;
        }else{
            this.disponivel = false;
        }
        return this.disponivel;
    }
    
      public int aumentarLivros(int livEmp){
            return this.exemplares += livEmp;      
    }
    
    @Override
    public String toString() {
        return "Título: " + this.titulo + "\n"
               +"Autor: " + this.autor + "\n"
               +"Ano de Publicacao:" + this.anoPub + "\n"
               +"Quantidade de Exemplares: " + this.exemplares + "\n"
               +"Codigo do livro: " + this.codigo + "\n"
               +"======================================="; 
        
             
    }
    
}