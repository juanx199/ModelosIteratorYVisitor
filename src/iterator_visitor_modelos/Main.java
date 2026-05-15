package iterator_visitor_modelos;

import iterator_visitor_modelos.colecciones.ColeccionArrayList;
import iterator_visitor_modelos.colecciones.ColeccionTreeSet;
import iterator_visitor_modelos.iterator.Iterador;
import iterator_visitor_modelos.modelo.Docente;
import iterator_visitor_modelos.modelo.Estudiante;
import iterator_visitor_modelos.modelo.Persona;
import iterator_visitor_modelos.visitor.ValidacionVisitor;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando programa de validacion (Iterator y Visitor)...\n");

        // inicializar estructuras
        ColeccionArrayList lista = new ColeccionArrayList();
        ColeccionTreeSet arbol = new ColeccionTreeSet();
        ValidacionVisitor visitante = new ValidacionVisitor();

        //datos de prueba
        Persona p1 = new Estudiante("0022", "Ana Martinez", "Calle 1", Arrays.asList("123", "456"));
        Persona p2 = new Docente("1234", "Carlos Perez", "Calle 2", Arrays.asList("789"));
        Persona p3 = new Estudiante("5001", "Beto Sanchez", "", Arrays.asList("111")); // Faltan datos (sin direccion)
        Persona p4 = new Docente("99999", "Diana Gomez", "Calle 3", Arrays.asList("222")); // Codigo muy largo
        Persona p5 = new Docente("20232020026", "Elena Torres", "Calle 4", Arrays.asList("333")); // Docente correcto

        // agregar a las colecciones
        Persona[] personas = {p1, p2, p3, p4, p5};
        for (Persona p : personas) {
            lista.agregar(p);
            arbol.agregar(p);
        }

        // recorrer ArrayList (Orden de Insercion)
        System.out.println("=== RECORRIDO DE ARRAYLIST (Orden de Insercion) ===");
        Iterador<Persona> iteradorLista = lista.crearIterador();
        while (iteradorLista.hasNext()) {
            Persona personaActual = iteradorLista.next();
            // Double Dispatch: La persona acepta al visitante
            personaActual.accept(visitante);
        }

        System.out.println("\n---------------------------------------------------\n");

        // Recorrer TreeSet (Ordenado alfabeticamente por Codigo)
        System.out.println("=== RECORRIDO DE TREESET (Ordenado por Codigo) ===");
        Iterador<Persona> iteradorArbol = arbol.crearIterador();
        while (iteradorArbol.hasNext()) {
            Persona personaActual = iteradorArbol.next();
            // Double Dispatch: La persona acepta al visitante
            personaActual.accept(visitante);
        }
    }
}
