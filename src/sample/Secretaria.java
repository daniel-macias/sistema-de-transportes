package sample;

public class Secretaria {
    private String password;
    private String usuario;
    private String correo;

    Secretaria(String passwordAIng, String usuarioAIng, String correoAIng){
        password = passwordAIng;
        usuario = usuarioAIng;
        correo = correoAIng;
    }

    public String getPassword() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() { return correo; }
}
