/**
 * Implementacion de Calculadora Postfix
 */
public class PostfixCalculator implements IPostfixCalculator {
    
    private IStack<Integer> stack;
    
    public PostfixCalculator() {
        this.stack = new VectorStack<>();
    }
    
    @Override
    public int evaluate(String expression) throws Exception {
        stack.clear();
        String[] tokens = expression.trim().split("\\s+");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Operandos insuficientes");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = calculate(a, b, token);
                stack.push(result);
            } else {
                throw new Exception("Token invalido: " + token);
            }
        }
        
        if (stack.size() != 1) {
            throw new Exception("Expresion invalida");
        }
        
        return stack.pop();
    }
    
    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/") || token.equals("%");
    }
    
    private int calculate(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) throw new Exception("Division por cero");
                return a / b;
            case "%": 
                if (b == 0) throw new Exception("Modulo por cero");
                return a % b;
            default: throw new Exception("Operador desconocido: " + operator);
        }
    }
}
