import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MENU extends JFrame {


    JLabel pic;
    Timer tm;
    int x = 0;
    //Images Path In Array
    String[] list = {
            "C:\\Users\\o876\\Pictures\\background\\chris.jpg",//0
            "C:\\Users\\o876\\Pictures\\background\\chriss.jpg",//1
            "C:\\Users\\o876\\Pictures\\background\\chris2.jpg",//2
            "C:\\Users\\o876\\Pictures\\background\\chrisss.jpg",//3
            "C:\\Users\\o876\\Pictures\\background\\sir.jpg",//4
            "C:\\Users\\o876\\Pictures\\background\\sir2.jpg",//5
            "C:\\Users\\o876\\Pictures\\background\\sir7.jpg"//6
    };

    public void Project(){
        pic = new JLabel();
        pic.setBounds(0, 0, 1600, 850);

        //Call The Function SetImageSize
        SetImageSize(6);
        //set a timer
        tm = new Timer(3000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0;
            }
        });
        add(pic);
        tm.start();

        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);

    }
    //create a function to resize the image
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }














    JButton b1, b2, b3, b4;
JLabel backround,welcome;

    public MENU() {
        super("MENU");
        b1 = new JButton("SIGN IN AS NEW EMPLOYEE");
        b2 = new JButton("LOGIN");
        b3 = new JButton("LOGOUT");
        b4= new JButton("ADMINISTRATION");
        welcome=new JLabel("WELCOME TO PAYROLL SYSTEM");
        backround=new JLabel(new ImageIcon("C:\\Users\\o876\\Pictures\\sir8.jpeg"));
        setSize(1600, 900);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 72));
        backround.setBounds(0,0,600,600);
        welcome.setBounds(150, 60, 1150, 50);
        b1.setBounds(200, 240, 200, 50);
        b2.setBounds(600, 180, 200, 50);
        b3.setBounds(1000, 240, 200, 50);
        b4.setBounds(200, 300, 200, 50);
        welcome.setForeground(Color.RED);
        welcome.setBackground(Color.CYAN);
        b1.setForeground(Color.BLUE);
        b2.setForeground(Color.BLUE);
        b3.setForeground(Color.BLUE);
        b4.setForeground(Color.BLUE);
        //background=new JLabel(new ImageIcon("C:\\Users\\o876\\Downloads\\login.jpg"));
        welcome.setOpaque(true);
        b1.setOpaque(true);
        b2.setOpaque(true);
        b3.setOpaque(true);
        b4.setOpaque(true);

       add(b1);  //backround.add(b4);
        add(b2);add(welcome);
         add(b3);
        //add(backround);



Project();
setActionlisters();

    }



    public void setActionlisters() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addnum num = new addnum();
                setVisible(false);
                num.setVisible(true);
            }
        };
        ActionListener buttonListener1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             LOGIN log= new LOGIN();
             setVisible(false);
             log.setVisible(true);
            }
        };
        ActionListener buttonListener2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGOUT lgout= new LOGOUT();
                setVisible(false);
                lgout.setVisible(true);
            }
        };
/*
        ActionListener adminilistener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery("select*from ADMIN");
                    String usernname=JOptionPane.showInputDialog("Enter Username");
                    String pass=JOptionPane.showInputDialog("Enter Password");
                    while(resultSet2.next()) {
                        if (usernname.equals(resultSet2.getString(1))) {
                            if (pass.equals(resultSet2.getString(5))) {
                                admin ad=new admin();
                                setVisible(false);
                                ad.setVisible(true);
                            }
                            else{JOptionPane.showMessageDialog(b4,"INCORRECT PASSWORD");}
                        }
                        else{JOptionPane.showMessageDialog(b4,"INCORRECT USERNAME AND PASSWORD");}
                    }
                    connection.close();
                } catch (Exception ee) {
                    System.out.println(ee);
                }

            }
        };*/
        b1.addActionListener(buttonListener);
        b2.addActionListener( buttonListener1);
        b3.addActionListener( buttonListener2);
        //b4.addActionListener(adminilistener);
    }

        public static void main (String[]args){
            new MENU();
        }

    }
