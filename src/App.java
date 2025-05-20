import java.util.ArrayList;
import java.util.Date;

import net.ripadbaisor.ranking.graphicinterface.login.InterfaceLogin;
import net.ripadbaisor.ranking.graphicinterface.usersinterface.AdminInterface;
import net.ripadbaisor.ranking.programdata.DataStore;
import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;
import net.ripadbaisor.ranking.videogame.Videogame;

public class App {
    public static void main(String[] args) throws Exception {
        DataStore defaultDataStore = new DataStore();
        defaultDataStore.addCredential(new Credentials("Admin", "1234"));
        new InterfaceLogin(defaultDataStore);
    }
}
