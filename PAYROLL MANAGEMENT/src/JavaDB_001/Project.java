
package JavaDB_001;
        import java.awt.Color;
        import java.awt.Image;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.*;


public class Project extends JFrame{
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

    public Project(){
        super("Java SlideShow");
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
        setLayout(null);
        setSize(1600, 850);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //create a function to resize the image
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public static void main(String[] args){

        new Project();
    }
}