package principal;
import gestor.GestorMoneda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        String tipoMonedaA = "";
        String tipoMonedaB = "";

        GestorMoneda gestorMoneda = new GestorMoneda();
        gestorMoneda.obtnerMoneda("USD");

        while (opcion != 7){

            mostrarListaOpciones();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    tipoMonedaA = "USD";
                    tipoMonedaB = "ARS";

                    break;
                case 2:
                    tipoMonedaA = "ARS";
                    tipoMonedaB = "USD";

                    break;
                case 3:
                    tipoMonedaA = "USD";
                    tipoMonedaB = "BRL";

                    break;
                case 4:
                    tipoMonedaA = "BRL";
                    tipoMonedaB = "USD";

                    break;
                case 5:
                    tipoMonedaA = "USD";
                    tipoMonedaB = "COP";

                    break;
                case 6:
                    tipoMonedaA = "COP";
                    tipoMonedaB = "USD";

                    break;
                case 7:
                     System.out.println("--- Conversor Finalizado ---");
                    break;

                default:
                    System.out.println("Opcion no valida.");

            }

            if(opcion > 0 && opcion < 7){

                double monedaA = gestorMoneda.obtenerValorMoneda(tipoMonedaA);
                double monedaB = gestorMoneda.obtenerValorMoneda(tipoMonedaB);

                System.out.println("Ingrese la Cantidad de "+tipoMonedaA+" que desea Convertir a "+tipoMonedaB);
                double cantidad = teclado.nextInt();

                double conversion = gestorMoneda.calcularConversionMoneda(monedaA,monedaB,cantidad);

                System.out.println(tipoMonedaB+": "+conversion);

                Scanner tecla = new Scanner(System.in);
                System.out.println("Presione la tecla ENTER para continuar...");
                tecla.nextLine();
            }

        }

    }

    private static void mostrarListaOpciones(){

        String listaOpciones = """
                
                *********************************************
                *            Conversor De Moneda            *
                *********************************************
                
                 1) Dolar => Peso Argentino
                 2) Peso Argentino => Dolar
                 3) Dolar => Real Brasileño
                 4) Real Brasileño => Dolar
                 5) Dolar => Peso Colombiano
                 6) Peso Colombiano => Dolar
                 7) Salir
                 
                *********************************************
                Ingresar el numero de la Opcion seleccionada:""";

        System.out.println(listaOpciones);
    }

}
