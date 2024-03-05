import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class admin extends JFrame {
    JProgressBar jb;
    String reg;
    JLabel Bbackround;
    int i=0,a=0,num=0;
    JTable listTable;
    JButton b1,b2,b3,bb4,TOTALSALARY,total,back;
    JTextField t1,t2,t3;
    admin(){
        super("Displaying");
        b1=new JButton("VIEW EMPLOYEES");
        b2=new JButton("SEARCH");
        b3=new JButton("DELETE");
        bb4=new JButton("PERFOMANCE");
        TOTALSALARY=new JButton("TOTAL SALARY FOR");
        total=new JButton("SALARIES");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField("VIEW PERFOMANCE OF");

        Bbackround=new JLabel(new ImageIcon("C:\\Users\\o876\\Pictures\\chrisss.jpg"));
        Bbackround.setBounds(0,0,1180,900);
        setVisible(true);
        setLayout(null);
        setSize(1000,1000);
        getContentPane().setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1180,900);

        jb=new JProgressBar(0,2504);
        jb.setBounds(20,180,150,30);
        jb.setValue(0);
        jb.setStringPainted(true);


        b1.setBounds(170, 120, 180, 50);
        b2.setBounds(350, 120, 200, 50);
        b3.setBounds(550, 120, 200, 50);
        TOTALSALARY.setBounds(750, 120, 200, 50);
        total.setBounds(950,120,200,50);
        bb4.setBounds(20,120,150,50);
        b1.setForeground(Color.BLUE);
        b2.setForeground(Color.BLUE);
        b3.setForeground(Color.BLUE);
        bb4.setForeground(Color.BLUE);
        TOTALSALARY.setForeground(Color.BLUE);
        TOTALSALARY.setOpaque(true);
        total.setForeground(Color.BLUE);
        total.setOpaque(true);
        b1.setOpaque(true);
        b2.setOpaque(true);
        b3.setOpaque(true);
        bb4.setOpaque(true);

        Bbackround.add(b1);Bbackround.add(TOTALSALARY);
        Bbackround.add(b2);Bbackround.add(total);
        Bbackround.add(b3); Bbackround.add(bb4);
        add(Bbackround);
SetUpAtionListeners();
    }

    public void SetUpAtionListeners() {
        ActionListener buttonlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select*from sign_in1");
                    Object[][] rowData = {};

                    Object[] columnNames = {"ID", "FIRSTNAME", "LASTNAME", "EMAIL", "NATIONAL_ID", "GENDER"};
                    DefaultTableModel listTableModel;
                    listTableModel = new DefaultTableModel(rowData, columnNames);
                    while (resultSet.next()) {
                        listTableModel.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(7)});
                    }
                    listTable = new JTable(listTableModel);
                    listTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    listTable.setCellEditor(null);
                    listTable.setBounds(37, 143, 397, 283);
                    listTable.setForeground(Color.lightGray);
                    listTable.setBackground(Color.CYAN);
                    listTable.isOpaque();

                    setVisible(false);
                    JFrame frame = new JFrame();

                    back = new JButton("BACK");
                    back.setBackground(Color.red);
                    back.isOpaque();
                    back.setBounds(12, 240, 200, 25);
                    frame.setVisible(true);
                    frame.setResizable(false);
                    frame.add(back);
                    frame.add(new JScrollPane(listTable));

                    frame.pack();
                    //JOptionPane.showMessageDialog( buttonListener,"Mismutch passwords reEnter");

                    connection.close();
                } catch (Exception ee) {
                    System.out.println(ee);
                }


                ActionListener BBV = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        admin ad = new admin();
                        ad.setVisible(true);
                    }
                };
                back.addActionListener(BBV);
            }
        };

        ActionListener buttonLister1=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";
                String search = JOptionPane.showInputDialog("ENTER USERNAME YOU WANT TO SEARCH LIKE 'B20101B' ");
                String cc, c;




                    if (search.equals("")) {
                        JOptionPane.showMessageDialog(b1, "Nothing to search enter Username");
                    } else if (search.length() < 7) {
                        JOptionPane.showMessageDialog(b1, "ENTER USERNAME WITH 7 CHARACTERS");
                    } else if (search.length() > 7) {
                        JOptionPane.showMessageDialog(b1, "ENTER USERNAME WITH 7 CHARACTERS");
                    }
                    c = String.valueOf(search.charAt(0));
                    cc = String.valueOf(search.charAt(6));
                 if (c.equals("B") && cc.equals("B")) {
                    search = search.substring(1, 6);
                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        DefaultListModel<String> l1 = new DefaultListModel<>();
                        JList<String> list = new JList<>(l1);
                        list.setBounds(10, 240, 700, 600);
                        add(list);
                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("select*from sign_in1");

                        while (resultSet.next()) {
                            if (search.equals(resultSet.getString(1))) {
                                a = 1;
                                l1.addElement(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6) + " " + resultSet.getString(7));
                            }
                        }
                        switch (a) {
                            case 1:
                                break;
                            default:
                                JOptionPane.showMessageDialog(b2, "NOT FOUND IN THE DATABASE");
                        }

                        connection.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }


            }
                else{
                JOptionPane.showMessageDialog(b1, "Invalid username");}
            }
        };
        ActionListener buttonlistener2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";
                String delete=JOptionPane.showInputDialog("ENTER USERNAME YOU WANT TO DELETE LIKE'B20002B'");
                if(delete.equals("")){JOptionPane.showMessageDialog(b1,"Nothing to DELETE enter Username");}
                else if(delete.length()<7){
                    JOptionPane.showMessageDialog(b1,"NOT FOUND");}
                else if(delete.length()>7){
                    JOptionPane.showMessageDialog(b1,"NOT FOUND");}
                else{
                delete=delete.substring(1,6);}

                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    DefaultListModel<String> l1 = new DefaultListModel<>();
                    JList<String> list = new JList<>(l1);
                    list.setBounds(10, 240, 700, 600);
                    add(list);
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement = connection.createStatement();
                    ResultSet reslt= statement.executeQuery("select*from sign_in1");
                    while(reslt.next()){
                        if(delete.equals(reslt.getString(1))){
                            statement.execute("delete from sign_in1 where(ID='"+delete+"')");
                            JOptionPane.showMessageDialog(b3,"SUCCESSFULLY DELETED");
                        }
                        //else{JOptionPane.showMessageDialog(b3,"NOT FOUND");}
                    }JOptionPane.showMessageDialog(b3,"NOT FOUND");

                    connection.close();
                } catch (Exception ee) {
                    System.out.println(ee);
                }


            }
        };
        ActionListener buttooonn=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String usernamee=JOptionPane.showInputDialog("ENTER USERNAME LIKE'B20002B'");
            usernamee=usernamee.substring(1,6);
                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select*from salary WHERE (ID='"+usernamee+"')");
                    int a=0;
                    while (resultSet.next()) {
                        if(usernamee.equals(resultSet.getString(2))){
                           a=a+(resultSet.getInt(8));
                        }
                    }
                    
                    while(i<=a){
                        jb.setValue(i);
                        i=i+20;
                        //try{Thread.sleep(1);}catch(Exception ee){}
                        add(jb);
                    }

                    //JOptionPane.showMessageDialog( buttonListener,"Mismutch passwords reEnter");

                    connection.close();
                } catch (Exception ee) {
                    System.out.println(ee);
                }

                }

        };
        ActionListener totalsalarylistener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernamee=JOptionPane.showInputDialog(TOTALSALARY,"ENTER USERNAME FOR WORKER LIKE 'B20002B'");
                String month=JOptionPane.showInputDialog(TOTALSALARY,"ENTER MONTH WORKED LIKE '1' FOR JANUARY");


                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";

                if (usernamee.equals("")) {
                    JOptionPane.showMessageDialog(b1, "Nothing to search enter Username");
                } else if (usernamee.length() < 7) {
                    JOptionPane.showMessageDialog(b1, "ENTER USERNAME WITH 7 CHARACTERS");
                } else if (usernamee.length() > 7) {
                    JOptionPane.showMessageDialog(b1, "ENTER USERNAME WITH 7 CHARACTERS");
                } else {
                    usernamee = usernamee.substring(1, 6);
                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        DefaultListModel<String> l1 = new DefaultListModel<>();
                        JList<String> list = new JList<>(l1);
                        list.setBounds(10, 240, 700, 600);
                        add(list);
                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("select*from salary where(ID='"+usernamee+"'and MONTH='"+month+"')");

                        while (resultSet.next()) {
                            a= a+ Integer.parseInt((resultSet.getString(8)));
                        }
                        JOptionPane.showMessageDialog(TOTALSALARY,"TOTAL SALARY FOR "+usernamee+" is :"+a);
                        connection.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }

                }

            }
        };
        ActionListener salarieslistener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String month=JOptionPane.showInputDialog(total,"ENTER THE MONTH U WANT TO SHOW SALARIES LIKE '1' FOR JANUARY");

                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "";



                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        DefaultListModel<String> l1 = new DefaultListModel<>();
                        JList<String> list = new JList<>(l1);
                        list.setBounds(10, 240, 700, 600);
                        add(list);
                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        Statement statement2 = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("select*from sign_in1");
                        while (resultSet.next()) {
                            reg=resultSet.getString(1);
                            ResultSet resultSet2 = statement2.executeQuery("select*from salary where(ID='"+reg+"'and MONTH='"+month+"')");
                            while(resultSet2.next()){
                                    a=a+(resultSet2.getInt(8));

                            }
                            l1.addElement("B"+reg+"B" + " " + a );
                            a=0;
                        }

                        connection.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }

                }








        };
        total.addActionListener(salarieslistener);
TOTALSALARY.addActionListener(totalsalarylistener);
        b1.addActionListener(buttonlistener);
        b2.addActionListener(buttonLister1);
        b3.addActionListener(buttonlistener2);
        bb4.addActionListener(buttooonn);

    }
public  static void main(String[]args){

        new admin();
}

    }

