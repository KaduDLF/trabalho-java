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
        System.out.println(" 5 - listar todos os livros disponiveis");
        System.out.println(" 6 - Associar emprestimo");
        System.out.println(" 7 - devolver algum livro");
        System.out.println(" 8 - sair");
        System.out.println("-------------------------------------");

    } // função pra mostrar o menu

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int soma = 0; //variavel para fazer o calculo se tem espaço no array
        int qtd = 0;
        int cadLiv = 0;// cadastro de livros;
        int qntdLiv = 0; // quantidade total de livros
        int qLiv = 0;
        int codLiv;
        String nomeUsu, sexoUsu, contatoUsu; // variaveis para cadastro de usuario
        int idadeUsu, idUsu;// variaveis para cadastro de usuario
        int restLiv = 0;
        int q_livros = 0;
        int qtdUsuarios = 0;
        int qtdLiv = 0;
        boolean algumLivroDisponivel = false;
        String escolha;
        int codigo_e;
        int livEmp = 0;
        
        System.out.println("Bem vindo ao sistema de biblioteca!");
        BibliUsuario[] usuarios = new BibliUsuario[100];
        BibliLivro[] livros = new BibliLivro[100];
        Emprestimos emprestimo = new Emprestimos();
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
                            System.out.println(usuarios[i].getNome() + " cadastrado com sucesso!!" + "\n" + "dê enter para prosseguir!");
                        }

                    } else {
                        System.out.println("Quantidade excede o espaço disponivel!");
                    }

                    break;
                case 2:
                    System.out.println("=================================================");
                    System.out.println("              CADASTRO DE LIVROS                 ");
                    System.out.println("=================================================");
                    
                    //pra mostrar quantos livros ainda cabe nessa bagaça
                    restLiv = livros.length - qtdLiv;
                    System.out.println("Sua biblioteca tem espaço para " + restLiv + " livros ");

                    System.out.println("Deseja cadastrar quantos livros? ");
                    cadLiv = scan.nextInt(); // isso aqui ta mesma coisa
                    scan.nextLine();

                    //pra vereficar se o numero n vai passar dessa bagaça 
                    if (cadLiv <= (livros.length - qtdLiv)) {
                        for (int i = 0; i < cadLiv; i++) { //loop de cria
                            System.out.print("Titulo: ");
                            String titulo = scan.nextLine();
                            System.out.print("Autor: ");
                            String autor = scan.nextLine();
                            System.out.print("Ano de Publicacao: ");
                            int anoPub = scan.nextInt();
                            System.out.print("Quantidade de Exemplares: ");
                            int exemplares = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Informe o codigo do livro: ");
                            int codigo = scan.nextInt();
                            
                            //cria um novo objeto e armaneza os livros ai
                            livros[qtdLiv] = new BibliLivro(titulo, autor, anoPub, exemplares, codigo);

                            System.out.println("Livro: " + livros[i].getTitulo() + " cadastrado com sucesso!");
                            qtdLiv++; // atualiza a quantidade
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
                    soma = 100 - qtdUsuarios;
                    System.out.println("Restam " + soma + " espaços para cadastro de usuarios");
                    scan.nextLine(); // aguardar o enter para prosseguir
                    break;

                case 4:
                    System.out.println("================================================");
                    System.out.println("              LISTAGEM DE LIVRROS               ");
                    System.out.println("================================================");
                    for (int i = 0; i < qntdLiv; i++) {
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
                case 6:
                    System.out.println("==========================================");
                    System.out.println("            LIVROS DISPONIVEL             ");
                    System.out.println("==========================================");
                    System.out.println("Deseja ver os livros disponiveis? ");
                    escolha = scan.nextLine().toLowerCase();
                    if ("sim".equals(escolha)){ // livro.length;
                        for (int i = 0; i <= (qntdLiv + cadLiv); i++){
                            System.out.println("CODIGO: " + livros[i].getCodigo());
                            System.out.println("TITULO: " + livros[i].getTitulo());
                            System.out.println("ANO DE PUBLICAÇÃO: " + livros[i].getAnoPub());
                            System.out.println("AUTOR:: " + livros[i].getAutor());
                            if (livros[i].emprestarExemplares(livEmp) > 0){
                                System.out.println("O livro " + livros[i].getTitulo() + " possui " + livros[i].emprestarExemplares(livEmp) + " copias ");

                            } else {
                                System.out.println("O livro " + livros[i].getTitulo() + " esta esgotado! ");
                            }
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("========================================");
                    System.out.println("                EMPRESTIMO              ");
                    System.out.println("========================================");         
                    System.out.println("Deseja pegar um livro emprestado? ");   
                    escolha = scan.nextLine().toLowerCase();
                    while("sim".equals(escolha)){
                        System.out.println("Informe o codigo do livro que voce deseja pegar emprestado: ");
                        codigo_e = scan.nextInt();
                        scan.nextLine();
                        for (int i = 0; i < livros.length; i++){
                            if (livros[i].getCodigo() == codigo_e){
                                System.out.println("Informe a data de emprestimo: ");
                                String emp = scan.nextLine();
                                emprestimo.setDataEmpr(emp);
                                System.out.println("Informe a data de devolucao: ");
                                String dev = scan.nextLine();
                                emprestimo.setDatadevol(dev);
                                livEmp++;
                                livros[i].emprestarExemplares(livEmp);
                                if (livros[i].emprestarExemplares(livEmp) > 0){
                                    System.out.println("O livro: " + livros[i].getTitulo()+ " possui: " + livros[i].emprestarExemplares(livEmp) + " copias!");

                                } else {
                                    System.out.print("Nao esta disponivel no momento - ESGOTADO! ");
                                    scan.nextLine();
                                    break;
                                }
                            }
                        }
                        
                        System.out.println("Deseja pegar outro livro emprestado? ");
                        escolha= scan.nextLine().toLowerCase();
                    }
                    break;
                        
                        // for para verificar se o livro esta disponivel;
                        
                        // for para verificar se o usuario existe;
                        
                        // for para anexar o livro ao usuario;
                        
                        // mostrar mensagem se deu erro ou não no cod

                case 7:
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




