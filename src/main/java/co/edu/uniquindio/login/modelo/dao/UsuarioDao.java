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
    recorre nuestra lista y nos indica
    en que posición se encuentra un elemento
    el cual recibe por parámetro:
     */
    public int buscar(String usuario)
    {
        return 0;
    }
    //crea un usuario y lo almacena en el arraylist
    public boolean insertar(Usuario user)
    {
        return true;
    }
    public boolean modificar(Usuario user)
    {
        return true;
    }
    public boolean eliminar(Usuario user)
    {
        return true;
    }

    /**
     * Busca en la lista de usuarios, mira en que posición está
     * algún elemento y lo retorna.
     */
    public Usuario obtener(Usuario user)
    {
        return null;
    }

}
