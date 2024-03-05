import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;



public class LOGOUT extends JFrame {


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


















    JLabel l1,l2,l3;
    JLabel Bbackround,welcome;
    JTextField t1;
    JPasswordField t2;
    JButton btn1;
    public LOGOUT(){
        super("LOGIN FORM");
        setForeground(Color.cyan);
        l1=new JLabel("USERNAME");
        l2=new JLabel("PASSWORD");
        l3=new JLabel("forgot password?");
        t1=new JTextField();
        t2=new JPasswordField();
        btn1=new JButton("LOGOUT");
        setVisible(true);
        setLayout(null);
        setSize(1600,850);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOGOUT FORM");
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






        welcome.setBounds(450,120,550,25);
        l1.setBounds(500, 240, 200, 25);
        l2.setBounds(500, 280, 200, 25);
        btn1.setBounds(500, 320, 200, 25);
        t1.setBounds(760, 240, 200, 25);
        t2.setBounds(760, 280, 200, 25);
        l3.setBounds(760, 320, 200, 25);






        add(l3);
        add(t1);
        add(t2);
        add(l1);
        add(l2);
        add(btn1);
        add(welcome);


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
                String usernname = t1.getText();
                String cc,c;
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
                        String date=String.valueOf(java.time.LocalDate.now());
                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        Statement statement2 = connection.createStatement();
                       ResultSet resultSet2 = statement2.executeQuery("select*from salary WHERE (DATE='"+date+"'and ID='"+usernname+"')");
                        ResultSet resultSet = statement.executeQuery("select*from sign_in1");


                        while (resultSet.next()) {
                            if (usernname.equals(resultSet.getString(1))) {
                                if (pass.equals(resultSet.getString(6))) {
                                    while(resultSet2.next()) {
                                        String loggedouttime = String.valueOf(java.time.LocalTime.now());
                                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                                        String loggedintime = resultSet2.getString(4);
                                        Date date1 = format.parse(loggedouttime);
                                        Date date2 = format.parse(loggedintime);
                                        long difference = date1.getTime() - date2.getTime();
                                        String workedhourss = String.valueOf(difference / 3600000);
                                        int workedhours = Integer.parseInt(workedhourss);
                                        int price = resultSet2.getInt(7);
                                        int totalamount = price * workedhours;
                                        statement2.execute("UPDATE salary SET TIMELOGGEDOUT='" + loggedouttime + "',HOURSWORKED='" + workedhours + "',TOTAL_AMOUNT='" + totalamount + "'  WHERE(ID='"+usernname+"'AND Date='"+date+"')");
                                        JOptionPane.showMessageDialog(btn1,"SUCCESSIFULLY LOGED OUT");
                                        break;
                                    }
                                    resultSet2.close();
                                    setVisible(false);
                                    MENU mn=new MENU();
                                    mn.setVisible(true);
                                }
                            }

                        }
                        resultSet.close();
                        // JOptionPane.showConfirmDialog(this, "INCORRECT PASSWORD OR USERNAME");

                        connection.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }

            }
        };
        btn1.addActionListener(buttonListener);

    }


    public static void main(String[] args) throws ParseException {
        new LOGOUT();
      /*  String loggedouttime = String.valueOf(java.time.LocalTime.now());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String loggedintime = "13:00:00.0000";
        Date date1 = format.parse(loggedouttime);
        Date date2 = format.parse(loggedintime);
        long difference = date1.getTime() - date2.getTime();
        String workedhourss = String.valueOf(difference / 3600000);
        int workedhours = Integer.parseInt(workedhourss);
        int price = 2;
        int totalamount = price * workedhours;
System.out.println(totalamount);
System.out.println(loggedouttime);
System.out.println(workedhours);*/



    }
}

