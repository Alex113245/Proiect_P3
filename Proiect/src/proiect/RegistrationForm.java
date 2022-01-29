package proiect;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class RegistrationForm implements ActionListener {
    JFrame frame;
    
    JLabel nameLabel=new JLabel("Username");
    JLabel passwordLabel=new JLabel("Passowrd");
    JLabel confirmPasswordLabel=new JLabel("Confirm Password");
    JLabel emailLabel=new JLabel("Email");
    JTextField nameTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("Register");
    JButton resetButton=new JButton("Reset");
 
 
    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,80,70);
        passwordLabel.setBounds(20,100,100,70);
        confirmPasswordLabel.setBounds(20,180,140,70);
        emailLabel.setBounds(20,260,100,70);
        nameTextField.setBounds(180,43,165,23);
        passwordField.setBounds(180,123,165,23);
        confirmPasswordField.setBounds(180,203,165,23);
        emailTextField.setBounds(180,283,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
 
 
    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                
            	java.sql.Connection Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect","root","password");
           
                PreparedStatement Pstatement=Connection.prepareStatement("insert into utilizatori values(?,?,?,?)");
               
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(4,passwordField.getText());
                Pstatement.setString(5,confirmPasswordField.getText());
                Pstatement.setString(7,emailTextField.getText());
                //Verifica cele 2 parola
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            nameTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            emailTextField.setText("");
        }
 
    }
}