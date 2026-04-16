package services;

import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario login(String login, String senha) {

        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) &&
                u.getSenha().equals(senha)) {
                return u;
            }
        }

        return null;
    }

    public List<Usuario> listar() {
        return usuarios;
    }
}