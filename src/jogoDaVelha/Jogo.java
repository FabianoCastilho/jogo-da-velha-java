/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
	
	private Tabuleiro tabuleiro;
	private int rodada = 1, vez = 1;
	private int comp = 0;
	private Jogador jogador1;
	private Jogador jogador2;
	
	Scanner sc = new Scanner(System.in);
	
	public Jogo() {
		System.out.println("   ##  JOGO DA VELHA  ##");
		tabuleiro = new Tabuleiro();
		iniciarJogadores();
		
		System.out.println("________________________");
		System.out.println();
		System.out.println(" # Iniciando Jogadas # ");
		
		while( Jogar() );
	}
	public void iniciarJogadores() {

		if (escolherJogador() == 1) {
			this.jogador1 = new JogadorHumano(1);
			System.out.println("________________________");
			System.out.println();
			System.out.println("O jogador 2 será o computador");
			do {
				try {
					System.out.println();
					System.out.println("Escolha o nivel do Compudador:  1-easy, 2-medium, 3-hard ");
					System.out.print("Dgite o nivel: ");
					comp = sc.nextInt();
					sc.nextLine();
					if(comp > 3 || comp < 1) {
						System.out.println("Escolha invalida, escolha outo numero de acordo com as opções:");
						System.out.println();
					}
				}catch (InputMismatchException e) {
					 System.out.println("Você Digitou algum caracter invalido");
					 System.out.println();
		    		 sc.next();
				}
			} while (comp < 1 || comp > 3);
			if (comp == 1) {
				this.jogador2 = new ComputadorEasy(2);
			}
			if (comp == 2) {
				this.jogador2 = new ComputadorMedium(2);
			}
			if (comp == 3) {
				this.jogador2 = new ComputadorHard(2);
			}
		} else {
			System.out.println("O jogador 1 será o computador");		
			do {
				try {
					System.out.println();
					System.out.println("Escolha o nivel do Compudador:  1-easy, 2-medium, 3-hard ");
					System.out.print("Dgite o nivel: ");
					comp = sc.nextInt();
					sc.nextLine();
					if(comp > 3 || comp < 1) {
						System.out.println();
						System.out.println("Escolha invalida, escolha outo numero de acordo com as opções:");						
					}
				}catch (InputMismatchException e) {
					System.out.println();
					 System.out.println("Você Digitou algum caracter invalido");
		    		 sc.next();
				}
			}while (comp < 1 || comp > 3);
		
			if (comp == 1) {
				this.jogador1 = new ComputadorEasy(1);
			}
			if (comp == 2) {
				this.jogador1 = new ComputadorMedium(1);
			}
			if (comp == 3) {
				this.jogador1 = new ComputadorHard(1);
			}
			System.out.println("________________________");
			System.out.println("O jogador 2 será Humano.");
			this.jogador2 = new JogadorHumano(2);
		}
	}
	public int escolherJogador(){
      int opcao = 0;
   
      do{
    	  try {
    		  System.out.println("Escolha quem vai ser o Jogador 1:");
		      System.out.println("1 -  Humano");
		      System.out.println("2 - Computador\n");
		      System.out.print("Opção: ");
			  opcao = sc.nextInt();
			  if(opcao != 1 && opcao != 2) {
	              System.out.println("Opção inválida! Digite novamente.");
	              System.out.println();
			  }
    	  }catch (InputMismatchException e) {
				 System.out.println("Você Digitou algum caracter invalido. Digite novamente.");
				 System.out.println();
	    		 sc.next();
			}
      }while(opcao != 1 && opcao != 2);
	   
      return opcao;
     }
	
	 public boolean Jogar(){
       if(!tabuleiro.jogoEmpatado() && tabuleiro.verificarGanhador() == 0 ){
            System.out.println("________________________");
            System.out.println("\n    # Rodada " + rodada + " #");
            System.out.println("É a vez do jogador " + vez() + ".");
            tabuleiro.exibirTabuleiro();
            if(vez() == 1) {
                jogador1.jogar(tabuleiro);
            }
            else
                jogador2.jogar(tabuleiro);   
            
            vez++;
            rodada++;
            return true;
            
        } else if(tabuleiro.verificarGanhador() == -1 ) {
        	System.out.println();
        	System.out.println("    # FIM DE JOGO #");
            System.out.println("** Jogador 1 ganhou!! **");
            return false;
        } else if(tabuleiro.verificarGanhador() == -2) { 
        	System.out.println();
        	System.out.println("    # FIM DE JOGO #");
            System.out.println("** Jogador 2 ganhou!! **");
            return false;
        } else if(tabuleiro.jogoEmpatado()){
        	System.out.println();
        	System.out.println("          # FIM DE JOGO #");
        	System.out.println("** Tabuleiro Completo. Jogo empatado! **");
       	 	return false;
        }
       return true;
	 } 
	 public int vez(){
        if(vez % 2 == 1)
            return 1;
        else
            return 2;
	 }
}
