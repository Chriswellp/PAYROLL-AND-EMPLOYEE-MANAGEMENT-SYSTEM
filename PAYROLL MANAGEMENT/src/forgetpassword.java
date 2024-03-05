import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class forgetpassword extends JFrame {
    JLabel ll1, l2, l3, l4,Bbackround;
    JTextField t1, t2, t3, t4;
    JButton  l8,L9;

    public forgetpassword() {
        super("ADD NUMBERS");
        L9=new JButton("BACK");
        ll1 = new JLabel("USERNAME");
        l2 = new JLabel("NEW PASSWORD");
        l3 = new JLabel("CONFIRM");
        l4 = new JLabel("NATIONAL ID");
        l8 = new JButton("RESET");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        setLayout(null);
        ll1.setBounds(10, 7, 200, 25);
        l2.setBounds(10, 40, 200, 25);
        l3.setBounds(10, 80, 200, 25);
        t1.setBounds(140, 8, 200, 25);
        t2.setBounds(140, 40, 200, 25);
        t3.setBounds(140, 80, 200, 25);
        t4.setBounds(140, 120, 200, 25);
        l4.setBounds(10, 120, 200, 25);
        l8.setBounds(10, 160, 200, 25);
        L9.setBounds(190, 160, 200, 25);
        Bbackround=new JLabel(new ImageIcon("C:\\Users\\o876\\Pictures\\sir7.jpeg"));
        Bbackround.setBounds(0,0,500,500);


        Bbackround.add(ll1);
        Bbackround.add(l2);
        Bbackround.add(l8);
        Bbackround.add(l3);
        Bbackround.add(t1);
        Bbackround.add(t2);
        Bbackround.add(t3);
        Bbackround.add(t4);
        Bbackround.add(l4);
        Bbackround.add(L9);
        add(Bbackround);

        setSize(500, 500);
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
        String Usernamee = t1.getText().trim();
        Usernamee=Usernamee.substring(1,6);
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement2 = connection.createStatement();

            ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM sign_in1 WHERE (ID='"+Usernamee+"')");

            while (resultSet2.next()) {
                JOptionPane.showMessageDialog(l8,"Your Username is  :"+"B"+resultSet2.getInt(1)+"B"+" And New Paasord is   : "+resultSet2.getString(6));
                MENU loG=new MENU();
                setVisible(false);
                loG.setVisible(true);
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
                    ;
                    String Usernamee = t1.getText().trim();
                    Usernamee=Usernamee.substring(1,6);
                    String New_Password = t2.getText().trim();
                    String Confirm = t3.getText().trim();
                    String national_id = t4.getText().trim();
                    ResultSet resultSet = statement.executeQuery("select*from sign_in1");
                    while (resultSet.next()) {
                        if (Usernamee.equals(resultSet.getString(1))) {
                            if (national_id.equals(resultSet.getString(5))) {
                                if (New_Password.equals(Confirm)) {

                                    statement.execute("UPDATE sign_in1 SET PASSWORD='" + Confirm + "' WHERE(ID='" + Usernamee + "')");
                                    idnum();

                                }
                                else{JOptionPane.showMessageDialog(l8,"MISMACH ON PASSWORDS");}
                            }
                            }
                        }
                    connection.close();
                } catch (Exception ee) {
                    System.out.println(ee);
                }



            }

        };
        ActionListener bbt=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              MENU MN=new MENU();
              setVisible(false);
              MN.setVisible(true);
            }
        };

        l8.addActionListener( buttonListener);
        L9.addActionListener(bbt);

    }




    public static void main (String[]args){
        new forgetpassword();


    }



}

