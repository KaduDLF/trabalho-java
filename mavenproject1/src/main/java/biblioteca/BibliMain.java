package biblioteca;

import java.util.Scanner;

public class BibliMain {
    public static void menu(){
        System.out.println("----------------Menu-----------------");
        System.out.println(" 1 - Cadastro de Usuario");
        System.out.println(" 2 - Cadastro de Livro");
        System.out.println(" 3 - listar todos os livros");
        System.out.println(" 4 - listar todos os livros disponiveis");
        System.out.println(" 5 - Associar emprestimo");
        System.out.println(" 6 - devolver algum livro");
        System.out.println(" 7 - sair");
        
    } // função pra mostrar o menu
           
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de biblioteca!");
        
        menu(); // mostrando o menu na tela
        
        System.out.println("escolha uma opção");
        int opc = scan.nextInt();
        
        while(opc != 7){
            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    
                    break;
            }
        }
        
    }
}
