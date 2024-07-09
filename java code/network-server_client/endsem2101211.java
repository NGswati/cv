import java.awt.event.*;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.net.*;
import org.w3c.dom.events.MouseEvent;
import java.io.*; 
import java.net.Socket;
import java.awt.Color;

class endsem2101211 extends JFrame implements ActionListener{
    JButton b1,b2;
    endsem2101211(String name) {
        super(name);
        setLocation(0,0);
        JLabel l1 = new JLabel("Student information Records");
        b1 = new JButton("Admin");
        b1.setBounds(20,50, 100, 100);
        b1.setBackground(Color.cyan);
        add(b1);
        b2 = new JButton("User");
        b2.setBounds(140, 50, 100, 100);
        b2.setBackground(Color.gray);
        add(b2);
        JPanel p1=new JPanel();
        p1.setBounds(0,0,500,500);
        p1.add(l1,b1);
        add(p1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b1) {
            new admin();
        } else if (evt.getSource() == b2) {
            new User();
        }
    }

    public static void main(String[] args) throws IOException{
        new endsem2101211("hello");
        System.out.println("Connecting to server... ");
        Socket socket = new Socket("localhost",3000);
        System.out.println("Connected to server");
        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str1="",str2="";
        System.out.println("Start comminicating with Server \nWrite stop to finish ");
    

    }

}
class admin extends JFrame implements ActionListener {
    JMenu menu;
    JMenuItem a1, a2, a3;
    JTextField tf;
    JLabel l;
    JButton b1;
    admin() {

        menu = new JMenu("Admin Menu");
        JMenuBar m1 = new JMenuBar();
        a1 = new JMenuItem("Add Details");
        a2 = new JMenuItem("Delete details");
        a3 = new JMenuItem("Modify details");
        menu.add(a1);
        menu.add(a2);
        menu.add(a3);
        m1.add(menu);
        setJMenuBar(m1);

        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        b1 = new JButton("Submit");
        b1.setBounds(600, 600, 100, 100);
        add(b1);
        setSize(800, 800);
        setLocation(100, 100);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == a1) {
            tf = new JTextField();
            tf.setSize(150, 20);
            tf.setLocation(400, 400);
            add(tf);
            setVisible(true);
        } else if (evt.getSource() == a2) {
            l = new JLabel("Deleted");
            l.setSize(150, 20);
            l.setLocation(50, 0);
            add(l);
            setVisible(true);
        }
        else if (evt.getSource() == a3) {
            tf = new JTextField();
            tf.setSize(150, 20);
            tf.setLocation(300, 300);
            add(tf);
            setVisible(true);
        }
    }
}

class User extends JFrame implements ActionListener {
    JMenu menu;
    JMenuItem a1, a2;
    JTextField tf;
    JLabel l;

    User() {

        menu = new JMenu("User Menu");
        JMenuBar m1 = new JMenuBar();
        m1.setBorderPainted(true);
        a1 = new JMenuItem("View details by roll number");
        a2 = new JMenuItem("View details by name");
        menu.add(a1);
        menu.add(a2);
        m1.add(menu);
        setJMenuBar(m1);

        a1.addActionListener(this);
        a2.addActionListener(this);

        setSize(800, 800);
        setLocation(100, 100);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == a1) {
            
        } else if (evt.getSource() == a2) {
            
        } 
    }
}

