package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMember extends JDialog {
    private JLabel name_label;
    private JTextField name_text;
    private JLabel update_label;
    private JComboBox update_combo;
    private JButton choose;
    private JLabel new_info;
    private JTextField update_text;
    private JComboBox update_choice;
    private JPasswordField update_password;

    private  JButton update;

    private JDialog jd;
    private ManageHelper helper;

    public UpdateMember(Frame owner, String title, boolean modal) {
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

        update_label=new JLabel("Option");
        update_label.setBounds(100,200,100,50);
        jd.add(update_label);

        update_combo=new JComboBox(new String[]{"","Password","Email","Cell Phone","Home Club"});
        update_combo.setBounds(300,200,200,50);
        jd.add(update_combo);

        new_info=new JLabel("New Info");
        new_info.setBounds(100,300,100,50);
        jd.add(new_info);

        update_text=new JTextField();
        update_text.setBounds(300,300,200,50);
        jd.add(update_text);
        update_text.setVisible(false);

        update_choice=new JComboBox(new String[]{"","club1","club2"});
        update_choice.setBounds(300,300,200,50);
        jd.add(update_choice);
        update_choice.setVisible(false);

        update_password=new JPasswordField();
        update_password.setBounds(300,300,200,50);
        jd.add(update_password);
        update_password.setVisible(false);

        choose=new JButton("Choose");
        choose.setBounds(150,400,100,50);
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String choice1=update_combo.getSelectedItem().toString();
                if(choice1=="Home Club"){
                   update_choice.setVisible(true);
                }else if(choice1==""){
                    JOptionPane.showMessageDialog(jd,"Please make a choice","",JOptionPane.WARNING_MESSAGE);
                }else if(choice1=="Password"){
                   update_password.setVisible(true);
                } else{
                    update_text.setVisible(true);
                }
            }
        });
        jd.add(choose);

        update=new JButton("Update");
        update.setBounds(300,400,100,50);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice2=update_combo.getSelectedItem().toString();
                if(choice2==""){
                    JOptionPane.showMessageDialog(jd,"Please make a choice","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Members members=new Members();
                String name1=name_text.getText();
                if(name1==""){
                    JOptionPane.showMessageDialog(jd,"Please input name","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                members.setName(name1);

                String column="",newInfo="";
                if(choice2.equals("Password")){
                    column="password";
                }
                if(choice2.equals("Email")){
                    column="email";
                }
                if(choice2.equals("Cell Phone")){
                    column="cellPhone";
                }
                if(choice2.equals("Home Club")){
                    column="homeClub";
                }

                if(!update_text.getText().equals("")){
                    newInfo=update_text.getText();
                }else if(!update_choice.getSelectedItem().toString().equals("")){
                    newInfo=update_choice.getSelectedItem().toString();
                }else{
                    newInfo=new String(update_password.getPassword());
                }
                if(newInfo==""){
                    JOptionPane.showMessageDialog(jd,"Please input new information","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(helper.Update(members,column,newInfo)){
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
        jd.add(update);

        WindowUTI.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);



    }
}
