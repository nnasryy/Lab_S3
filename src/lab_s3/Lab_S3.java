package lab_s3;
import java.util.Scanner;
import java.util.Random;

public class Lab_S3 {
    private static int contadorPalabrasAlReves = 0;
    private static int contadorNumeroPerfecto = 0;
    private static int contadorPrimos = 0;
    private static int contadorVotaciones = 0;

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.println("**** Menu ****");
        System.out.println("1. Palabras Al Reves");
        System.out.println("2. Numero Perfecto");
        System.out.println("3. Primos");
        System.out.println("4. Votaciones");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opcion: ");
        int entrada = lea.nextInt();
        lea.nextLine();

        if (entrada <= 0 || entrada > 5) {
            System.out.println("Error. Opcion no permitida");
        } else {
            switch (entrada) {
                case 1:
                    int cantidad = 0, maxLongitud = 0;
                    String palabraMasLarga = "";

                    System.out.println("***Palabras Al Reves***");
                    System.out.print("Ingrese la cantidad de palabras: ");
                    cantidad = lea.nextInt();
                    lea.nextLine();

                    for (int i = 1; i <= cantidad; i++) {
                        System.out.print("Palabra #" + i + ": ");
                        String palabra = lea.nextLine();

                        String palabraInvertida = new StringBuilder(palabra).reverse().toString();
                        System.out.println("Al reves: " + palabraInvertida);

                        if (palabra.length() > maxLongitud) {
                            maxLongitud = palabra.length();
                            palabraMasLarga = palabra;
                        }
                    }

                    if (!palabraMasLarga.isEmpty()) {
                        String invertida2 = new StringBuilder(palabraMasLarga).reverse().toString();
                        System.out.println("La palabra mas larga fue: " + palabraMasLarga);
                        if (palabraMasLarga.equalsIgnoreCase(invertida2)) {
                            System.out.println(", Si es un palindromo");
                        } else {
                            System.out.println(", No es un palindromo");
                        }
                    }
                    System.out.println();
                    contadorPalabrasAlReves++;
                    break;
                case 2:
                    System.out.println("*** Numero Perfecto ***");
                    System.out.print("Ingresa un numero: ");
                    int numero = lea.nextInt();

                    int sumaDivisores = 0;

                    for (int i = 1; i < numero; i++) {
                        if (numero % i == 0) {
                            sumaDivisores += i;
                        }
                    }

                    if (sumaDivisores == numero) {
                        System.out.println(numero + " es perfecto.");
                    } else {
                        System.out.println(numero + " no es perfecto.");
                    }
                    System.out.println();
                    contadorNumeroPerfecto++;
                    break;
                case 3:
                    System.out.println("***Primos***");
                    Random random = new Random();
                    numero = random.nextInt(100) + 1;

                    int divisores = 0;
                    System.out.println("Numero generado: " + numero);
                    System.out.print("Divisores de " + numero + " son: ");

                    for (int i = 1; i <= numero; i++) {
                        if (numero % i == 0) {
                            divisores++;
                            System.out.print(i);
                            if (i < numero) {
                                System.out.print(", ");
                            }
                        }
                    }
                    System.out.println();

                    if (divisores == 2) {
                        System.out.println("El numero " + numero + " es primo porque tiene " + divisores + " divisores (1 y si mismo).");
                    } else {
                        System.out.println("El numero " + numero + " no es primo porque tiene " + divisores + " divisores.");
                    }
                    System.out.println();
                    contadorPrimos++;
                    break;
                case 4:
                    int votosAzul = 0, votosRojo = 0, votosNegro = 0, votosAmarillo = 0, votosNulos = 0;

                    System.out.println("Votaciones");
                    System.out.print("¿Cuantos votantes hay en el pais?: ");
                    int votantes = lea.nextInt();

                    System.out.println("Opciones de voto:");
                    System.out.println("1. Azul");
                    System.out.println("2. Rojo");
                    System.out.println("3. Negro");
                    System.out.println("4. Amarillo");

                    for (int i = 0; i < votantes; i++) {
                        System.out.print("Ingrese el voto del votante " + (i + 1) + ": ");
                        int voto = lea.nextInt();

                        switch (voto) {
                            case 1:
                                votosAzul++;
                                break;
                            case 2:
                                votosRojo++;
                                break;
                            case 3:
                                votosNegro++;
                                break;
                            case 4:
                                votosAmarillo++;
                                break;
                            default:
                                votosNulos++;
                                break;
                        }
                    }

                    int votosValidos = votosAzul + votosRojo + votosNegro + votosAmarillo;
                    double porcentajeValidos = (double) votosValidos / votantes;

                    System.out.println("--- Resultados de la Votacion ---");
                    System.out.println("Votos por Azul: " + votosAzul);
                    System.out.println("Votos por Rojo: " + votosRojo);
                    System.out.println("Votos por Negro: " + votosNegro);
                    System.out.println("Votos por Amarillo: " + votosAmarillo);
                    System.out.println("Votos Nulos: " + votosNulos);
                    System.out.println("Total de votos validos: " + votosValidos);
                    System.out.println("Porcentaje de votos validos: " + String.format("%.2f%%", porcentajeValidos * 100));

                    String planillaGanadora = "Amarillo";
                    if (votosAzul > votosRojo && votosAzul > votosNegro && votosAzul > votosAmarillo) {
                        planillaGanadora = "Azul";
                    } else if (votosRojo > votosAzul && votosRojo > votosNegro && votosRojo > votosAmarillo) {
                        planillaGanadora = "Rojo";
                    } else if (votosNegro > votosAzul && votosNegro > votosRojo && votosNegro > votosAmarillo) {
                        planillaGanadora = "Negro";
                    }

                    if (porcentajeValidos >= 0.6) {
                        System.out.println("Planilla ganadora: " + planillaGanadora);
                    } else {
                        System.out.println(" VOTACION FALLIDA");
                    }
                    System.out.println();
                    contadorVotaciones++;
                    break;
                case 5:
                    System.out.println("Salida del programa...");
                    break;
            }
        }

        System.out.println("---uso del menu---");
        System.out.println("Palabras Al Reves ingresado: " + contadorPalabrasAlReves + " veces.");
        System.out.println("Numero Perfecto ingresado: " + contadorNumeroPerfecto + " veces.");
        System.out.println("Primos ingresado: " + contadorPrimos + " veces.");
        System.out.println("Votaciones ingresado: " + contadorVotaciones + " veces.");

        lea.close();
    }
}