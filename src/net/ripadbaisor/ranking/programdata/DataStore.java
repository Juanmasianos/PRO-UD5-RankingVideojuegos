package net.ripadbaisor.ranking.programdata;

import java.util.ArrayList;

import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;
import net.ripadbaisor.ranking.videogame.Videogame;

public class DataStore {
    private ArrayList<Credentials> credentialsList = new ArrayList<>();
    private ArrayList<Request> requests = new ArrayList<>();
    private ArrayList<Videogame> videogames = new ArrayList<>();

    public ArrayList<Credentials> getCredentialsList() {
        return credentialsList;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public ArrayList<Videogame> getVideogames() {
        return videogames;
    }

    public void addSolicitud(Request request) {
        this.requests.add(request);
    }

    public void addVideogame(Videogame videogame) {
        videogames.add(videogame);
    }

    public void addCredential(Credentials cred) {
        credentialsList.add(cred);
    }
}
