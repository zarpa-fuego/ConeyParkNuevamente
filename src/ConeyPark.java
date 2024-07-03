import java.util.Scanner;

public class ConeyPark {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] comentarios = new String[10]; // Cambia el tamaño del array según sea necesario
        int index = 0;

        System.out.println("Ingresa tus comentarios (escribe 'salir' para finalizar):");

        while (index < comentarios.length) {
            System.out.print("Comentario " + (index + 1) + ": ");
            String comentario = scanner.nextLine();

            if (comentario.equalsIgnoreCase("salir")) {
                break;
            }

            comentarios[index] = comentario;
            index++;
        }

        scanner.close();

        System.out.println("\nComentarios almacenados:");
        for (int i = 0; i < index; i++) {
            System.out.println((i + 1) + ": " + comentarios[i]);
        }
    }
}