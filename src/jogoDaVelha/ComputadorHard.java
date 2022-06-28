/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

import java.util.Random;

public class ComputadorHard extends Jogador{
	
	public ComputadorHard(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println();
		System.out.println("Jogador Computador Hard Criado.");
		
	}
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		jogada(tabuleiro);
		tabuleiro.setPosicao( jogador, posicaoJogada,  posicao);
	}
	@Override
	public void jogada(Tabuleiro tabuleiro) {  
		Random random = new Random();
		do {
			posicaoJogada = random.nextInt(9) + 1;
			
			if(!tabuleiro.validarJogada(posicaoJogada)) {	
				posicaoJogada = 5;
			}
			if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada = 3;
				
			}
		    if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada = random.nextInt(9) + 1;
			}
			
		    if(!tabuleiro.validarJogada(posicaoJogada)){
				posicaoJogada = 7;	
			}
			
			if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada =random.nextInt(9) + 1;
			}
			if(!tabuleiro.validarJogada(posicaoJogada)){
				posicaoJogada = 6;
				
			}
			if(!tabuleiro.validarJogada(posicaoJogada)){
				posicaoJogada = random.nextInt(9) + 1;
			}
			if(!tabuleiro.validarJogada(posicaoJogada)) {
				posicaoJogada =random.nextInt(9) + 1;
			}		
		}while(!tabuleiro.validarJogada(posicaoJogada));
		System.out.println("Posição jogada = " + posicaoJogada);
	}
}
