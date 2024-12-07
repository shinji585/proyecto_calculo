import java.util.*;
public class validador {
    static Scanner s = new Scanner(System.in); // creamos un scanner  
    // en esta clase crearemos todos los metodos que utilizaremos que utilizaremos para validar las entradas de los usuario 
    public double validador_general(){
        double  valor = 0;
        boolean validador = false;
        // se crea un ciclo while para verificar los tipos de datos 
        while (!validador) {
            System.out.print("Por favor, ingrese un número entero o decimal válido: ");
            String capturador = s.nextLine();

            // al momento de hacer una entrada con una coma la entrada nos va  a ser invalidad por eso mismo remplazamos la coma por un punto para que esta pueda ser caputada de forma correcta 
            capturador = capturador.replace(",", ".");
            // convertimos el objecto tipo string que acabamos de capturar a tipo int y validamos para que este no sea un caracter no deseado o menor a cero o igual a este 
            try {
                //verfica primero que la entrada no sea decimal mirando que la entrada tenga un punto 
                if(capturador.contains(".")){
                    valor = Double.parseDouble(capturador);
                }else{
                    // ahora verifica que sea de tipo entero y lo convierte a double 
                    valor = Integer.parseInt(capturador);
                }
                // validamos que las entradas no sean menores a cero 
                if(valor <= 0){
                    System.out.println("el valor no tiene que ser menor o igual a cero please ingrese la informacion de nuevo.");
                }else{
                    validador = true; // validamos que la entrada sea correcta y finalizamos el ciclo 
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero o decimal válido.");
            }
        }
        return valor; 
    }
}