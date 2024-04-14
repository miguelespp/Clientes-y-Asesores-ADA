import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    
    public static void menu() {
        System.out.println("Teniendo las siguientes operaciones disponibles : ");
        System.out.println("1. Buscar a un asesor y listar al mismo con todos sus clientes");
        System.out.println("2. Buscar a un cliente y mostrar el nombre de quien es su asesor");
        System.out.println("3. Listar a todos los asesores con sus clientes");
        System.out.println("Seleccione la operacion a realizar => ");
    }

    public static void pause() {
        System.out.println("Presione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        short opc = 0;
        //Creamos el linkedhashmap
        LinkedHashMap<String, LinkedList<String>> asesores = new LinkedHashMap<>();
        // Primeras inserciones
        LinkedList<String> asesor1 = new LinkedList<>();
        asesor1.add("Marie");
        asesor1.add("Juan");
        asesor1.add("Saul");
        LinkedList<String> asesor2 = new LinkedList<>();
        asesor2.add("Luis");
        asesor2.add("Jorge");
        asesor2.add("Emilia");
        //Añadimos los asesores
        asesores.put("Pedro", asesor1);
        asesores.put("Ana", asesor2);
        do {
            do {
                cls();
                menu();
                
                    opc = entrada.nextShort();
                    entrada.nextLine();
                
                
            } while (opc != 1 && opc != 2 && opc != 3 && opc != 0);
            switch (opc) {
                case 1: {

                    // caso optimizando recursos tanto la memoria como el tiempo de ejecucion
                    
                    cls();
                    System.out.println("Ingrese el nombre del asesor a buscar => ");
                    String asesor = entrada.nextLine();
                    //entrada.nextLine();
                    if (asesores.containsKey(asesor)) {
                        cls();
                        System.out.println("El asesor " + asesor + " tiene los siguientes clientes : ");
                        long inicio = System.currentTimeMillis();
                        Thread.sleep(500);
                        // con una eficiencia O(n)
                        System.out.println(asesores.get(asesor) + "\n");
                        long fin = System.currentTimeMillis();
                        System.out.println((double) (fin-inicio) + " ms \n");
                        //System.out.println(asesores.get(asesor).size());
                    }else{
                        System.out.println("No se encontro al asesor");
                    }
                    pause();
                }; break;

                case 2: {

                    // se optimiza la memoria sin embargo el tiempo de ejecucion si es mayor por lo que en busca de aminorarlo, se almacena en un set y se itera

                    cls();
                    System.out.println("Ingrese el nombre del cliente a buscar => ");
                    String cliente = entrada.nextLine();
                    long inicio = System.currentTimeMillis();
                    Thread.sleep(500);
                    // iteramos un set de manera que solo se realiza un recorrido aunque se obtiene una eficiencia O(n^3)
                    for (String asesor : asesores.keySet()) {
                        if (asesores.get(asesor).contains(cliente)) {
                            System.out.println("El cliente " + cliente + " es asesorado por " + asesor);
                            break;
                        }
                    }
                    long fin = System.currentTimeMillis();
                    System.out.println((double) (fin-inicio) + " ms \n");
                    pause();
                }; break;
                
                case 3 : {

                    // se optmiza la memoria y el tiempo de ejecucion, es similar al primero

                    cls();
                    long inicio = System.currentTimeMillis();
                    Thread.sleep(500); // retraso de 0.5 s para reducir el indice de error del contador
                    for(String asesor : asesores.keySet()) {
                        System.out.println("El asesor " + asesor + "tiene los siguientes clientes => ");
                        System.out.println(asesores.get(asesor) + "\n");
                    }
                    long fin = System.currentTimeMillis();
                        System.out.println((double) (fin-inicio) + " ms \n");
                    pause();
                }; break;

                default:{
                    cls();
                    System.out.println("Bye Bye, estoy haciendo mewing !!");
                    pause();
                };
                    break;
            }
        } while (opc!= 0);
        entrada.close();
    }
}
