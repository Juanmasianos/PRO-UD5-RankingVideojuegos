import java.util.ArrayList;

import net.ripadbaisor.ranking.graphicinterface.login.InterfaceLogin;
import net.ripadbaisor.ranking.graphicinterface.usersinterface.AdminInterface;
import net.ripadbaisor.ranking.programdata.DataStore;
import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;

public class App {
    public static void main(String[] args) throws Exception {
        DataStore defaultDataStore = new DataStore();
        defaultDataStore.addCredential(new Credentials("Admin", "1234"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        defaultDataStore.addSolicitud(new Request("elmaspto", "Quiero que me shupes lah bolas"));
        new AdminInterface(defaultDataStore);
    }
}
