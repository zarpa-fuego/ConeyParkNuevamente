import Utils.Colors;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    private int cant_person;
    private int opcion;
    private String[] nombres;
    private String[] apellidos;
    private String[] dni;
    private String[] sexo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.ANSI_CYAN + "Ingrese Nuevo usuario del sistema" + Colors.ANSI_RESET);
        String usernameSystem = scanner.nextLine();
        System.out.println(Colors.ANSI_CYAN + "Ingrese Nueva Clave al sistema" + Colors.ANSI_RESET);
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
            System.out.println(Colors.ANSI_CYAN + "Bienvenido" + Colors.ANSI_RESET);
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
    //EDY TOLA
    public void fedad() {
        Scanner usuario = new Scanner(System.in);
        System.out.println("-------------Bienvenido---------------");
        System.out.println("¿Quiere crear su tarjeta Coney?");
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
    }
    public void fDatosCliente() {
        Scanner butch = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas a reservar tarjeta");
        cant_person = butch.nextInt();
        butch.nextLine();

        this.nombres = new String[cant_person];
        this.apellidos = new String[cant_person];
        this.dni = new String[cant_person];
        this.sexo = new String[cant_person];

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
    }

    public String fTarjeta() {
        Scanner frull = new Scanner(System.in);
        System.out.println("Seleccione su tarjeta:");
        System.out.println("Marque 1 para tarjeta simple");

        opcion = frull.nextInt();
        String resultado = "";

        if (opcion == 1) {
            if (cant_person == 1) {
                resultado = "Ha seleccionado una tarjeta simple para 1 persona.";
            } else {
                resultado = "La tarjeta simple no es válida para más de 1 persona.";
            }
        } else {
            resultado = "Opción no válida.";
        }
        return resultado;
    }
    //EDY TOLA
    public static boolean login(String usuario, String clave, String userSystem, String passwordSystem) {
        if (usuario.equals(userSystem) && clave.equals(passwordSystem)) {
            return true;
        }
        return false;
    }


    public static Double crearVenta(Double tarjeta) {
        cualProducto();
        Scanner opcproducto = new Scanner(System.in);
        int productoEscogido = opcproducto.nextInt();
        switch (productoEscogido) {
            case 1:
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
            case 2:
                printComidasDisponibles();
                Scanner sc2 = new Scanner(System.in);
                int opcComida = sc2.nextInt();
                Double precio1 = precioComida(opcComida);
                String producto1 = nombreComida(opcComida);
                if (tarjeta > precio1) {
                    imprimirBoleta(precio1, producto1);
                    return restarSaldoTareta(tarjeta, precio1);
                } else {
                    System.out.println(Colors.ANSI_RED + "Ud. No tiene Saldo" + Colors.ANSI_RESET);
                    return tarjeta;
                }
        }
        return tarjeta;
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

    public static void cualProducto() {
        System.out.println(Colors.ANSI_GREEN + "╔══════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║       ¿Què le vendemos?      ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠══════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  1. Juegos   ║  2. Comidas   ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚══════════════════════════════╝" + Colors.ANSI_RESET);
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

    public static void printComidasDisponibles() {
        System.out.println(Colors.ANSI_GREEN + "╔═══════════════════════════════════╗" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║         Comidas Disponibles       ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠═══════════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║ OPC ║     Comidas        ║ Precio ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╠═══════════════════════════════════╣" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  1  ║    Pizza Grande    ║  30.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  2  ║   Pizza Familiar   ║  50.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  3  ║Hamburguesa de Pollo║   5.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  4  ║   Helado Sublime   ║   3.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  5  ║    Helado Trika    ║   2.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  6  ║  Helado Chocolate  ║   3.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  7  ║  Helado Vainilla   ║   3.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  8  ║    Helado Fresa    ║   3.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  9  ║     Raspidilla     ║   3.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  10 ║    Gaseosa Pepsi   ║   3.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  11 ║  Gaseosa Cocacola  ║   2.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  12 ║  Gaseosa Inkacola  ║   2.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  13 ║ Halgodón de Azúcar ║   2.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  14 ║      Popcorn       ║   3.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  15 ║ Chocolate Princesa ║   2.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  16 ║    Papitas Lays    ║   1.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  17 ║  Papitas Picantes  ║   1.50 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  18 ║    Galleta Oreo    ║   1.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  19 ║    Galeta Casino   ║   1.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "║  20 ║       Empanada     ║   3.00 ║" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "╚═══════════════════════════════════╝" + Colors.ANSI_RESET);
    }

    public static Double precioJuego(int juegoOpcion) {
        Double[] juegos = listaJuegos();
        for (int i = 0; i < juegos.length; i++) {
            if (juegoOpcion - 1 == i) {
                return juegos[i];
            }
        }
        return 0.0;
    }

    public static String nombreJuego(int juegoOpcion) {
        String[] juegos = listaNombresJuegos();
        for (int i = 0; i < juegos.length; i++) {
            if (juegoOpcion - 1 == i) {
                return juegos[i];
            }
        }
        return "Juego no disponible";
    }

    public static Double precioComida(int opcComida) {
        Double[] comidas = listaComidas();
        for (int i = 0; i < comidas.length; i++) {
            if (opcComida - 1 == i) {
                return comidas[i];
            }
        }
        return 0.0;
    }

    public static String nombreComida(int opcComida) {
        String[] comidas = listaNombresComidas();
        for (int i = 0; i < comidas.length; i++) {
            if (opcComida - 1 == i) {
                return comidas[i];
            }
        }
        return "Comida no disponible";
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

    public static String[] listaNombresComidas() {
        return new String[]{
                "Pizza Grande", "Pizza Familiar", "Hamburguesa de pollo",
                "Helado Sublime", "Helado Trika", "Helado Chocolate", "Helado Vainilla", "Helado Fresa",
                "Raspadilla", "Gaseosa Pepsi", "Gaseosa Coca Cola",
                "Gaseosa Inka Cola", "Algodón de Azúcar", "PopCorn",
                "Chocolate Princesa", "Papitas Lays", "Papitas Picantes", "Galleta Oreo",
                "Galletas Casino", "Empanada"
        };
    }

    public static Double[] listaComidas() {
        Double[] comidas = new Double[20];
        comidas[0] = 30.00;
        comidas[1] = 50.00;
        comidas[2] = 5.00;
        comidas[3] = 3.00;
        comidas[4] = 2.00;
        comidas[5] = 3.50;
        comidas[6] = 3.50;
        comidas[7] = 3.50;
        comidas[8] = 3.00;
        comidas[9] = 3.00;
        comidas[10] = 2.50;
        comidas[11] = 2.50;
        comidas[12] = 2.00;
        comidas[13] = 3.00;
        comidas[14] = 2.50;
        comidas[15] = 1.50;
        comidas[16] = 1.50;
        comidas[17] = 1.00;
        comidas[18] = 1.50;
        comidas[19] = 3.00;
        return comidas;
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
