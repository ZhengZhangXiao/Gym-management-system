package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.model.ClassModel;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;

public class ViewClass extends JDialog {
    private  JPanel jp;
    private  JTable jt;
    private  JScrollPane jsp;
    private JDialog jd;
    private ClassModel classModel;
    public ViewClass(Frame owner, String title, boolean modal) {
// set JDialog and its function
        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();
        jp = new JPanel();
        jt = new JTable();
        String sql = " select * from class_info";

// show all classes' information
        classModel = new ClassModel(sql,jd);
        jt.setModel(classModel);

        jsp = new JScrollPane(jt);
        jp.add(jsp);
        c.add(jp,BorderLayout.CENTER);

        this.setSize(600,600);
        this.setResizable(false);
        WindowUTI.setFrameCenter(this);
        this.setVisible(true);
    }
}
