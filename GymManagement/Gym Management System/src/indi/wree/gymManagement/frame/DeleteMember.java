package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMember extends JDialog {
  private JLabel name_label;
  private JTextField name_text;
  private JLabel email_label;
  private JTextField email_text;
  private JLabel club_label;
  private JComboBox club_choice;
  private JButton delete;
  private JDialog jd;

  private ManageHelper helper;

  public DeleteMember(Frame owner, String title, boolean modal) {
    super(owner, title, modal);
    helper=new ManageHelper();
    this.jd=this;
    this.setSize(600,600);
    this.setLayout(null);

    name_label=new JLabel("Name");
    name_label.setBounds(100,100,100,50);
    jd.add(name_label);

    name_text=new JTextField();
    name_text.setBounds(300,100,200,50);
    jd.add(name_text);

    email_label=new JLabel("Email");
    email_label.setBounds(100,200,100,50);
    jd.add(email_label);

    email_text=new JTextField();
    email_text.setBounds(300,200,200,50);
    jd.add(email_text);

    club_label=new JLabel("Home Club");
    club_label.setBounds(100,300,100,50);
    jd.add(club_label);

    club_choice=new JComboBox(new String[]{"","club 1","club 2"});
    club_choice.setBounds(300,300,200,50);
    jd.add(club_choice);

    delete=new JButton("Delete");
    delete.setBounds(250,400,100,50);
    delete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name1=name_text.getText();
        String email1=email_text.getText();
        String club1=club_choice.getSelectedItem().toString().trim();

        if(name1==""){
          JOptionPane.showMessageDialog(jd,"Please input name","",JOptionPane.WARNING_MESSAGE);
          return;
        }
        if(email1==""){
          JOptionPane.showMessageDialog(jd,"Please input email","",JOptionPane.WARNING_MESSAGE);
          return;
        }
        if(club1==""){
          JOptionPane.showMessageDialog(jd,"Please choose club","",JOptionPane.WARNING_MESSAGE);
          return;
        }

        Members members=new Members();
        members.setName(name1);
        members.setEmail(email1);
        members.setHomeClub(club1);

        if(helper.Delete(members)){
          JOptionPane.showMessageDialog(jd,"Delete Success");
          jd.dispose();
          return;
        }else{
          JOptionPane.showMessageDialog(jd,"Wrong name,email or home club","",JOptionPane.WARNING_MESSAGE);
          jd.dispose();
          return;
        }
      }
    });
    jd.add(delete);

    WindowUTI.setFrameCenter(this);
    this.setResizable(false);
    this.setVisible(true);

  }
}
