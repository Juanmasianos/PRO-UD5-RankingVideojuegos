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
        setSize(800, 600);
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

                JPanel videogameListPanel = createVideogameListerPanel();

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

    private JPanel createVideogameListerPanel() {

        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBackground(Color.DARK_GRAY);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());

        listPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        boolean gotLooped = false;

        for (Videogame videogame : dataStore.getVideogames()) {

            gotLooped = true;

            JButton btnVideogame = new JButton("<html><div style=\"text-align: center;\">" + videogame.getName() + "<br />" +
                                                "Puntuacion Total: " + videogame.getFinalScore() + "</div></html>");
            btnVideogame.setBackground(new Color(111, 54, 154));
            btnVideogame.setForeground(Color.WHITE);
            btnVideogame.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            btnVideogame.setPreferredSize(new Dimension(220, 70));

            btnVideogame.addActionListener(e -> {

                JPanel videogameScorerPanel = createVideogameScorer(videogame);

                cardPanel.add(videogameScorerPanel, "videogameScorer");

                setTitle("Puntaje de juego");
                cardLayout.show(cardPanel, "videogameScorer");
            });

            listPanel.add(btnVideogame, gbc);

            gbc.gridx++;

            if (gbc.gridx == 2) {
                gbc.gridx = 0;
                gbc.gridy++;
            }

        }

        if (!gotLooped) {

            JLabel noVideogamesLabel = new JLabel("No hay videojuegos a mostrar");
            noVideogamesLabel.setForeground(Color.WHITE);
            listPanel.add(noVideogamesLabel);

        }

        listPanel.setPreferredSize(new Dimension(500, gbc.gridy * 80));

        JScrollPane scrollPane = new JScrollPane(listPanel);
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
            setTitle("Interfaz de cliente");
            cardLayout.show(cardPanel, "Inicio");
        });

        return containerPanel;

    }

    private JPanel createVideogameScorer(Videogame videogame) {

        JPanel scorerPanel = new JPanel();
        scorerPanel.setLayout(new GridBagLayout());

        scorerPanel.setBackground(Color.DARK_GRAY);

        JLabel labelScorer = new JLabel("<html>Puntuando: " + videogame.getName()
                + "<br />Fecha de salida: " + videogame.getLaunchDateFormatted() 
                + "<br />Puntuacion total actual: " + videogame.getFinalScore()
                + "<br />Los valores deben estar entre 1 y 100");
        JLabel labelGraphicScore = new JLabel("Puntuacion de los gráficos: ");
        JTextField textGraphicScore = new JTextField();
        JLabel labelGameplayScore = new JLabel("Puntuacion del gameplay: ");
        JTextField textGameplayScore = new JTextField();
        JLabel labelOptimizationScore = new JLabel("Puntuacion de la optimizacion: ");
        JTextField textOptimizationScore = new JTextField();
        JLabel labelStoryScore = new JLabel("Puntuacion de la historia: ");
        JTextField textStoryScore = new JTextField();
        JButton btnScore = new JButton("<html>Confirmar<br/> puntuacion</html>");
        JButton btnReturn = new JButton("Regresar");
        JLabel errorLabel = new JLabel("Error: No puede haber ningun campo vacío");
        JLabel errorLabelTwo = new JLabel("Error: Algun campo no tiene valores numéricos");
        JLabel errorLabelThree = new JLabel("Error: Algun campo no tiene valores entre los especificados");

        labelScorer.setForeground(Color.WHITE);
        labelGraphicScore.setForeground(Color.WHITE);
        labelGameplayScore.setForeground(Color.WHITE);
        labelOptimizationScore.setForeground(Color.WHITE);
        labelStoryScore.setForeground(Color.WHITE);
        btnScore.setForeground(Color.WHITE);
        textGraphicScore.setPreferredSize(new Dimension(180, 30));
        textGameplayScore.setPreferredSize(new Dimension(180, 30));
        textOptimizationScore.setPreferredSize(new Dimension(180, 30));
        textStoryScore.setPreferredSize(new Dimension(180, 30));
        btnScore.setPreferredSize(new Dimension(120, 50));
        btnScore.setBackground(new Color(111, 54, 154));
        btnScore.setForeground(Color.WHITE);
        btnReturn.setPreferredSize(new Dimension(120, 50));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
        errorLabelTwo.setForeground(Color.RED);
        errorLabelTwo.setVisible(false);
        errorLabelThree.setForeground(Color.RED);
        errorLabelThree.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcTwo = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbcTwo.insets = new Insets(10, 10, 30, -180);
        gbcTwo.gridx = 0;
        gbcTwo.gridy = 0;
        scorerPanel.add(labelScorer, gbcTwo);
        gbc.gridx = 0;
        gbc.gridy = 1;
        scorerPanel.add(labelGraphicScore, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        scorerPanel.add(textGraphicScore, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        scorerPanel.add(labelGameplayScore, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        scorerPanel.add(textGameplayScore, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        scorerPanel.add(labelOptimizationScore, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        scorerPanel.add(textOptimizationScore, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        scorerPanel.add(labelStoryScore, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        scorerPanel.add(textStoryScore, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        scorerPanel.add(btnScore, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        scorerPanel.add(btnReturn, gbc);
        gbc.insets = new Insets(10, -120, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 7;
        scorerPanel.add(errorLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        scorerPanel.add(errorLabelTwo, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        scorerPanel.add(errorLabelThree, gbc);

        btnReturn.addActionListener(e -> {

            JPanel videogameListPanel = createVideogameListerPanel();

            cardPanel.add(videogameListPanel, "videogameLister");

            setTitle("Interfaz de Administrador");
            cardLayout.show(cardPanel, "videogameLister");

        });

        btnScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                errorLabel.setVisible(false);
                errorLabelTwo.setVisible(false);
                errorLabelThree.setVisible(false);
                String stringGraphicScore;
                String stringGameplayScore;
                String stringOptimizationScore;
                String stringStoryScore;

                try {

                    stringGraphicScore = textGraphicScore.getText();
                    stringGameplayScore = textGameplayScore.getText();
                    stringOptimizationScore = textOptimizationScore.getText();
                    stringStoryScore = textStoryScore.getText();

                    textGraphicScore.setText("");
                    textGameplayScore.setText("");
                    textOptimizationScore.setText("");
                    textStoryScore.setText("");

                    if (stringGraphicScore.isEmpty() || stringGameplayScore.isEmpty() || stringOptimizationScore.isEmpty() || stringStoryScore.isEmpty()) {

                        errorLabel.setVisible(true);

                    } else {

                        float graphicScore = Float.parseFloat(stringGraphicScore);
                        float gameplayScore = Float.parseFloat(stringGameplayScore);
                        float optimizationScore = Float.parseFloat(stringOptimizationScore);
                        float storyScore = Float.parseFloat(stringStoryScore);

                        if ((graphicScore > 100 || graphicScore < 1) ||
                            (gameplayScore > 100 || gameplayScore < 1) ||
                            (optimizationScore > 100 || optimizationScore < 1) ||
                            (storyScore > 100 || storyScore < 1)) {

                                errorLabelThree.setVisible(true);
                            
                        } else {

                            videogame.setGraphicsScore(graphicScore);
                            videogame.setGameplayScore(gameplayScore);
                            videogame.setOptimizationScore(optimizationScore);
                            videogame.setStoryScore(storyScore);
                            videogame.setFinalScore();

                        }

                    }

                } catch (Exception excep) {

                    errorLabelTwo.setVisible(true);
                    
                    textGraphicScore.setText("");
                    textGameplayScore.setText("");
                    textOptimizationScore.setText("");
                    textStoryScore.setText("");

                }

            }
        });

    return scorerPanel;

}

}
