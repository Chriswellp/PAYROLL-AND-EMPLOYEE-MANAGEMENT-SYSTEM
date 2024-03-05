import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class addnum extends JFrame {
    JLabel ll1, l2, l3, l4, l5, l6, l7,Bbackround;
    JTextField t1, t2, t3, t4, t5, t6;
    JComboBox t7;
    String gend[]={"MALE","FEMALE"};
    JButton btn1, l8;

    public addnum() {
        super("ADD NUMBERS");
        ll1 = new JLabel("First Name");
        l2 = new JLabel("Surname");
        l3 = new JLabel("Email");
        l4 = new JLabel("National ID");
        l5 = new JLabel("Password");
        l6 = new JLabel("Confirm Password");
        l7 = new JLabel("Gender");
        l8 = new JButton("Click to login");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        Bbackround=new JLabel(new ImageIcon("C:\\Users\\o876\\Pictures\\chrisss.jpg"));
        Bbackround.setBounds(0,0,600,600);

        t7 = new JComboBox(gend);
        btn1 = new JButton("SIGN IN");
        setLayout(null);
        ll1.setBounds(10, 7, 200, 25);
        l2.setBounds(10, 40, 200, 25);
        l3.setBounds(10, 80, 200, 25);
        t1.setBounds(140, 8, 200, 25);
        t2.setBounds(140, 40, 200, 25);
        t3.setBounds(140, 80, 200, 25);
        t4.setBounds(140, 120, 200, 25);
        t5.setBounds(140, 160, 200, 25);
        t6.setBounds(140, 200, 200, 25);
        l4.setBounds(10, 120, 200, 25);
        l5.setBounds(10, 160, 200, 25);
        l6.setBounds(10, 200, 200, 25);
        l7.setBounds(10, 240, 200, 25);

        t7.setBounds(140, 240, 200, 25);

        btn1.setBounds(10, 280, 120, 25);
        l8.setBounds(140, 280, 120, 25);
        ll1.setForeground(Color.CYAN);
        l2.setForeground(Color.CYAN);
        l3.setForeground(Color.CYAN);
        l4.setForeground(Color.CYAN);
        l5.setForeground(Color.CYAN);
        l6.setForeground(Color.CYAN);
        l7.setForeground(Color.CYAN);
        l8.setForeground(Color.blue);
        btn1.setForeground(Color.blue);
        Bbackround.add(ll1);
        Bbackround.add(l2);
        Bbackround.add(l8);
        Bbackround.add(l3);
        Bbackround.add(t1);
        Bbackround.add(t2);
        Bbackround.add(t3);
        Bbackround.add(t4);
        Bbackround.add(t5);
        Bbackround.add(t6);
        Bbackround.add(l4);
        Bbackround.add(l5);
        Bbackround.add(l6);
        Bbackround.add(l7);
        Bbackround.add(t7);
        Bbackround.add(btn1);
add(Bbackround);
        setSize(600, 600);
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SIRCHRIS TRIAL");


        setUpButtonListeners();

    }
    public void idnum() {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement2 = connection.createStatement();

            ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM sign_in1 ORDER BY ID DESC LIMIT 1");

            while (resultSet2.next()) {
                JOptionPane.showMessageDialog(btn1,"Your Username is  :"+"B"+resultSet2.getInt(1)+"B"+" And Paasord is   : "+resultSet2.getString(6));
           LOGIN log=new LOGIN();
           setVisible(false);
           log.setVisible(true);
            }

            connection.close();
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }


    public void setUpButtonListeners() {

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                    String url = "jdbc:mysql://localhost:3306/project";
                    String username = "root";
                    String password = "";

                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        DefaultListModel<String> l1 = new DefaultListModel<>();
                        JList<String> list = new JList<>(l1);
                        list.setBounds(10, 320, 250, 800);
                        add(list);
                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        String name = t1.getText().trim();
                        String surname = t2.getText().trim();
                        String email = t3.getText().trim();
                        String national_id = t4.getText().trim();
                        String passwordd = t5.getText().trim();
                        String confirm = t6.getText().trim();
                        String gender = String.valueOf(t7.getItemAt(t7.getSelectedIndex()));

                        if (passwordd.equals(confirm)) {
                            statement.execute("INSERT INTO sign_in1(FIRSTNAME,LASTNAME,EMAIL,NATIONAL_ID,PASSWORD,GENDER)value('" + name + "','" + surname + "','" + email + "','" + national_id + "','" + passwordd + "','" + gender + "')");
                            idnum();

                        } else {
                            //JOptionPane.showMessageDialog( buttonListener,"Mismutch passwords reEnter");
                        }
                        connection.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }



            }

        };

        ActionListener buttonListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LOGIN log = new LOGIN();
                setVisible(false);
                log.setVisible(true);
            }
        };

        btn1.addActionListener(buttonListener);
        l8.addActionListener( buttonListener2);

    }




        public static void main (String[]args){
            new addnum();


        }



}
