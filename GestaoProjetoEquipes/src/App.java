import javax.swing.*;
import models.Usuario;
import services.UsuarioService;

public class App {

    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();

        // usuário 1
        Usuario admin = new Usuario();
        admin.setLogin("admin");
        admin.setSenha("123");
        admin.setNome("Lukas");

        // usuário 2
        Usuario user = new Usuario();
        user.setLogin("joao");
        user.setSenha("123");
        user.setNome("João");

        service.cadastrar(admin);
        service.cadastrar(user);

        String login = JOptionPane.showInputDialog("Login:");
        String senha = JOptionPane.showInputDialog("Senha:");

        Usuario logado = service.login(login, senha);

        if (logado != null) {
            JOptionPane.showMessageDialog(null,
                    "Bem-vindo " + logado.getNome());
        } else {
            JOptionPane.showMessageDialog(null,
                    "Login inválido!");
        }
    }
}