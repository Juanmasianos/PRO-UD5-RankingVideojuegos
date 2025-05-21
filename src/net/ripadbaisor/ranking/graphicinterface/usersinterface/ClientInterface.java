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

public class ClientInterface extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private DataStore dataStore;
    private String username;

    public ClientInterface(DataStore dataStore, String logedUser) {

        this.dataStore = dataStore;
        this.username = logedUser;

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

        JPanel requestAdderPanel = new JPanel();
        requestAdderPanel.setLayout(new GridBagLayout());

        requestAdderPanel.setBackground(Color.DARK_GRAY);

        JLabel labelAddRequest = new JLabel("Añadir una solicitud");
        JLabel labelRequest = new JLabel("Solicitud: ");
        JTextField textRequest = new JTextField();
        JButton btnAdd = new JButton("<html>Añadir<br/> Solicitud</html>");
        JButton btnReturn = new JButton("Regresar");
        JLabel errorLabel = new JLabel("Error al registrar la solicitud, esta no puede estar vacia");

        labelAddRequest.setForeground(Color.WHITE);
        labelRequest.setForeground(Color.WHITE);
        textRequest.setPreferredSize(new Dimension(180, 30));
        btnAdd.setPreferredSize(new Dimension(120, 50));
        btnAdd.setBackground(new Color(111, 54, 154));
        btnAdd.setForeground(Color.WHITE);
        btnReturn.setPreferredSize(new Dimension(120, 50));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, -130);
        gbc.gridx = 0;
        gbc.gridy = 0;
        requestAdderPanel.add(labelAddRequest, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        requestAdderPanel.add(labelRequest, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        requestAdderPanel.add(textRequest, gbc);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        requestAdderPanel.add(btnAdd, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        requestAdderPanel.add(btnReturn, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        requestAdderPanel.add(errorLabel, gbc);

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                setTitle("Interfaz de cliente");
                cardLayout.show(cardPanel, "Inicio");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                errorLabel.setVisible(false);
                String request = "";

                request = textRequest.getText();

                textRequest.setText("");

                if (request.isEmpty()) {

                    errorLabel.setVisible(true);

                } else {

                    dataStore.addRequest(new Request(username, request));

                    errorLabel.setVisible(false);

                }

            }
        });

        return requestAdderPanel;

    }

    private JPanel CreateVideogameLister() {

        return new JPanel();

    }

}
