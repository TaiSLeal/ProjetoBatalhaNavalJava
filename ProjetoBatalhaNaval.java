package com.company.ProjetoJavaBatalhaNaval;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ProjetoBatalhaNaval {

     static String[][] tabuleiro = new String[11][11]; // Tabuleiro que será impresso

     static int[][] jogador = new int[11][11];

     static int[][] computador = new int[11][11];

     static Scanner scan = new Scanner(System.in);

     static int linha, acertoJogador=0, acertoComputador=0, coluna;

     static Random numeroRandom = new Random();

     static Scanner input = new Scanner(System.in);

    public static void  definicaoDoTabuleiro () {


        tabuleiro[0][0] = "|  ";
        tabuleiro[0][1] = "0";
        tabuleiro[0][2] = "1";
        tabuleiro[0][3] = "2";
        tabuleiro[0][4] = "3";
        tabuleiro[0][5] = "4";
        tabuleiro[0][6] = "5";
        tabuleiro[0][7] = "6";
        tabuleiro[0][8] = "7";
        tabuleiro[0][9] = "8";
        tabuleiro[0][10] = "9";


        tabuleiro[1][0] = "| A";
        tabuleiro[2][0] = "| B";
        tabuleiro[3][0] = "| C";
        tabuleiro[4][0] = "| D";
        tabuleiro[5][0] = "| E";
        tabuleiro[6][0] = "| F";
        tabuleiro[7][0] = "| G";
        tabuleiro[8][0] = "| H";
        tabuleiro[9][0] = "| I";
        tabuleiro[10][0] = "| J";



        for (int i = 1; i < tabuleiro.length; i++) {
            for (int j = 1; j < tabuleiro[i].length; j++) {

                tabuleiro[i][j] = " ";
            }
        }

    }

    public static void impressaoDoTabuleiro (){

        System.out.println("---------------------------------------------");
        System.out.println("                  JOGADOR                    ");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {

                System.out.print(tabuleiro[i][j] + " | ");

            }
            System.out.println();
            System.out.println("---------------------------------------------");
        }

    }

    public static void dicionarioLetrasEmNumeros () {

        String input = scan.next();

        if (input.equalsIgnoreCase("A")) {
            linha = 1;

        } else if (input.equalsIgnoreCase("B")) {
            linha = 2;

        } else if (input.equalsIgnoreCase("C")) {
            linha = 3;

        }else if (input.equalsIgnoreCase("D")) {
            linha = 4;

        } else if (input.equalsIgnoreCase("E")) {
            linha = 5;

        } else if (input.equalsIgnoreCase("F")) {
            linha = 6;

        }else if (input.equalsIgnoreCase("G")) {
            linha = 7;

        }else if (input.equalsIgnoreCase("H")) {
            linha = 8;

        }else if (input.equalsIgnoreCase("I")) {
            linha = 9;

        }else if (input.equalsIgnoreCase("J")) {
            linha = 10;

        }else{
            linha = 100;
        }

    }


    public static void disposicaoManualDosNavios () {

        System.out.print(" Esse é seu Tabuleiro :");
        System.out.println();

        impressaoDoTabuleiro();



        for (int i = 1; i < 11; i++) {



            boolean linhaValida = false;

            while (!linhaValida) {

                System.out.println("Escolha a linha (representada pelas letras (A-J)) onde deseja colocar o " + i + "° navio:");


                dicionarioLetrasEmNumeros();

                if (linha >= 1 && linha <= 10) {

                    linhaValida = true;

                } else {
                    System.out.println("opção invalida, tente novamente");
                }

            }

            boolean colunaValida = false;

            while (!colunaValida) {
                try {
                    input = new Scanner(System.in);

                    System.out.println("Escolha a coluna (representada pelos números (0-9)) onde deseja colocar o " + i + "° navio:");

                    coluna = input.nextInt();

                    if (coluna >= 0 && coluna <= 9) {
                        colunaValida = true;

                    } else {
                        System.out.println("Opção inválida, tente novamente");
                    }

                } catch (InputMismatchException erro) {
                    System.out.println("Opção invalida, tente novamente");
                }
            }

                coluna = coluna + 1;


                tabuleiro[linha][coluna] = "N";
                jogador[linha][coluna] = 1;



            impressaoDoTabuleiro();

        }
    }

    public static void disposicaoAleatoriaDosNavios () {

        for (int x = 1; x < 11; x++) {

            int a;


            a = numeroRandom.nextInt(10);


            jogador[a + 1][x] = 1;
            tabuleiro[a + 1][x] = "N";
        }

        impressaoDoTabuleiro ();
    }

    public static void opcoesDeDisposicoesDosNavios() {

        boolean validado = false;

        while (!validado) {
            try {
                input = new Scanner(System.in);
                System.out.print(" Digite 1 se quiser dispor seus navios manualmente ou digite 2 se quiser dispor seus navios aleatoriamente: ");
                int escolha = input.nextInt();


                if (escolha == 1) {

                    disposicaoManualDosNavios();

                    validado = true;

                } else if (escolha == 2) {

                    disposicaoAleatoriaDosNavios();

                    validado = true;

                }else {
                    System.out.println("Opção invalida!!!");
                }

            } catch (InputMismatchException erro) {

                System.out.println("Opção invalida:");

            }




        }
    }


    public static void disposicaoNaviosComputador () {

        for (int x = 1; x < 11; x++) {

            int b;

            b = numeroRandom.nextInt(10);

            computador[b + 1][x] = 1;

        }
    }

    public static void tirosJogador () {

        boolean linhaValida = false;

        while(!linhaValida) {

            System.out.println("Escolha a linha (representada pelas letras (A-J)) onde deseja atirar:");

            dicionarioLetrasEmNumeros();

            if(linha >= 1 && linha <=10){

                linhaValida = true;

            }else{
                System.out.println("opção invalida, tente novamente");
            }

        }
        System.out.println();

        boolean colunaValida = false;

        while(!colunaValida) {
            try {

                input = new Scanner(System.in);

                System.out.println("Escolha a coluna (representada pelos números (0-9)) onde deseja atirar:");

                coluna = input.nextInt();

                if (coluna >= 0 && coluna <= 9) {
                    colunaValida = true;

                } else {
                    System.out.println("Opção inválida, tente novamente");
                }
            } catch (InputMismatchException erro) {
                System.out.println("Opção inválida, tente novamente");
            }
        }


        coluna = coluna + 1;

        // impresão dos tiros do jogador no tabuleiro

        if (computador[linha][coluna] == 1 && jogador[linha][coluna] == 1) {
            tabuleiro[linha][coluna] = "X";
            acertoJogador = acertoJogador + 1;
        } else if (computador[linha][coluna] == 1 && jogador[linha][coluna] != 1) {
            tabuleiro[linha][coluna] = "*";
            acertoJogador = acertoJogador + 1;
        } else if (computador[linha][coluna] != 1 && jogador[linha][coluna] == 1) {
            tabuleiro[linha][coluna] = "n";
        } else {
            tabuleiro[linha][coluna] = "-";
        }

    }

    public static void tirosComputador () {

        int a ;
        int b ;

        a = numeroRandom.nextInt(10);
        b = numeroRandom.nextInt(10);

        if (jogador[a+1][b+1] == 1) {

            acertoComputador = acertoComputador + 1;

        }
    }


      public static void main (String[]args) {

          System.out.print(" Olá, SEJA BEM VIDO AO JOGO DE BATALHA NAVAL !!!!!");
          System.out.println();
          System.out.print(" Você tem direito a 10 navios ");
          System.out.println();

          definicaoDoTabuleiro ();

          opcoesDeDisposicoesDosNavios();

          disposicaoNaviosComputador ();


          boolean fimDeJogo = false;

          while (!fimDeJogo) {

              tirosJogador ();
              tirosComputador ();
              impressaoDoTabuleiro ();


              // Placar Computador x Jogador
              System.out.println(" * = Tiro certeiro ");
              System.out.println(" - = Tiro na água ");
              System.out.println(" X = Tiro certeiro com navio posicionado ");
              System.out.println(" n = Tiro na água  com navio posicionado ");
              System.out.println("Computador acertou: "+acertoComputador+" navios");
              System.out.println("Você acertou: "+acertoJogador+" navios");


              if (acertoJogador==10 || acertoComputador==10) {
                  fimDeJogo = true;
              }


          }

          if (acertoJogador == 10){
              System.out.println("PARABÉNS VOCÊ GANHOU !!!!!!!!!");
          } else {

              System.out.println("VOCÊ PERDEU !!!!!!!!!");
          }


    }


}


