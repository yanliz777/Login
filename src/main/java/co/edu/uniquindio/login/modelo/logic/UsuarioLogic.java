package co.edu.uniquindio.login.modelo.logic;

import co.edu.uniquindio.login.modelo.beans.Usuario;
import co.edu.uniquindio.login.modelo.dao.UsuarioDao;

public class UsuarioLogic {
    private static UsuarioDao userDao = new UsuarioDao();
    /**
     * Método que me permite autentificar, es decir, se recibe el usuario y contraseña
     * que ingresa el user en la gui por parámetros y acá se autentifica para
     * saber que todo este correcto:
     */
    public static boolean autentificar(String user,String password){

        if(obtener(user) != null)
        {
            Usuario userConsulta = obtener(user);//crea el usuario

            if(userConsulta.getUser().equals(user) && userConsulta.getPassword().equals(password)){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    /*Métodos estáticos, es decir, no se necesita crear nuevos objetos
    para acceder a estos métodos:
    */
    public static boolean insertar(Usuario user){
       return userDao.insertar(user);
    }
    public static boolean modificar(Usuario user){
        return userDao.modificar(user);
    }
    public static boolean eliminar(String user){
        return userDao.eliminar(user);
    }
    public static Usuario obtener(String user){
        return userDao.obtener(user);
    }
}
