import java.util.Random;
import java.util.Scanner;

public class TrabalhoPratico1 {
	
	public static void main(String[] args) {
			
			String escolha;
			String palavraSorteada = null;
			String [][] jogoDaForca = new String [51][52];
			String tema = null;
			String palavras = null;
			int opcao;
			int jogarNovamente = 0;
			int i = 0;
			int j = 0;
			int l = 0;
			int confereTema = 0;
			int conferePalavra = 0;
			int quantidadePalavras = 0;
			int posicaoPalavraAleatoria = 0;
			char letra = 0;
			
			
			Random aleatorio = new Random();
			
			
			Scanner ler = new Scanner(System.in);
			
			System.out.println("===================================");
			System.out.println("         JOGO DA VELHA   ");
			
			carregaTemas(jogoDaForca, i, j);
			
			do {
				
			menu();
			 
			 opcao = ler.nextInt();
				
				switch(opcao) {
				
					case 1:
						
						menuGerenciaTema();
						
						escolha = ler.next();
						
						switch(escolha) {
						
							case "a":
								
								cadastraTema(jogoDaForca,tema,confereTema,i);
								 
							break;
						
							case "b":
								
								excluiTema(jogoDaForca, tema, confereTema, i, j);
								
							break;
						
							case "c":
								
								buscaTema(jogoDaForca, tema, confereTema, i);
								
							break;
						}
					
					break;
				
					case 2:
						
						menuGerenciaPalavra();
						
						escolha = ler.next();
						
						switch(escolha) {
						
							case "a":
								
								cadastraPalavra(jogoDaForca, tema, palavras, confereTema, conferePalavra, i, j);
								
							break;
						
							case "b":
								
								excluiPalavra(jogoDaForca, palavras, conferePalavra, i, j);
								
							break;
						
							case "c":
								
								buscaPalavra(jogoDaForca, palavras, conferePalavra, i, j);
								
							break;
							
							case "d":
								
								listaPalavras(jogoDaForca, tema, confereTema, i, j);
								
							break;
						}
				
					break;
				
					case 3:
						
						jogo(jogoDaForca, tema, palavraSorteada, letra, quantidadePalavras, confereTema, 
								posicaoPalavraAleatoria, jogarNovamente, i, j, l);
						
					break;
				
					default:
						
						if(opcao != 4) {
							
							System.out.println(" Opção Inválida!! Escolha uma opção existente. \n");
						}
				}
				
			}while (opcao != 4);
			
			System.out.println("XAU");
	
		}
	
		
		static void menu() {
			
			System.out.println("\n===================================");
			System.out.println("\n Escolha uma Opção:\n ");
			System.out.println(" Digite (1) - Gerenciar Temas ");
			System.out.println(" Digite (2) - Gerenciar Palavras ");
			System.out.println(" Digite (3) - Jogar ");
			System.out.println(" Digite (4) - Sair ");
			System.out.println("===================================");
			
		}
		
		
		static void menuGerenciaTema() {
			
			System.out.println(" Digite (a) - Cadastrar Tema: ");
			System.out.println(" Digite (b) - Excluir Tema: ");
			System.out.println(" Digite (c) - Buscar Tema: ");
			System.out.println("===================================");
			
		}
		
		static void menuGerenciaPalavra() {

			
			System.out.println(" Digite (a) - Cadastrar Palavra: ");
			System.out.println(" Digite (b) - Excluir Palavra: ");
			System.out.println(" Digite (c) - Buscar Palavra: ");
			System.out.println(" Digite (d) - Listar Palavra");
			System.out.println("===================================");
			
		}
		
		static String cadastraTema(String jogoDaForca[][], String tema, int confereTema, int i) {
			
			System.out.println(" Digite um tema: ");
			Scanner ler = new Scanner(System.in);
			tema = ler.next();
			 
			 for(i = 1; i < 51; i++) {
				
				 if(jogoDaForca[i - 1][0] != null) { // tendo um tema já cadastrado, verificando se exsite repetição
					confereTema = tema.compareTo(jogoDaForca[i - 1][0]);
				 
					if(confereTema == 0) { 
						System.out.println("===================================");
						System.out.println(" Tema Repetido!! ");
						
						break;
						
					}
					
					if(jogoDaForca[i][0] == null) { //cadastrando segundo tema em diante
						jogoDaForca[i][0] = tema;
						System.out.println("===================================");
						System.out.println(" Tema Cadastrado com sucesso! ");
						
						break;
						
					}
					
				}
				 
				 if(jogoDaForca[i][0] == null) { //cadastrando primeiro tema
					 jogoDaForca[i][0] = tema;
					 System.out.println("===================================");
					 System.out.println(" Tema Cadastrado com sucesso! ");
					 
					 break;
					 
				 }
			 
			 }
			 
			return tema;
		}
		
		static String excluiTema(String jogoDaForca[][], String tema, int confereTema, int i, int j) {
			
			System.out.println(" Digite o Tema que deseja Excluir: ");
			Scanner ler = new Scanner(System.in);
			tema = ler.next();
			
			for(i = 1; i < 51; i++) {
				
				if(jogoDaForca[i][0] != null) { //conferindo se tema existe
					confereTema = tema.compareTo(jogoDaForca[i][0]);
					
					if(confereTema == 0) {
						
						for(j = 2; j < 52; j++) {
							
							if(jogoDaForca[i][j] != null) { //conferindo se tema possui palavras cadastradas
								System.out.println("===================================");
								System.out.println(" Não foi possível Excluir o Tema!! ");
								
								break;
								
							}
							
							if(jogoDaForca[i][j] == null) { //excluindo tema
								jogoDaForca[i][0] = jogoDaForca[i+1][0]; // substituindo tema excluido pelo tema posterior
								System.out.println("===================================");
								System.out.println(" Tema Excluído com sucesso! ");
								
								break;
								
							}
						}
					}
				}
			}
			
			return tema;
		}
		
		static void buscaTema(String jogoDaForca[][], String tema, int confereTema, int i) {
			
			System.out.println("Escreva o Tema que deseja Buscar: ");
			Scanner ler = new Scanner(System.in);
			tema = ler.next();
			
			for(i = 1; i < 51; i++) {
				
				if(jogoDaForca[i][0] != null) { //verificando se tema existe
					confereTema = tema.compareTo(jogoDaForca[i][0]);
					
					if(confereTema == 0) {
						System.out.println("===================================");
						System.out.println(" O Tema ( " + jogoDaForca[i][0] + " ) foi Encontrado! ");
					}
				}
			}
		}
		
		static String cadastraPalavra(String jogoDaForca[][], String tema, String palavras, int confereTema, int conferePalavra, int i, int j) {
			
			System.out.println(" Escolha um Tema para Cadastrar uma Palavra: ");
			Scanner ler = new Scanner(System.in);
			tema = ler.next();
			
			for(i = 1; i < 51; i++) {
				
				if(jogoDaForca[i][0] != null) { //verificando se tema existe
					confereTema = tema.compareTo(jogoDaForca[i][0]);
					
					if(confereTema == 0) {
						System.out.println(" Escreva uma Palavra para o Tema: ");
						palavras = ler.next();
						
						for(j = 2; j < 52; j++) {
							
							 if(jogoDaForca[i][j - 1] != null) { //verificando se palavra já existe no tema
								conferePalavra = palavras.compareTo(jogoDaForca[i][j - 1]);
							 
								if(conferePalavra == 0) {
									System.out.println("===================================");
									System.out.println(" Palavra Repetida!! ");
									
									break;
									
								}
								
								if(jogoDaForca[i][j] == null) { //cadastrando segunda palavra em diante
									System.out.println("===================================");
									System.out.println(" Palavra Cadastrada com sucesso! ");
									jogoDaForca[i][j] = palavras;
										
									break;
									
								}
								
							}
							 
							 if(jogoDaForca[i][j] == null) { //cadastrando primeira palavra
								 jogoDaForca[i][j] = palavras;
								 System.out.println("===================================");
								 System.out.println(" Palavra Cadastrada com sucesso! ");
								 
								 break;
								 
							 }
						 
						 }	
						
						
					}
					
				}
			}
			
			return palavras;
		}
		
		static String excluiPalavra(String jogoDaForca[][], String palavras, int conferePalavra, int i, int j) {
			
			System.out.println(" Digite a Palavra que deseja Excluir: ");
			Scanner ler = new Scanner(System.in);
			palavras = ler.next();
			
			for(i = 1; i < 51; i++) {
				
				for (j = 2; j < 52; j++) {
					
					if(jogoDaForca[i][j] != null) { // verificando se palavra existe
						conferePalavra = palavras.compareTo(jogoDaForca[i][j]);
						
						if(conferePalavra == 0) {
							jogoDaForca[i][j] = jogoDaForca[i][j + 1]; // substituindo palavra excluida pela posterior
							System.out.println("===================================");
							System.out.println(" Palavra Excluída com sucesso!");
						}
					}
				}
			}
			
			return palavras;
		}
		
		static void buscaPalavra(String jogoDaForca[][], String palavras, int conferePalavra, int i, int j) {
			
			System.out.println(" Digite a Palavra que deseja Buscar: ");
			Scanner ler = new Scanner(System.in);
			palavras = ler.next();
			
			for(i = 1; i < 51; i++) {
				
				for(j = 2; j < 52; j++) {
					
					if(jogoDaForca[i][j] != null) { // verificando se palavra existe
						conferePalavra = palavras.compareTo(jogoDaForca[i][j]);
						
						if(conferePalavra == 0) {
							System.out.println("===================================");
							System.out.println("Palavra (" + jogoDaForca[i][j] + ") encontrada no Tema (" + jogoDaForca[i][0] + ") !");
						}
					}
				}
			}
		}
		
		static void listaPalavras(String jogoDaForca[][], String tema, int confereTema, int i, int j) {
			
			System.out.println("Escolha um Tema para mostrar as Palavras: ");
			Scanner ler = new Scanner(System.in);
			tema = ler.next();
			
			for(i = 1; i < 51; i++) {
				
				if(jogoDaForca[i][0] != null) { // verificando se tema existe
					confereTema = tema.compareTo(jogoDaForca[i][0]);
					
					if(confereTema == 0) {
						System.out.println("===================================");
						System.out.println(" Tema: " + jogoDaForca[i][0]);
						System.out.print(" Palavras:  ");
						
						for(j = 2; j < 52; j++) {
							
							if(jogoDaForca[i][j] != null) {
								System.out.print(jogoDaForca[i][j] + " || ");
							}
							
						}
						
					}
					
				}
			}
		}
		
		static void jogo(String jogoDaForca[][], String tema, String palavraSorteada, char letra, int quantidadePalavras, int confereTema, 
				int posicaoPalavraAleatoria, int jogarNovamente, int i, int j, int l) {
			
			do {
				quantidadePalavras = 2;
				System.out.println("Escolha um Tema para Começar o Jogo da Forca: ");
				Scanner ler = new Scanner(System.in);
				tema = ler.next();
			
				for(i = 1; i < 51; i++) {
				
					if(jogoDaForca[i][0] != null) { 
						confereTema = tema.compareTo(jogoDaForca[i][0]);
					
						if(confereTema == 0) { //verificando se tema existe
						
							for(j = 2; j < 52; j++) {
							
								if(jogoDaForca[i][j] != null) {
								quantidadePalavras++;
								}		
							}
							
							posicaoPalavraAleatoria = 0;
							Random aleatorio = new Random();
						
							do {
							
								posicaoPalavraAleatoria = aleatorio.nextInt(1,quantidadePalavras);
							
							}while(posicaoPalavraAleatoria == 1 || posicaoPalavraAleatoria == quantidadePalavras);
						
							palavraSorteada = jogoDaForca[i][posicaoPalavraAleatoria];
						
						
							char [] acertos = new char [palavraSorteada.length()];
						
							for(l = 0; l < acertos.length; l++) {
								acertos[l] = 0;
							}
						
							boolean ganhar = false;
							boolean erro = true;
							int tentativas = 6;
						
							while(!ganhar && tentativas > 1) {
							
								System.out.println(" Digite uma Letra: ");
								letra = ler.next().charAt(0);
						
								for(l = 0; l < palavraSorteada.length(); l++) {
							
									if(letra == palavraSorteada.charAt(l)) {
										acertos[l] = 1;
										erro = false;
									
									
									}
								}	
								
								if(erro) {
									tentativas--;
									System.out.println(tentativas);
								}
							
								ganhar = true;
								for(l = 0; l < palavraSorteada.length(); l++) {
							
									if(acertos[l] == 0) {
										System.out.print(" _ ");
									
										ganhar = false;
								
									}else {
										System.out.print(" " + palavraSorteada.charAt(l) + " ");
									}
								}
							}
						
							if(tentativas > 1) {
								System.out.println("\n===================================");
								System.out.println(" Parabéns!Você acertou a palavra! Deseja jogar novamente?");
								System.out.println(" Digite (1) para jogar novamente ou (2) para sair: ");
								jogarNovamente = ler.nextInt();
							
							}else {
								System.out.println("\n\n===================================");
								System.out.println(" Você perdeu! Deseja Deseja jogar novamente? ");
								System.out.println(" Digite (1) para jogar novamente ou (2) para sair: ");
								jogarNovamente = ler.nextInt();
							}
						}
					}
				}
			
			}while(jogarNovamente == 1);
		}
		
		static String carregaTemas(String jogoDaForca[][], int i, int j) {
			
			jogoDaForca[1][0] = "casa";     jogoDaForca[2][0] = "aeroporto";     jogoDaForca[3][0] = "pessoa";       jogoDaForca[4][0] = "carro";      jogoDaForca[5][0] = "comida";
			jogoDaForca[1][2] = "teto";	    jogoDaForca[2][2] = "alfandega";     jogoDaForca[3][2] = "braço";        jogoDaForca[4][2] = "roda";       jogoDaForca[5][2] = "arroz";
			jogoDaForca[1][3] = "chao";     jogoDaForca[2][3] = "aviao";         jogoDaForca[3][3] = "perna";        jogoDaForca[4][3] = "pneu";       jogoDaForca[5][3] = "feijao";
			jogoDaForca[1][4] = "cozinha";  jogoDaForca[2][4] = "piloto";        jogoDaForca[3][4] = "mao";          jogoDaForca[4][4] = "freio";      jogoDaForca[5][4] = "carne";
			jogoDaForca[1][5] = "quarto";   jogoDaForca[2][5] = "estacionamento";jogoDaForca[3][5] = "dedo";         jogoDaForca[4][5] = "acelerador"; jogoDaForca[5][5] = "frango";
			jogoDaForca[1][6] = "jardim";   jogoDaForca[2][6] = "restaurante";   jogoDaForca[3][6] = "olho";         jogoDaForca[4][6] = "motor";      jogoDaForca[5][6] = "peixe";
			jogoDaForca[1][7] = "piscina";  jogoDaForca[2][7] = "mala";          jogoDaForca[3][7] = "cabeça";       jogoDaForca[4][7] = "escapamento";jogoDaForca[5][7] = "salada";
			jogoDaForca[1][8] = "garagem";  jogoDaForca[2][8] = "fila";          jogoDaForca[3][8] = "cabelo";       jogoDaForca[4][8] = "volante";    jogoDaForca[5][8] = "fruta";
			jogoDaForca[1][9] = "sala";     jogoDaForca[2][9] = "comissario";    jogoDaForca[3][9] = "unha";         jogoDaForca[4][9] = "buzina";     jogoDaForca[5][9] = "tomate";
			jogoDaForca[1][10] = "banheiro";jogoDaForca[2][10] = "carrinho";     jogoDaForca[3][10] = "sombrancelha";jogoDaForca[4][10] = "embreagem"; jogoDaForca[5][10] = "batata";
			jogoDaForca[1][11] = "portao";  jogoDaForca[2][11] = "elevador";     jogoDaForca[3][11] = "boca";        jogoDaForca[4][11] = "velocimetro";jogoDaForca[5][11] = "alface";
		
			return jogoDaForca[i][j];
		}
		 
	}
