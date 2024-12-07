import java.util.*;

public class Derivada_Resistencia_Paralela {
    static Scanner s = new Scanner(System.in); 
    
    public static void main(String[] args) {
        // Variables necesarias para los cálculos
        double RT = 0; 
        double dR1 = 0; 
        double dR2 = 0; 
        double R1 = 0; 
        double R2 = 0; 

        // Instanciamos el validador para entrada de datos
        validador validar = new validador();

        // Limpiamos la pantalla y mostramos el mensaje de bienvenida
        Limpiarpantalla();
        mostrarMensajeBienvenida();

        // Solicitamos los datos de las resistencias y sus derivadas en un ciclo
        int j = 0;
        while (j < 1) { // Este ciclo solo se ejecutará una vez para ingresar los 4 valores
            System.out.println("Ingrese la razón de cambio para R1 (dR1): ");
            dR1 = validar.validador_general(); // Obtenemos la razón de cambio para R1
            System.out.println("Ingrese la razón de cambio para R2 (dR2): ");
            dR2 = validar.validador_general(); // Obtenemos la razón de cambio para R2
            System.out.println("Ingrese el valor para R1 (Resistencia 1): ");
            R1 = validar.validador_general(); // Obtenemos el valor de la resistencia 1
            System.out.println("Ingrese el valor para R2 (Resistencia 2): ");
            R2 = validar.validador_general(); // Obtenemos el valor de la resistencia 2
            j++; // Incrementamos el contador para salir del ciclo
        }

        // Calculamos la resistencia total usando los valores ingresados
        RT = resistencia_total(R1, R2); 

        // Calculamos la razón de cambio de la resistencia total
        double resultado = razon_cambio(RT, dR1, dR2, R1, R2); 
        
        // Mostramos los resultados obtenidos
        System.out.println("\n========================================");
        System.out.println("La resistencia total es: " + RT + " ohms");
        System.out.println("La razón de cambio con respecto al tiempo es: " + resultado + " ohms ");
        System.out.println("========================================\n");
    }

    // Método para mostrar un mensaje de bienvenida
    public static void mostrarMensajeBienvenida() {
        System.out.println("****************************************");
        System.out.println("Bienvenido al proyecto de Resistencia en Paralelo.");
        System.out.println("Este programa calcula la resistencia total y la razón de cambio.");
        System.out.println("****************************************");

        // Logo de una resistencia en paralelo en ASCII
        System.out.println("  ________             ");
        System.out.println(" / ______ \\            ");
        System.out.println("| |      | |            ");
        System.out.println("| |______| |            ");
        System.out.println(" \\______/ /            ");
        System.out.println("  `------'             ");
        System.out.println("****************************************");
    }

    // Método para limpiar la pantalla (cmd) en sistemas Windows
    public static void Limpiarpantalla() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls"); // Limpia la pantalla
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            System.out.println("ERROR DE TIPO: " + e.getMessage());
        }
    }

    // Método para calcular la resistencia total en paralelo
    public static double resistencia_total(double R1, double R2) {
        // Fórmula de resistencia en paralelo: 1 / (1/R1 + 1/R2)
        double valor = 1 / ((1 / R1) + (1 / R2)); 
        return valor;
    }

    // Método para calcular la razón de cambio de la resistencia total en función de las derivadas de R1 y R2
    public static double razon_cambio(double RT, double dR1, double dR2, double R1, double R2) {
        // Calcula la razón de cambio de la resistencia total (dRT/dt) usando la fórmula derivada
        double valor = Math.pow(RT, 2) * ( (1 / Math.pow(R1, 2)) * dR1 + (1 / Math.pow(R2, 2)) * dR2);
        
        // Devuelve el valor calculado
        return valor;
    }
}