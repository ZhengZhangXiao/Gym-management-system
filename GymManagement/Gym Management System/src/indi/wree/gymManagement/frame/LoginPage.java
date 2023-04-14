package src.indi.wree.gymManagement.frame;

import src.indi.wree.gymManagement.bean.User;
import src.indi.wree.gymManagement.dao.ManageHelper;
import src.indi.wree.gymManagement.utli.WindowUTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {


    private JLabel username_Label;
    private JLabel password_Label;
    private JTextField username_Text;
    private JPasswordField password_Text;
    private JButton login_Button;
    private JLabel userType_Label;
    private JComboBox userType;
    private JFrame jf;

    public LoginPage(){

        // set JFrame and its function
        super("ABC Fitness");
        this.jf=this;
        this.setLayout(null);
        this.setSize(600,600);
        Container c=this.getContentPane();


        username_Label=new JLabel("User Name");
        username_Label.setBounds(100,100,100,50);
        c.add(username_Label);

        username_Text=new JTextField();
        username_Text.setBounds(250,100,200,50);
        username_Text.grabFocus();
        c.add(username_Text);

        password_Label=new JLabel("Password");
        password_Label.setBounds(100,200,100,50);
        c.add(password_Label);

        password_Text=new JPasswordField();
        password_Text.setBounds(250,200,200,50);
        c.add(password_Text);

        userType_Label=new JLabel("User Type");
        userType_Label.setBounds(100,300,100,50);
        c.add(userType_Label);

        userType=new JComboBox(new String[]{"","Member","Staff"});
        userType.setBounds(250,300,200,70);
        c.add(userType);

        login_Button=new JButton("Login");
        login_Button.setBounds(250,400,100,50);
        login_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String userName=username_Text.getText();
              String password=new String(password_Text.getPassword());
              String user=userType.getSelectedItem().toString();
// check if user input necessary information

              if(userName==""){
                  JOptionPane.showMessageDialog(jf,"Please input your user name","",JOptionPane.WARNING_MESSAGE);
              }
              if(password==""){
                    JOptionPane.showMessageDialog(jf,"Please input your password","",JOptionPane.WARNING_MESSAGE);
              }
              if(user==""){
                    JOptionPane.showMessageDialog(jf,"Please choose your user type","",JOptionPane.WARNING_MESSAGE);
              }

              User user1=new User();
              user1.setUsername(userName);
              user1.setPassword(password);
              if(user=="Member"){
                  user1.setUserType(1);
              }else{
                  user1.setUserType(0);
              }

// Login function
              ManageHelper helper=new ManageHelper();

              if(helper.login(user1)){
                  JOptionPane.showMessageDialog(jf,"Login Successfully!");
                  jf.dispose();
                  if(user1.isUserType()==0){
                     StaffSystemFrame ssf=new StaffSystemFrame(user1);
                  }else{
                      MemberSystemFrame msf=new MemberSystemFrame(user1);
                  }
                  return;
              }else{
                  JOptionPane.showMessageDialog(jf,"Wrong user name, password of user type");
                  Reset();
                  return;

              }


            }
        });

        c.add(login_Button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setResizable(false);
        WindowUTI.setFrameCenter(this);
        this.setVisible(true);


    }
//reset the input box
    public void Reset(){
        username_Text.setText("");
        password_Text.setText("");
        userType.setSelectedIndex(0);
    }


}
