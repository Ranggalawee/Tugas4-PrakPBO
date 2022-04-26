package Tugas4PBO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login {

    Connector connector = new Connector();

    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("LOGIN");

    JLabel lUsername = new JLabel("Username  ");
    JTextField tfUsername = new JTextField();
    JLabel lPassword = new JLabel("Password  ");
    JTextField tfPassword = new JTextField();
    JButton btnLogin = new JButton("Login");
    JButton btnRegister = new JButton("Register");

    public Login(){
        window.setLayout(null);
        window.setSize(400,200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lUsername);
        window.add(tfUsername);
        window.add(tfPassword);
        window.add(lPassword);
        window.add(btnLogin);
        window.add(btnRegister);

//LABEL
        lUsername.setBounds(5, 35, 120, 20);
        lPassword.setBounds(5, 60, 120, 20);

//TEXTFIELD
        tfUsername.setBounds(110, 35, 120, 20);
        tfPassword.setBounds(110, 60, 120, 20);

//BUTTON PANEL
        btnLogin.setBounds(250, 35, 90, 20);
        btnRegister.setBounds(250,60,90,20);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String query = "SELECT * FROM `users` WHERE username = '" + getUsername() + "' AND password = '" + getPassword() + "'";
                    connector.statement = connector.koneksi.createStatement();
                    ResultSet resultSet = connector.statement.executeQuery(query);
                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(null, "Login Berhasil");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login gagal, silahkan coba lagi");
                        tfPassword.requestFocus();
                    }
                } catch (SQLException e) {
                    System.out.println("Error");
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Register register = new Register();
            }
        });

    }

    public String getUsername(){
        return tfUsername.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

}