package biblioteca;

public class Emprestimos {
    private BibliLivro livro;
    private String dataEmpr;
    private String datadevol;
    
    Emprestimos(BibliLivro liv, String dataEmpr){
         this.livro = liv;
         this.dataEmpr = dataEmpr;
    }
    Emprestimos(BibliLivro liv, String dataEmpr, String dataDev){
         this.livro = liv;
         this.dataEmpr = dataEmpr;
         this.datadevol = dataDev;
    }
    
    public void emprestar(){
        this.livro.emprestarExemplares(1);
    }

    public void setDataEmpr(String dataEmpr) {
        this.dataEmpr = dataEmpr;
    }

    public void setDatadevol(String datadevol) {
        this.datadevol = datadevol;
    }
    
}
