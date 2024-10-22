

package biblioteca;


public class BibliLivro {
    private BibliExemplares[] exemplar;
    private String titulo;
    private String autor;
    private int anoPub;
    private int exemplares;
    private int idLivro;
    
    public BibliLivro(String titulo, String autor, int anoPub, int exemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        this.exemplares = exemplares;
    }

    public BibliExemplares[] getExemplar() {
        this.exemplar = new BibliExemplares[3];
        return exemplar;
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
        return anoPub;
    }
    
    public void setAnoPub(int anoPublicacao){
        this.anoPub = anoPublicacao;
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
        return "Título: " + this.titulo + 
               ", Autor: " + this.autor + 
               ", Ano de Publicacao:" + this.anoPub + 
               ", Quantidade de Exemplares: " + this.exemplares + 
               ", Id Livro" + this.idLivro; 
    }
    
}