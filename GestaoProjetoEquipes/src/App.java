import models.Usuario;
import services.UsuarioService;
import services.ProjetoService;
import services.TarefaService;
import views.TelaLogin;

public class App {

    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();
        ProjetoService projetoService = new ProjetoService();
        TarefaService tarefaService = new TarefaService();

        // usuários iniciais
        Usuario admin = new Usuario();
        admin.setLogin("admin");
        admin.setSenha("123");
        admin.setNome("Lukas");

        Usuario user = new Usuario();
        user.setLogin("joao");
        user.setSenha("123");
        user.setNome("João");

        usuarioService.cadastrar(admin);
        usuarioService.cadastrar(user);

        // inicia sistema
        new TelaLogin(usuarioService, projetoService, tarefaService).setVisible(true);
    }
}