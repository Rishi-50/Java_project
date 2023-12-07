import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 720);
        setLocation(150,75);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/score.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 338, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 200, 450, 338);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for practicing the DS Syllabus Quiz");
        heading.setBounds(45, 30, 1300, 50);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 38));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel lblscore = new JLabel("Your scores -  ");
        lblscore.setBounds(550, 200, 300, 50);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblscore.setForeground(Color.WHITE);
        add(lblscore);

        JLabel TSAScore = new JLabel("TSA -  ");
        TSAScore.setBounds(550, 275, 300, 30);
        TSAScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
        TSAScore.setForeground(Color.WHITE);
        add(TSAScore);

        JLabel JSLScore = new JLabel("JSL  -  ");
        JSLScore.setBounds(550, 335, 300, 30);
        JSLScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
        JSLScore.setForeground(Color.WHITE);
        add(JSLScore);

        JLabel ISScore = new JLabel("IS   -  ");
        ISScore.setBounds(550, 395, 300, 30);
        ISScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
        ISScore.setForeground(Color.WHITE);
        add(ISScore);

        try{
            ConnectorSQL c = new ConnectorSQL();
            String query = "SELECT TSAScore, JSLScore, ISScore FROM login WHERE username = '" + name + "'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                TSAScore.setText("TSA -  "+rs.getString("TSAScore"));
                JSLScore.setText("JSL  -  "+rs.getString("JSLScore"));
                ISScore.setText("IS   -  "+rs.getString("ISScore"));
            }
            System.out.println("Connected to DB!");
        }catch(Exception e){
            System.out.println(e);
        }

        JButton submit = new JButton("Play Again");
        submit.setBounds(680, 570, 120, 30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        JLabel backgroundLabel = getLabel();
        add(backgroundLabel);

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

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        setVisible(false);
        dispose();
        new Login();
    }

    public static void main(String[] args) {
        new Score("rishi123", 0);
    }
}