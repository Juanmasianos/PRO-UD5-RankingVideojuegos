package net.ripadbaisor.ranking.programdata;

import java.util.ArrayList;

import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;

public class DataStore {
    private ArrayList<Credentials> credentialsList = new ArrayList<>();
    private ArrayList<Request> requests = new ArrayList<>();
    private ArrayList<String> puntuaciones = new ArrayList<>();

    public ArrayList<Credentials> getCredentialsList() {
        return credentialsList;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public ArrayList<String> getPuntuaciones() {
        return puntuaciones;
    }

    public void addSolicitud(Request request) {
        this.requests.add(request);
    }

    public void addPuntuacion(String puntuacion) {
        puntuaciones.add(puntuacion);
    }

    public void addCredential(Credentials cred) {
        credentialsList.add(cred);
    }
}
