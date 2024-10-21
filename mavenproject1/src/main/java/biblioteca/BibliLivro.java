

package biblioteca;


public class BibliLivro {
    
    private String titulo;
    private String autor;
    private int AnoPub;
    private int exemplares;
    private int idLivro;
    
    public BibliLivro(String titulo, String autor, int AnoPub, int exemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.AnoPub = AnoPub;
        this.exemplares = exemplares;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
   
    public String getAutor(){
       return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public int getAnoPub(){
        return AnoPub;
    }
    
    public void setAnoPub(int anoPublicacao){
        this.AnoPub = anoPublicacao;
    }
    
    public int getExemplares(){
        return exemplares;
    }
    
    public void setexEmplares(int exemplarDisponivel){
        this.exemplares = exemplarDisponivel;
    }
    
    public int getIdLivro(){
        return idLivro;
    }
    
    @Override
    public String toString() {
        return "Título: " + this.titulo + ", Autor: " + this.autor + ", Ano de Publicacao:" + 
                this.AnoPub + ", Quantidade de Exemplares: " + this.exemplares + ", Id Livro" + this.idLivro; 
    }
    
}