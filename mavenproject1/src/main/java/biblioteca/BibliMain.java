package biblioteca;

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
        int qtd = 0; 
        String nomeUsu, sexoUsu, contatoUsu; // variaveis para cadastro de usuario
        int idadeUsu, idUsu; // variaveis para cadastro de usuario
        System.out.println("Bem vindo ao sistema de biblioteca!");
        
        menu(); // mostrando o menu na tela
        
     
        System.out.println("escolha uma opcao");
        int opc = scan.nextInt();
                
        while(opc != 8){
            switch(opc){
                case 1:
                    System.out.println("Deseja cadastrar quantos usuarios?");
                    qtd = scan.nextInt();
                    BibliUsuario[] usuarios = new BibliUsuario[qtd];
                    
                 
                    for(int i = 0; i<usuarios.length;i++){
                        scan.nextLine();
                        System.out.println("Digite o nome do usuario");
                        nomeUsu = scan.nextLine();
                        System.out.println("Digite o sexo do usuario");
                        sexoUsu = scan.nextLine();
                        System.out.println("Digite o contato do usuario, ex'(62)4402-8922'");
                        contatoUsu = scan.nextLine();
                        System.out.println("Digite a idade do usuario");
                        idadeUsu = scan.nextInt();
                        scan.nextLine();
                        idUsu = (i + 1);
                        usuarios[i] = new BibliUsuario(nomeUsu, sexoUsu, contatoUsu, idadeUsu, idUsu);
                        System.out.println(usuarios[i].getNome() + " cadastrado com sucesso!!" + "\n" + "dê enter para prosseguir!");
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Listagem de Usuarios");
                    scan.nextLine();
                    for(BibliUsuario usu : usuarios){
                        
                    }
                    break;
                case 4:
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
