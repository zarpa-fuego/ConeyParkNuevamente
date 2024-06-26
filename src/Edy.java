import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Crear_Tarjeta {
    private int cant_person;
    private int opcion;
    private String[] nombres;
    private String[] apellidos;
    private String[] dni;
    private String[] sexo;

    public static void main(String[] args) {
        Crear_Tarjeta tarjeta = new Crear_Tarjeta();
        tarjeta.fedad();
    }

    public String fedad() {
        Scanner usuario = new Scanner(System.in);
        System.out.println("-------------Bienvenido---------------");
        System.out.println("¿Quiere crear su tarjeta Coney? ");
        System.out.println("SI/NO");
        String respuesta = usuario.next().toUpperCase();

        if (respuesta.equals("SI")) {
            System.out.println("Para la compra de la tarjeta, coloque su fecha de nacimiento");
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
                System.out.println("Proceda a llenar sus datos");
                fDatosCliente();
                String resultadoTarjeta = fTarjeta();
                System.out.println(resultadoTarjeta);
                double totalPagar = fPago();
                System.out.println("Total a pagar: " + totalPagar);
            } else {
                System.out.println("Venga con un mayor, no puede ingresar.");
            }

            System.out.println("Tarjeta Coney creada con éxito.");
        } else {
            System.out.println("Gracias por su visita. ¡Hasta luego!");
        }

        usuario.close();
        return null;
    }

    public String fDatosCliente() {
        Scanner butch = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas a reservar tarjeta");
        cant_person = butch.nextInt();
        butch.nextLine();

        nombres = new String[cant_person];
        apellidos = new String[cant_person];
        dni = new String[cant_person];
        sexo = new String[cant_person];

        for (int i = 0; i < cant_person; i++) {
            System.out.println("----DATOS DE LA PERSONA NRO # " + (i + 1));
            System.out.println("Ingrese sus nombres");
            nombres[i] = butch.nextLine();
            System.out.println("Ingrese sus apellidos");
            apellidos[i] = butch.nextLine();
            System.out.println("Ingrese su nro dni");
            dni[i] = butch.nextLine();
            System.out.println("Ingrese su sexo");
            sexo[i] = butch.nextLine();
        }
        return null;
    }

    public String fTarjeta() {
        Scanner frull = new Scanner(System.in);
        System.out.println("Seleccione su tarjeta:");
        System.out.println("Marque 1 para tarjeta simple \nMarque 2 para tarjeta doble");

        opcion = frull.nextInt();
        String resultado = "";

        switch (opcion) {
            case 1:
                if (cant_person == 1) {
                    resultado = "Ha seleccionado una tarjeta simple para 1 persona.";
                } else if (cant_person > 1) {
                    resultado = "La tarjeta simple no es válida para más de 1 persona.";
                }
                break;

            case 2:
                if (cant_person <= 2) {
                    resultado = "Ha seleccionado una tarjeta doble para " + cant_person + " personas.";
                } else {
                    resultado = "La tarjeta doble no es válida para más de 2 personas.";
                }
                break;

            default:
                resultado = "Opción no válida.";
                break;
        }

        frull.close();
        return resultado;
    }

    public double fPago() {
        double subtotal, igv, totalpagar = 0;
        if (opcion == 1) {
            igv = (cant_person * 50) * 0.18;
            subtotal = (cant_person * 50)-igv;
            totalpagar = subtotal + igv;
            System.out.println("--------------------------------");
            System.out.println("SUBTOTAL " + subtotal);
            System.out.println("IGV " + igv);
            System.out.println("TOTAL A PAGAR " + totalpagar);
            System.out.println("--------------------------------");

        } else if (opcion == 2) {
            igv = (cant_person * 80) * 0.18;
            subtotal = (cant_person * 50)-igv;
            totalpagar = subtotal + igv;
            System.out.println("SUBTOTAL " + subtotal);
            System.out.println("IGV " + igv);
            System.out.println("TOTAL A PAGAR " + totalpagar);
        } else if (opcion == 3) {
            igv = (cant_person * 100) * 0.18;
            subtotal = (cant_person * 50)-igv;
            totalpagar = subtotal + igv;
            System.out.println("SUBTOTAL " + subtotal);
            System.out.println("IGV " + igv);
            System.out.println("TOTAL A PAGAR " + totalpagar);
        }
        return totalpagar;
    }
}