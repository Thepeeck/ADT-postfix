import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Programa principal
 */
public class Main {
    
    public static void main(String[] args) {
        String archivo = "datos.txt";
        
        try {
            IPostfixCalculator calculadora = new PostfixCalculator();
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            int numeroLinea = 1;
            
            System.out.println("=== Evaluador de Expresiones Postfix ===\n");
            
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                
                System.out.println("Expresion " + numeroLinea + ": " + linea);
                try {
                    int resultado = calculadora.evaluate(linea);
                    System.out.println("Resultado: " + resultado);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
                System.out.println();
                numeroLinea++;
            }
            
            reader.close();
            
        } catch (Exception e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}
