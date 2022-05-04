package projetoPdi1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static projetoPdi1.FIlters.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int valor = 0;


        do {
            System.out.println("=================================================== Bem - Vindo ao Menu de Filtros ====================================================");
            System.out.println(" 10 -  Para exibir a foto que vamos modificar");
            System.out.println(" 1 -  aumento de tonalidade");
            System.out.println(" 2 -  banda cinza R");
            System.out.println(" 3 -  banda cinza G");
            System.out.println(" 4 -  banda cinza B");
            System.out.println(" 5 -  Cinza média ");
            System.out.println(" 6 -  Negativo");
            System.out.println(" 7 -  Limiar");
            System.out.println(" 8 -  RGB - YIQ");
            System.out.println(" 9 -  YIQ - RGB ");
            System.out.println(" 0 -  Para Sair ");

            valor = sc.nextInt();
            if (valor == 0) System.exit(0);
            if (valor == 1) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);
                System.out.println("Informe a banda que deseja modificar: 0 , 1 ou 2");
                int banda = sc.nextInt();
                System.out.println("Informe o aumento - de 0 até 255 apenas.");
                int aumento = sc.nextInt();
                BufferedImage imagemSaida = aumentoTonalidade(imagem, banda, aumento);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 2) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = grayBandR(imagem);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 3) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = grayBandG(imagem);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 4) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = grayBandB(imagem);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 5) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = grayScaleMedia(imagem);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 6) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = negativo(imagem);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 7) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");
                System.out.println("Informe o valor de Limiar - Min [0] Max [255]");
                int lim = sc.nextInt();
                // Transformando o arquivo em uma classe de images
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = limiar(imagem, lim);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }
            if (valor == 8) {
                File arquivo;
                arquivo = new File("src//projetoPdi1//lenna.png");

                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                BufferedImage imagemSaida = limiar(imagem, 200);


                ImageIO.write(imagem, "png", new File("src//Pdi01//lenna2.png"));


                JLabel mylabel = new JLabel(new ImageIcon(imagemSaida));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(imagemSaida.getWidth(), imagemSaida.getHeight()));
                myframe.add(mypanel);
                myframe.setVisible(true);

            }

            if (valor == 10) {
                File arquivo = new File("src//Pdi01//lenna.png");
                // Transformando o arquivo em uma classe deimagem
                BufferedImage imagem = ImageIO.read(arquivo);

                int height = imagem.getHeight();
                int width = imagem.getWidth();
                ImageIO.write(imagem, "png", new File("src\\Pdi01\\lenna2.png"));

                // Exibir a imagem

                JLabel mylabel = new JLabel(new ImageIcon(imagem));
                JPanel mypanel = new JPanel();
                mypanel.add(mylabel);
                JFrame myframe = new JFrame();
                myframe.setSize(new Dimension(width, height));
                myframe.add(mypanel);
                myframe.setVisible(true);
            }


        }
        while (valor != 0);


//


    }


}
