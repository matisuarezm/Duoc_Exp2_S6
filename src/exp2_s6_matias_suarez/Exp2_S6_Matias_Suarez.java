package exp2_s6_matias_suarez;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author msuarez
 */
public class Exp2_S6_Matias_Suarez {
    
    Scanner input = new Scanner(System.in);
    static String nombreTeatro = "TEATRO MORO";
    final int totalAsientosTeatro = 20;
    final int valorEntrada = 5000;
    final String[] asientos = new String[totalAsientosTeatro]; //estado de asientos Reservado - Comprado - Libre
    ArrayList<Integer> guardaAsientoComprado = new ArrayList<>();
    static int entradasReservadas = 0;
    static int entradasVendidas = 0;
    
    //Clase Main
    public static void main(String[] args) throws InterruptedException {
        System.out.println("====--->>> BIENVENIDOS AL EXPECTACULAR " + nombreTeatro + " <<<---====\n");
        Exp2_S6_Matias_Suarez menuPrincipal = new Exp2_S6_Matias_Suarez();//Instanciamos la clase principal
        menuPrincipal.MostrarMenu();//llamamos al metodo MostrarMenu() dentro de la clase instanaciada
    }
    
    //Constructor inicializamos todo los asientos como libres
    public Exp2_S6_Matias_Suarez(){
        for (int i = 0; i < totalAsientosTeatro; i++) {
            asientos[i] = "Libre";
        }
    }
    
    //Creamos una clase Menu
    public void MostrarMenu() throws InterruptedException{
        int opcionMenu = 0;        
        do {
            System.out.println("===... MEMÚ PRINCIPAL " + nombreTeatro + " ...===\n");
            System.out.println("1.- Reserva de Asientos");
            System.out.println("2.- Modificar la Reserva");
            System.out.println("3.- Comprar Entrada");
            System.out.println("4.- Imprimir Boleta");
            System.out.println("5.- Salir");
            System.out.print("\nSeleccione una opcion del Menú: ");
            
            try{
                opcionMenu = input.nextInt();
                input.nextLine();
                switch (opcionMenu){
                    case 1:
                        ReservarAsiento();
                        break;
                    case 2:
                        ModificarReserva();
                        break;                    
                    case 3:
                        ComprarEntrada();
                        break;
                    case 4:
                        ImprimirBoleta();
                        break;
                    case 5:
                        System.out.println("Usted esta saliendo del sistema, Muchas gracias.");
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(900);
                        System.out.print(".");
                    }
                    System.out.println("");
                    break;//fin break menu (5)
                    default:
                        System.out.println("Opcion Ingresada no es valida, Intente nuevamente");
                }
            }catch (InputMismatchException e){
                System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
                input.nextLine();
                opcionMenu = 0;
            }            
        }while(opcionMenu != 5);
    
    }//Fin metodo MostrarMenu
    
    public void ReservarAsiento(){
        
        System.out.println(":::... RESERVA DE ASIENTO ...:::");
        System.out.println("\nLos asientos disponibles son los siguientes: ");
        
        //Mostrar asientos libres
        for (int i = 0; i < totalAsientosTeatro; i++) {
            if (asientos[i].equals("Libre")) {
                System.out.print((i+1) + "[" + asientos[i] + "]");
                if ((i + 1) % 4 == 0) {
                    System.out.println("");
                }
            }
        }
        
        int cantidadAReservar = CantidadEntradas();
        int reservados = 0;
        
        while (reservados < cantidadAReservar){
            try{
                System.out.print("Ingrese el numero de asiento a reservar #" + (reservados + 1) + ": ");
                int asientoAReservar = input.nextInt();
                input.nextLine();
                if (asientoAReservar < 1 || asientoAReservar > totalAsientosTeatro) {
                    System.out.println("Asiento ingresado inválido");
                    continue;
                }
                
                String estadoReserva = asientos[asientoAReservar - 1];
                if (!estadoReserva.equals("Libre")) {
                    System.out.println("Asiento no disponible. Estado: " + asientos[asientoAReservar - 1]);
                    continue;
                } 
                
                //Cambiamos Estado del asiento a reservado
                asientos[asientoAReservar - 1] = "Reservado";
                entradasReservadas ++;
                System.out.println("El asiento: " + asientoAReservar + " fue reservado existosamente...!!!\n");
                reservados ++;
                
            }catch (InputMismatchException e){
                System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
                input.nextLine();
            }
        }
        System.out.println("Reserva finalizada. Has reservado un total de " + cantidadAReservar + " entradas.");
        
    }//Fin metodo ReservarAsiento
    
    public void ModificarReserva(){
        System.out.println(":::... MODIFICAR RESERVA ...:::");
        System.out.println("Los asientos reservados son:\n");
        
        boolean existenReservados = false;
        
        for (int i = 0; i < totalAsientosTeatro; i++) {
            if (asientos[i].equals("Reservado")) {
                System.out.print((i + 1) + "[" + asientos[i] + "]");
                existenReservados = true;
                if ((i + 1) % 4 == 0) System.out.println("");
            }
        }
        if (!existenReservados) {
            System.out.println("\nNo existen reservas para modificar");
            return;
        }
        
        System.out.println("\nSeleccione una opcion para la reserva");
        System.out.println("1. Cambiar asiento reservado");
        System.out.println("2. Comprar la reserva del asiento");
        System.out.print("\nIngrese opción (1 o 2): ");
        
        int opcionReserva;
        int reservaAntigua;
        int reservaNueva;
        int reservaACompra;
        
        try{
            opcionReserva = input.nextInt();
            input.nextLine();
            
            if (opcionReserva == 1) {
                
                //Liberamos el antiguo asiento
                System.out.print("Ingrese el numero de asiento reservado a cambiar: ");
                reservaAntigua = input.nextInt();
                input.nextLine();
                
                if (reservaAntigua < 1 || reservaAntigua > totalAsientosTeatro || (!asientos[reservaAntigua - 1].equals("Reservado"))) {
                    System.out.println("Asiento no reservado o no válido");
                    return;
                }
                
                //Reservamos el nuevo asiento
                System.out.print("Ingrese el nuevo asiento a reservar: ");
                reservaNueva = input.nextInt();
                input.nextLine();
                
                if (reservaNueva < 1 || reservaNueva > totalAsientosTeatro || (!asientos[reservaNueva - 1].equals("Libre"))) {
                    System.out.println("Nuevo asiento no válido o no libre");
                    return;
                }
                
                //Actualizar estado de asiento modificado
                asientos[reservaAntigua - 1] = "Libre";
                asientos[reservaNueva - 1] = "Reservado";
                
                System.out.println("El cambio de asiento fue realizado con exito: " + reservaAntigua + " --> " + reservaNueva);
            
            } else if (opcionReserva == 2) {
                System.out.print("Ingrese el asiento reservado para comprarlo: ");
                reservaACompra = input.nextInt();
                input.nextLine();
                
                if (reservaACompra < 1 || reservaACompra > totalAsientosTeatro || (!asientos[reservaACompra - 1].equals("Reservado"))) {
                    System.out.println("Asiento no reservado o no válido");
                    return;
                }
                
                //Cambiamos el estado de reservado a comprado
                asientos[reservaACompra - 1] = "Comprado";
                entradasReservadas --;
                entradasVendidas ++;
                guardaAsientoComprado.add(reservaACompra);
                
                System.out.println("La compra fue realizada con exito para el asiento: " + reservaACompra + '\n');
                
            }else {
                System.out.println("Opción ingresada no válida");
            }
        }catch(InputMismatchException e){
            System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
            input.nextLine();
        }
       
    }//Fin metodo ModificarReserva
    
    public void ComprarEntrada(){
        System.out.println(":::... COMPRAR ENTRADAS ...:::");
        System.out.println("Los asientos disponibles para comprar son:\n");
        
        boolean existenLibres = false;
        for (int i = 0; i < totalAsientosTeatro; i++) {
            if (asientos[i].equals("Libre")) {
                System.out.print((i + 1) + "[" + asientos[i] + "]");
                existenLibres = true;
                if ((i + 1) % 4 == 0) System.out.println("");
            }
        }
        
        if (!existenLibres) {
            System.out.println("\nNo hay asientos dispoibles a la venta");
            return;
        }
        
        int cantidadAComprar = CantidadEntradas();
        int comprados = 0;
        
        while(comprados < cantidadAComprar){
            System.out.print("Ingrese el numero de asiento a comprar #" + (comprados + 1) + ": ");
            try{
                int asientoAComprar = input.nextInt();
                input.nextLine();
                if (asientoAComprar < 1 || asientoAComprar > totalAsientosTeatro) {
                    System.out.println("Numero de asiento no válido");
                    continue;
                }
                
                String estadoAsiento = asientos[asientoAComprar - 1];
                if (!estadoAsiento.equals("Libre")) {
                    System.out.println("El asiento no esta disponible para comprar. Estado actual: " + estadoAsiento);
                    continue;
                }
                
                //Modificamos estados
                asientos[asientoAComprar - 1] = "Comprado";
                entradasVendidas++;
                guardaAsientoComprado.add(asientoAComprar);
                System.out.println("El asiento: " + asientoAComprar + " fue comprado existosamente...!!!\n");
                comprados ++;
            }catch(InputMismatchException e){
                System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
                input.nextLine();
            }
        }
        System.out.println("Compra finalizada. Has comprado un total de " + cantidadAComprar + " entradas.");
    }//Fin metodo ComprarEntrada
    
    public void ImprimirBoleta(){
        System.out.println(":::... IMPRESION DE BOLETA ...:::");
        int totalBoleta = valorEntrada * guardaAsientoComprado.size();
        
        if (guardaAsientoComprado.isEmpty()) {
            System.out.println("No hay compras recientes para generar la boleta");
            return;
        }
                
        System.out.println("");
        System.out.println("=====--->>>Boleta de Reserva<<<---====" + '\n');
        System.out.println("Teatro: " + nombreTeatro);
        System.out.println("Asientos Comprados: ");
            for (int asiento : guardaAsientoComprado) {
                System.out.println("- Asiento N°: " + asiento);
            }
        System.out.println("Cantidad Entradas: " + guardaAsientoComprado.size());
        System.out.println("Valor unitario: " + valorEntrada);
        System.out.println("Total: $" + (totalBoleta));
        System.out.println("\n======================================\n");
        
        System.out.println("Boleta generada correctamente, Muchas Gracias.\n");
        
        guardaAsientoComprado.clear(); //Limpiamos el arreglo con la informacion de compra
        
    }//Fin metodo ImprimirBoleta
    
    public int CantidadEntradas(){
        
        int entradasDisponibles = totalAsientosTeatro - (entradasVendidas + entradasReservadas);
        int cantidadEntradasCompra = 0;
        
        while(true){
            System.out.println("\n¿Cuantas entradas desea? (Disponible: " + entradasDisponibles + ")");
            try{
                cantidadEntradasCompra = input.nextInt();
                input.nextLine();
                if (cantidadEntradasCompra > 0 && cantidadEntradasCompra <= entradasDisponibles) {
                    return cantidadEntradasCompra;
                }else{
                    System.out.println("Lo siento no tenemos tantas entradas disponibles"); 
                }                            
            }catch (InputMismatchException e){
                System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
                input.nextLine();
            }
        }
    }//Fin metodo cantidadEntradas
    
}
