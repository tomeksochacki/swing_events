package testswingnextexerciseexample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{

    public Main(){

        super("Events");
        this.setBounds(300, 300, 300, 200);
        initComponents();
        this.setDefaultCloseOperation(3);
    }

    public void initComponents(){

        colorRed = new JButton("Red");
        colorBlack = new JButton("Black");
        colorBlue = new JButton("Blue");

        colorBlue.addActionListener(this);

        colorRed.addActionListener(new ListenerColors(Color.RED));
        //colorBlack.addActionListener(new ListenerColors(Color.BLACK));

        this.panel.add(colorRed);
        this.panel.add(colorBlack);
        this.panel.add(colorBlue);

        this.getContentPane().add(panel);

        buildButton("Green", Color.GREEN);

        colorBlack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLACK);
            }
        });


    }
    JPanel panel = new JPanel();
    JButton colorRed;
    JButton colorBlack;
    JButton colorBlue;

    public void buildButton(String name, final Color color){
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(color);
            }
        });
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == colorBlue)
            panel.setBackground(Color.BLUE);

    }

    private class ListenerColors implements ActionListener{

        public ListenerColors(Color c){
            this.color = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        panel.setBackground(color);
        }

        Color color;
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
