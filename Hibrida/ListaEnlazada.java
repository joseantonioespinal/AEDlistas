public class ListaEnlazada {
    private Nodo cabeza;
    
    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    public void insertar(String nombre) {
        Nodo nuevo = new Nodo(nombre);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.getNombre()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
