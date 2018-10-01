package sample;

public class Secretaria {
    private String password;
    private String usuario;

    Secretaria(String passwordAIng, String usuarioAIng){
        password = passwordAIng;
        usuario = usuarioAIng;

    }

    public String getPassword() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }
}
