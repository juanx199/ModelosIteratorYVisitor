package iterator_visitor_modelos.modelo;

import iterator_visitor_modelos.visitor.Visitor;
import java.util.List;

public class Docente extends Persona {

    public Docente(String codigo, String nombres, String direccion, List<String> telefonos) {
        super(codigo, nombres, direccion, telefonos);
    }

    // Recibe al visitante y le dice qué tipo de persona es
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
