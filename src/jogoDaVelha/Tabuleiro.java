/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

public class Tabuleiro {
	
	private Integer[][] tabuleiro = new Integer[3][3];

	public Tabuleiro() {
		iniciarTabuleiro();
		//exibirTabuleiro();
		
	}
	
	public void iniciarTabuleiro() {
		int p = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				tabuleiro[i][j] = (p);
				p += 1;
			}
		}
	}
	public void exibirTabuleiro() {
		for(int i = 0; i < 3; i++) {
			if(i == 1 || i == 2) {
				System.out.println();
				System.out.println("----+-----+----");
			}
			for(int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == -1) {
					System.out.print(" X ");
					
				}
				else if(tabuleiro[i][j] == -2) {
					System.out.print(" O ");
				}
				else {
					System.out.print(" " + tabuleiro[i][j] + " ");  
				}
				if ( j == 0 || j == 1) {
					System.out.print(" | ");
				}
			}
		}
		System.out.println();
	}
	 public int getPosicao(int[] posicao){
	        return tabuleiro[posicao[0]][posicao[1]];
	 }
	 
	 public void setPosicao( int jogador, Integer posicaoJogada, int[] posicao){
	        if(jogador == 1) {
	        	if (posicaoJogada == 1) {
					posicao[0] = 0;
					posicao[1] = 0;
				} else if (posicaoJogada == 2) {
					posicao[0] = 0;
					posicao[1] = 1;
				} else if (posicaoJogada == 3) {
					posicao[0] = 0;
					posicao[1] = 2;
				} else if (posicaoJogada == 4) {
					posicao[0] = 1;
					posicao[1] = 0;
				} else if (posicaoJogada == 5) {
					posicao[0] = 1;
					posicao[1] = 1;
				} else if (posicaoJogada == 6) {
					posicao[0] = 1;
					posicao[1] = 2;
				} else if (posicaoJogada == 7) {
					posicao[0] = 2;
					posicao[1] = 0;
				} else if (posicaoJogada == 8) {
					posicao[0] = 2;
					posicao[1] = 1;
				} else if (posicaoJogada == 9) {
					posicao[0] = 2;
					posicao[1] = 2;
				}
	            tabuleiro[posicao[0]][posicao[1]] = -1;
	        }
         else if(jogador == 2) {	  
         	if (posicaoJogada == 1) {
					posicao[0] = 0;
					posicao[1] = 0;
				} else if (posicaoJogada == 2) {
					posicao[0] = 0;
					posicao[1] = 1;
				} else if (posicaoJogada == 3) {
					posicao[0] = 0;
					posicao[1] = 2;
				} else if (posicaoJogada == 4) {
					posicao[0] = 1;
					posicao[1] = 0;
				} else if (posicaoJogada == 5) {
					posicao[0] = 1;
					posicao[1] = 1;
				} else if (posicaoJogada == 6) {
					posicao[0] = 1;
					posicao[1] = 2;
				} else if (posicaoJogada == 7) {
					posicao[0] = 2;
					posicao[1] = 0;
				} else if (posicaoJogada == 8) {
					posicao[0] = 2;
					posicao[1] = 1;
				} else if (posicaoJogada == 9) {
					posicao[0] = 2;
					posicao[1] = 2;
				}
	            tabuleiro[posicao[0]][posicao[1]] = -2;
         
        }
	       exibirTabuleiro();
	}
	public boolean validarJogada(Integer posicaoJogada) {
			for(int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(tabuleiro[i][j].equals(posicaoJogada)){
						return true;
					}
				}
			} 
			return false;
	}
	public int verificarGanhador() {		
		for (int i = 0 ; i < 3; i ++) { 
			
			if( (tabuleiro[i][0] == tabuleiro[i][1] ) &&  (tabuleiro[i][2] == tabuleiro[i][0]) && (tabuleiro[i][1] == tabuleiro[i][2])  && tabuleiro[i][0] == -1){
				return -1;
			}
			if( (tabuleiro[i][0] == tabuleiro[i][1] ) &&  (tabuleiro[i][2] == tabuleiro[i][0]) && (tabuleiro[i][1] == tabuleiro[i][2])  && tabuleiro[i][0] == -2){
				return -2;
			}
		}
		for (int j = 0 ; j < 3; j ++) { 
			
			if( (tabuleiro[0][j] == tabuleiro[1][j]) && (tabuleiro[2][j] == tabuleiro[0][1]) && (tabuleiro[1][j] == tabuleiro[2][j] ) && tabuleiro[0][j]  == -1){
				return -1;
			}
			if(  (tabuleiro[0][j] == tabuleiro[1][j]) && (tabuleiro[2][j] == tabuleiro[0][1]) && (tabuleiro[1][j] == tabuleiro[2][j] ) && tabuleiro[0][j]  == -2){
				return -2;
			}	
		}
		if( (tabuleiro[0][0] == tabuleiro[1][1]) && (tabuleiro[0][0] == tabuleiro[2][2]) && (tabuleiro[1][1] == tabuleiro[2][2]) && tabuleiro[0][0] == -1) {
         return -1;
		}
		if( (tabuleiro[0][0] == tabuleiro[1][1]) && (tabuleiro[0][0] == tabuleiro[2][2]) && (tabuleiro[1][1] == tabuleiro[2][2]) && tabuleiro[0][0] == -2) {
         return -2;
		}
		if( (tabuleiro[0][2] == tabuleiro[1][1]) && ( tabuleiro[0][2] == tabuleiro[2][0]) && (tabuleiro[1][1] == tabuleiro[2][0]) && tabuleiro[0][2] == -1) {
         return -1;
		}
		if( (tabuleiro[0][2] == tabuleiro[1][1]) && ( tabuleiro[0][2] == tabuleiro[2][0]) && (tabuleiro[1][1] == tabuleiro[2][0]) && tabuleiro[0][2] == -2) {
         return -2;
		}
     return 0;
	}
	public boolean jogoEmpatado() {
		
		int contador = 9;
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(tabuleiro[i][j] == -1 || tabuleiro[i][j] == -2) {
					contador --;
					
				if (contador == 0 ) {
				    return true;		
				
				}
			}
		}
		}
	return false;
	}
}
