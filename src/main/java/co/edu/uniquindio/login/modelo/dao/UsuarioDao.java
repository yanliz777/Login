package co.edu.uniquindio.login.modelo.dao;

import co.edu.uniquindio.login.modelo.beans.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private List<Usuario> usuarios;//se almacenan todos los usuarios

    public UsuarioDao(){
        usuarios = new ArrayList<>();
    }

    /*
    Este método recibe por parámetro el nombre del user
    si el usuario está en la lista retorna la posición en la
    que se encuentra, si no se encuentra, retorna -1:
     */
    public int buscar(String usuario)
    {
        int n = -1;
        for (int i = 0; i <usuarios.size() ; i++) {
            if(usuarios.get(i).getUser().equals(usuario)) {
                n = i;//posición en la que encontró el elemento
                break;
            }
        }
        return n;
    }
    /*almacena un usuario que le llega por parámetro al método y
     verifica en el if() que retorna el método buscar, si retorna -1 quiere
     decir que el usuario no está en el arraylist entonces ingresa dentro del
     if() y agrega al usuario al arraylist y retorna true, sino, retorna false,
     dando a entender que no se realizó inserción.
    */
    public boolean insertar(Usuario user)
    {
        if(buscar(user.getUser()) == -1){
            usuarios.add(user);
            return true;
        }
        else {
            return  false;
        }
    }
    public boolean modificar(Usuario user)
    {
        if(buscar(user.getUser()) != -1){
            Usuario userAux = obtener(user.getUser());

            userAux.setPassword(user.getPassword());
            userAux.setName(user.getName());
            userAux.setLastName(user.getLastName());
            userAux.setEmail(user.getEmail());

            return true;
        }
        else {
            return  false;
        }
    }
    public boolean eliminar(String user)
    {
        if(buscar(user) != -1){
            usuarios.remove(buscar(user));
            return true;
        }
        else {
            return  false;
        }
    }

    /**
     * Este método verifica si el método buscar() es
     * diferente de -1, si lo es, quiere decir que el objeto se
     * encuentra en el arraylist y lo retornaría, si no, retorna null;
     */
    public Usuario obtener(String user)
    {
       if(buscar(user) != -1){
            return usuarios.get(buscar(user));//retornamos la posición en la que se encontró al usuario
       }
       else {
            return null;
       }
    }

}
