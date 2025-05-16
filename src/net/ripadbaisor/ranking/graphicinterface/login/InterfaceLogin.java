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

        JPanel panelInicial = createInitialPanel();

        JPanel panelLoginCliente = createLoginPanel("ClienteLogin");

        JPanel panelLoginAdministrador = createLoginPanel("Administrador");

        JPanel panelRegistroCliente = createRegisterPanel();

        cardPanel.add(panelInicial, "Inicio");
        cardPanel.add(panelLoginCliente, "ClienteLogin");
        cardPanel.add(panelLoginAdministrador, "Administrador");
        cardPanel.add(panelRegistroCliente, "ClienteRegister");

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createInitialPanel() {

        return new JPanel();
    }

    private JPanel createLoginPanel(String tipo) {

        return new JPanel();
    }

    private JPanel createRegisterPanel() {

        return new JPanel();
    }
    

}