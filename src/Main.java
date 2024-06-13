import Utils.Colors;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.ANSI_CYAN + "Ingrese Nuevo usuario del sistema" + Colors.ANSI_RESET);
        String usernameSystem = scanner.nextLine();
        System.out.println(Colors.ANSI_CYAN + "Ingrese Nueva Clave del sistema del sistema" + Colors.ANSI_RESET);
        String passwordSystem = scanner.nextLine();
        clearConsole();


        System.out.println(Colors.ANSI_CYAN + "==================================================" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_CYAN + "Sistema Coney Park" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_CYAN + "==================================================" + Colors.ANSI_RESET);


        System.out.println(Colors.ANSI_YELLOW + "Ingrese Usuario" + Colors.ANSI_RESET);

        String usuario = scanner.nextLine();
        System.out.println(Colors.ANSI_YELLOW + "Ingrese Password" + Colors.ANSI_RESET);
        String password = scanner.nextLine();

        clearConsole();

        if (login(usuario, password, usernameSystem, passwordSystem)) {
            System.out.println(Colors.ANSI_CYAN + "==================================================" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_CYAN + "Sistema Coney Park" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_CYAN + "Bien Venido" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_CYAN + "==================================================" + Colors.ANSI_RESET);
            Double tarjetaMonto = 0.0;
            int opc = 0;


            do {

                try {
                    printMainMenu();
                    opc = scanner.nextInt();
                    switch (opc) {
                        case 1: {
                            // Gestion de tarjeta
                            do {
                                printMenuTarjeta();
                                opc = scanner.nextInt();
                                switch (opc) {
                                    case 0: {
                                        System.out.println(Colors.ANSI_RED + "Volver atrar" + Colors.ANSI_RESET);
                                    }
                                    break;
                                    case 1: {
                                        tarjetaMonto = recargarSaldo(tarjetaMonto);


                                    }
                                    break;
                                    case 2: {
                                        imprimirTarjeta(tarjetaMonto);
                                    }
                                    break;
                                }
                            } while (opc != 0);
                        }
                        break;
                        case 2: {
                            do {
                                printMenuVenta();
                                opc = scanner.nextInt();
                                switch (opc) {
                                    case 0: {
                                        System.out.println(Colors.ANSI_RED + "Volver atrar" + Colors.ANSI_RESET);
                                    }
                                    break;
                                    case 1: {
                                        tarjetaMonto = crearVenta(tarjetaMonto);
                                    }
                                    break;
                                }

                            } while (opc != 0);
                        }
                        break;
                    }

                } catch (Exception e) {

                }
            } while (opc != 4);
        } else {
            System.out.println(Colors.ANSI_RED + "Ud. No tiene Acceso al Sistema" + Colors.ANSI_RESET);
        }

    }

    public static boolean login(String usuario, String clave, String userSystem, String passwordSystem) {
        if (usuario.equals(userSystem) && clave.equals(passwordSystem)) {
            return true;
        }
        return false;
    }


    public static Double crearVenta(Double tarjeta) {
        printJuegosDisponibles();
        Scanner sc = new Scanner(System.in);
        int opcJuego = sc.nextInt();
        Double precio = precioJuego(opcJuego);
        String producto = nombreJuego(opcJuego);
        if (tarjeta > precio) {
            imprimirBoleta(precio, producto);
            return restarSaldoTareta(tarjeta, precio);
        } else {
            System.out.println(Colors.ANSI_RED + "Ud. No tiene Saldo" + Colors.ANSI_RESET);
            return tarjeta;
        }
    }

    public static Double restarSaldoTareta(Double tarjeta, Double precio) {
        return tarjeta - precio;
    }


    public static void imprimirTarjeta(Double tarjetaMonto) {
        System.out.println(Colors.ANSI_RED + "====================" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "Su Saldo es: |" + tarjetaMonto + "|" + Colors.ANSI_RESET);
    }


    public static void printMainMenu() {
        System.out.println(Colors.ANSI_GREEN + "╔══════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║          Menú Principal      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠══════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Gestion Tarjeta    1      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Gestión Ventas     2      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Salir              4      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚══════════════════════════════╝" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "ingrese opción: " + Colors.ANSI_RESET);

    }

    public static void printMenuVenta() {
        System.out.println(Colors.ANSI_GREEN + "╔══════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║          Menú Venta          ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠══════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Crear Venta         1     ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Volver              0     ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚══════════════════════════════╝" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "ingrese opción: " + Colors.ANSI_RESET);

    }

    public static void printMenuTarjeta() {
        System.out.println(Colors.ANSI_GREEN + "╔══════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║          Menú Tarjeta        ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠══════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Recargar Tarjetas    1    ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Ver Tarjetas         2    ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║    Volver               0    ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚══════════════════════════════╝" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "ingrese opción: " + Colors.ANSI_RESET);

    }

    public static void printJuegosDisponibles() {
        System.out.println(Colors.ANSI_GREEN + "╔══════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║      Juegos Disponibles      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠══════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ OPC ║  Juegos   ║  Precio    ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠══════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 1   ║  Barquito ║  3.30      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 2   ║  Monkey   ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 3   ║  Xball    ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 4   ║  Dolphin  ║  3.80      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 5   ║  Racing   ║  3.80      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 6   ║  DuoDrive ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 7   ║  FrenziII ║  3.30      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 8   ║  Carousel ║  3.80      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 9   ║  Piratas  ║  3.70      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 10  ║  SkyLander║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 11  ║  BigTeeth ║  4.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 12  ║  Lane     ║  3.30      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 13  ║  CrazyHoop║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 14  ║  Deal     ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 15  ║  DinoPop  ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 16  ║  Funny    ║  4.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 17  ║  Jungle   ║  4.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 18  ║  CarBatman║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 19  ║  UltraRace║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 20  ║  CrazySped║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 21  ║  Coconut  ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 22  ║  MotoGP   ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 23  ║  Batman   ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 24  ║  Ghost    ║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 25  ║  AfterDark║  4.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 26  ║  FunkyCats║  3.20      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 27  ║  CongoBong║  2.70      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ 28  ║  ChoqueCar║  7.00      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚══════════════════════════════╝" + Colors.ANSI_RESET);


    }

    public static Double precioJuego(int juegoOpcion) {
        return switch (juegoOpcion) {
            case 1 -> 3.30;
            case 2 -> 3.20;
            case 3 -> 3.20;
            case 4 -> 3.80;
            case 5 -> 3.80;
            case 6 -> 3.20;
            case 7 -> 3.30;
            case 8 -> 3.80;
            case 9 -> 3.70;
            case 10 -> 3.20;
            case 11 -> 4.20;
            case 12 -> 3.30;
            case 13 -> 3.20;
            case 14 -> 3.20;
            case 15 -> 3.20;
            case 16 -> 4.20;
            case 17 -> 4.20;
            case 18 -> 3.20;
            case 19 -> 3.20;
            case 20 -> 3.20;
            case 21 -> 3.20;
            case 22 -> 3.20;
            case 23 -> 3.20;
            case 24 -> 3.20;
            case 25 -> 4.20;
            case 26 -> 3.20;
            case 27 -> 2.70;
            case 28 -> 7.00;
            default -> 0.0;

        };

    }
    public static String nombreJuego(int juegoOpcion) {
        return switch (juegoOpcion) {
            case 1 -> "Barquito";
            case 2 -> "Monkey";
            case 3 -> "Xball";
            case 4 -> "Dolphin";
            case 5 -> "Racing";
            case 6 -> "DuoDrive";
            case 7 -> "FrenziII";
            case 8 -> "Carousel";
            case 9 -> "Piratas";
            case 10 -> "SkyLander";
            case 11 -> "BigTeeth";
            case 12 -> "Lane";
            case 13 -> "CrazyHoop";
            case 14 -> "Deal";
            case 15 -> "DinoPop";
            case 16 -> "Funny";
            case 17 -> "Jungle";
            case 18 -> "CarBatman";
            case 19 -> "UltraRace";
            case 20 -> "CrazySped";
            case 21 -> "Coconut";
            case 22 -> "MotoGP";
            case 23 -> "Batman";
            case 24 -> "Ghost";
            case 25 -> "AfterDark";
            case 26 -> "FunkyCats";
            case 27 -> "CongoBong";
            case 28 -> "ChoqueCar";

            default -> "No existe Juego";
        };

    }


    public static Double recargarSaldo(Double tarjeta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Su saldo actual es : " + Colors.ANSI_BLUE + tarjeta + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "Ingrese Monto a Recargar" + Colors.ANSI_RESET);
        Double recarga = sc.nextDouble();
        tarjeta = tarjeta + recarga;
        System.out.println("Su saldo actual es : " + Colors.ANSI_BLUE + tarjeta + Colors.ANSI_RESET);
        imprimirBoleta(recarga, "Recarga Tarjeta");
        return tarjeta;
    }

    public static void imprimirBoleta(Double monto, String producto) {
        Double baseImpoble = monto / 1.18;
        Double igv = monto - baseImpoble;
        Double total = baseImpoble + igv;
        System.out.println(Colors.ANSI_PURPLE + "===========================================================" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "Tiket Boleta" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "Señores: Varios" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "RUC 20001111544" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "Fecha " + LocalDate.now() + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "Producto " + producto + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "igv " + String.format("%.2f", igv) + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "BI " + String.format("%.2f", baseImpoble) + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "Total " + String.format("%.2f", total) + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_PURPLE + "===========================================================" + Colors.ANSI_RESET);
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}