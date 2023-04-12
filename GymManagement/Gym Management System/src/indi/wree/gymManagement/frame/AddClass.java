package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClass extends JDialog {

    private JLabel name_label;
    private JTextField name_text;
    private JLabel time_label;
    private JComboBox time_text;
    private JLabel teacher_label;
    private JTextField teacher_text;

    private JButton add_class;
    private JButton cancel;
    private JDialog jd;
    private ManageHelper helper;

    public AddClass(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        helper=new ManageHelper();
        this.jd=this;
        this.setSize(600,600);
        this.setLayout(null);

        name_label=new JLabel("Class Name");
        name_label.setBounds(100,100,100,50);
        this.add(name_label);

        name_text=new JTextField();
        name_text.setBounds(300,100,200,50);
        this.add(name_text);

        time_label=new JLabel("Time");
        time_label.setBounds(100,200,100,50);
        this.add(time_label);

        time_text=new JComboBox(new String[]{"","Monday","Tuesday","Wednesday","Thursday","Friday"});
        time_text.setBounds(300,200,200,50);
        this.add(time_text);

        teacher_label=new JLabel("Teacher");
        teacher_label.setBounds(100,300,100,50);
        this.add(teacher_label);

        teacher_text=new JTextField();
        teacher_text.setBounds(300,300,200,50);
        this.add(teacher_text);

        add_class=new JButton("Add");
        add_class.setBounds(150,400,100,50);
        add_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name1=name_text.getText();
                String time1=time_text.getSelectedItem().toString();
                String teacher1=teacher_text.getText();

                if(name1==""){
                    JOptionPane.showMessageDialog(jd,"Please input class name","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(time1==""){
                    JOptionPane.showMessageDialog(jd,"Please input class time","",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(teacher1==""){
                    JOptionPane.showMessageDialog(jd,"Please input teacher name","",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                GymClass gymClass=new GymClass();
                gymClass.setClassName(name1);
                gymClass.setTime(time1);
                gymClass.setTeacher(teacher1);

                if(helper.addClass(gymClass)){
                    JOptionPane.showMessageDialog(jd,"Add Success");
                    jd.dispose();
                    return;
                }else{
                    JOptionPane.showMessageDialog(jd,"Failed","",JOptionPane.WARNING_MESSAGE);
                    jd.dispose();
                    return;
                }

            }
        });
        this.add(add_class);

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
