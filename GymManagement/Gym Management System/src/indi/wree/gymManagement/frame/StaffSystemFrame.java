package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.User;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffSystemFrame extends JFrame {
  private JMenuBar menubar;
  private JMenu member_management;
  private JMenu classes_management;


  private JMenuItem add_member;
  private JMenuItem delete_member;
  private JMenuItem update_member;
  private JMenuItem view_member;
  private JMenuItem view_staff;
  private JMenuItem add_classes;
  private JMenuItem delete_classes;
  private JMenuItem update_classes;
  private JMenuItem view_classes;


  private JFrame jf;

  private User user;


  public StaffSystemFrame(User user) {

    // set JFrame and its function
    super();

    this.jf=this;
    this.setLayout(null);

    this.setTitle("Welcome " +user.getUsername());
    this.user=user;

    menubar=new JMenuBar();
    this.setJMenuBar(menubar);

    member_management=new JMenu("Member Management");
    menubar.add(member_management);

// staff could use it add  a new gym member
    add_member=new JMenuItem("Add Gym Member");
    add_member.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          AddMember addMember=new AddMember(jf,"Add Gym Member",true);
      }
    });
    member_management.add(add_member);

// staff could use it delete a gym member
    delete_member=new JMenuItem("Delete Gym Member");
    delete_member.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       DeleteMember dm=new DeleteMember(jf,"Delete Gym Member",true);
      }
    });

    member_management.add(delete_member);
// staff could use it update gym member's infomation
    update_member=new JMenuItem("Update Member Information");
    update_member.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      UpdateMember um=new UpdateMember(jf,"Update Member Information",true);
      }
    });

    member_management.add(update_member);
// staff could use it to view all gym member's information
    view_member=new JMenuItem("All Gym Member");
    view_member.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         ViewMember vm=new ViewMember(jf,"All Member Information",true,"members");
      }
    });
    member_management.add(view_member);
// staff could use it to view all gym staff's information
    view_staff=new JMenuItem("All Gym Staff");
    view_staff.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewMember vm=new ViewMember(jf,"All Staff Information",true,"staffs");
      }
    });
    member_management.add(view_staff);




    classes_management=new JMenu("Gym Class Management");
    menubar.add(classes_management);

// staff could use it add a new gym class
    add_classes=new JMenuItem("Add Gym Class");
    add_classes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       AddClass ac=new AddClass(jf,"Add Gym Class",true);
      }
    });

    classes_management.add(add_classes);

// staff could use it delete a gym class
    delete_classes=new JMenuItem("Delete Gym Class");
    delete_classes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      DeleteClass dc=new DeleteClass(jf,"Delete Gym Class",true);
      }
    });

    classes_management.add(delete_classes);
// staff could use it update gym class's information
    update_classes=new JMenuItem("Update Class Information");
    update_classes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      UpdateClass uc=new UpdateClass(jf,"Update Class Information",true);
      }
    });

    classes_management.add(update_classes);
//staff could use it to view all gym class's information
    view_classes=new JMenuItem("All Gym Classes");
    view_classes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewClass vc=new ViewClass(jf,"All Gym Classes",true);
      }
    });

    classes_management.add(view_classes);






     this.setSize(600,600);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setResizable(false);
     WindowUTI.setFrameCenter(this);
     this.setVisible(true);






  }
}
