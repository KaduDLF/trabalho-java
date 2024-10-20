

package biblioteca;


public class BibliLivro {
    
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int exemplarDisponivel;
    private int idLivro;
    
    public BibliLivro(String titulo, String autor, int anoPublicacao, int exemplarDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplarDisponivel = exemplarDisponivel;
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
    
    public int getAnoPublicacao(){
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }
    
    public int getExemplarDisponivel(){
        return exemplarDisponivel;
    }
    
    public void setexEmplarDisponivel(int exemplarDisponivel){
        this.exemplarDisponivel = exemplarDisponivel;
    }
    
}