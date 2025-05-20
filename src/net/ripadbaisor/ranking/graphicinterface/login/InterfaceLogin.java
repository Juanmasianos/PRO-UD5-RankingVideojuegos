package net.ripadbaisor.ranking.graphicinterface.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import net.ripadbaisor.ranking.graphicinterface.usersinterface.AdminInterface;
import net.ripadbaisor.ranking.graphicinterface.usersinterface.ClientInterface;
import net.ripadbaisor.ranking.programdata.DataStore;
import net.ripadbaisor.ranking.programdata.userAccounts.Credentials;

public class InterfaceLogin extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private DataStore dataStore;

    public InterfaceLogin(DataStore dataStore) {

        this.dataStore = dataStore;

        setTitle("Interfaz de Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel initialPanel = createInitialPanel();

        JPanel clientLoginPanel = createLoginPanel("ClientLogin");

        JPanel adminLoginPanel = createLoginPanel("Admin");

        JPanel clientRegisterPanel = createRegisterPanel();

        cardPanel.add(initialPanel, "Inicio");
        cardPanel.add(clientLoginPanel, "ClientLogin");
        cardPanel.add(adminLoginPanel, "Admin");
        cardPanel.add(clientRegisterPanel, "ClientRegister");

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createInitialPanel() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridBagLayout());

        JButton btnClient = new JButton("Cliente");
        JButton btnAdmin = new JButton("Administrador");

        btnClient.setPreferredSize(new Dimension(150, 70));
        btnAdmin.setPreferredSize(new Dimension(150, 70));

        btnClient.setBackground(new Color(111, 54, 154));
        btnAdmin.setBackground(new Color(111, 54, 154));
        btnClient.setForeground(Color.WHITE);
        btnAdmin.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(btnClient, gbc);
        gbc.gridx = 0;
        panel.add(btnAdmin, gbc);

        btnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("login de cliente");
                cardLayout.show(cardPanel, "ClientLogin");
            }
        });

        btnAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("login de administrador");
                cardLayout.show(cardPanel, "Admin");
            }
        });

        return panel;
    }

    private JPanel createLoginPanel(String tipo) {

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());

        loginPanel.setBackground(Color.DARK_GRAY);

        JLabel labelUser = new JLabel("Usuario:");
        JTextField textUser = new JTextField();
        JLabel labelPassword = new JLabel("Contraseña:");
        JPasswordField textPassword = new JPasswordField();
        JButton btnEnter = new JButton("Ingresar");
        JButton btnReturn = new JButton("Regresar");
        JLabel errorLabel = new JLabel("Usuario o contraseña incorrectos");

        labelUser.setForeground(Color.WHITE);
        labelPassword.setForeground(Color.WHITE);
        textUser.setPreferredSize(new Dimension(180, 30));
        textPassword.setPreferredSize(new Dimension(180, 30));
        btnEnter.setPreferredSize(new Dimension(120, 50));
        btnEnter.setBackground(new Color(111, 54, 154));
        btnEnter.setForeground(Color.WHITE);
        btnReturn.setPreferredSize(new Dimension(120, 50));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JLabel labelLogin;
        if (tipo.toLowerCase().equals("admin")) {

            labelLogin = new JLabel("Login de administrador");
            labelLogin.setForeground(Color.WHITE);

            GridBagConstraints gbc = new GridBagConstraints();
            GridBagConstraints gbcTwo = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbcTwo.insets = new Insets(10, 10, 30, -180);
            gbcTwo.gridx = 0;
            gbcTwo.gridy = 0;
            loginPanel.add(labelLogin, gbcTwo);
            gbc.gridx = 0;
            gbc.gridy = 1;
            loginPanel.add(labelUser, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            loginPanel.add(textUser, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            loginPanel.add(labelPassword, gbc);
            gbc.gridx = 1;
            gbc.gridy = 2;
            loginPanel.add(textPassword, gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            loginPanel.add(btnEnter, gbc);
            gbc.gridx = 1;
            gbc.gridy = 3;
            loginPanel.add(btnReturn, gbc);
            gbcTwo.gridx = 0;
            gbcTwo.gridy = 4;
            loginPanel.add(errorLabel, gbcTwo);

        } else {

            labelLogin = new JLabel("Login de cliente");
            JButton btnRegister = new JButton("Registarse");
            btnRegister.setPreferredSize(new Dimension(120, 50));
            btnRegister.setBackground(new Color(111, 54, 154));
            btnRegister.setForeground(Color.WHITE);

            labelLogin.setForeground(Color.WHITE);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 1;
            gbc.gridy = 0;
            loginPanel.add(labelLogin, gbc);
            gbc.insets = new Insets(10, 10, 10, -100);
            gbc.gridx = 0;
            gbc.gridy = 1;
            loginPanel.add(labelUser, gbc);
            gbc.insets = new Insets(10, -100, 10, 10);
            gbc.gridx = 2;
            gbc.gridy = 1;
            loginPanel.add(textUser, gbc);
            gbc.insets = new Insets(10, 10, 10, -100);
            gbc.gridx = 0;
            gbc.gridy = 2;
            loginPanel.add(labelPassword, gbc);
            gbc.insets = new Insets(10, -100, 10, 10);
            gbc.gridx = 2;
            gbc.gridy = 2;
            loginPanel.add(textPassword, gbc);
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 3;
            loginPanel.add(btnRegister, gbc);
            gbc.gridx = 1;
            gbc.gridy = 3;
            loginPanel.add(btnEnter, gbc);
            gbc.gridx = 2;
            gbc.gridy = 3;
            loginPanel.add(btnReturn, gbc);
            gbc.insets = new Insets(10, -100, 10, -100);
            gbc.gridx = 1;
            gbc.gridy = 4;
            loginPanel.add(errorLabel, gbc);

            btnRegister.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    errorLabel.setVisible(false);

                    setTitle("Registro");

                    cardLayout.show(cardPanel, "ClientRegister");
                }
            });

        }

        btnReturn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                setTitle("Interfaz de Login");
                cardLayout.show(cardPanel, "Inicio");
            }
        });

        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user = textUser.getText();
                String password = new String(textPassword.getPassword());

                if (user.isEmpty() || password.isEmpty()) {

                    errorLabel.setVisible(true);

                } else {

                    if (tipo.toLowerCase().equals("admin")) {

                        if (user.equals(dataStore.getCredentialsList().get(0).getUsername())
                                && password.equals(dataStore.getCredentialsList().get(0).getPassword())) {

                            textUser.setText("");
                            textPassword.setText("");

                            dispose();
                            new AdminInterface(dataStore);
                            

                        } else {

                            errorLabel.setVisible(true);

                        }

                    } else {

                        boolean gotLooped = false;

                        for (int i = 1; i < dataStore.getCredentialsList().size(); i++) {

                            gotLooped = true;

                            if (user.equals(dataStore.getCredentialsList().get(i).getUsername())
                                    && password.equals(dataStore.getCredentialsList().get(i).getPassword())) {

                                textUser.setText("");
                                textPassword.setText("");

                                dispose();
                                new ClientInterface(dataStore);

                            } else {

                                errorLabel.setVisible(true);

                            }
                        }

                        if (!gotLooped) {

                            textUser.setText("");
                            textPassword.setText("");

                            errorLabel.setVisible(true);

                        }

                    }
                }

            }
        });

        return loginPanel;
    }

    private JPanel createRegisterPanel() {

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());

        registerPanel.setBackground(Color.DARK_GRAY);

        JLabel labelUser = new JLabel("Usuario:");
        JTextField textUser = new JTextField();
        JLabel labelPassword = new JLabel("Contraseña:");
        JPasswordField textPassword = new JPasswordField();
        JButton btnRegistrar = new JButton("<html>Registar<br/> usuario</html>");
        JButton btnReturn = new JButton("Regresar");
        JLabel errorLabel = new JLabel("Error al registrar el usuario, algún campo esta mal");
        JLabel errorLabelTwo = new JLabel("Error al registrar el usuario, el usuario ya existe");

        labelUser.setForeground(Color.WHITE);
        labelPassword.setForeground(Color.WHITE);
        textUser.setPreferredSize(new Dimension(180, 30));
        textPassword.setPreferredSize(new Dimension(180, 30));
        btnRegistrar.setPreferredSize(new Dimension(120, 50));
        btnRegistrar.setBackground(new Color(111, 54, 154));
        btnRegistrar.setForeground(Color.WHITE);
        btnReturn.setPreferredSize(new Dimension(120, 50));
        btnReturn.setBackground(new Color(111, 54, 154));
        btnReturn.setForeground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
        errorLabelTwo.setForeground(Color.RED);
        errorLabelTwo.setVisible(false);

        JLabel labelRegister;
        labelRegister = new JLabel("Registro de cliente");
        JButton btnLogin = new JButton("Log in");
        btnLogin.setPreferredSize(new Dimension(120, 50));
        btnLogin.setBackground(new Color(111, 54, 154));
        btnLogin.setForeground(Color.WHITE);

        labelRegister.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        registerPanel.add(labelRegister, gbc);
        gbc.insets = new Insets(10, 10, 10, -100);
        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(labelUser, gbc);
        gbc.insets = new Insets(10, -100, 10, 10);
        gbc.gridx = 2;
        gbc.gridy = 1;
        registerPanel.add(textUser, gbc);
        gbc.insets = new Insets(10, 10, 10, -100);
        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(labelPassword, gbc);
        gbc.insets = new Insets(10, -100, 10, 10);
        gbc.gridx = 2;
        gbc.gridy = 2;
        registerPanel.add(textPassword, gbc);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(btnLogin, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        registerPanel.add(btnRegistrar, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        registerPanel.add(btnReturn, gbc);
        gbc.insets = new Insets(10, -100, 10, -100);
        gbc.gridx = 1;
        gbc.gridy = 4;
        registerPanel.add(errorLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        registerPanel.add(errorLabelTwo, gbc);

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                setTitle("Interfaz de Login");
                cardLayout.show(cardPanel, "Inicio");
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                setTitle("login de cliente");
                cardLayout.show(cardPanel, "ClientLogin");
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user = textUser.getText();
                String password = new String(textPassword.getPassword());

                textUser.setText("");
                textPassword.setText("");

                if (user.isEmpty() || password.isEmpty()) {

                    errorLabel.setVisible(true);

                } else {

                    boolean isAlreadyRegistered = false;

                    for (int i = 0; i < dataStore.getCredentialsList().size(); i++) {
                        if (user.equals(dataStore.getCredentialsList().get(i).getUsername())
                                && password.equals(dataStore.getCredentialsList().get(i).getPassword())) {

                            isAlreadyRegistered = true;

                            errorLabelTwo.setVisible(true);

                        }
                    }

                    if (!isAlreadyRegistered) {

                        dataStore.addCredential(new Credentials(user, password));

                        errorLabel.setVisible(false);

                    }

                    errorLabel.setVisible(false);
                }

            }
        });

        return registerPanel;
    }
    

}