package net.ripadbaisor.ranking.graphicinterface.usersinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import net.ripadbaisor.ranking.graphicinterface.login.InterfaceLogin;
import net.ripadbaisor.ranking.programdata.DataStore;
import net.ripadbaisor.ranking.programdata.requests.Request;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;
import net.ripadbaisor.ranking.videogame.Videogame;

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

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                dispose();

                new InterfaceLogin(dataStore);

            }
        });

        return panel;

    }

    private JPanel createRequestPanel() {

        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBackground(Color.GRAY);

        JPanel requestPanel = new JPanel(new GridBagLayout());
        requestPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        boolean gotLooped = false;

        for (Request request : dataStore.getRequests()) {

            gotLooped = true;

            JTextArea requestText = new JTextArea(request.toString());
            requestText.setWrapStyleWord(true);
            requestText.setLineWrap(true);
            requestText.setEditable(false);
            requestText.setBackground(Color.DARK_GRAY);
            requestText.setForeground(Color.WHITE);
            requestText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            requestText.setPreferredSize(new Dimension(500, 50));

            requestPanel.add(requestText, gbc);
            gbc.gridy++;
        }

        if (!gotLooped) {
            
            JLabel noRequestsLabel = new JLabel("No hay solicitudes a mostrar");
            noRequestsLabel.setForeground(Color.WHITE);
            requestPanel.add(noRequestsLabel);

        }

        requestPanel.setPreferredSize(new Dimension(500, gbc.gridy * 80));

        JScrollPane scrollPane = new JScrollPane(requestPanel);
        scrollPane.setBackground(Color.DARK_GRAY);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JButton btnReturn = new JButton("Regresar");
        btnReturn.setPreferredSize(new Dimension(150, 50));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(btnReturn);

        containerPanel.add(scrollPane, BorderLayout.CENTER);
        containerPanel.add(bottomPanel, BorderLayout.SOUTH);

        btnReturn.addActionListener(e -> {
            setTitle("Interfaz de Administrador");
            cardLayout.show(cardPanel, "Inicio");
        });

        return containerPanel;
    }





}