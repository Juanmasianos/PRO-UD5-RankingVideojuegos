package net.ripadbaisor.ranking.programdata.requests;

public class Request {
    private String request;
    private String author;

    public Request(String author, String request) {
        this.author = author;
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return author + " sugiere: " + request;
    }
}

