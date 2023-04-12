package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClass extends JDialog {
    private JLabel no_label;
    private JTextField no_text;
    private JLabel update_label;
    private JComboBox update_combo;
    private JButton choose;
    private JLabel new_info;
    private JTextField update_text;
    private JComboBox update_choice;
    private  JButton update;

    private JDialog jd;
    private ManageHelper helper;

    public UpdateClass(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        helper=new ManageHelper();
        this.jd=this;
        this.setSize(600,600);
        this.setLayout(null);


        no_label=new JLabel("Class No.");
        no_label.setBounds(100,100,100,50);
        jd.add(no_label);

        no_text=new JTextField();
        no_text.setBounds(300,100,200,50);
        jd.add(no_text);

        update_label=new JLabel("Option");
        update_label.setBounds(100,200,100,50);
        jd.add(update_label);

        update_combo=new JComboBox(new String[]{"","Class Name","Time","Teacher"});
        update_combo.setBounds(300,200,200,50);
        jd.add(update_combo);

        new_info=new JLabel("New Info");
        new_info.setBounds(100,300,100,50);
        jd.add(new_info);

        update_text=new JTextField();
        update_text.setBounds(300,300,200,50);
        jd.add(update_text);
        update_text.setVisible(false);

        update_choice=new JComboBox(new String[]{"","Monday","Tuesday","Wednesday","Thursday","Friday"});
        update_choice.setBounds(300,300,200,50);
        jd.add(update_choice);
        update_choice.setVisible(false);

        choose=new JButton("Choose");
        choose.setBounds(150,400,100,50);
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String choice1=update_combo.getSelectedItem().toString();
                if(choice1=="Time"){
                    update_choice.setVisible(true);
                }else if(choice1==""){
                    JOptionPane.showMessageDialog(jd,"Please make a choice","",JOptionPane.WARNING_MESSAGE);
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
                GymClass gymClass=new GymClass();
                String no1=no_text.getText();
                if(no1==""){
                    JOptionPane.showMessageDialog(jd,"Please input class No.","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                gymClass.setClassNo(Integer.parseInt(no1));

                String column="",newInfo="";
                if(choice2.equals("Class Name")){
                    column="className";
                }
                if(choice2.equals("Time")){
                    column="time";
                }
                if(choice2.equals("Teacher")){
                    column="teacher";
                }


                if(!update_text.getText().equals("")){
                    newInfo=update_text.getText();
                }else {
                    newInfo=update_choice.getSelectedItem().toString();
                }

                if(newInfo==""){
                    JOptionPane.showMessageDialog(jd,"Please input new information","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(helper.updateClass(gymClass,column,newInfo)){
                    JOptionPane.showMessageDialog(jd,"Update Success");
                    jd.dispose();
                    return;
                }else {
                    JOptionPane.showMessageDialog(jd,"Update Failed");
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
