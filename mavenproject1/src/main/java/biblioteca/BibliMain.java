package biblioteca;

import java.awt.BorderLayout;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BibliMain {

    public static void menu() {
        System.out.println("----------------Menu-----------------");
        System.out.println(" 1 - Cadastro de Usuario");
        System.out.println(" 2 - Cadastro de Livro");
        System.out.println(" 3 - listar todos os usuarios");
        System.out.println(" 4 - listar todos os livros");
        System.out.println(" 5 - Emprestimo ");
        System.out.println(" 6 - listar todos os livros disponiveis");
        System.out.println(" 7 - Gravar em arquivo");
        System.out.println(" 8 - devolver algum livro");
        System.out.println(" 9 - listar todos os emprestimos");
        System.out.println(" 10 - sair");
        System.out.println("-------------------------------------");

    } // função pra mostrar o menu

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int soma = 0; //variavel para fazer o calculo se tem espaço no array
        int qtd = 0; // quantidade de usuarios
        int cadLiv = 0;// cadastro de livros;
        int qtdLiv = 0; // quantidade total de livros
        String nomeUsu, sexoUsu, contatoUsu; // variaveis para cadastro de usuario
        int idadeUsu, idUsu;// variaveis para cadastro de usuario
        int restLiv = 0; // soma, se sobra livros
        int qtdUsuarios = 0; // qtd usuarios a serem cadastrados
        String escolha, anoPub; // escolha se sim ou não e ano de publicação dos livros
        int codigo_e; // verificar se o codigo escolhido é o mesmo do livro
        int codigo; // codigo do livro
        int qtdEmprestimos;
        int exemplares; // qtd de exemplares
        String dataDeEmp; // dia de emprestimo
        boolean livroEncontrado = false; // verificador das listas
        boolean usuEncontrado = false; // verificador das listas
        boolean emprestEncontrado = false; // verificador das listas
        boolean codigoIgual = false; // verificador das listas
        String email;
        double precoLiv; //saber o preço do livro;
        System.out.println("Bem vindo ao sistema de biblioteca!");
        BibliUsuario[] usuarios = new BibliUsuario[100];
        BibliLivro[] livros = new BibliLivro[100];
        Emprestimos[] emprestimos = new Emprestimos[300]; // supondo que cada pessoa pode fazer 3 emprestimos
        menu(); // mostrando o menu na tela

        System.out.println("escolha uma opcao");
        int opc = scan.nextInt();

        while (opc != 10) {
            switch (opc) {
                case 1:
                    try {
                        qtdUsuarios = 0;
                        for (int i = 0; i < usuarios.length; i++) {
                            if (usuarios[i] != null) {
                                qtdUsuarios++;
                            }
                        }
                        soma = usuarios.length - qtdUsuarios; // verificação de quantos usuários já foram preenchidos
                        System.out.println("Existem " + soma + " espaços para cadastro de usuários");
                        scan.nextLine(); // dê enter para prosseguir

                        System.out.println("Deseja cadastrar quantos usuários?");
                        qtd = scan.nextInt();
                        if (qtd <= soma) {
                            for (int i = qtdUsuarios; i < (qtdUsuarios + qtd); i++) {
                                scan.nextLine();
                                System.out.println("Digite o nome do usuário");
                                nomeUsu = scan.nextLine();
                                System.out.println("Digite o sexo do usuário");
                                sexoUsu = scan.nextLine();
                                System.out.println("Digite o contato do usuário, ex'(62)4002-8922'");
                                contatoUsu = scan.nextLine();
                                System.out.println("Digite a idade do usuário");
                                idadeUsu = scan.nextInt();
                                System.out.println("Informe seu email: ");
                                email = scan.nextLine();
                                scan.nextLine();
                                idUsu = (i + 1);
                                usuarios[i] = new BibliUsuario(nomeUsu, sexoUsu, contatoUsu, idadeUsu, idUsu, email);
                                System.out.println("Nome: " + usuarios[i].getNome() + " foi cadastrado com sucesso!! id: " + usuarios[i].getId() + "\n" + "Dê enter para prosseguir!");

                                scan.nextLine();
                            }

                        } else {
                            System.out.println("Quantidade excede o espaço disponível!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar usuários: ");
                        scan.nextLine(); // Limpa o buffer em caso de erro
                    }
                    break;

                case 2:
                    System.out.println("=================================================");
                    System.out.println("              CADASTRO DE LIVROS                 ");
                    System.out.println("=================================================");

                    try {
                        qtdLiv = 0;

                        for (int i = 0; i < livros.length; i++) {
                            if (livros[i] != null) {
                                qtdLiv++;
                            }
                        }

                        // Fazer a conta de quantos livros ainda podem ser cadastrados
                        restLiv = livros.length - qtdLiv;
                        System.out.println("Sua biblioteca tem espaço para " + restLiv + " livros ");

                        System.out.println("Deseja cadastrar quantos livros? ");
                        cadLiv = scan.nextInt();
                        scan.nextLine();

                        // Verificação se a quantidade de livros desejada é menor que disponível
                        if (cadLiv <= restLiv) {
                            for (int i = qtdLiv; i < (cadLiv + qtdLiv); i++) {
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
                                System.out.println("Esse livro possui preco? ");
                                String resposta = scan.nextLine();
                                if ("sim".equals(resposta) || "s".equals(resposta)){
                                    System.out.println("Quanto custa o livro? ");
                                    precoLiv = scan.nextDouble();
                                    scan.nextLine();
                                    livros[i] = new  BibliLivro(titulo, autor, anoPub, exemplares, codigo, precoLiv);
                                    System.out.println("Livro: " + livros[i].getTitulo() + ", foi cadastrado com sucesso! id: " + livros[i].getCodigo());
                                    System.out.println("Voce tera que pagar R$:" + precoLiv);
                                    System.out.println("BOA LEITURA!");
                                    System.out.println("De enter para voltar para o menu");
                                    scan.nextLine();
                                } else {
                                    livros[i] = new BibliLivro(titulo, autor, anoPub, exemplares, codigo);
                                    System.out.println("Livro: " + livros[i].getTitulo() + ", foi cadastrado com sucesso! id: " + livros[i].getCodigo());
                                    System.out.println("BOA LEITURA!");
                                    System.out.println("De enter para continuar: ");
                                    scan.nextLine();
                                }
                            }

                        } else {
                            System.out.println("Nao é possivel cadastrar mais livros!");
                        }

                    } catch (Exception e) {
                        System.out.println("Erro na entrada de dados: ");
                        scan.nextLine(); // Limpa o buffer em caso de erro
                    }

                    break;

                case 3:
                    usuEncontrado = false;
                    qtdUsuarios = 0;
                    System.out.println("=======================================");
                    System.out.println("         LISTAGEM DE USUARIOS          ");
                    System.out.println("=======================================");
                    scan.nextLine();
                    for (BibliUsuario usu : usuarios) {
                        if (usu != null) {
                            usuEncontrado = true;
                            System.out.println(usu);
                            qtdUsuarios++;
                        }

                    }
                    if (!usuEncontrado) {
                        System.out.println("Não há usuarios cadastrados!!");
                    }
                    soma = usuarios.length - qtdUsuarios;
                    System.out.println("Restam " + soma + " espaços para cadastro de usuarios");
                    scan.nextLine(); // aguardar o enter para prosseguir
                    break;

                case 4:
                    livroEncontrado = false;
                    System.out.println("================================================");
                    System.out.println("              LISTAGEM DE LIVROS               ");
                    System.out.println("================================================");
                    qtdLiv = 0;
                    for (int i = 0; i < livros.length; i++) {
                        if (livros[i] != null) {
                            qtdLiv++;
                            System.out.println("================================================");
                            System.out.println(livros[i]); // As informaçoes estao tudo dentro do ToString de livros
                            System.out.println("================================================");
                            livroEncontrado = true;
                        }
                    }
                    if (!livroEncontrado) {
                        System.out.println("Não há livros cadastrados!!");
                    }
                    restLiv = livros.length - qtdLiv;
                    if (restLiv > 0) {
                        System.out.println("Ainda restam " + restLiv + " livros para cadastrar!");

                    } else if (restLiv == 0) {
                        System.out.println("Esgotado!");
                    }
                    System.out.println("Dê enter para continuar");
                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 5:
                    try {
                        usuEncontrado = false;
                        livroEncontrado = false;
                        boolean livrofoiEncontrado = false;
                        System.out.println("========================================");
                        System.out.println("                EMPRESTIMO              ");
                        System.out.println("========================================");
                        System.out.println("Deseja pegar um livro emprestado? ");
                        escolha = scan.next().toLowerCase();
                        scan.nextLine();
                        boolean possuiMaisDe3EmpAtivo = false;

                        while ("sim".equals(escolha) || "s".equals(escolha)) {
                            System.out.println("Qual seu ID de usuario?");
                            idUsu = scan.nextInt();
                            scan.nextLine();

                            for (int i = 0; i < usuarios.length; i++) {
                                if (usuarios[i] != null) {
                                    if (idUsu == usuarios[i].getId()) {
                                        usuEncontrado = true; // se encontrado vira true
                                        break;
                                    }
                                }
                            }
                            qtdEmprestimos = 0;
                            for (int i = 0; i < emprestimos.length; i++) {
                                if (emprestimos[i] != null) {
                                    qtdEmprestimos++;
                                }
                            }

                            if (usuarios[idUsu - 1].getQuantidadeEmprs() == 3) {
                                possuiMaisDe3EmpAtivo = true;
                            }

                            if (possuiMaisDe3EmpAtivo) {
                                System.out.println("Esse usuario já possui mais de 3 emprestimos ativos..., devolva pelo menos 1 livro antes de pegar outro");
                            } else {
                                if (usuEncontrado) {
                                    System.out.println("Informe o codigo do livro que voce deseja pegar emprestado: ");
                                    codigo_e = scan.nextInt();
                                    scan.nextLine();

                                    for (int i = 0; i < emprestimos.length; i++) {
                                        if (emprestimos[i] != null) {
                                            if (emprestimos[i].getUsuario().getId() == idUsu) {
                                                if (emprestimos[i].getLivro().getCodigo() == codigo_e) {
                                                    livrofoiEncontrado = true;
                                                    break;
                                                }
                                            }
                                        }
                                    } // logica para analisar se o usuario possui apenas 1 exemplar de cada livro

                                    if (livrofoiEncontrado) {
                                        System.out.println("Esse usuario ja possui esse livro!");
                                    } else {
                                        for (int i = 0; i < livros.length; i++) {
                                            if (livros[i] != null && codigo_e == livros[i].getCodigo()) { // Verifica se o livro não é nulo e se o código bate
                                                if (livros[i].getDisponivel()) {
                                                    System.out.println("O livro ainda possui " + livros[i].getExemplares() + " exemplares");
                                                    System.out.println("Que dia o livro foi emprestado ou vai ser emprestado? ");
                                                    dataDeEmp = scan.nextLine();

                                                    for (int j = qtdEmprestimos; j < (qtdEmprestimos + 1); j++) {
                                                        emprestimos[j] = new Emprestimos(livros[i], dataDeEmp, usuarios[idUsu - 1]);
                                                        emprestimos[j].emprestar(); // diminui a quantidade de exemplares
                                                        emprestimos[j].verificar(); // verifica disponibilidade
                                                        System.out.println(emprestimos[j]);
                                                        
                                                    }

                                                    if (livros[i].getDisponivel()) {
                                                        System.out.println("O livro ainda esta disponivel com mais " + livros[i].getExemplares() + " exemplares.");
                                                        scan.nextLine();
                                                    } else {
                                                        System.out.println("O livro esta sem exemplares disponiveis :" + livros[i].getExemplares());
                                                        scan.nextLine();
                                                    }

                                                } else {
                                                    System.out.println("O livro não está disponível");
                                                }

                                                livroEncontrado = true;
                                                break;
                                            }
                                        }

                                        if (!livroEncontrado) {
                                            System.out.println("Livro não encontrado");
                                        }
                                    }
                                } else {
                                    System.out.println("Usuario não cadastrado!");
                                    scan.nextLine();
                                }
                            }

                            System.out.println("Deseja realizar outro emprestimo?");
                            escolha = scan.nextLine().toLowerCase();
                        }
                    } catch (Exception e) {
                        System.out.println("Erro na entrada de dados. Por favor, verifique e tente novamente.");
                        scan.nextLine(); // limpa a entrada para evitar looping infinito em caso de erro
                    }
                    break;

                case 6:
                    livroEncontrado = false;
                    System.out.println("==========================================");
                    System.out.println("            LIVROS DISPONÍVEIS            ");
                    System.out.println("==========================================");
                    System.out.println("Deseja ver os livros disponiveis? [sim ou nao] ");
                    escolha = scan.next().toLowerCase();
                    scan.nextLine();
                    if ("sim".equals(escolha) || "s".equals(escolha)) {
                        for (int i = 0; i < livros.length; i++) {
                            if (livros[i] != null) {
                                if (livros[i].getDisponivel()) { // se livro.disponivel for true e diferente de null
                                    System.out.println(livros[i]);
                                    livroEncontrado = true;
                                }
                            }
                        }
                        if (!livroEncontrado) {
                            System.out.println("Não há livros disponiveis");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Então beleza po");
                        scan.nextLine();
                    }
                    break;

                case 7:
                    System.out.println("================================");
                    System.out.println("Deseja gravar tudo em 1 arquivo?");
                    System.out.println("================================");
                    escolha = scan.next().toLowerCase();
                    if ("sim".equals(escolha) || "s".equals(escolha)) {
                        System.out.println("Gravando informações em arquivo...");
                        try {
                            FileWriter fileWriter = new FileWriter("biblioteca_dados.txt", true);
                            PrintWriter printWriter = new PrintWriter(fileWriter);

                            // Gravação dos usuários
                            printWriter.println("===== Usuários Cadastrados =====");
                            for (BibliUsuario usuario : usuarios) {
                                if (usuario != null) {
                                    printWriter.println(usuario);
                                }
                            }

                            // Gravação dos livros
                            printWriter.println("\n===== Livros Cadastrados =====");
                            for (BibliLivro livro : livros) {
                                if (livro != null) {
                                    printWriter.println(livro);
                                }
                            }

                            // Gravação dos emprestimos
                            printWriter.println("\n===== Emprestimos Ativos =====");
                            for (Emprestimos emprest : emprestimos) {
                                if (emprest != null) {
                                    printWriter.println(emprest);
                                }
                            }

                            printWriter.close();
                            fileWriter.close();
                            System.out.println("Dados gravados com sucesso em biblioteca_dados.txt!");
                        } catch (Exception e) {
                            System.out.println("Erro ao gravar os dados: " + e.getMessage());
                        }
                    }

                    break;

                case 8:
                    try {
                        livroEncontrado = false;
                        codigoIgual = false;
                        usuEncontrado = false;
                        System.out.println("=======================================");
                        System.out.println("                DEVOLUCAO              ");
                        System.out.println("=======================================");
                        System.out.println("Deseja fazer uma devolucao? ");
                        escolha = scan.next().toLowerCase();

                        while ("sim".equals(escolha) || "s".equals(escolha)) {
                            System.out.println("Informe o seu ID: ");
                            idUsu = scan.nextInt();
                            scan.nextLine();

                            for (int i = 0; i < usuarios.length; i++) {
                                if (usuarios[i] != null && usuarios[i].getId() == idUsu) {
                                    usuEncontrado = true;
                                    if (usuarios[i].getQuantidadeEmprs() > 0) {
                                        for (int j = 0; j < emprestimos.length; j++) {
                                            if (emprestimos[j] != null) { // listagem de livros que o usuario possui emprestado
                                                if (emprestimos[j].getUsuario().getId() == idUsu) {
                                                    System.out.println("Titulo: " + emprestimos[j].getLivro().getTitulo());
                                                    System.out.println("Id: " + emprestimos[j].getLivro().getCodigo());
                                                    System.out.println("-------------------------------------------------");
                                                }
                                            }
                                        }
                                        // ira perguntar o codigo e apos informar, o for verificara se os codigos cadastrado é igual ao informado
                                        System.out.println("Informe o codigo do livro que voce deseja devolver: ");
                                        codigo_e = scan.nextInt();
                                        scan.nextLine();
                                        for (int k = 0; k < livros.length; k++) {
                                            if (livros[k] != null) {
                                                if (livros[k].getCodigo() == codigo_e) {
                                                    livroEncontrado = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (livroEncontrado) {
                                            for (int j = 0; j < emprestimos.length; j++) {
                                                if (emprestimos[j].getUsuario().getId() == idUsu) {
                                                    if (emprestimos[j].getLivro().getCodigo() == codigo_e) {
                                                        codigoIgual = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            // caso encontre o livro, o sistema ira verificar se o codigo do usuario e do livro é do usuario especifico
                                            if (codigoIgual) {
                                                for (int j = 0; j < emprestimos.length; j++) {
                                                    if (emprestimos[j] != null) {
                                                        if (emprestimos[j].getUsuario().getId() == idUsu) {
                                                            if (emprestimos[j].getLivro().getCodigo() == codigo_e) {
                                                                emprestimos[j].setDataEmpr(null);  // vai zerar a data de emprestimo
                                                                emprestimos[j].getLivro().aumentarLivros(1); // vai acrescentar esse exemplar aos disponiveis
                                                                emprestimos[j].verificar(); //verifica a disponibilidade
                                                                emprestimos[j].diminuirQntEmp(); //libera espaço para pegar emprestado 1 livro
                                                                emprestimos[j].setEmpAtivo(); // Emprestimo ativo vira 0 
                                                                System.out.println("livro devolvido com sucesso");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("O codigo informado nao pertence ao que o usuario pegou!");
                                            }
                                        } else {
                                            System.out.println("Esse codigo de livro nao existe!! ");
                                        }
                                    } else {
                                        System.out.println("usuario não possui emprestimos ativos!!");
                                    }
                                }
                                if (!usuEncontrado) {
                                    System.out.println("Usuario não foi encontrado!");
                                }
                            }
                            // a devolução foi feito tudo dentro do for, pois necessita de diversos motivos para ocorrer

                            System.out.println("Deseja fazer uma devolucao? ");
                            escolha = scan.next().toLowerCase();
                        }
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao processar a devolução: " + e.getMessage());
                        scan.nextLine(); // limpa a entrada para evitar looping infinito em caso de erro
                    }

                case 9:
                    emprestEncontrado = false;
                    System.out.println("=======================================");
                    System.out.println("         LISTAGEM DE EMPRESTIMOS       ");
                    System.out.println("=======================================");
                    System.out.println("Deseja fazer listar os emprestimos ativos?");
                    escolha = scan.next().toLowerCase();

                    if ("sim".equals(escolha) || "s".equals(escolha)) {
                        for (int i = 0; i < emprestimos.length; i++) {
                            if (emprestimos[i] != null) {
                                if (emprestimos[i].getEmprestAtivo()) { // se emprestimo[i] estiver ativo
                                    emprestEncontrado = true;
                                    System.out.println(emprestimos[i]); // mostrando na tela o toString de "emprestimos"
                                    System.out.println("======================");
                                }
                            }
                        }
                        if (emprestEncontrado) {
                            System.out.println(" "); // espaço antes
                            System.out.println("Emprestimos listados!!");
                            scan.nextLine(); // aguardar enter para prosseguir
                            scan.nextLine();
                        } else {
                            System.out.println(" "); // espaço antes
                            System.out.println("não há emprestimos ativos");
                            scan.nextLine(); // aguardar enter para prosseguir
                            scan.nextLine();
                        }

                    }
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
