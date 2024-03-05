import JavaDB_001.Project;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class LOGIN extends JFrame {



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










    JLabel l1,l2,l3,l4,welcome,Bbackround,Bbackround1;
    JTextField t1;
    JPasswordField t2;
    JButton btn1;
    JPanel pn;
    int a,b=0;
    JComboBox CB1;
    String s[]={"MANAGER","GENERAL"};
    public LOGIN(){
        super("LOGIN FORM");
        setForeground(Color.cyan);
        pn=new JPanel();
        l1=new JLabel("USERNAME");
        l2=new JLabel("PASSWORD");
        l3=new JLabel("forgot password?");
        l4=new JLabel("ACCESS LEVEL");
        t1=new JTextField();
        t2=new JPasswordField();
        CB1=new JComboBox(s);
        btn1=new JButton("LOGIN");
        setVisible(true);
        setLayout(null);
        setSize(1600,850);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOGIN FORM");
        welcome=new JLabel("WELCOME TO PAYROLL SYSTEM");
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        welcome.setForeground(Color.RED);
        welcome.setBackground(Color.CYAN);
        welcome.setOpaque(true);
        l1.setForeground(Color.RED);
        l1.setBackground(Color.CYAN);
        l2.setForeground(Color.RED);
        l2.setBackground(Color.CYAN);
        l3.setForeground(Color.CYAN);
        btn1.setForeground(Color.RED);
        btn1.setBackground(Color.CYAN);
        l1.setOpaque(true);
        l2.setOpaque(true);
        btn1.setOpaque(true);
        l4.setForeground(Color.RED);
        l4.setBackground(Color.CYAN);
        l4.setOpaque(true);
pn.setBackground(Color.lightGray);


        welcome.setBounds(450,120,550,25);
        l4.setBounds(500,200,200,25);
        CB1.setBounds(760,200,200,25);
        l1.setBounds(500, 240, 200, 25);
        l2.setBounds(500, 280, 200, 25);
        btn1.setBounds(500, 320, 200, 25);
        t1.setBounds(760, 240, 200, 25);
        t2.setBounds(760, 280, 200, 25);
        l3.setBounds(760, 320, 200, 25);
        pn.setBounds(20,500,1480,250);
        

        //add(pn);
add(t1);
add(t2);
add(l1);
add(l2);
add(l4);add(welcome);
add(btn1);add(l3);add(CB1);



        Project();
        setUpButtonListeners();
        mouseListener();
    }
    public void mouseListener(){
        MouseListener mouselistsener1=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // JOptionPane.showConfirmDialog(l3,"MOUSE CLICKED");

            }

            @Override
            public void mousePressed(MouseEvent e) {
              forgetpassword fp=new forgetpassword();
              setVisible(false);
              fp.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        l3.addMouseListener(mouselistsener1);

    }

    public void setUpButtonListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                String time= String.valueOf(java.time.LocalTime.now());

               Date dd= new Date();
               String monthh=String.valueOf(dd.getMonth());
                int month=Integer.parseInt(monthh)+1;
                String date=String.valueOf(java.time.LocalDate.now());
                String cc,c;
                    String usernname = t1.getText();
                   c= String.valueOf(usernname.charAt(0));
                   cc=String.valueOf(usernname.charAt(6));
                    if(c.equals("B")&& cc.equals("B")){
                    if (usernname.length() < 7) {
                    JOptionPane.showMessageDialog(btn1, "Please enter Correct username LIKE 'B20009B'");
                }
                else{
                     usernname=usernname.substring(1,6);}}
                    else{JOptionPane.showMessageDialog(btn1, "INCORRECT PASSWORD OR USERNAME");}
                    String pass = t2.getText();
                    String url = "jdbc:mysql://localhost:3306/project";
                    String username = "root";
                    String password = "";
                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        Statement statement3 = connection.createStatement();
                        Statement statement2 = connection.createStatement();
                        ResultSet resultSet2 = statement2.executeQuery("select*from salary");
                        ResultSet resultSet = statement.executeQuery("select*from sign_in1");
                        ResultSet resultSet3 = statement3.executeQuery("select*from admin");

                        while (resultSet2.next()) {
                            if (date.equals(resultSet2.getString(3)) && usernname.equals(resultSet2.getString(2))) {
                                a = 1;
                            }
                        }
                        while(resultSet3.next()){
                        if (pass.equals(resultSet3.getString(5)) && usernname.equals(resultSet3.getString(1))) {
                            a = 2;
                        }
                    }

                        switch (a) {
                            case 1:
                                JOptionPane.showMessageDialog(btn1, "LOGGED IN ALREADY");
                                MENU mn = new MENU();
                                mn.setVisible(true);
                                break;
                            case 2:
                                admin ad= new admin();
                                setVisible(false);
                                ad.setVisible(true);
                                break;
                            default:
                                while (resultSet.next()) {
                                    //System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                                    if (usernname.equals(resultSet.getString(1))) {
                                        if (pass.equals(resultSet.getString(6))) {
                                            if ((CB1.getItemAt(CB1.getSelectedIndex())).equals("MANAGER")) {
                                                String a = JOptionPane.showInputDialog("Enter management code");

                                                if (a.equals("112233")) {

                                                    statement.execute("INSERT INTO salary(ID,DATE,TIMELOGGEDIN,AMOUNT_PER_HOUR,MONTH)value('" + usernname + "','" + date + "','" + time + "','4','" + month + "')");
                                                    JOptionPane.showMessageDialog(btn1, "LOGIN SUCCESSIFULY");
                                                } else {
                                                    JOptionPane.showMessageDialog(btn1, "WRONG MANAGEMENT CODE");

                                                }
                                            } else {
                                                statement.execute("INSERT INTO salary(ID,DATE,TIMELOGGEDIN,AMOUNT_PER_HOUR,MONTH)value('" + usernname + "','" + date + "','" + time + "','2','" + month + "')");
                                                JOptionPane.showMessageDialog(btn1, "LOGIN SUCCESSIFULY");
                                            }
                                            setVisible(false);
                                            MENU mnn = new MENU();
                                            mnn.setVisible(true);
                                        } else {
                                            JOptionPane.showMessageDialog(btn1, "INCORRECT PASSWORD OR USERNAME");
                                        }
                                    }
                                    else{b=1;}
                                }
                                break;


                        }
                            switch (b){
                                case 1:
                                    JOptionPane.showMessageDialog(btn1, "INCORRECT PASSWORD OR USERNAME");
                                    break;
                            }



                        // JOptionPane.showConfirmDialog(this, "INCORRECT PASSWORD OR USERNAME");

                        connection.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }


            }
        };



        btn1.addActionListener(buttonListener);
    }


    public static void main(String[] args){
new LOGIN();
    }
}
