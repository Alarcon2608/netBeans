package view;

import controller.Controlador;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class Vista extends JFrame {
    private Controlador controlador;
    private JTextField txtNombreUsuario;
    private JPasswordField txtContrasena;

    public Vista(Controlador controlador) {
        this.controlador = controlador;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Gestión de Usuarios");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);

        JLabel lblNombreUsuario = new JLabel("Nombre de usuario:");
        lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        txtNombreUsuario = new JTextField(20);
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.BOLD, 12));
        txtContrasena = new JPasswordField(20);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        JButton btnVerUsuarios = new JButton("Ver Usuarios");  // New button to view users

        btnRegistrar.setBackground(new Color(102, 204, 255));
        btnRegistrar.setForeground(Color.WHITE);
        btnIniciarSesion.setBackground(new Color(102, 204, 255));
        btnIniciarSesion.setForeground(Color.WHITE);
        btnVerUsuarios.setBackground(new Color(153, 153, 255));  // Different color for differentiation
        btnVerUsuarios.setForeground(Color.WHITE);

        btnRegistrar.addActionListener(this::handleRegister);
        btnIniciarSesion.addActionListener(this::handleLogin);
        btnVerUsuarios.addActionListener(this::handleViewUsers);  // Add action listener to new button

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.lightGray);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JPanel panelNombreUsuario = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panelNombreUsuario.setBackground(Color.lightGray);
        panelNombreUsuario.add(lblNombreUsuario);
        panelNombreUsuario.add(txtNombreUsuario);

        JPanel panelContrasena = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panelContrasena.setBackground(Color.lightGray);
        panelContrasena.add(lblContrasena);
        panelContrasena.add(txtContrasena);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        panelBotones.setBackground(Color.lightGray);
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnIniciarSesion);
        panelBotones.add(btnVerUsuarios);  // Add new button to the panel

        contentPanel.add(panelNombreUsuario);
        contentPanel.add(panelContrasena);
        contentPanel.add(panelBotones);

        add(contentPanel);
        pack();
        setVisible(true);
    }

    private void handleRegister(ActionEvent e) {
        String nombre = txtNombreUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();
        if (nombre.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            controlador.registrarUsuario(nombre, contrasena);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            clearFields();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleLogin(ActionEvent e) {
        String nombre = txtNombreUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();
        if (nombre.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (controlador.iniciarSesion(nombre, contrasena)) {
            openUserPanel(nombre);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos.", "Inicio de Sesión Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openUserPanel(String userName) {
        JFrame userFrame = new JFrame("Bienvenido");
        userFrame.setSize(300, 200);
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Hola, " + userName + "!", JLabel.CENTER);
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userFrame.add(userLabel);

        userFrame.setVisible(true);
    }
    
    private void handleViewUsers(ActionEvent e) {
        JFrame frame = new JFrame("Lista de Usuarios");
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea userList = new JTextArea();
        userList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userList);
        frame.add(scrollPane);

        StringBuilder userData = new StringBuilder();
        Map<String, Usuario> usuarios = controlador.getUsuarios();
        usuarios.forEach((nombre, usuario) -> {
            userData.append("Usuario: ").append(nombre)
                    .append(", Hash de Contraseña: ").append(usuario.getContrasenaHash())
                    .append("\n");
        });

        userList.setText(userData.toString());
        frame.setVisible(true);
    }

    private void clearFields() {
        txtNombreUsuario.setText("");
        txtContrasena.setText("");
    }
}
