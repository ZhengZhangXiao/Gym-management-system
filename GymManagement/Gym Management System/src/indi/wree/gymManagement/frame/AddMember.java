package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends JDialog {

    private JLabel name_label;
    private JTextField name_text;
    private JLabel password_label;
    private JPasswordField password_text;
    private JLabel email_label;
    private JTextField email_text;
    private JLabel phone_label;
    private JTextField phone_text;
    private JLabel homeClub;
    private JComboBox club_choice;

    private JLabel userType;
    private JComboBox type_choice;
    private JButton register;
    private JButton cancel;
    private JDialog jd;
    private ManageHelper helper;
    public AddMember(Frame owner, String title, boolean modal) {

// set JDialog and its function

        super(owner, title, modal);
        helper=new ManageHelper();
        this.jd=this;
        this.setSize(600,600);
        this.setLayout(null);

        name_label=new JLabel("Name");
        name_label.setBounds(50,100,50,50);
        this.add(name_label);

        name_text=new JTextField();
        name_text.setBounds(150,100,100,50);
        this.add(name_text);

        password_label=new JLabel("Password");
        password_label.setBounds(300,100,100,50);
        this.add(password_label);

        password_text=new JPasswordField();
        password_text.setBounds(450,100,100,50);
        this.add(password_text);

        email_label=new JLabel("Email");
        email_label.setBounds(50,200,50,50);
        this.add(email_label);

        email_text=new JTextField();
        email_text.setBounds(150,200,100,50);
        this.add(email_text);

        phone_label=new JLabel("Cell Phone");
        phone_label.setBounds(300,200,100,50);
        this.add(phone_label);

        phone_text=new JTextField();
        phone_text.setBounds(450,200,100,50);
        this.add(phone_text);

        homeClub=new JLabel("Home Club");
        homeClub.setBounds(50,300,50,50);
        this.add(homeClub);

        club_choice=new JComboBox(new String[]{"","club 1","club 2"});
        club_choice.setBounds(150,300,100,50);
        this.add(club_choice);

        userType=new JLabel("User Type");
        userType.setBounds(300,300,100,50);
        this.add(userType);

        type_choice=new JComboBox(new String[]{"","Member","Staff"});
        type_choice.setBounds(450,300,100,50);
        this.add(type_choice);

        register=new JButton("Register");
        register.setBounds(150,400,100,50);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Members members=new Members();
                String name1=name_text.getText();
                String password1=new String(password_text.getPassword());
                String email1=email_text.getText().trim();
                String phone1=phone_text.getText().trim();
                String club1=club_choice.getSelectedItem().toString().trim();
                String type1=type_choice.getSelectedItem().toString();

// check if user input necessary information
                if(name1==""){
                    JOptionPane.showMessageDialog(jd,"Please input name","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(password1==""){
                    JOptionPane.showMessageDialog(jd,"Please input password","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(email1==""){
                    JOptionPane.showMessageDialog(jd,"Please input email","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(phone1==""){
                    JOptionPane.showMessageDialog(jd,"Please input cell phone","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(club1==""){
                    JOptionPane.showMessageDialog(jd,"Please choose club","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(type1==""){
                    JOptionPane.showMessageDialog(jd,"Please choose user type","",JOptionPane.WARNING_MESSAGE);
                    return;
                }


                // add a new class into the database
                members.setName(name1);
                members.setPassword(password1);
                members.setEmail(email1);
                members.setCellPhone(phone1);
                members.setHomeClub(club1);
                if(type1=="Member"){
                    members.setType(1);
                }else{
                    members.setType(0);
                }

                if(helper.Register(members)){
                    JOptionPane.showMessageDialog(jd,"Registration Success");
                    jd.dispose();
                    return;
                }else{
                    JOptionPane.showMessageDialog(jd,"Registration Failed","",JOptionPane.WARNING_MESSAGE);
                    jd.dispose();
                    return;
                }

            }
        });

        this.add(register);

//cancel function
        cancel=new JButton("Cancel");
        cancel.setBounds(350,400,100,50);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jd.dispose();
            }
        });

        this.add(cancel);

        WindowUTI.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);










    }
}
