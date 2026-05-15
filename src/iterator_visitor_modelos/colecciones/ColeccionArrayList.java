package iterator_visitor_modelos.colecciones;

import iterator_visitor_modelos.iterator.Agregado;
import iterator_visitor_modelos.iterator.Iterador;
import iterator_visitor_modelos.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

public class ColeccionArrayList implements Agregado<Persona> {
    private List<Persona> listaPersonas;

    public ColeccionArrayList() {
        listaPersonas = new ArrayList<>();
    }

    public void agregar(Persona p) {
        listaPersonas.add(p);
    }

    @Override
    public Iterador<Persona> crearIterador() {
        return new IteradorConcreto(listaPersonas);
    }

    // Clase interna para el iterador
    private class IteradorConcreto implements Iterador<Persona> {
        private List<Persona> coleccion;
        private int posicion = 0;

        public IteradorConcreto(List<Persona> coleccion) {
            this.coleccion = coleccion;
        }

        @Override
        public boolean hasNext() {
            return posicion < coleccion.size();
        }

        @Override
        public Persona next() {
            if (this.hasNext()) {
                return coleccion.get(posicion++);
            }
            return null;
        }
    }
}
