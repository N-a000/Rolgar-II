public class Vacio extends Pieza {
    private static final String NOMBRE = "_";
    private static final int VIDA = 1;
    private static final boolean TRANSITABLE = true;

    public Vacio(Coordenada coordenadas) {
        super(TipoPieza.VACIO, null, coordenadas, NOMBRE, VIDA, TRANSITABLE);
    }
}
