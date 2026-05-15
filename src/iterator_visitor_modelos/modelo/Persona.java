package iterator_visitor_modelos.modelo;

import iterator_visitor_modelos.visitor.Visitor;
import java.util.List;

// implementa Comparable para el TreeSet
public abstract class Persona implements Comparable<Persona> {

    // Atributos comunes
    protected String codigo;
    protected String nombres;
    protected String direccion;
    protected List<String> telefonos;

    public Persona(String codigo, String nombres, String direccion, List<String> telefonos) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    // Método que permite recibir al visitante
    public abstract void accept(Visitor v);

    // Ordenar por código para que el TreeSet funcione bien
    @Override
    public int compareTo(Persona otraPersona) {
        return this.codigo.compareTo(otraPersona.getCodigo());
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }
}
