package net.ripadbaisor.ranking.programdata.requests;

public class Request {
    private String nombrePropuesto;
    private String autor;

    public Request(String autor, String nombrePropuesto) {
        this.autor = autor;
        this.nombrePropuesto = nombrePropuesto;
    }

    public String getNombrePropuesto() {
        return nombrePropuesto;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return autor + " sugiere: " + nombrePropuesto;
    }
}

