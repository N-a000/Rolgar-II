package src.utils;

/**
 * Clase de utilidades para validaciones comunes usadas en los TDAs del juego.
 * Contiene métodos estáticos para verificar valores nulos, vacíos o fuera de rango.
 */
public class ValidacionesUtils {

    /**
     * Verifica que un objeto no sea nulo.
     * 
     * @param obj Objeto a verificar
     * @param campo Nombre del campo para el mensaje de error
     * @throws RuntimeException si el objeto es nulo
     */
    public static void noNulo(Object obj, String campo) {
        if (obj == null) {
            throw new RuntimeException(campo + " no puede ser nulo.");
        }
    }

    /**
     * Verifica que un valor entero sea mayor a cero.
     * 
     * @param valor Valor a verificar
     * @param campo Nombre del campo para el mensaje de error
     * @throws RuntimeException si el valor es menor o igual a cero
     */
    public static void validarMayorACero(int valor, String campo) {
        if (valor <= 0) {
            throw new RuntimeException(campo + " debe ser mayor a cero.");
        }
    }

    /**
     * Verifica que una cadena de texto tenga al menos cierta cantidad de caracteres.
     * 
     * @param texto Texto a verificar
     * @param minimo Cantidad mínima de caracteres
     * @param campo Nombre del campo para el mensaje de error
     * @throws RuntimeException si el texto es nulo o no cumple la longitud mínima
     */
    public static void validarMinimoDeCaracteres(String texto, int minimo, String campo) {
        if (texto == null || texto.length() < minimo) {
            throw new RuntimeException(campo + " debe tener al menos " + minimo + " caracteres.");
        }
    }

    /**
     * Verifica que un arreglo o lista no esté vacío.
     * 
     * @param cantidad Tamaño del arreglo o lista
     * @param campo Nombre del campo para el mensaje de error
     * @throws RuntimeException si la lista está vacía
     */
    public static void validarNoVacio(int cantidad, String campo) {
        if (cantidad == 0) {
            throw new RuntimeException(campo + " no puede estar vacío.");
        }
    }
}
