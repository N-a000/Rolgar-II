package src.piezas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import src.coordenada.Coordenada;
import src.cartas_de_poder.CartaPoder;
import utils.ValidacionesUtils;

public class AdministradorDePersonaje extends Personaje {

    // ATRIBUTOS ESPECÍFICOS DE ROLGAR -----------------------------------------------------
    private Coordenada posicion;
    private int vision;
    private int fuerza;
    private double salud;
    private List<CartaPoder> poderes;

    // CONSTRUCTOR --------------------------------------------------------------------------
    public AdministradorDePersonaje(
            String nombre,
            int vida,
            Coordenada posicion,
            int vision,
            int fuerza,
            double salud
    ) {
        super(nombre, vida);

        ValidacionesUtils.noNulo(posicion, "Posición");
        ValidacionesUtils.validarMayorACero(vision, "Visión");
        ValidacionesUtils.validarMayorACero(fuerza, "Fuerza");
        ValidacionesUtils.validarRango(salud, 0, 1, "Salud");

        this.posicion = posicion;
        this.vision = vision;
        this.fuerza = fuerza;
        this.salud = salud;
        this.poderes = new ArrayList<>();
    }

    // MÉTODOS ------------------------------------------------------------------------------

    public void mover(Coordenada nuevaPos) {
        ValidacionesUtils.noNulo(nuevaPos, "Coordenada nueva");
        this.posicion = nuevaPos;
    }

    public void agregarPoder(CartaPoder poder) {
        ValidacionesUtils.noNulo(poder, "Poder");
        poderes.add(poder);
    }

    public void recuperarEnergia() {
        int recuperacion = (int) (getVidaMaxima() * salud);
        curar(recuperacion);
    }

    // GETTERS ------------------------------------------------------------------------------

 	/**
  	 * devuelve la posicion del personaje (posición en el tablero)
  	 * @return
  	 */
  	public Coordenada getPosicion() {
  		return posicion;
  	}
  	/**
  	 * devuelve la vision del personaje  (cantidad de casilleros que puede ver)
  	 * @return
  	 */
  	public int getVision() {
  		return vision;
  	}
  	/**
  	 * devuelve la fuerza del personaje (nivel de energia que descuenta al atacar)
  	 * @return
  	 */
  	public int getFuerza() {
  		return fuerza;
  	}
  	/**
  	 * devuelve la salud (porcentaje de recuperacion de energia al pasar el turno)
  	 * @return
  	 */
    public double getSalud() {
        return salud;
    }
  	/**
  	 * devuelve la coleccion de cartas obtenidas
  	 * @return
  	 */
    public List<CartaPoder> getPoderes() {
        return poderes;
    }
    
  //METODOS DE CLASE ----------------------------------------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fuerza, poderes, posicion, salud, vision);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdministradorDePersonaje other = (AdministradorDePersonaje) obj;
		return fuerza == other.fuerza && Objects.equals(poderes, other.poderes)
				&& Objects.equals(posicion, other.posicion)
				&& Double.doubleToLongBits(salud) == Double.doubleToLongBits(other.salud) && vision == other.vision;
	}


}
