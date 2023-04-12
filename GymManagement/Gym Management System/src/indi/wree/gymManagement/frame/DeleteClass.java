package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClass extends JDialog {
    private JLabel no_label;
    private JTextField no_text;
    private JLabel name_label;
    private JTextField name_text;
    private JLabel time_label;
    private JComboBox time_text;
    private JButton delete_class;
    private JDialog jd;
    private ManageHelper helper;

    public DeleteClass(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        helper=new ManageHelper();
        this.jd=this;
        this.setSize(600,600);
        this.setLayout(null);

        name_label=new JLabel("Class Name");
        name_label.setBounds(100,100,100,50);
        jd.add(name_label);

        name_text=new JTextField();
        name_text.setBounds(300,100,200,50);
        jd.add(name_text);

        time_label=new JLabel("Time");
        time_label.setBounds(100,200,100,50);
        this.add(time_label);


        time_text=new JComboBox(new String[]{"","Monday","Tuesday","Wednesday","Thursday","Friday"});
        time_text.setBounds(300,200,200,50);
        this.add(time_text);

        no_label=new JLabel("Class No.");
        no_label.setBounds(100,300,100,50);
        jd.add(no_label);

        no_text=new JTextField();
        no_text.setBounds(300,300,100,50);
        jd.add(no_text);

        delete_class=new JButton("Delete Class");
        delete_class.setBounds(250,400,100,50);
        delete_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1=name_text.getText();
                String time1=time_text.getSelectedItem().toString();
                String no1=no_text.getText();

                if(name1==""){
                    JOptionPane.showMessageDialog(jd,"Please input class name","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(time1==""){
                    JOptionPane.showMessageDialog(jd,"Please choose class time","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(no1==""){
                    JOptionPane.showMessageDialog(jd,"Please input class No.","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                GymClass gymClass=new GymClass();

                gymClass.setClassNo(Integer.parseInt(no1));
                gymClass.setClassName(name1);
                gymClass.setTime(time1);

                if(helper.deleteClass(gymClass)){
                    JOptionPane.showMessageDialog(jd,"Delete Success");
                    jd.dispose();
                    return;
                }else{
                    JOptionPane.showMessageDialog(jd,"Wrong class No ,name or time","",JOptionPane.WARNING_MESSAGE);
                    jd.dispose();
                    return;
                }

            }
        });

        jd.add(delete_class);



        WindowUTI.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }
}
