package co.edu.uniquindio.login.modelo.beans;

public class Usuario {
    //atributos:
    private String user;
    private String password;
    private String name;
    private String lastName;
    private String email;
    //constructores:
    public Usuario(){}
    public Usuario(String user, String password, String name, String lastName, String email) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    //getters/setters:
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
