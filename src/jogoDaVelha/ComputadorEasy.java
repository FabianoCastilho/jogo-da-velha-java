/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

public class ComputadorEasy extends Jogador {
	
	public ComputadorEasy(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println("Jogador Computador Easy Criado.");
		System.out.println();
	}
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		jogada(tabuleiro);
		tabuleiro.setPosicao( jogador, posicaoJogada,  posicao);
	}
	@Override
	public void jogada(Tabuleiro tabuleiro) {  
		
		do {
			posicaoJogada = 8;
			
			if(!tabuleiro.validarJogada(posicaoJogada)) {	
			
				posicaoJogada = 1;
			}
			if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada = 2;
				
			}
		    if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada = 4;
			}
			
		    if(!tabuleiro.validarJogada(posicaoJogada)){
				posicaoJogada = 6;	
			}
			
			if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada = 5;
			}
			if(!tabuleiro.validarJogada(posicaoJogada)){
				posicaoJogada = 9;
				
			}
			if(!tabuleiro.validarJogada(posicaoJogada)){
				posicaoJogada = 3;
			}
			if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada = 7;
			
			}		
		}while(!tabuleiro.validarJogada(posicaoJogada));
		System.out.println("Posição jogada = " + posicaoJogada);
	}

}
