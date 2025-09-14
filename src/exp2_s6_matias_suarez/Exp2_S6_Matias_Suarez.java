package exp2_s6_matias_suarez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author msuarez
 */
public class Exp2_S6_Matias_Suarez {
    
    Scanner input = new Scanner(System.in);
    
    public void MostrarMenu() throws InterruptedException{
        int opcionMenu = 0;        
        do {
            System.out.println("===... MEMÚ PRINCIPAL TEATRO MORO ...===\n");
            System.out.println("1.- Reserva de Asientos");
            System.out.println("2.- Modificar la Reserva");
            System.out.println("3.- Comprar Entrada");
            System.out.println("4.- Imprimir Boleta");
            System.out.println("5.- Salir");
            
            try{
                opcionMenu = input.nextInt();
                input.nextLine();
                switch (opcionMenu){
                    case 1:
                        break;
                    case 2:
                        break;                    
                    case 3:
                        break;
                    case 4:
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
            }            
        }while(opcionMenu != 5);
    
    }

    public static void main(String[] args) {
        
    }
    
}
