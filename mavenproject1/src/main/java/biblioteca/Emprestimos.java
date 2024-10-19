package biblioteca;

public class Emprestimos {
    private BibliUsuario usuario;
    private BibliLivro livro;
    private String dataEmpr;
    private String datadevol;
    private int idEmpr;

    public void setDataEmpr(String dataEmpr) {
        this.dataEmpr = dataEmpr;
    }

    public void setDatadevol(String datadevol) {
        this.datadevol = datadevol;
    }
    
}
