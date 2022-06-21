package jogoDaVelha;

import java.util.Scanner;

public class Jogo {
	
	private Tabuleiro tabuleiro;
	private int rodada = 1, vez = 1;
	private Jogador jogador1;
	private Jogador jogador2;
	
	Scanner sc = new Scanner(System.in);
	
	public Jogo() {
		
		tabuleiro = new Tabuleiro();
		iniciarJogadores();
		
		while( Jogar() );
	}
	public void iniciarJogadores() {
		System.out.println(" Escolha quer vai ser o Jogador 1:");
		if (escolherJogador() == 1) {
			this.jogador1 = new JogadorHumano(1);
			
			System.out.println("O jogador 2 será o computador");
			System.out.println("Escolha o nivel do Compudador:  1-easy, 2-medium, 3-hard ");
			int comp = sc.nextInt();
			sc.nextLine();
			while (comp > 3 || comp < 1) {
				System.out.println(" Escolha invalida, escolha outo numero de acordo com as opções: ");
				System.out.print("1-easy, 2-medium, 3-hard :");
				comp = sc.nextInt();
			} 
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
			System.out.print("Escolha o nivel do Compudador:  1-easy, 2-medium, 3-hard ");
			int comp = sc.nextInt();
			while (comp > 3 || comp < 1) {
				System.out.println(" Escolha invalida, escolha outo numero de acordo com as opções: ");
				System.out.print("1-easy, 2-medium, 3-hard :");
				comp = sc.nextInt();
			} 
			if (comp == 1) {
				this.jogador1 = new ComputadorEasy(1);
			}
			if (comp == 2) {
				this.jogador1 = new ComputadorMedium(1);
			}
			if (comp == 3) {
				this.jogador1 = new ComputadorHard(1);
			}
			
			this.jogador2 = new JogadorHumano(2);
		}
	}
	public int escolherJogador(){
      int opcao=0;
      
      do{
          System.out.println("1 -  Humano");
          System.out.println("2 - Computador\n");
          System.out.print("Opção: ");
          opcao = sc.nextInt();
          sc.nextLine();
          
          if(opcao != 1 && opcao != 2)
              System.out.println("Opção inválida! Tente novamente");
      }while(opcao != 1 && opcao != 2);
      
      return opcao;
     }
	 public boolean Jogar(){
        if(tabuleiro.verificarGanhador() == 0 ){
            System.out.println("_______________________");
            System.out.println("\nRodada "+ rodada);
            System.out.println("É a vez do jogador " + vez() );
            
            if(vez() == 1) {
                jogador1.jogar(tabuleiro);
            }
            else
                jogador2.jogar(tabuleiro);
           
            if(tabuleiro.jogoEmpatado()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            vez++;
            rodada++;
            return true;
        } else{
            if(tabuleiro.verificarGanhador() == -1 )
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");
            return false;
        }
	 } 
	 public int vez(){
        if(vez % 2 == 1)
            return 1;
        else
            return 2;
	 }
}
