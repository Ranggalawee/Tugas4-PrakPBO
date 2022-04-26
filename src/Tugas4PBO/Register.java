package Tugas4PBO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Register {

    Connector connector = new Connector();

    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("REGISTER");

    JLabel lUsername = new JLabel("Username  ");
    JTextField tfUsername = new JTextField();
    JLabel lPassword = new JLabel("Password  ");
    JTextField tfPassword = new JTextField();
    JButton btnSubmit = new JButton("Submit");
    JButton btnLogin = new JButton("Login");

    public Register(){
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
        window.add(btnSubmit);
        window.add(btnLogin);

//LABEL
        lUsername.setBounds(5, 35, 120, 20);
        lPassword.setBounds(5, 60, 120, 20);

//TEXTFIELD
        tfUsername.setBounds(110, 35, 120, 20);
        tfPassword.setBounds(110, 60, 120, 20);

//BUTTON PANEL
        btnSubmit.setBounds(250, 35, 90, 20);
        btnLogin.setBounds(250,60,90,20);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String query = "INSERT INTO `users`(`username`, `password`) VALUES ('"+getUsername()+"','"+getPassword()+"')";
                    if (!getUsername().isEmpty() && !getPassword().isEmpty()){
                        connector.statement = connector.koneksi.createStatement();
                        connector.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Register Berhasil!!");
                    }
                    else if (getUsername().isEmpty() || getPassword().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Register gagal, silahkan coba lagi.");
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Login login = new Login();
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
