import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quiz extends JFrame implements ActionListener {

    static String[][] quizdata = new String[10][7];
//    String[][] answers = new String[10][2];
    String[][] useranswers = new String[10][1];
    String subjectname;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    public static void question_fetcher(String subject){
        String sqlQuery = "SELECT Qno, Qtext, Opt1, Opt2, Opt3, Opt4, CorrAns FROM "+subject;

        try{
            ConnectorSQL c = new ConnectorSQL();
            ResultSet resultSet = c.s.executeQuery(sqlQuery);

            // Iterate through the result set and populate the array
            int row = 0;
            while (resultSet.next()) {
                quizdata[row][0] = resultSet.getString("Qno");
                quizdata[row][1] = resultSet.getString("Qtext");
                quizdata[row][2] = resultSet.getString("Opt1");
                quizdata[row][3] = resultSet.getString("Opt2");
                quizdata[row][4] = resultSet.getString("Opt3");
                quizdata[row][5] = resultSet.getString("Opt4");
                quizdata[row][6] = resultSet.getString("CorrAns");
                row++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

////         Print the fetched data (optional)
//        for (String[] row : quizdata) {
//            for (String value : row) {
//                System.out.print(value + "\t");
//            }
//            System.out.println();
//        }
    }
    Quiz(String name,String subject) {
        this.name = name;
        this.subjectname = subject;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        question_fetcher(subject);

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                System.out.println("Ans stored - "+useranswers[count][0]);
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                String ans = quizdata[i][6].toLowerCase();
                int x = switch (ans) {
                    case "a" -> 2;
                    case "b" -> 3;
                    case "c" -> 4;
                    case "d" -> 5;
                    default -> 0;
                };
                if (useranswers[i][0].equals(quizdata[i][x])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            try{
                ConnectorSQL c = new ConnectorSQL();
                String subjecttable="TSAScore";
                if(subjectname.equals("TimeSeriesQuestions")){
                    subjecttable="TSAScore";
                } else if (subjectname.equals("JavaScalaQuestions")) {
                    subjecttable="JSLScore";
                } else if (subjectname.equals("InfoSysQuestions")) {
                    subjecttable="ISScore";
                }
                String query = "UPDATE login SET "+subjecttable+" = '"+score+"' WHERE username = '"+name+"'";
                c.s.executeUpdate(query);
                System.out.println("Added to DB!");
                setVisible(false);
                dispose();
                new Score(name,score);
            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
            System.out.println(score);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    String ans = quizdata[i][6].toLowerCase();
                    int x = switch (ans) {
                        case "a" -> 2;
                        case "b" -> 3;
                        case "c" -> 4;
                        case "d" -> 5;
                        default -> 0;
                    };
                    if (useranswers[i][0].equals(quizdata[i][x])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {

        qno.setText("" + (count + 1) + ". ");
        question.setText(quizdata[count][1]);
        opt1.setText(quizdata[count][2]);
        opt1.setActionCommand(quizdata[count][2]);

        opt2.setText(quizdata[count][3]);
        opt2.setActionCommand(quizdata[count][3]);

        opt3.setText(quizdata[count][4]);
        opt3.setActionCommand(quizdata[count][4]);

        opt4.setText(quizdata[count][5]);
        System.out.println("Opt 4 text - "+opt4.getText());
        opt4.setActionCommand(quizdata[count][5]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("rishi123","JavaScalaQuestions");
    }
}