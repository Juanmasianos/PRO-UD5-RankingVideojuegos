package net.ripadbaisor.ranking.graphicinterface.usersinterface;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import net.ripadbaisor.ranking.graphicinterface.login.InterfaceLogin;
import net.ripadbaisor.ranking.programdata.DataStore;
import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;
import net.ripadbaisor.ranking.videogame.Videogame;

public class ClientInterface extends JFrame{
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private DataStore dataStore;

    public ClientInterface(DataStore dataStore) {

        this.dataStore = dataStore;

        setTitle("Interfaz de cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel initialPanel = createInitialPanel();

        JPanel requestAdderPanel = createRequestAdderPanel();

        cardPanel.add(initialPanel, "Inicio");
        cardPanel.add(requestAdderPanel, "requestAdder");

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    private JPanel createInitialPanel() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridBagLayout());

        JButton btnAddRequest = new JButton("Añadir Solicitudes");
        JButton btnShowList = new JButton("Mostrar Juegos");
        JButton btnLogOut = new JButton("Log Out");

        btnAddRequest.setPreferredSize(new Dimension(150, 70));
        btnShowList.setPreferredSize(new Dimension(150, 70));
        btnLogOut.setPreferredSize(new Dimension(150, 70));
        btnAddRequest.setBackground(new Color(111, 54, 154));
        btnShowList.setBackground(new Color(111, 54, 154));
        btnLogOut.setBackground(new Color(111, 54, 154));
        btnAddRequest.setForeground(Color.WHITE);
        btnShowList.setForeground(Color.WHITE);
        btnLogOut.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(btnAddRequest, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(btnShowList, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(btnLogOut, gbc);

        btnAddRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Añadir Solicitudes");
                cardLayout.show(cardPanel, "requestAdder");
            }
        });

        btnShowList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JPanel videogameListPanel = CreateVideogameLister();

                cardPanel.add(videogameListPanel, "videogameLister");

                setTitle("Lista de Videojuegos");
                cardLayout.show(cardPanel, "videogameLister");

            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                new InterfaceLogin(dataStore);

            }
        });

        return panel;

    }

    private JPanel createRequestAdderPanel() {

        return new JPanel();

    }

    private JPanel CreateVideogameLister() {

        return new JPanel();

    }

}   
