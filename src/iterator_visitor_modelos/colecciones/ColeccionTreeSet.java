package iterator_visitor_modelos.colecciones;

import iterator_visitor_modelos.iterator.Agregado;
import iterator_visitor_modelos.iterator.Iterador;
import iterator_visitor_modelos.modelo.Persona;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

public class ColeccionTreeSet implements Agregado<Persona> {
    private Set<Persona> setPersonas;

    public ColeccionTreeSet() {
        setPersonas = new TreeSet<>();
    }

    public void agregar(Persona p) {
        setPersonas.add(p);
    }

    @Override
    public Iterador<Persona> crearIterador() {
        return new IteradorConcreto(setPersonas);
    }

    // Clase interna para el iterador
    private class IteradorConcreto implements Iterador<Persona> {
        private Iterator<Persona> iteradorNativo;

        public IteradorConcreto(Set<Persona> coleccion) {
            // Aprovechamos el iterador de Java para recorrer el Set, ya que no podemos acceder por índice
            this.iteradorNativo = coleccion.iterator();
        }

        @Override
        public boolean hasNext() {
            return iteradorNativo.hasNext();
        }

        @Override
        public Persona next() {
            return iteradorNativo.next();
        }
    }
}
