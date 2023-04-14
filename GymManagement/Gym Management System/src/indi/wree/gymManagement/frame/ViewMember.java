package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.model.MemberModel;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;

public class ViewMember extends JDialog {
    private  JPanel jp;
    private  JTable jt;
    private  JScrollPane jsp;
    private JDialog jd;
    private MemberModel memberModel;


    public ViewMember(Frame owner, String title, boolean modal,String type) {
// set JDialog and its function
        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();
        jp = new JPanel();
        jt = new JTable();
        String  sql="";
        if(type.equals("members")){
            sql = " select * from user_info where usertype=1 ";
        }else {
            sql = " select * from user_info where usertype=0 ";
        }
// show all the members or staffs' information
         memberModel= new MemberModel(sql,jd,type);
        jt.setModel(memberModel);

        jsp = new JScrollPane(jt);
        jp.add(jsp);
        c.add(jp,BorderLayout.CENTER);

        this.setSize(600,600);
        this.setResizable(false);
        WindowUTI.setFrameCenter(this);
        this.setVisible(true);

    }
}
