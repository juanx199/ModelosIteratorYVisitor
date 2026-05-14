package iterator_visitor_modelos.visitor;

import iterator_visitor_modelos.modelo.Estudiante;
import iterator_visitor_modelos.modelo.Docente;
import iterator_visitor_modelos.modelo.Persona;

// Visitante encargado de revisar que los datos estén bien
public class ValidacionVisitor implements Visitor {

    // Revisa si los datos básicos están incompletos
    private boolean datosIncompletos(Persona p) {
        return p.getCodigo() == null || p.getCodigo().trim().isEmpty() ||
               p.getNombres() == null || p.getNombres().trim().isEmpty() ||
               p.getDireccion() == null || p.getDireccion().trim().isEmpty() ||
               p.getTelefonos() == null || p.getTelefonos().isEmpty();
    }

    @Override
    public void visit(Estudiante estudiante) {
        // Valida datos del estudiante
        if (datosIncompletos(estudiante)) {
            System.out.println("Notificación: El estudiante " + estudiante.getNombres() + " tiene datos incompletos.");
        }
    }

    @Override
    public void visit(Docente docente) {
        // Valida datos del docente
        if (datosIncompletos(docente)) {
            System.out.println("Notificación: El docente " + docente.getNombres() + " tiene datos incompletos.");
        }
        
        // Regla especial: el código no debe tener más de 4 caracteres
        if (docente.getCodigo() != null && docente.getCodigo().length() > 4) {
            System.out.println("Error: El docente con código [" + docente.getCodigo() + "] supera los 4 dígitos.");
        }
    }
}
