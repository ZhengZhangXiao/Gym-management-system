package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.bean.User;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewProfile extends JDialog {

    private JLabel name_label;
    private JLabel name_text;
    private JLabel password_label;
    private JTextField password_text;
    private JLabel email_label;
    private JTextField email_text;
    private JLabel phone_label;
    private JTextField phone_text;
    private JLabel homeClub;
    private JTextField club_choice;

    private JButton update;

    private JDialog jd;
    private ManageHelper helper;

    public ViewProfile(Frame owner, String title, boolean modal, User user) {
        // set JDialog and its function
        super(owner, title, modal);
        helper=new ManageHelper();
        this.jd=this;
        this.setSize(600,600);
        this.setLayout(null);
// show this member's personal information
        Members newMember= helper.getMemberInfo(user);

        name_label=new JLabel("Name");
        name_label.setBounds(100,50,50,50);
        this.add(name_label);

        name_text=new JLabel(newMember.getName());
        name_text.setBounds(300,50,200,50);
        this.add(name_text);

        password_label=new JLabel("Password");
        password_label.setBounds(100,130,100,50);
        this.add(password_label);

        password_text=new JTextField(newMember.getPassword());
        password_text.setBounds(300,130,200,50);
        this.add(password_text);

        email_label=new JLabel("Email");
        email_label.setBounds(100,210,100,50);
        this.add(email_label);

        email_text=new JTextField(newMember.getEmail());
        email_text.setBounds(300,210,200,50);
        this.add(email_text);

        phone_label=new JLabel("Cell Phone");
        phone_label.setBounds(100,290,100,50);
        this.add(phone_label);

        phone_text=new JTextField(newMember.getCellPhone());
        phone_text.setBounds(300,290,200,50);
        this.add(phone_text);

        homeClub=new JLabel("Home Club");
        homeClub.setBounds(100,370,100,50);
        this.add(homeClub);

        club_choice=new JTextField(newMember.getHomeClub());
        club_choice.setBounds(300,370,200,50);
        this.add(club_choice);
//update his own information
        update=new JButton("Update");
        update.setBounds(250,450,100,50);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String password=password_text.getText();
                String email=email_text.getText();
                String cellPhone=phone_text.getText();
                String club=club_choice.getText();

                Members members=new Members();
                members.setName(user.getUsername());
                members.setPassword(password);
                members.setEmail(email);
                members.setCellPhone(cellPhone);
                members.setHomeClub(club);

                if(helper.UpdateAll(members)){
                    JOptionPane.showMessageDialog(jd,"Update Success");
                    jd.dispose();
                    return;
                }else {
                    JOptionPane.showMessageDialog(jd,"Update Failed","",JOptionPane.WARNING_MESSAGE);
                    jd.dispose();
                    return;
                }

            }
        });

        this.add(update);


        WindowUTI.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);


    }
}
