package biblioteca;

import java.awt.BorderLayout;
import java.util.Scanner;

public class BibliMain {

    public static void menu() {
        System.out.println("----------------Menu-----------------");
        System.out.println(" 1 - Cadastro de Usuario");
        System.out.println(" 2 - Cadastro de Livro");
        System.out.println(" 3 - listar todos os usuarios");
        System.out.println(" 4 - listar todos os livros");
        System.out.println(" 5 - Emprestimo ");
        System.out.println(" 6 - listar todos os livros disponiveis");
        System.out.println(" 7 - Associar emprestimo");
        System.out.println(" 8 - devolver algum livro");
        System.out.println(" 9 - sair");
        System.out.println("-------------------------------------");

    } // função pra mostrar o menu

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int soma = 0; //variavel para fazer o calculo se tem espaço no array
        int qtd = 0;
        int cadLiv = 0;// cadastro de livros;
        int qntdLiv = 0; // quantidade total de livros
        String nomeUsu, sexoUsu, contatoUsu; // variaveis para cadastro de usuario
        int idadeUsu, idUsu;// variaveis para cadastro de usuario
        int restLiv = 0;
        int qtdUsuarios = 0;
        int qtdLiv = 0;
        String escolha, anoPub;
        int codigo_e;
        int livEmp = 0;
        int codigo;
        int exemplares;
        

        
        System.out.println("Bem vindo ao sistema de biblioteca!");
        BibliUsuario[] usuarios = new BibliUsuario[100];
        BibliLivro[] livros = new BibliLivro[100];
        menu(); // mostrando o menu na tela

        System.out.println("escolha uma opcao");
        int opc = scan.nextInt();

        while (opc != 8) {
            switch (opc) {
                case 1:

                    qtdUsuarios = 0;
                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuarios[i] != null) {
                            qtdUsuarios++;
                        }
                    }
                    soma = usuarios.length - qtdUsuarios; // verificação de quantos usuarios ja foram preenchidos
                    System.out.println("Existem " + soma + " espaços para cadastro de usuarios");
                    scan.nextLine(); // dê enter para prosseguir

                    System.out.println("Deseja cadastrar quantos usuarios?");
                    qtd = scan.nextInt();
                    if (qtd <= soma) {
                        for (int i = qtdUsuarios; i < (qtdUsuarios + qtd); i++) {
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
                            System.out.println("Nome: " + usuarios[i].getNome() + " foi cadastrado com sucesso!!" + "\n" + "Dê enter para prosseguir!");
                        }

                    } else {
                        System.out.println("Quantidade excede o espaço disponivel!");
                    }

                    break;
                case 2:
                    System.out.println("=================================================");
                    System.out.println("              CADASTRO DE LIVROS                 ");
                    System.out.println("=================================================");
                    qtdLiv = 0;
                    
                    for (int i = 0; i < livros.length; i++){
                        if (livros[i] != null){
                            qtdLiv++;
                        }
                    }
                    //pra mostrar quantos livros ainda cabe nessa bagaça
                    restLiv = livros.length - qtdLiv;
                    System.out.println("Sua biblioteca tem espaço para " + restLiv + " livros ");

                    System.out.println("Deseja cadastrar quantos livros? ");
                    cadLiv = scan.nextInt(); // isso aqui ta mesma coisa
                    scan.nextLine();

                    //pra vereficar se o numero n vai passar dessa bagaça 
                    if (cadLiv <= restLiv) {
                        for (int i = qtdLiv; i < cadLiv; i++) { //loop de cria
                            System.out.print("Titulo: ");
                            String titulo = scan.nextLine();
                            System.out.print("Autor: ");
                            String autor = scan.nextLine();
                            System.out.print("Ano de Publicacao: ");
                            anoPub = scan.nextLine();
                            System.out.print("Quantidade de Exemplares: ");
                            exemplares = scan.nextInt();
                            scan.nextLine();
                            codigo = (i + 1);
                            
                            livros[i] = new BibliLivro(titulo, autor, anoPub, exemplares, codigo);                           
                            System.out.println("Livro: " + livros[i].getTitulo() + " cadastrado com sucesso!");
                            scan.nextLine(); // tava bugando e pulando o titulo
                        }

                        
                    } else {
                        System.out.println("Nao é possivel cadastrar mais livros!");
                    }
                    
                    

                    break;

                case 3:
                    qtdUsuarios = 0;
                    System.out.println("=======================================");
                    System.out.println("         LISTAGEM DE USUARIOS          ");
                    System.out.println("=======================================");
                    scan.nextLine();
                    for (BibliUsuario usu : usuarios) {
                        if (usu != null) {
                            System.out.println(usu);
                            qtdUsuarios++;
                        }

                    }
                    soma = usuarios.length - qtdUsuarios;
                    System.out.println("Restam " + soma + " espaços para cadastro de usuarios");
                    scan.nextLine(); // aguardar o enter para prosseguir
                    break;

                case 4:
                    System.out.println("================================================");
                    System.out.println("              LISTAGEM DE LIVROS               ");
                    System.out.println("================================================");
                    for (int i = 0; i < livros.length; i++) {
                        if (livros[i] != null) {
                            System.out.println("================================================");
                            System.out.println("Titulo: " + livros[i].getTitulo());
                            System.out.println("Autor: " + livros[i].getAutor());
                            System.out.println("Ano de publicacao: " + livros[i].getAnoPub());
                            System.out.println("Exemplares do livro: " + livros[i].getExemplares());
                            System.out.println("Codigo: " + livros[i].getCodigo());
                            System.out.println("================================================");

                        }
                    }
                    if (restLiv > 0) {
                        System.out.println("Ainda restam " + restLiv + " livros para cadastrar!");

                    } else if (restLiv == 0) {
                        System.out.println("Esgotado!");
                    }

                    break;
                 // fazer um case antes desse para fazer o emprestimo, para depois saber se tem livro disponivelm ou nao
                    // provavelmente tera q fazer alteração nesse case
                    case 5:
                    System.out.println("========================================");
                    System.out.println("                EMPRESTIMO              ");
                    System.out.println("========================================");         
                    System.out.println("Deseja pegar um livro emprestado? ");   
                    escolha = scan.nextLine().toLowerCase();
                    String dataDeEmp;
                    while("sim".equals(escolha) || "s".equals(escolha)){
                        System.out.println("Qual seu codigo de usuario?");
                        idUsu = scan.nextInt();
                        scan.nextLine();
                        boolean encontrado = false;
                        for(int i = 0; i< usuarios.length; i++){
                            if(idUsu == usuarios[i].getId()){
                                encontrado = true; // se encontrado vira true
                                break;
                            }
                        }
                        if(encontrado){
                            System.out.println("Informe o codigo do livro que voce deseja pegar emprestado: ");
                            codigo_e = scan.nextInt();
                            scan.nextLine();
                            encontrado = false;
                            for(int i = 0; i< livros.length; i++){
                            if(codigo_e == livros[i].getCodigo()){
                                encontrado = true; // se encontrado vira true
                                if(livros[i].getDisponivel()){
                                    System.out.println("Que dia o livro foi emprestado ou vai ser emprestado? ");
                                    dataDeEmp = scan.nextLine();
                                    usuarios[idUsu - 1].emprestimos = new Emprestimos(livros[i], dataDeEmp);
                                    usuarios[idUsu - 1].emprestimos.emprestar();
                                }else{
                                    System.out.println("o livro não esta disponivel");
                                }
                                break;
                            }else{
                                System.out.println("livro não encontrado");
                            }
                        }
                            
                            
                            
                        }else{
                            System.out.println("usuario não encontrado");
                        }
                        
                    }
                    break;
                        
                        // for para verificar se o livro esta disponivel;
                        
                        // for para verificar se o usuario existe;
                        
                        // for para anexar o livro ao usuario;
                        
                        // mostrar mensagem se deu erro ou não no cod

                    
                case 6:
                    System.out.println("==========================================");
                    System.out.println("            LIVROS DISPONIVEIS            ");
                    System.out.println("==========================================");
                    System.out.println("Deseja ver os livros disponiveis? ");
                    escolha = scan.nextLine().toLowerCase();
                    if ("sim".equals(escolha) || "s".equals(escolha)){
                        for(int i = 0; i < livros.length; i++){
                            if(livros[i].getDisponivel() && livros[i] != null){ // se livro.disponivel for true e diferente de null
                                System.out.println("CODIGO: " + livros[i].getCodigo());
                                System.out.println("TITULO: " + livros[i].getTitulo());
                                System.out.println("ANO DE PUBLICAÇÃO: " + livros[i].getAnoPub());
                                System.out.println("AUTOR:: " + livros[i].getAutor());
                                System.out.println("O livro " + livros[i].getTitulo() + " possui " + livros[i].getExemplares() + " copias disponiveis");
                            }
                        }
                    }else{
                        System.out.println("então beleza po");
                        scan.nextLine();
                    }
                    break;
                case 7:
                    System.out.println("");
                    break;
                    
                case 8:
                    System.out.println("");
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




