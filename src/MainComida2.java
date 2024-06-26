import java.util.Scanner;
public class comida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double PORCENTAJE_IGV = 0.18;
        String[] nombresComida = {
                "Pizza grande", "Pizza familiar", "Hamburguesa de carne", "Hamburguesa de pollo",
                "Helado trika", "Helado sublime", "Helado de chocolate", "Helado de fresa",
                "Helado de vainilla", "Raspadilla", "Gaseosa Pepsi", "Gaseosa Coca Cola",
                "Gaseosa Nika Cola", "Algodón de Azúcar", "PopCorn", "Chocolate sublime",
                "Chocolate prindcesa", "Papitas Lays picantes", "Papitas Lays", "Galleta oreo",
                "Galletas casino", "Empanadas"
        };
        double[] preciosComida = {
                30.00, 50.00, 12.00, 5.00,
                1.80, 3.00, 2.00, 3.50,
                3.50, 3.00, 1.00, 3.00,
                3.00, 2.00, 3.00, 2.50,
                2.50, 2.50, 2.50, 3.00,
                2.00, 3.00
        };

        double totalComida = 0.0;
        double montoTotal, subTotal, igv;

        System.out.println("Bienvenido a la Tienda de Juegos Mecánicos y Comida");
        System.out.println("Seleccione los productos de comida que desea comprar:");
        for (int i = 0; i < nombresComida.length; i++) {
            System.out.println((i + 1) + ".- " + nombresComida[i] + " - S/." + preciosComida[i]);
        }
        System.out.println("Ingrese '0' para terminar la selección de comida.");

        int opComida;
        while (true) {
            System.out.print("Seleccione una opción (0 para terminar): ");
            opComida = scanner.nextInt();

            if (opComida == 0) {
                break;
            } else if (opComida < 1 || opComida > nombresComida.length) {
                System.out.println("Opción no válida");
            } else {
                System.out.print("Ingrese la cantidad de " + nombresComida[opComida - 1] + " que desea comprar: ");
                int cantidad = scanner.nextInt();
                double subtotalComida = preciosComida[opComida - 1] * cantidad;
                totalComida += subtotalComida;
                System.out.println("Subtotal para " + nombresComida[opComida - 1] + ": S/." + subtotalComida);
            }
        }

        subTotal = totalComida;
        igv = subTotal * PORCENTAJE_IGV;
        montoTotal = subTotal + igv;

        System.out.println("\n-----TICKET DE COMPRA-----");
        System.out.println("Comida:");
        if (totalComida > 0.0) {
            System.out.println("Total de comida: S/." + totalComida);
        } else {
            System.out.println("No se seleccionó comida.");
        }
        System.out.println("\nSubtotal: S/." + subTotal);
        System.out.println("IGV (18%): S/." + igv);
        System.out.println("Total a pagar: S/." + montoTotal);

        scanner.close();
    }
}