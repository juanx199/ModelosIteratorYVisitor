package iterator_visitor_modelos.visitor;

import iterator_visitor_modelos.modelo.Estudiante;
import iterator_visitor_modelos.modelo.Docente;

// Define qué hacer con cada tipo de persona
public interface Visitor {
    // Visita a un estudiante
    void visit(Estudiante estudiante);
    
    // Visita a un docente
    void visit(Docente docente);
}
