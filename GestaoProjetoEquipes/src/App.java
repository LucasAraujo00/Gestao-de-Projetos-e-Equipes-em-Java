import models.Usuario;
import services.UsuarioService;
import views.TelaLogin;

public class App {

    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();

        Usuario admin = new Usuario();
        admin.setLogin("admin");
        admin.setSenha("123");
        admin.setNome("Lukas");

        Usuario user = new Usuario();
        user.setLogin("joao");
        user.setSenha("123");
        user.setNome("João");

        service.cadastrar(admin);
        service.cadastrar(user);

        new TelaLogin(service).setVisible(true);
    }
}