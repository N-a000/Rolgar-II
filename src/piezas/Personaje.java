package src.piezas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import src.coordenada.Coordenada;
import src.cartas_de_poder.*;
import utils.ValidacionesUtils;

public class Personaje {

//INTERFACES ----------------------------------------------------------------------------------------------
//ENUMERADOS ----------------------------------------------------------------------------------------------
//CONSTANTES ----------------------------------------------------------------------------------------------
//ATRIBUTOS DE CLASE --------------------------------------------------------------------------------------
//ATRIBUTOS -----------------------------------------------------------------------------------------------
    private String nombre;
    private int vida;
    private Coordenada posicion; // debe tener x, y, z
    private List<CartaPoder> poderes; // o List<String> si Carta no está implementada
    private int vision;          // cantidad de casilleros visibles
    private int fuerza;          // energía que descuenta al atacar
    private double salud;        // porcentaje de recuperación por turno
    private int vidaMaxima; // vida total que no puede superarse


//ATRIBUTOS TRANSITORIOS ----------------------------------------------------------------------------------
//CONSTRUCTORES -------------------------------------------------------------------------------------------
    public Personaje(String nombre, int vida, Coordenada posicion, int vision, int fuerza, double salud) {
        ValidacionesUtils.noNulo(nombre, "Nombre");
        ValidacionesUtils.noNulo(posicion, "Posición");
        ValidacionesUtils.validarMayorACero(vida, "Vida");
        ValidacionesUtils.validarMayorACero(vision, "Visión");
        ValidacionesUtils.validarMayorACero(fuerza, "Fuerza");
        ValidacionesUtils.validarRango(salud, 0, 1, "Salud"); // salud debe ser entre 0 y 1

        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.posicion = posicion;
        this.vision = vision;
        this.fuerza = fuerza;
        this.salud = salud;
        this.poderes = new ArrayList<>();
    }

//METODOS ABSTRACTOS --------------------------------------------------------------------------------------
//METODOS HEREDADOS (CLASE)--------------------------------------------------------------------------------
//METODOS HEREDADOS (INTERFACE)----------------------------------------------------------------------------
//METODOS DE CLASE ----------------------------------------------------------------------------------------


	@Override
	public String toString() {
		return "Personaje: nombre:" + this.nombre;
	}

    @Override
    public int hashCode() {
    	return Objects.hash(fuerza, nombre, posicion, salud, vida, vision);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj == null)
    		return false;
    	if (getClass() != obj.getClass())
    		return false;
    	Personaje other = (Personaje) obj;
    	return fuerza == other.fuerza && Objects.equals(nombre, other.nombre)
    			&& Objects.equals(posicion, other.posicion);
    }
//METODOS GENERALES ---------------------------------------------------------------------------------------



	public void mover(Coordenada nuevaPos) {
        ValidacionesUtils.noNulo(nuevaPos, "Coordenada nueva");
        this.posicion = nuevaPos;
    }



	public void recibirDanio(int danio) {
        ValidacionesUtils.validarMayorACero(danio, "Daño");
        vida -= danio;
        if (vida < 0) {
        	vida = 0;
        }
    }

    public void recuperarEnergia() {
        int recuperacion = (int) (vidaMaxima * salud); 
        vida += recuperacion;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void agregarPoder(CartaPoder poder) {
        ValidacionesUtils.noNulo(poder, "Poder");
        poderes.add(poder);
    }

//METODOS DE COMPORTAMIENTO -------------------------------------------------------------------------------
//METODOS DE CONSULTA DE ESTADO ---------------------------------------------------------------------------	
//GETTERS REDEFINIDOS -------------------------------------------------------------------------------------
//GETTERS INICIALIZADOS -----------------------------------------------------------------------------------
//GETTERS COMPLEJOS ---------------------------------------------------------------------------------------
//GETTERS SIMPLES -----------------------------------------------------------------------------------------
    
    /**
     * devuelve el nombre del personaje
     * @return
     */
    public String getNombre() {
  		return nombre;
  	}
    
    /**
     * devuelve la vida del personaje
     * @return
     */
  	public int getVida() {
  		return vida;
  	}
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
    
    public int getVidaMaxima() {
        return vidaMaxima;
    }
//SETTERS COMPLEJOS----------------------------------------------------------------------------------------	
//SETTERS SIMPLES -----------------------------------------------------------------------------------------
}
