package biblioteca;

public class Emprestimos {
    private BibliUsuario usuario;
    private BibliLivro livro;
    private String dataEmpr;
    private String datadevol;
    private boolean emprestAtivo = false;
    
    Emprestimos(BibliLivro liv, String dataEmpr, BibliUsuario usuario){
        this.usuario = usuario;
        this.livro = liv;
        this.dataEmpr = dataEmpr;
        this.emprestAtivo = true;
        this.usuario.setQuantidadeEmprs(1);
    }
    Emprestimos(BibliLivro liv, String dataEmpr, String dataDev){
         this.livro = liv;
         this.dataEmpr = dataEmpr;
         this.datadevol = dataDev;
    }

    public BibliLivro getLivro() {
        return this.livro;
    }

    public BibliUsuario getUsuario() {
        return usuario;
    }
    
    public boolean getEmprestAtivo(){
        return this.emprestAtivo;
    }
    
    
    
    public void emprestar(){
        this.livro.emprestarExemplares(1);
    }
    
    public void verificar(){
        this.livro.verificarDisponibilidade();
    }

    public void setDataEmpr(String dataEmpr) {
        this.dataEmpr = dataEmpr;
    }

    public void setDatadevol(String datadevol) {
        this.datadevol = datadevol;
    }
    
    public String getDataEmpr(){
        return this.dataEmpr;
    }
    public void devolver(){
        this.livro.aumentarLivros(1);
    }

    @Override
    public String toString() {
        return "usuario: " + this.usuario.getNome()+ " usuarios id: " + this.usuario.getId() + " livro: " + this.livro.getTitulo() + " livro id: " + this.livro.getCodigo();
    }
    
    
    
    
  
}
