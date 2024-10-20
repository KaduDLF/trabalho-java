package biblioteca;

import java.awt.BorderLayout;
import java.util.Scanner;

public class BibliMain {
    public static void menu(){
        System.out.println("----------------Menu-----------------");
        System.out.println(" 1 - Cadastro de Usuario");
        System.out.println(" 2 - Cadastro de Livro");
        System.out.println(" 3 - listar todos os usuarios");
        System.out.println(" 4 - listar todos os livros");
        System.out.println(" 5 - listar todos os livros disponiveis");
        System.out.println(" 6 - Associar emprestimo");
        System.out.println(" 7 - devolver algum livro");
        System.out.println(" 8 - sair");
        System.out.println("-------------------------------------");
        
    } // função pra mostrar o menu
           
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int soma = 0; // variavel para fazer o calculo se tem espaço no array
        int qtd = 0;  
        String nomeUsu, sexoUsu, contatoUsu; // variaveis para cadastro de usuario
        int idadeUsu, idUsu;// variaveis para cadastro de usuario
        int qtdLiv = 0; 
        int qtdUsuarios = 0;
        System.out.println("Bem vindo ao sistema de biblioteca!");
        BibliUsuario[] usuarios = new BibliUsuario[100];
        BibliLivro[] livros = null;
        
        menu(); // mostrando o menu na tela
        
     
        System.out.println("escolha uma opcao");
        int opc = scan.nextInt();
                
        while(opc != 8){
            switch(opc){
                case 1:
                    
                    qtdUsuarios = 0;
                    for(int i = 0;i < usuarios.length; i++){
                            if(usuarios[i] != null){
                                qtdUsuarios++; 
                            }
                        }
                    soma = usuarios.length - qtdUsuarios; // verificação de quantos usuarios ja foram preenchidos
                    System.out.println("Existem " + soma + " espaços para cadastro de usuarios");
                    scan.nextLine(); // dê enter para prosseguir
                    
                    System.out.println("Deseja cadastrar quantos usuarios?");
                    qtd = scan.nextInt();
                    if(qtd <= soma){
                        for(int i = qtdUsuarios; i < (qtdUsuarios+qtd) ;i++){
                            scan.nextLine();
                            System.out.println("Digite o nome do usuario");
                            nomeUsu = scan.nextLine();
                            System.out.println("Digite o sexo do usuario");
                            sexoUsu = scan.nextLine();
                            System.out.println("Digite o contato do usuario, ex'(62)4002-8922'");
                            contatoUsu = scan.nextLine();
                            System.out.println("Digite a idade do usuario");
                            idadeUsu = scan.nextInt();
                            scan.nextLine();
                            idUsu = (i + 1);
                            usuarios[i] = new BibliUsuario(nomeUsu, sexoUsu, contatoUsu, idadeUsu, idUsu);    
                            System.out.println(usuarios[i].getNome() + " cadastrado com sucesso!!" + "\n" + "dê enter para prosseguir!");
                        }
                        
                    }else{
                        System.out.println("Quantidade excede o espaço disponivel!");
                    }
                    
                    break;
                case 2:
                    System.out.println("Deseja cadastrar quantos livro? ");
                     qtdLiv = scan.nextInt();
                     scan.nextLine();
                     
                      livros = new BibliLivro[qtdLiv];
                     
                    for (int i = 0; i < qtdLiv; i++){
                        System.out.println("Informe o Titulo do livro: ");
                        String titulo = scan.nextLine();
                        System.out.println("Informe o autor do livro: ");
                        String autor = scan.nextLine();
                        System.out.println("Informe o ano de publicacao: ");
                        int ano_pub = scan.nextInt();
                        System.out.println("Informe a quantidade de exemplares desse livro: ");
                        int exemplar = scan.nextInt();
                        
                        livros[i] = new BibliLivro(titulo, autor, ano_pub, exemplar); // vai armazenar dentro do construtor os indices em sequencia
                        System.out.println("livro: " + livros[i].getTitulo() + ", cadastrado com sucesso! \n"
                                + "De enter para continuar! "); 
                        scan.nextLine();
                    }
                            
                    break;

                case 3:
                    qtdUsuarios = 0;
                    System.out.println("=======================================");
                    System.out.println("         LISTAGEM DE USUARIOS          ");
                    System.out.println("=======================================");
                    scan.nextLine();
                    for(BibliUsuario usu : usuarios){
                        if(usu != null){
                            System.out.println(usu);
                            qtdUsuarios++;
                        }
                        
                    }
                    soma = 100 - qtdUsuarios;
                    System.out.println("Restam " + soma + " espaços para cadastro de usuarios");
                    scan.nextLine(); // aguardar o enter para prosseguir
                    break;
                case 4:
                    System.out.println("=======================================");
                    System.out.println("           LISTAGEM DE LIVROS          ");
                    System.out.println("=======================================");
                    scan.nextLine();
      
                    for(int i = 0; i < qtdLiv; i++){
                        System.out.println("Titulo: " + livros[i].getTitulo());
                        System.out.println("Autor: " + livros[i].getAutor());
                        System.out.println("Ano de publicacao: " + livros[i].getAnoPublicacao());
                        System.out.println("Quantidade de exemplares feitos: " +livros[i].getExemplarDisponivel());
                        
                    }
                    
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção errada!!!");
                    break;
            }
            menu();
            System.out.println("escolha outra opcao");
            opc = scan.nextInt();
            
        }
        
    }
}
