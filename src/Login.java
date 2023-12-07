import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    JButton rules, back,eye;
    JButton signup = new JButton("Sign up NOW!!");
    JTextField tfname;
    boolean passvis=false;
    JTextField useridInput = new JTextField();
    JPasswordField passwordInput = new JPasswordField(20);

    Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("Java Mini Project");
        title.setBounds(15, 15, 600, 45);
        title.setFont(new Font("Comic Sans", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        add(title);

        JLabel text1 = new JLabel("Don't Have an Account?");
        text1.setFont(new Font("Osward",Font.PLAIN,20));
        text1.setForeground(Color.WHITE);
        text1.setBounds(1000,40,900,100);
        add(text1,BorderLayout.NORTH);

        signup.addActionListener(this);
        signup.setBorderPainted(false);
        signup.setFocusPainted(false);
        signup.setContentAreaFilled(false);
        signup.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        signup.setBorder(new EmptyBorder(0, 0, 0, 0));
        signup.setForeground(Color.WHITE);
        signup.setBounds(953,90,200,50);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signup.setFont(new Font("Trebuchet MS",Font.PLAIN,17));
                signup.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signup.setFont(new Font("Trebuchet MS",Font.PLAIN,15));
                signup.setForeground(Color.WHITE);
            }
        });
        add(signup);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/quiztime1.jpg"));
        java.awt.Image originalImage = i1.getImage();
        java.awt.Image scaledImage = originalImage.getScaledInstance(512, 512, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 512, 512);
//        add(image);

        JLabel heading = new JLabel("CSE-DS Syllabus Quizzer");
        heading.setBounds(400, 300, 600, 45);
        heading.setFont(new Font("Comic Sans", Font.BOLD, 40));
        heading.setForeground(Color.WHITE);
        add(heading);

        rules = new JButton("Rules");
        rules.setFocusPainted(false);
        rules.addActionListener(this);
        rules.setForeground(Color.BLACK);
        rules.setBackground(Color.WHITE);
        rules.setBounds(525,495,200,50);
        add(rules);

        ImageIcon user1 = new ImageIcon(ClassLoader.getSystemResource("pics/user.png"));
        Image iuser1 = user1.getImage().getScaledInstance(25,25 , Image.SCALE_SMOOTH);
        user1 = new ImageIcon(iuser1);
        JLabel userlabel = new JLabel(user1);
        userlabel.setBounds(410,385,25,25);
        add(userlabel,BorderLayout.NORTH);

        JLabel userid = new JLabel("Email ID :");
        userid.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        userid.setForeground(Color.WHITE);
        userid.setBounds(448,350,900,100);
        add(userid,BorderLayout.NORTH);

        useridInput.setBounds(560,385,250,35);
        useridInput.setFont(new Font("Trebuchet MS",Font.PLAIN,15));
        add(useridInput);

        ImageIcon pass1 = new ImageIcon(ClassLoader.getSystemResource("pics/lock.png"));
        Image ipass1 = pass1.getImage().getScaledInstance(25,25 , Image.SCALE_SMOOTH);
        pass1 = new ImageIcon(ipass1);
        JLabel passlabel = new JLabel(pass1);
        passlabel.setBounds(410,435,25,25);
        add(passlabel,BorderLayout.NORTH);

        JLabel password = new JLabel("Password :");
        password.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        password.setForeground(Color.WHITE);
        password.setBounds(448,400,900,100);
        add(password,BorderLayout.NORTH);

        ImageIcon eye1 = new ImageIcon(ClassLoader.getSystemResource("pics/eye1.png"));
        Image ieye1 = eye1.getImage().getScaledInstance(20,20 , Image.SCALE_SMOOTH);
        eye1 = new ImageIcon(ieye1);
        eye = new JButton(eye1);
        eye.setBorderPainted(false);
        eye.setContentAreaFilled(false);
        eye.setFocusPainted(false);
        eye.addActionListener(this);
        eye.setBounds(810,440,25,25);
        add(eye);

        passwordInput.setBounds(560,435,250,35);
        passwordInput.setFont(new Font("Trebuchet MS",Font.PLAIN,15));
        add(passwordInput);

        JLabel backgroundLabel = getLabel();
        add(backgroundLabel);

        setSize(1280, 720);
        setLocation(150,75);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==rules){
            ConnectorSQL c = new ConnectorSQL();
            String userid = useridInput.getText();
            char[] passInput = passwordInput.getPassword();
            String passString = new String(passInput);
            String query1 = "select * from login where username = '"+userid+"' and pass = '"+passString+"'";
            try {
                ResultSet rs = c.s.executeQuery(query1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,"Login Successful!");
                    setVisible(false);
                    new Important_Info(userid);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials.");
                }
            } catch(Exception err){
                System.out.println(err);
            }
        }else if (ae.getSource()==signup) {
            setVisible(false);
            dispose();
            new Signup();
        }else if(ae.getSource()==eye){
            passvis = !passvis;
            if(passvis){
                passwordInput.setEchoChar((char) 0);
            }
            else{
                passwordInput.setEchoChar('•');
            }
        }
        else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static JLabel getLabel() {
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("pics/gradient.jpg"));
        Image bg1 = backgroundImage.getImage().getScaledInstance(1280,720 , Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(bg1);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        return backgroundLabel;
    }

    public static void main(String[] args) {
        new Login();
    }
}