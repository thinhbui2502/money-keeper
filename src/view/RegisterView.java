package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private String[] gender = {"Nam", "Nữ"};
    private JLabel nameLabel = new JLabel("TÊN");
    private JLabel genderLabel = new JLabel("GIỚI TÍNH");
    private JLabel accountLabel = new JLabel("TÀI KHOẢN");
    private JLabel passwordLabel = new JLabel("MẬT KHẨU");
    private JLabel confirmPasswordLabel = new JLabel("XÁC NHẬN MẬT KHẨU");
    private JLabel cityLabel = new JLabel("THÀNH PHỐ");
    private JLabel emailLabel = new JLabel("EMAIL");
    private JTextField nameTextField = new JTextField();
    private JComboBox genderComboBox = new JComboBox(gender);
    private JTextField accountField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField confirmPasswordField = new JPasswordField();
    private JTextField cityTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JButton registerButton = new JButton("ĐĂNG KÝ");
    private JButton resetButton = new JButton("RESET");
    private JButton loginButton = new JButton("EXIT");


    public RegisterView() {
        initComponents();
        actionEvent();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame frame = new JFrame();
        frame.setTitle("ĐĂNG KÝ TÀI KHOẢN");
        frame.setBounds(40, 40, 380, 600);
        frame.getContentPane().setBackground(Color.decode(("#669966")));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        nameLabel.setBounds(20, 20, 40, 70);
        genderLabel.setBounds(20, 70, 80, 70);
        accountLabel.setBounds(20, 120, 100, 70);
        passwordLabel.setBounds(20, 170, 100, 70);
        confirmPasswordLabel.setBounds(20, 220, 140, 70);
        cityLabel.setBounds(20, 270, 100, 70);
        emailLabel.setBounds(20, 320, 100, 70);
        nameTextField.setBounds(180, 43, 165, 23);
        genderComboBox.setBounds(180, 93, 165, 23);
        accountField.setBounds(180, 143, 165, 23);
        passwordField.setBounds(180, 193, 165, 23);
        confirmPasswordField.setBounds(180, 243, 165, 23);
        cityTextField.setBounds(180, 293, 165, 23);
        emailTextField.setBounds(180, 343, 165, 23);
        registerButton.setBounds(70, 400, 100, 35);
        resetButton.setBounds(220, 400, 100, 35);
        loginButton.setBounds(140, 450, 105, 35);

        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(accountLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(accountField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(loginButton);
    }

    public void actionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        loginButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            if (passwordField.getText() != null && passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())) {
                JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                try {
                    FileWriter fileWriter = new FileWriter("account.txt");
                    fileWriter.write(accountField.getText());
                    fileWriter.write(passwordField.toString());
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu không khả dụng!");
            }
        }

        if (e.getSource() == resetButton) {
            nameTextField.setText("");
            genderComboBox.setSelectedItem("Male");
            accountField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            cityTextField.setText("");
            emailTextField.setText("");
        }

        if (e.getSource() == loginButton) {
            System.exit(0);
        }
    }

}
