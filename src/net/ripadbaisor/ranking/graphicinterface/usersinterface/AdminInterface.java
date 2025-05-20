package net.ripadbaisor.ranking.graphicinterface.usersinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import net.ripadbaisor.ranking.programdata.DataStore;
import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;
import net.ripadbaisor.ranking.videogame.Videogame;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminInterface extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private DataStore dataStore;

    public AdminInterface(DataStore dataStore) {

        this.dataStore = dataStore;

        setTitle("Interfaz de Administrador");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel initialPanel = createInitialPanel();

        JPanel requestPanel = createRequestPanel();

        // JPanel videogameAdderPanel = createVideogameAdderPanel("VideogameAdder");

        cardPanel.add(initialPanel, "Inicio");
        cardPanel.add(requestPanel, "request");
        // cardPanel.add(videogameAdderPanel, "videogameAdder");

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    private JPanel createInitialPanel() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridBagLayout());

        JButton btnRequest = new JButton("Ver Solicitudes");
        JButton btnEditVideogames = new JButton("Editar Videojuegos");
        JButton btnAddVideogames = new JButton("Añadir Videojuegos");
        JButton btnLogOut = new JButton("Log Out");

        btnRequest.setPreferredSize(new Dimension(150, 70));
        btnEditVideogames.setPreferredSize(new Dimension(150, 70));
        btnAddVideogames.setPreferredSize(new Dimension(150, 70));
        btnLogOut.setPreferredSize(new Dimension(150, 70));

        btnRequest.setBackground(new Color(111, 54, 154));
        btnEditVideogames.setBackground(new Color(111, 54, 154));
        btnAddVideogames.setBackground(new Color(111, 54, 154));
        btnLogOut.setBackground(new Color(111, 54, 154));
        btnRequest.setForeground(Color.WHITE);
        btnEditVideogames.setForeground(Color.WHITE);
        btnAddVideogames.setForeground(Color.WHITE);
        btnLogOut.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(btnRequest, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(btnEditVideogames, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(btnAddVideogames, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btnLogOut, gbc);

        btnRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Ver Solicitudes");
                cardLayout.show(cardPanel, "request");
            }
        });

        return panel;

    }

    private JPanel createRequestPanel() {

        JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new GridBagLayout());
        requestPanel.setBackground(Color.DARK_GRAY);
        requestPanel.setLayout(new GridBagLayout());

        JScrollPane requestScroll = new JScrollPane(requestPanel);
        requestScroll.setBorder(BorderFactory.createTitledBorder("Sugerencias de usuarios"));

        JButton btnReturn = new JButton("Regresar");
        btnReturn.setPreferredSize(new Dimension(150, 70));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);

        boolean gotLooped = false;

        for (Request request : dataStore.getRequests()) {
            gotLooped = true;
            JLabel requestLabel = new JLabel(dataStore.toString() + "/n");
        }

        if (!gotLooped) {

            JLabel noRequestLabel = new JLabel("No hay solicitudes para mostrar");
            noRequestLabel.setForeground(Color.WHITE);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 0;
            requestPanel.add(noRequestLabel, gbc);

        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        requestPanel.add(btnReturn, gbc);

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Interfaz de Administrador");
                cardLayout.show(cardPanel, "Inicio");
            }
        });

        return requestPanel;
    }

}