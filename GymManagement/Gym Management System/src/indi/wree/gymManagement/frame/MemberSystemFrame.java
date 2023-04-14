package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.User;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberSystemFrame extends JFrame {
    private JMenuBar menubar;
    private JMenu profile;
    private JMenu browse_class;

    private JMenuItem view_profile;
   private  JMenuItem view_class;

    private JFrame jf;

    private User user;

    public MemberSystemFrame(User user)  {
//  set JFrame and its function
        super();
        this.jf=this;
        this.setLayout(null);
        this.setTitle("Welcome " +user.getUsername());
        this.user=user;

        menubar=new JMenuBar();
        this.setJMenuBar(menubar);

        profile=new JMenu("ViewProfile");
        menubar.add(profile);
// member could use it view his profile and change his information
        view_profile=new JMenuItem("View ViewProfile");
        view_profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewProfile vp=new ViewProfile(jf,"Profile",true,user);
            }
        });

        profile.add(view_profile);



        browse_class=new JMenu("Gym Class");
        menubar.add(browse_class);
// member could use it view gym class
        view_class=new JMenuItem("Browse class");
        view_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewClass vc=new ViewClass(jf,"All Gym Class",true);
            }
        });

        browse_class.add(view_class);


        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        WindowUTI.setFrameCenter(this);
        this.setVisible(true);


    }
}
