package net.ripadbaisor.ranking.graphicinterface.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import net.ripadbaisor.ranking.userAccounts.Credentials;

public class InterfaceLogin extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private ArrayList<Credentials> credentialsList;

    public InterfaceLogin(ArrayList<Credentials> credentials) {

        this.credentialsList = credentials;

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

        return new JPanel();
    }

    private JPanel createRegisterPanel() {

        return new JPanel();
    }
    

}