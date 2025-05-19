package net.ripadbaisor.ranking.programdata;

import java.util.ArrayList;
import net.ripadbaisor.ranking.userAccounts.Credentials;

public class DataStore {
    private ArrayList<Credentials> credentialsList = new ArrayList<>();
    private ArrayList<String> solicitudes = new ArrayList<>();
    private ArrayList<String> puntuaciones = new ArrayList<>();

    public ArrayList<Credentials> getCredentialsList() {
        return credentialsList;
    }

    public ArrayList<String> getSolicitudes() {
        return solicitudes;
    }

    public ArrayList<String> getPuntuaciones() {
        return puntuaciones;
    }

    public void addSolicitud(String solicitud) {
        solicitudes.add(solicitud);
    }

    public void addPuntuacion(String puntuacion) {
        puntuaciones.add(puntuacion);
    }

    public void addCredential(Credentials cred) {
        credentialsList.add(cred);
    }
}
