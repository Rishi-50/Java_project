import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Important_Info extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    JRadioButton TSA,JSL,IS;
    ButtonGroup groupoptions;
    JLabel alert;
    Important_Info(String name) {
        this.name = name;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to the CSE-DS Syllabus Quizzer!");
        heading.setBounds(280, 15, 900, 30);
        heading.setFont(new Font("Verdana", Font.BOLD, 25));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(300, 35, 700, 500);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>" +
                        "1. Remember, you're here to quiz, not to compose poetry. Keep your answers pointy and to the pointy." + "<br><br>" +
                        "2. No unnecessary smiling at your neighbor. They might not know the answer either, and it's not a secret code for help." + "<br><br>" +
                        "3. In life, you have options. In this quiz, you have obligations. All questions are compulsory, like waking up on Mondays." + "<br><br>" +
                        "4. Crying is allowed, but please use your quiz paper to soak up those tears. We're here for laughs, not waterworks." + "<br><br>" +
                        "5. Only fools ask questions. Be the wise one answering. Wisdom is your superpower, not a cape." + "<br><br>" +
                        "6. If your friend is answering more questions, they might be doing the 'Jai Mata Di' chant under the desk. You do you." + "<br><br>" +
                        "7. Brace yourself! This quiz is not for the faint-hearted. It's like a roller coaster, but with fewer safety instructions." + "<br><br>" +
                        "8. May you know more than what John Snow knows (and he knows nothing). Good luck, and may the quiz odds be ever in your favor!" + "<br><br>" +
                        "<html>"
        );
        rules.setForeground(Color.WHITE);
        add(rules);


        TSA = new JRadioButton();
        TSA.setText("Time-Series Analysis");
        TSA.setBounds(250, 525, 200, 30);
        TSA.setForeground(Color.WHITE);
        TSA.setOpaque(false);
        TSA.setFocusPainted(false);
        TSA.setFont(new Font("Dialog", Font.PLAIN, 17));
        add(TSA);

        JSL = new JRadioButton();
        JSL.setText("Java Scala Language");
        JSL.setBounds(525, 525, 200, 30);
        JSL.setForeground(Color.WHITE);
        JSL.setOpaque(false);
        JSL.setFocusPainted(false);
        JSL.setFont(new Font("Dialog", Font.PLAIN, 17));
        add(JSL);

        IS = new JRadioButton();
        IS.setText("Information Security");
        IS.setBounds(810, 525, 200, 30);
        IS.setForeground(Color.WHITE);
        IS.setFocusPainted(false);
        IS.setOpaque(false);
        IS.setFont(new Font("Dialog", Font.PLAIN, 17));
        add(IS);

        groupoptions = new ButtonGroup();
        groupoptions.add(TSA);
        groupoptions.add(JSL);
        groupoptions.add(IS);

        alert = new JLabel("!!! Please Choose A Subject to be Quizzed on.");
        alert.setFont(new Font("Verdana",Font.BOLD,15));
        alert.setForeground(Color.RED);
        alert.setBounds(300,560,500,30);
        alert.setVisible(false);
        add(alert);

        back = new JButton("Back");
        back.setBounds(295, 600, 125, 45);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Verdana",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(850, 600, 125, 45);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Verdana",Font.PLAIN,16));
        start.addActionListener(this);
        add(start);

        JLabel label = getLabel();
        add(label);

        setSize(1280, 720);
        setLocation(150, 100);
        setVisible(true);
    }
    public static JLabel getLabel() {
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("pics/gradientbg.png"));
        Image bg1 = backgroundImage.getImage().getScaledInstance(backgroundImage.getIconWidth(),backgroundImage.getIconHeight() , Image.SCALE_DEFAULT);
        backgroundImage = new ImageIcon(bg1);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        return backgroundLabel;
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == start) {
            if(groupoptions.getSelection() == null){
                alert.setVisible(true);
            }
            else{
                String choice="";
                if(TSA.isSelected()){
                    choice = "TimeSeriesQuestions";
                } else if (JSL.isSelected()) {
                    choice="JavaScalaQuestions";
                }else if(IS.isSelected()){
                    choice="InfoSysQuestions";
                }
                setVisible(false);
                System.out.println(choice);
                new Quiz(name,choice);
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Important_Info("Shreenissh");
    }
}