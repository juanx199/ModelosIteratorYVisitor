package iterator_visitor_modelos.visitor;

import iterator_visitor_modelos.modelo.Estudiante;
import iterator_visitor_modelos.modelo.Docente;

public interface Visitor {
    // Visitar a un estudiante
    void visit(Estudiante estudiante);

    // Visitar a un docente
    void visit(Docente docente);
}
