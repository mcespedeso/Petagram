package py.com.mcespedes.petagram.pojo;

/**
 * Created by root on 22/11/16.
 */

public class Mascota {

    private String nombre;
    private int imagen;
    private int likes;

    public Mascota(String nombre, int imagen, int likes) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
