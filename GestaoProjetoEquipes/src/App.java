import javax.swing.JOptionPane;

public class App {
   

    public static void main(String[] args) {
        
        String primeiroNome = "Lucas";
        String ultimoNome = "Araujo";
        
        String nomeCompleto = primeiroNome + " " + ultimoNome;
        
        System.out.println(primeiroNome);
        System.out.println(ultimoNome);
        System.out.println(nomeCompleto);
        
        int numero1 = 2;
        int numero2 = 3;
        
        int resultadoSoma = numero1 + numero2;
        
        System.out.println(resultadoSoma);
        
        String numero3 = "2";
        String numero4 = "3";
        
        String resultadoJuncao = numero3 + numero4;
        
        System.out.println(resultadoJuncao);
        
        double a = 1;
        double b = 2;
        
        double soma = a + b;
        double subtracao = a - b;
        double multiplicacao = a * b;
        double divisao = a / b;
        
        System.out.println("soma: " + soma);
        System.out.println("subtração: " + subtracao);
        System.out.println("multiplicação: " + multiplicacao);
        System.out.println("divisão: " + divisao);
        
        String firstName = JOptionPane.showInputDialog("Digite seu primeiro nome: ");
        String lastName = JOptionPane.showInputDialog("Digite seu último nome: ");
        String idade = JOptionPane.showInputDialog("Qual é a sua idade? : ");
        
        String cliente = firstName + " " + lastName + " com idade de " + idade + " anos";
        
        JOptionPane.showMessageDialog(null, cliente);
            
    }
}
