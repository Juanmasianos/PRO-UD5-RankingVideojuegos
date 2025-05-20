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

        JPanel videogameAdderPanel = createVideogameAdderPanel();

        cardPanel.add(initialPanel, "Inicio");
        cardPanel.add(videogameAdderPanel, "videogameAdder");

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

                JPanel requestPanel = createRequestPanel();

                cardPanel.add(requestPanel, "request");

                setTitle("Ver Solicitudes");
                cardLayout.show(cardPanel, "request");
            }
        });

        btnAddVideogames.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                setTitle("Añadir Videojuego");
                cardLayout.show(cardPanel, "videogameAdder");

            }
        });

        btnEditVideogames.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JPanel videogameEditorPanel = createVideogameEditorPanel();

                cardPanel.add(videogameEditorPanel, "videogameEditor");

                setTitle("Editar Videojuego");
                cardLayout.show(cardPanel, "videogameEditor");

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

    private JPanel createVideogameAdderPanel() {

        JPanel adderPanel = new JPanel();
        adderPanel.setLayout(new GridBagLayout());

        adderPanel.setBackground(Color.DARK_GRAY);

        JLabel labelAddVideogame = new JLabel("Añadir un Videojuego");
        JLabel labelName = new JLabel("Nombre:");
        JTextField textName = new JTextField();
        JLabel labelReleaseDate = new JLabel("Fecha de salida:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        JFormattedTextField textReleaseDate = new JFormattedTextField(dateFormatter);
        JButton btnAdd = new JButton("<html>Añadir<br/> Videojuego</html>");
        JButton btnReturn = new JButton("Regresar");
        JLabel errorLabel = new JLabel("<html>Error al registrar el videojuego, la fecha no es correcta.<br /> No debe estar vacia y su formato es dd/mm/aaaa </html>");
        JLabel errorLabelTwo = new JLabel("Error al registrar el videojuego, el videojuego ya existe");

        labelAddVideogame.setForeground(Color.WHITE);
        labelName.setForeground(Color.WHITE);
        labelReleaseDate.setForeground(Color.WHITE);
        textName.setPreferredSize(new Dimension(180, 30));
        textReleaseDate.setPreferredSize(new Dimension(180, 30));
        btnAdd.setPreferredSize(new Dimension(120, 50));
        btnAdd.setBackground(new Color(111, 54, 154));
        btnAdd.setForeground(Color.WHITE);
        btnReturn.setPreferredSize(new Dimension(120, 50));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
        errorLabelTwo.setForeground(Color.RED);
        errorLabelTwo.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcTwo = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbcTwo.insets = new Insets(10, 10, 30, -180);
        gbcTwo.gridx = 0;
        gbcTwo.gridy = 0;
        adderPanel.add(labelAddVideogame, gbcTwo);
        gbc.gridx = 0;
        gbc.gridy = 1;
        adderPanel.add(labelName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        adderPanel.add(textName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        adderPanel.add(labelReleaseDate, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        adderPanel.add(textReleaseDate, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        adderPanel.add(btnAdd, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        adderPanel.add(btnReturn, gbc);
        gbc.insets = new Insets(10, -120, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        adderPanel.add(errorLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        adderPanel.add(errorLabelTwo, gbc);

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                setTitle("Interfaz de Administrador");
                cardLayout.show(cardPanel, "Inicio");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                errorLabel.setVisible(false);
                errorLabelTwo.setVisible(false);
                String name = "";
                String releaseDateString = "";

                try {

                    name = textName.getText();
                    releaseDateString = textReleaseDate.getText();

                    textName.setText("");
                    textReleaseDate.setText("");

                    if (name.isEmpty() || releaseDateString.isEmpty()) {

                        errorLabel.setVisible(true);

                    } else {

                        boolean isAlreadyAdded = false;

                        Date releaseDate = (Date) textReleaseDate.getValue();

                        for (int i = 0; i < dataStore.getVideogames().size(); i++) {
                            if (name.equals(dataStore.getVideogames().get(i).getName())) {

                                isAlreadyAdded = true;

                                errorLabelTwo.setVisible(true);

                            }
                        }

                        if (!isAlreadyAdded) {

                            dataStore.addVideogame(new Videogame(name, releaseDate));

                            errorLabel.setVisible(false);

                        }

                    }

                } catch (Exception excep) {

                    errorLabel.setVisible(true);

                    textName.setText("");
                    textReleaseDate.setText("");

                }

            }
        });

        return adderPanel;
    }

    private JPanel createVideogameEditorPanel() {

        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBackground(Color.DARK_GRAY);

        JPanel editorPanel = new JPanel();
        editorPanel.setLayout(new GridBagLayout());

        editorPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        boolean gotLooped = false;

        for (Videogame videogame : dataStore.getVideogames()) {

            gotLooped = true;

            JButton btnVideogame = new JButton(videogame.getName());
            btnVideogame.setBackground(Color.DARK_GRAY);
            btnVideogame.setForeground(Color.WHITE);
            btnVideogame.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            btnVideogame.setPreferredSize(new Dimension(220, 50));

            editorPanel.add(btnVideogame, gbc);
            
            gbc.gridx++;

            if (gbc.gridx == 2) {
                gbc.gridx = 0;
                gbc.gridy++;
            }

        }

        if (!gotLooped) {

            JLabel noVideogamesLabel = new JLabel("No hay videojuegos a mostrar");
            noVideogamesLabel.setForeground(Color.WHITE);
            editorPanel.add(noVideogamesLabel);

        }

        editorPanel.setPreferredSize(new Dimension(500, gbc.gridy * 80));

        JScrollPane scrollPane = new JScrollPane(editorPanel);
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