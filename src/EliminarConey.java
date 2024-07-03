/*import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class EliminarConey {
    private int cant_person;

    public static void main(String[] args) {
        Eliminar_Tarjeta tarjeta = new Eliminar_Tarjeta();
        tarjeta.fedad();
    }

    public void fedad() {
        Scanner usuario = new Scanner(System.in);
        System.out.println("-------------Bienvenido---------------");
        System.out.println("¿Quiere eliminar su tarjeta Coney? ");
        System.out.println("SI/NO");
        String respuesta = usuario.next().toUpperCase();

        if (respuesta.equals("SI")) {
            System.out.println("Para la eliminación de la tarjeta, ingrese su fecha de nacimiento");
            System.out.println("Ingrese el día de su nacimiento (DD): ");
            int dia = usuario.nextInt();
            System.out.println("Ingrese el mes de su nacimiento (MM): ");
            int mes = usuario.nextInt();
            System.out.println("Ingrese el año de su nacimiento (YYYY): ");
            int anio = usuario.nextInt();

            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            int edad = Period.between(fechaNacimiento, fechaActual).getYears();

            System.out.println("Fecha de nacimiento ingresada: " + dia + "/" + mes + "/" + anio);
            System.out.println("Edad calculada: " + edad);

            if (edad >= 18) {
                System.out.println("Proceda a ingresar sus datos para eliminar la tarjeta");
                fDatosCliente();
                double totalPagar = fPago();
                System.out.println("Total a pagar por eliminar la tarjeta: " + totalPagar);
            } else {
                System.out.println("Venga con un mayor, no puede proceder.");
            }

            System.out.println("Tarjeta Coney eliminada con éxito.");
        } else {
            System.out.println("Gracias por su visita. ¡Hasta luego!");
        }

        usuario.close();
    }

    public void fDatosCliente() {
        Scanner butch = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas para eliminar la tarjeta");
        cant_person = butch.nextInt();
        butch.nextLine();

        for (int i = 0; i < cant_person; i++) {
            System.out.println("----DATOS DE LA PERSONA NRO # " + (i + 1));
            System.out.println("Ingrese sus nombres");
            String nombres = butch.nextLine();
            System.out.println("Ingrese sus apellidos");
            String apellidos = butch.nextLine();
            System.out.println("Ingrese su nro dni");
            String dni = butch.nextLine();
            System.out.println("Ingrese su sexo");
            String sexo = butch.nextLine();
        }
    }

    public double fPago() {
        double totalpagar = 0;

        double costoPorPersona = 50;
        totalpagar = cant_person * costoPorPersona;


        double igv = totalpagar * 0.18;

        totalpagar += igv;

        System.out.println("--------------------------------");
        System.out.println("SUBTOTAL: $" + (totalpagar - igv));
        System.out.println("IGV (18%): $" + igv);
        System.out.println("TOTAL A PAGAR: $" + totalpagar);
        System.out.println("--------------------------------");

        return totalpagar;
    }
}
 */