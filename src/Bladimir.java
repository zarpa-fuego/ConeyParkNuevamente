/*import Utils.Colors;

import java.time.LocalDate;
import java.util.Scanner;

public class ConeyParkNuevamente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.ANSI_CYAN + "Ingrese Nuevo usuario del sistema" + Colors.ANSI_RESET);
        String usernameSystem = scanner.nextLine();
        System.out.println(Colors.ANSI_CYAN + "Ingrese Nueva Clave del sistema del sistema" + Colors.ANSI_RESET);
        String passwordSystem = scanner.nextLine();
        System.out.println("Ingrese la edad del usuario");
        String edad = scanner.nextLine();
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
                                    break;                                }
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
                try {
                    printMainMenu();
                    opc = scanner.nextInt();
                    switch (opc) {
                        case 3: {
                            // Instrucciones
                            do {
                                printMainMenuInstrucciones();
                                opc = scanner.nextInt();
                                switch (opc) {
                                    case 0: {
                                        System.out.println(Colors.ANSI_RED + "Volver atrar" + Colors.ANSI_RESET);
                                    }
                                    break;

                                }
                            } while (opc != 0);

                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
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
        System.out.println(Colors.ANSI_GREEN + "║    Instrucciones      3      ║" + Colors.ANSI_RESET);
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
        Double[] juegos = listaJuegos();
        for (int i = 0; i < juegos.length; i++) {
            if ( juegoOpcion - 1 == i){
                return juegos[i];
            }
        }
        return 0.0;
    }

    public static String nombreJuego (int juegoOpcion){
        String[] juegos = listaNombresJuegos();
        for (int i = 0; i < juegos.length; i++){
            if (juegoOpcion - 1== i){
                return juegos[i];
            }
        }
        return "Juego no disponible";
    }

    public static Double[] listaJuegos() {
        Double[] juegos = new Double[28];
        juegos[0] = 3.30;
        juegos[1] = 3.20;
        juegos[2] = 3.20;
        juegos[3] = 3.80;
        juegos[4] = 3.80;
        juegos[5] = 3.20;
        juegos[6] = 3.30;
        juegos[7] = 3.80;
        juegos[8] = 3.70;
        juegos[9] = 3.20;
        juegos[10] = 4.20;
        juegos[11] = 3.30;
        juegos[12] = 3.20;
        juegos[13] = 3.20;
        juegos[14] = 3.20;
        juegos[15] = 4.20;
        juegos[16] = 4.20;
        juegos[17] = 3.20;
        juegos[18] = 3.20;
        juegos[19] = 3.20;
        juegos[20] = 3.20;
        juegos[21] = 3.20;
        juegos[22] = 3.20;
        juegos[23] = 3.20;
        juegos[24] = 4.20;
        juegos[25] = 3.20;
        juegos[26] = 2.70;
        juegos[27] = 7.00;
        return juegos;
    }


    public static String[] listaNombresJuegos() {
        return new String[]{
                "Barquito", "Monkey", "Xball", "Dolphin", "Racing", "DuoDrive",
                "FrenziII", "Carousel", "Piratas", "SkyLander", "BigTeeth", "Lane",
                "CrazyHoop", "Deal", "DinoPop", "Funny", "Jungle", "CarBatman",
                "UltraRace", "CrazySped", "Coconut", "MotoGP", "Batman", "Ghost",
                "AfterDark", "FunkyCats", "CongoBong", "ChoqueCar"
        };
    }
    public static void printMainMenuInstrucciones() {
        System.out.println(Colors.ANSI_GREEN + "╔═══════════════════════════════════════════════════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║                                 Instrucciones                             ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠═══════════════════════════════════════════════════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ Stock mínimo 100 promociones al día o hasta agotar stock.                 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠ Válido para todos los locales Coney Park y Coney Active a nivel nacional. ╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ La promoción aplica según la escala de recarga de cada parque,            ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ para mayor información puede consultar en taquilla                        ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ Si no cuenta con una tarjeta Coney, deberá adquirir una                   ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ Los precios incluyen IGV                                                  ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ El E-Dinero vence a los 60 días de no uso, y los coney bonos estándar     ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ vencen a los 60 días siguientes.                                          ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ Adquiérela en todas las taquillas de los centros de entretenimiento       ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  familiar de Coney Park y Coney Active                                    ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠ ¿Cómo usar la targeta?                                                    ╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ Para jugar deberás deslizar de forma previa la tarjeta en la lectora,     ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║la cual descontará el saldo correspondiente. También podrás ganar e-tickets║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚═══════════════════════════════════════════════════════════════════════════╝" + Colors.ANSI_RESET);

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

 */