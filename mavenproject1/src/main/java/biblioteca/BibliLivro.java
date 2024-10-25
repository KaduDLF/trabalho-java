

package biblioteca;


public class BibliLivro {
    private String titulo;
    private String autor;
    private String anoPub;
    private int exemplares;
    private int codigo;
    private boolean disponivel;
    
    public BibliLivro(String titulo, String autor, String anoPub, int exemplares, int codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        this.exemplares = exemplares;
        this.codigo = codigo;
        this.disponivel = true;
    }

    //public BibliExemplares[] getExemplar() {
        //this.exemplar = new BibliExemplares[3];
        //return exemplar;
    //}
    // Fazer uma analise coerente sobre esse valor declarado dentro dos colchetes.
    //se a quantidade for maior que 3, vai acontecer oq??  felipe fez esse comentario
    
    public boolean getDisponivel(){
        return this.disponivel;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    //public void setTitulo(String titulo){
    //    this.titulo = titulo;
    //}
   
    public String getAutor(){
       return autor;
    }
    
    //public void setAutor(String autor){
    //    this.autor = autor;
    //}
    
    public String getAnoPub(){
        return anoPub;
    }
    
   // public void setAnoPub(int anoPublicacao){
   //     this.anoPub = anoPublicacao;
    //}
    
    public int getExemplares(){ 
        return exemplares;
    }
    
    public void setexEmplares(int exemplarDisponivel){
        this.exemplares = exemplarDisponivel;
    }
    
    
    
    public int getCodigo(){
        return  codigo;
    }
    
    
    public int emprestarExemplares(int livEmp){
        return this.exemplares -= livEmp;
    }
    
    @Override
    public String toString() {
        return "Título: " + this.titulo + 
               ", Autor: " + this.autor + 
               ", Ano de Publicacao:" + this.anoPub + 
               ", Quantidade de Exemplares: " + this.exemplares + 
               ", Codigo do livro: " + this.codigo; 
               //Id Livro" + this.idLivro; // mexi nesse retorno, esse id é de usuarios
    }
    
}