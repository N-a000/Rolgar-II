package src.piezas;

import java.util.Objects;
import utils.ValidacionesUtils;

public class Personaje {

//INTERFACES ----------------------------------------------------------------------------------------------
//ENUMERADOS ----------------------------------------------------------------------------------------------
//CONSTANTES ----------------------------------------------------------------------------------------------
//ATRIBUTOS DE CLASE --------------------------------------------------------------------------------------
//ATRIBUTOS -----------------------------------------------------------------------------------------------
    private String nombre;
    private int vida;
    private int vidaMaxima;


//ATRIBUTOS TRANSITORIOS ----------------------------------------------------------------------------------
//CONSTRUCTORES -------------------------------------------------------------------------------------------
    public Personaje(String nombre, int vida) {
        ValidacionesUtils.noNulo(nombre, "Nombre");
        ValidacionesUtils.validarMayorACero(vida, "Vida");

        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
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
		return Objects.hash(nombre, vida, vidaMaxima);
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
    	return Objects.equals(nombre, other.nombre) && vida == other.vida && vidaMaxima == other.vidaMaxima;
    }


	public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int danio) {
        ValidacionesUtils.validarMayorACero(danio, "Daño");
        vida -= danio;
        if (vida < 0) vida = 0;
    }

    public void curar(int puntos) {
        ValidacionesUtils.validarMayorACero(puntos, "Puntos de curación");
        vida += puntos;
        if (vida > vidaMaxima) vida = vidaMaxima;
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
     * devuelve la vida maxima del personaje
     * @return
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }
//SETTERS COMPLEJOS----------------------------------------------------------------------------------------	


//SETTERS SIMPLES -----------------------------------------------------------------------------------------
}
