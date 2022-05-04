package projetoPdi1;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FIlters {


    public static BufferedImage aumentoTonalidade(BufferedImage img, int banda, int aumento) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                if (banda == 0) {
                    red += aumento;
                    if (red > 255) {
                        red = 255;
                    }
                }
                if (banda == 1) {
                    green += aumento;
                    if (green > 255) {
                        green = 255;
                    }
                }

                if (banda == 2) {
                    blue += aumento;
                    if (blue > 255) {
                        blue = 255;
                    }
                }


                Color aumentoTon = new Color(red, green, blue);

                img.setRGB(coluna, linha, aumentoTon.getRGB());


            }
        }

        return img;
    }


    public static BufferedImage grayBandR(BufferedImage img) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb;
                rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (int) (red + green + blue) / 3;
                Color novaCor = new Color(red, media, media);


                img.setRGB(coluna, linha, novaCor.getRGB());

            }
        }

        return img;
    }

    public static BufferedImage grayBandG(BufferedImage img) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb;
                rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (int) (red + green + blue) / 3;
                Color novaCor = new Color(media, green, media);


                img.setRGB(coluna, linha, novaCor.getRGB());

            }
        }

        return img;
    }

    public static BufferedImage grayBandB(BufferedImage img) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb;
                rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (int) (red + green + blue) / 3;
                Color novaCor = new Color(media, media, blue);


                img.setRGB(coluna, linha, novaCor.getRGB());

            }
        }

        return img;
    }


    public static BufferedImage grayScaleMedia(BufferedImage img) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (int) (red + green + blue) / 3;


                Color novaCor = new Color(media, media, media);

                img.setRGB(coluna, linha, novaCor.getRGB());


            }
        }

        return img;
    }


    public static BufferedImage negativo(BufferedImage img) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                Color novaCor = new Color(255 - red, 255 - green, 255 - blue);

                img.setRGB(coluna, linha, novaCor.getRGB());


            }
        }

        return img;
    }


    public static BufferedImage limiar(BufferedImage img, int valor) {
        int altura = img.getHeight();
        int largura = img.getWidth();
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                Color novaCor = null;
//                int limiar = 100;


                if (valor > red) {
                    novaCor = new Color(255, 255, 255);
                } else {
                    novaCor = new Color(0, 0, 0);
                }

                img.setRGB(coluna, linha, novaCor.getRGB());


            }
        }

        return img;
    }


    public double[][][] Rgb2yiq(BufferedImage img) {
        int largura = img.getWidth();
        int altura = img.getHeight();

        double[][][] imgYIQ = new double[altura][largura][3];

        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int rgb = img.getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                double y = (double) (0.299 * red + 0.587 * green + 0.114 * blue); //Y
                double i = (double) (0.596 * red - 0.274 * green - 0.322 * blue); //I
                double q = (double) (0.211 * red - 0.523 * green + 0.312 * blue); //Q
                imgYIQ[linha][coluna][0] = y;
                imgYIQ[linha][coluna][1] = i;
                imgYIQ[linha][coluna][2] = q;

                //System.out.println("pixel("+linha+","+coluna+" com Y = "+y+", i= "+i+", q= "+q);
            }
        }

        return imgYIQ;
    }

    public BufferedImage yiq2RGB(double[][][] imgYIQ) {
        int altura = imgYIQ.length;
        int largura = imgYIQ[0].length;
        BufferedImage imgSaida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {

                int red = (int) (imgYIQ[linha][coluna][0] + 0.956 * imgYIQ[linha][coluna][1] + 0.621 * imgYIQ[linha][coluna][2]);
                int green = (int) (imgYIQ[linha][coluna][0] - 0.272 * imgYIQ[linha][coluna][1] - 0.647 * imgYIQ[linha][coluna][2]);
                int blue = (int) (imgYIQ[linha][coluna][0] - 1.106 * imgYIQ[linha][coluna][1] + 1.703 * imgYIQ[linha][coluna][2]);

                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(coluna, linha, novaCor.getRGB());
            }
        }
        return imgSaida;
    }


}
