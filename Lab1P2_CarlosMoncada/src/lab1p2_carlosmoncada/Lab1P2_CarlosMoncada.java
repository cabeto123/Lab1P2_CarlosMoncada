/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_carlosmoncada;

import java.util.Scanner;

/**
 *
 * @author calol
 */
public class Lab1P2_CarlosMoncada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("1.Ejercicio 1");
            System.out.println("2.Ejercicio 2");
            System.out.println("3.Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese A ");
                    int a = entrada.nextInt();
                    System.out.println("Ingrese B");
                    int b = entrada.nextInt();
                    System.out.println("Ingrese C: ");
                    int c = entrada.nextInt();

                    double vertice = (b * -1) / 2 * a;
                    double suma = suma(vertice + 200, a, b, c, 0);
                    System.out.println("Suma " + suma);
                    double resta = resta(vertice-200, a, b, c, 0);
                    System.out.println("Resta "+resta);

                    break;
                case 2:
                    String numero = "";
                    System.out.println("Digite X: ");
                    String XString = entrada.next();
                    for (int i = 0; i < XString.length(); i++) {

                        int codigoascii = (int) XString.charAt(i);
                        if (codigoascii >= 48 && codigoascii <= 57) {
                            numero += XString.charAt(i);
                        }
                    }
                    int X = Integer.parseInt(numero);

                    System.out.println("Digite el limite: ");
                    String xlimite = entrada.next();
                    numero = "";
                    for (int i = 0; i < xlimite.length(); i++) {
                        int codigoascii = (int) xlimite.charAt(i);
                        if (codigoascii >= 48 && codigoascii <= 57) {
                            numero += xlimite.charAt(i);
                        }
                    }
                    int limite = Integer.parseInt(numero);

                    if (limite < 0) {
                        System.out.println("Limite incorrecto");
                    } else {
                        double resp = seno(limite, 0, X, 0);
                        double respcoseno = coseno(limite, 0, X, 0);
                        System.out.println("Seno: " + resp);
                        System.out.println("Coseno: " + respcoseno);
                        if (X < 90) {
                            double resptangente = tangente(limite, 0, X, 0);
                            System.out.println("Tangente " + resptangente);
                        }

                    }

                    break;

            }

        }
    }//fin del main

    public static double seno(int limite, int n, double X, double operacion) {
        if (n == limite + 1) {

            return 0;
        } else {
            double numerador;
            double denominador;

            double x;
            x = Math.pow(X, (2 * n) + 1);

            numerador = Math.pow(-1, n);

            denominador = 2 * n + 1;
            denominador = factorial(denominador);
            operacion = numerador / denominador * x;

            return operacion + (seno(limite, n + 1, X, operacion));

        }

    }

    public static double coseno(int limite, int n, double X, double operacion) {
        if (n == limite + 1) {
            return 0;
        } else {
            double numerador;
            double denominador;

            double x;
            x = Math.pow(X, 2 * n);

            numerador = Math.pow(-1, n);

            denominador = 2 * n;
            denominador = factorial(denominador);
            operacion = numerador / denominador * x;

            return operacion + (coseno(limite, n + 1, X, operacion));

        }

    }

    public static double tangente(int limite, int n, double X, double operacion) {
        if (n == limite + 1) {
            return 0;
        } else {
            double numerador;
            double denominador;

            double x;
            x = Math.pow(X, 2 * n - 1);

            numerador = Math.pow(2, n) * Math.pow(-4, n) * (1 - Math.pow(4, n));

            denominador = 2 * n;
            denominador = factorial(denominador);
            operacion = numerador / denominador * x;

            return operacion + (tangente(limite, n + 1, X, operacion));

        }

    }

    public static double factorial(double n) {
        double aux = n;
        if (n == 0) {
            return 1;
        } else {
            for (double i = n - 1; i >= 1; i--) {
                aux *= i;
            }
            return aux;
        }

    }

    public static double suma(double valorant, int a, int b, int c, int i) {
        if (i == 100) {
            return valorant;
        } else {
            valorant = valorant+(a * (Math.pow(valorant, 2)) + valorant + c) / (2 * a * valorant + b);
            return suma(valorant, a, b, c, i + 1);
        }

    }
    public static double resta(double valorant, int a, int b, int c, int i) {
        if (i == 100) {
            return valorant;
        } else {
            valorant = valorant-(a * (Math.pow(valorant, 2)) + valorant + c) / (2 * a * valorant + b);
            return resta(valorant, a, b, c, i + 1);
        }

    }

}
