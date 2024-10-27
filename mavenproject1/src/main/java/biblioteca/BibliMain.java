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
        System.out.println(" 9 - sair");
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
        
        System.out.println("Bem vindo ao sistema de biblioteca!");
        BibliUsuario[] usuarios = new BibliUsuario[100];
        BibliLivro[] livros = new BibliLivro[100];
        Emprestimos[] emprestimos = new Emprestimos[300]; // supondo que cada pessoa pode fazer 3 emprestimos
        menu(); // mostrando o menu na tela
         
        System.out.println("escolha uma opcao");
        int opc = scan.nextInt();

        while (opc != 9) {
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

                            
                            try{
                                FileWriter arquivo = new FileWriter("./arquivo/biblioteca.txt", true);
                                PrintWriter gravarArquivo = new PrintWriter(arquivo);
                                
                                gravarArquivo.println(usuarios[i].toString());
                                gravarArquivo.close();
                                arquivo.close();
                                System.out.println("Usuário foi salvo com sucesso!");
                            
                           
                            } catch (Exception e) {
                                System.out.println("Erro ao salvar usuário! " + e);
                            }

                            scan.nextLine();

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
                        for (int i = qtdLiv; i < (cadLiv  + qtdLiv); i++) { //loop de cria
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

                            
                            try{
                                FileWriter arquivo = new FileWriter("./arquivo/biblioteca.txt", true);
                                PrintWriter gravarArquivo = new PrintWriter(arquivo);
                                
                                gravarArquivo.println(livros[i].toString());
                                gravarArquivo.close();
                                arquivo.close();
                                System.out.println("Livro foi salvo com sucesso!");
                            } catch (Exception e){
                                System.out.println("Não foi possível salvar este livro! " + e);
                            }

                            System.out.println("De enter para continuar: ");
                                    

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
                            usuEncontrado = true;
                            System.out.println(usu);
                            qtdUsuarios++;
                        }

                    }
                    if(!usuEncontrado){
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
                            System.out.println("Titulo: " + livros[i].getTitulo());
                            System.out.println("Autor: " + livros[i].getAutor());
                            System.out.println("Ano de publicacao: " + livros[i].getAnoPub());
                            System.out.println("Exemplares do livro: " + livros[i].getExemplares());
                            System.out.println("Codigo: " + livros[i].getCodigo());
                            System.out.println("================================================");
                            livroEncontrado = true;
                        }
                    }
                    if(!livroEncontrado){
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
                 // fazer um case antes desse para fazer o emprestimo, para depois saber se tem livro disponivelm ou nao
                    // provavelmente tera q fazer alteração nesse case
                case 5:
                    usuEncontrado = false;
                    livroEncontrado = false;
                    System.out.println("========================================");
                    System.out.println("                EMPRESTIMO              ");
                    System.out.println("========================================");         
                    System.out.println("Deseja pegar um livro emprestado? ");   
                    escolha = scan.next().toLowerCase();
                    scan.nextLine();
                    boolean possuiMaisDe3EmpAtivo = false;
                    while("sim".equals(escolha)|| "s".equals(escolha)){
                        System.out.println("Qual seu ID de usuario?");
                        idUsu = scan.nextInt();
                        scan.nextLine();
                        
                        
                        for(int i = 0; i< usuarios.length; i++){
                            if(usuarios[i] != null){
                                if(idUsu == usuarios[i].getId()){
                                    usuEncontrado = true; // se encontrado vira true
                                    break;
                                }
                            }
                        }
                        qtdEmprestimos = 0;
                        for(int i = 0; i < emprestimos.length;i++){
                            if(emprestimos[i] != null){
                                qtdEmprestimos++;
                            }
                        }
                        
                        if(usuarios[idUsu - 1].getQuantidadeEmprs() == 3){
                            possuiMaisDe3EmpAtivo = true;
                        }
                        
                        if(possuiMaisDe3EmpAtivo){
                            System.out.println("Esse usuario já possui mais de 3 emprestimos ativos..., devolva pelo menos 1 livro antes de pegar outro");
                        }else{
                            if(usuEncontrado){
                                System.out.println("Informe o codigo do livro que voce deseja pegar emprestado: ");
                                codigo_e = scan.nextInt();
                                scan.nextLine();
                                for(int i = 0; i < livros.length; i++){
                                    if(livros[i] != null && codigo_e == livros[i].getCodigo()){ // Verifica se o livro não é nulo e se o código bate
                                        if(livros[i].getDisponivel()){
                                            System.out.println("O livro ainda possui " + livros[i].getExemplares() + " exemplares");
                                            System.out.println("Que dia o livro foi emprestado ou vai ser emprestado? ");
                                            dataDeEmp = scan.nextLine();
                                            for(int j = qtdEmprestimos; j < (qtdEmprestimos + 1); j++){
                                                emprestimos[j] = new Emprestimos(livros[i], dataDeEmp, usuarios[idUsu - 1]);// instancia um objeto Emprestimos e anexa a data de emprestimo, o livro e o usuario
                                                emprestimos[j].emprestar(); // usa o metodo da classe emprestimos que diminui a quantidade de exemplares
                                                emprestimos[j].verificar(); // verifica a quantidade de exemplares, se for > 0 então ainda disponivel, se não disponivel = false
                                                System.out.println(emprestimos[j]);
                                            }
                                            if(livros[i].getDisponivel() == true){
                                                System.out.println("O livro ainda esta disponivel com mais " + livros[i].getExemplares());
                                                scan.nextLine();
                                            }else{
                                                System.out.println("O livro esta sem exemplares disponiveis :" + livros[i].getExemplares());
                                                scan.nextLine();
                                            }
                                            
                                            

                                        } else {
                                            System.out.println("O livro não está disponível");
                                        }

                                        livroEncontrado = true; // Define que o livro foi encontrado
                                        break; // Sai do loop
                                    }
                                }

                                // Se o livro não foi encontrado após o loop, exibe a mensagem
                                if(!livroEncontrado){
                                    System.out.println("Livro não encontrado");
                                }
                            }else{
                                System.out.println("Usuario não cadastrado!");
                                scan.nextLine();
                            }
                        }
                        
                        System.out.println("Deseja realizar outro emprestimo?");   
                        escolha = scan.nextLine().toLowerCase();    
                    }
                    break;
                case 6:
                    livroEncontrado = false;
                    System.out.println("==========================================");
                    System.out.println("            LIVROS DISPONIVEIS            ");
                    System.out.println("==========================================");
                    System.out.println("Deseja ver os livros disponiveis? [sim ou nao] ");
                    escolha = scan.next().toLowerCase();
                    scan.nextLine();
                    if ("sim".equals(escolha) || "s".equals(escolha)){
                        for(int i = 0; i < livros.length; i++){
                            if(livros[i] != null){
                                if(livros[i].getDisponivel()){ // se livro.disponivel for true e diferente de null
                                    System.out.println(livros[i]);
                                    livroEncontrado = true;
                                }
                            }
                        }
                        if(!livroEncontrado){
                            System.out.println("Não há livros disponiveis");
                            scan.nextLine();
                        }
                    }else{
                        System.out.println("Então beleza po");
                        scan.nextLine();
                    }
                    break;
                case 7:
                    System.out.println("");
                    break;
                    
                case 8:
                    livroEncontrado = false;
                    System.out.println("=======================================");
                    System.out.println("                DEVOLUCAO              ");
                    System.out.println("=======================================");
                    System.out.println("Deseja fazer uma devolucao? ");
                    escolha = scan.next().toLowerCase();
                    
                        while("sim".equals(escolha) || "s".equals(escolha)){
                            System.out.print("Informe seu ID: ");
                            idUsu = scan.nextInt();
                            int devolvido = 0;
                            for (int i = 0; i < usuarios.length; i++){
                                if(usuarios[i] != null && idUsu == usuarios[i].getId()){
                                    usuEncontrado = true;
                                        if(usuarios[i].getQuantidadeEmprs() > 0){
                                            System.out.println("Deseja fazer devolucao de um livro? ");
                                            escolha = scan.next().toLowerCase();
                                            if("sim".equals(escolha) || "s".equals(escolha)){
                                                for(int j = 0; j < emprestimos.length; j++){
                                                   if(emprestimos[j] != null){
                                                        if(emprestimos[j].getUsuario().getId() == idUsu){
                                                            System.out.println(emprestimos[j].getLivro());

                                                        } 
                                                    }
                                                }
                                                System.out.println("Escolha o codigo do livro que voce deseja devolver: ");
                                                codigo_e = scan.nextInt();
                                                scan.nextLine();
                                                for (int j= 0; j < emprestimos.length; j++){
                                                    if(emprestimos[j].getUsuario().getId() == idUsu){
                                                        if (emprestimos[j].getLivro().getCodigo() == codigo_e){
                                                            livroEncontrado = true;
                                                            emprestimos[j].setDataEmpr(null);  
                                                            emprestimos[j].getLivro().aumentarLivros(1);
                                                            emprestimos[j].verificar();
                                                            emprestimos[j].diminuirQntEmp();
                                                            emprestimos[j].setEmpAtivo();

                                                        } 
                                                    }
                                                }
                                                if (!livroEncontrado){
                                                    System.out.println("O livro nao pertence a esse usuario! ");
                                                }
                                            }  

                                        }
                                }
                            } if (!usuEncontrado){
                                System.out.println("Usuario nao encontrado!");
                            }                
                                    

                       System.out.println("Deseja fazer uma devolucao? ");
                       escolha = scan.next().toLowerCase();
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




