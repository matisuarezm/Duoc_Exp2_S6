package exp2_s6_matias_suarez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author msuarez
 */
public class Exp2_S6_Matias_Suarez {
    
    Scanner input = new Scanner(System.in);
    final int totalAsientosTeatro = 20;
    final String[] asientos = new String[totalAsientosTeatro]; //estado de asientos Reservado - Comprado - Libre
    
    //Clase Main
    public static void main(String[] args) throws InterruptedException {
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
            System.out.println("===... MEMÚ PRINCIPAL TEATRO MORO ...===\n");
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
        try{
            System.out.println("\nIngrese el numero de asiento a reservar (1 - " + totalAsientosTeatro + "):\n");
            int asientoAReservar = input.nextInt();
            input.nextLine();
            if (asientoAReservar < 1 || asientoAReservar > totalAsientosTeatro) {
                System.out.println("Asiento ingresado inválido");
                return;
            }
            if (!asientos[asientoAReservar - 1].equals("Libre")) {
                System.out.println("Asiento no disponible. Estado: " + asientos[asientoAReservar - 1]);
            }else{
                asientos[asientoAReservar - 1] = "Reservado";
                System.out.println("El asiento: " + asientoAReservar + " fue reservado existosamente...!!!");
            }
        }catch (InputMismatchException e){
            System.out.println("Error.. Entrada invalida, Por favor ingrese un numero");
            input.nextLine();
        }
        
        
    }//Fin metodo ReservarAsiento
    
    public void ModificarReserva(){
        
    }//Fin metodo ModificarReserva
    
    public void ComprarEntrada(){
        
    }//Fin metodo ComprarEntrada
    
    public void ImprimirBoleta(){
        
    }//Fin metodo ImprimirBoleta
    
}
