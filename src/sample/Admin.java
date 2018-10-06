package sample;

public class Admin {
    private String password;
    private String usuario;

    Admin(){
        password = "123Admin!";
        usuario = "administrador";
    }

    public String getPassword() {
        return password;
    }

    public String getUsuario(){
        return usuario;
    }

}
