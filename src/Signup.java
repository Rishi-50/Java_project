import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {

    JButton signup;
    JLabel alert,alert1,namealert;
    JButton back;
    JTextField username,pass1,pass2;
    Signup(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("REGISTRATION");
        heading.setBounds(500, 150, 600, 45);
        heading.setFont(new Font("Comic Sans", Font.BOLD, 40));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel usertext = new JLabel("Username : ");
        usertext.setFont(new Font("Osward",Font.PLAIN,25));
        usertext.setForeground(Color.WHITE);
        usertext.setBounds(400,250,900,25);
        add(usertext);

        username = new JTextField();
        username.setBounds(575,250,250,35);
        add(username);

        namealert = new JLabel("Passwords Don't Match!");
        namealert.setFont(new Font("Osward",Font.PLAIN,18));
        namealert.setForeground(Color.RED);
        namealert.setBounds(575,285 ,900,25);
        namealert.setVisible(false);
        add(namealert);

        JLabel passtext = new JLabel("Password : ");
        passtext.setFont(new Font("Osward",Font.PLAIN,25));
        passtext.setForeground(Color.WHITE);
        passtext.setBounds(405,325,900,25);
        add(passtext);

        pass1 = new JTextField();
        pass1.setBounds(575,325,250,35);
        add(pass1);

        alert = new JLabel("Passwords Don't Match!");
        alert.setFont(new Font("Osward",Font.PLAIN,18));
        alert.setForeground(Color.RED);
        alert.setBounds(575,360,900,25);
        alert.setVisible(false);
        add(alert);

        JLabel passtext2 = new JLabel("Re-enter Password : ");
        passtext2.setFont(new Font("Osward",Font.PLAIN,25));
        passtext2.setForeground(Color.WHITE);
        passtext2.setBounds(305,400,900,25);
        add(passtext2);

        pass2 = new JTextField();
        pass2.setBounds(575,400,250,35);
        add(pass2);

        alert1 = new JLabel("Passwords Don't Match!");
        alert1.setFont(new Font("Osward",Font.PLAIN,18));
        alert1.setForeground(Color.RED);
        alert1.setBounds(575,435,900,25);
        alert1.setVisible(false);
        add(alert1);

        signup = new JButton("Register");
        signup.addActionListener(this);
        signup.setFocusPainted(false);
        signup.setForeground(Color.BLACK);
        signup.setBackground(Color.WHITE);
        signup.setBounds(525,495,200,50);
        add(signup);

        JLabel backgroundLabel = getLabel();
        add(backgroundLabel);

        setSize(1280, 720);
        setLocation(150,75);
        setVisible(true);
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
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==signup){
            namealert.setVisible(false);
            alert.setVisible(false);
            alert1.setVisible(false);
            String uname = username.getText();
            String p1 = pass1.getText();
            System.out.println(p1);
            String p2 = pass2.getText();
            if(uname.isEmpty()){
                System.out.println("P1 checker - "+p1);
                namealert.setText("Username Cannot be Empty!");
                namealert.setVisible(true);
            }
            else if(p1.isEmpty()){
                System.out.println("P1 checker - "+p1);
                alert.setText("Password Cannot be Empty!");
                alert.setVisible(true);
            }
            else if(p2.isEmpty()){
                alert1.setText("Password Cannot be Empty!");
                alert1.setVisible(true);
            }
            else if(!p1.equals(p2)){
                alert.setText("Passwords Don't Match!");
                alert.setVisible(true);
                alert1.setText("Passwords Don't Match!");
                alert1.setVisible(true);
            }
            else{
                try{
                    ConnectorSQL c = new ConnectorSQL();
                    String query = "insert into login values('"+uname+"', '"+p1+"', '"+0+"', '"+0+"', '"+0+"')";
                    c.s.executeUpdate(query);
                    System.out.println("Added to DB!");
                    setVisible(false);
                    dispose();
                    new Login();
                }catch (Exception err){
                    System.out.println(err);
                }
            }
        }
    }
}