package diningphil;

/*
 * CS409 Team Project
 * March 21, 2018
 * Tannenbaum's Solution to the Dining Philosophers Solution
 * Team 2
 * Matthew Annerton, Dina Brown, Tristan Cone, Quang Tran
 *
 * @author drums
 */

import com.intellij.ui.JBColor;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class DiningAppGui extends JFrame {

    /*
     * Declare private variables and arrays
     */
    private static final long serialVersionUID = -9102921349267475005L;
    private JPanel contentPane;
    private ArrayList<JLabel> forkLabelList = new ArrayList<>();
    private ArrayList<JLabel> philosopherLabelList = new ArrayList<>();
    private ArrayList<JProgressBar> progressBars = new ArrayList<>();
    private ArrayList<JLabel> thinkList = new ArrayList<>();
    private ArrayList<JLabel> finishedList = new ArrayList<>();
    private DiningApp diningApp;

    /*
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DiningAppGui frame = new DiningAppGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     * Create the frame.
     */
    public DiningAppGui() {
        setTitle("DINING PHILOSOPHERS BY GROUP 2");
        diningApp = new DiningApp();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 800);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);


        /* create table */
        ImageIcon tableIcon = new ImageIcon("/diningphil/resource/Layer 0-250pixels.png");
        JLabel roundTable = new JLabel(tableIcon, JLabel.CENTER);
        roundTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/Layer 0-250pixels.png")));
        roundTable.setBounds(375, 316, 250, 250); //345, 290, 250 , 250)
        roundTable.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(roundTable);

        /* legend */
//        JLabel legend = new JLabel();
//        legend.setOpaque(true);
//        legend.setBackground(Color.LIGHT_GRAY);
//        legend.setVisible(true);
//        legend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/Green.png")));
//        legend.setBounds(20, 240, 100, 250);
//        contentPane.add(legend);

        /* Text area*/
        JTextArea txtrObserveTheDining = new JTextArea();
        txtrObserveTheDining.setEditable(false);
        txtrObserveTheDining.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        txtrObserveTheDining.setLineWrap(true);
        txtrObserveTheDining.setText("- 5 philosophers sit at a table\r\n" +
                "- There are only 5 forks on the table \r\n" +
                "- They are all hungry & want to eat\r\n" +
                "- They can only eat when the fork to the left & right of them are both available\r\n" +
                "- After eating for a period, they then take a nap \r\n" +
                "- The color Green around a philosopher symbolizes that he is eating.");
        txtrObserveTheDining.setBounds(40, 11, 843, 141);
        contentPane.add(txtrObserveTheDining);

        /*Creating Philosopher 1: David Hume.*/
        ImageIcon icon = new ImageIcon("/diningphil/resource/David_Hume.png");
        JLabel lblPhilosopher_1 = new JLabel(icon, JLabel.CENTER);
        lblPhilosopher_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/David_Hume.png")));
        lblPhilosopher_1.setOpaque(true);
        lblPhilosopher_1.setForeground(Color.WHITE);
        lblPhilosopher_1.setBackground(Color.BLACK);
        lblPhilosopher_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhilosopher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPhilosopher_1.setBounds(580, 240, 142, 70);
        philosopherLabelList.add(lblPhilosopher_1);
        contentPane.add(lblPhilosopher_1);
        /* Thinking...*/
        JLabel Thinking = new JLabel("Thinking...");
        Thinking.setVisible(false);
        Thinking.setBounds(732, 240, 65, 14);
        thinkList.add(Thinking);
        contentPane.add(Thinking);
        /*Progress bar*/
        JProgressBar progressBar_1 = new JProgressBar();
        progressBar_1.setForeground(Color.RED);
        progressBar_1.setBackground(new Color(51, 204, 255));
        progressBar_1.setMaximum(50);
        progressBar_1.setBounds(580, 195, 142, 22);
        progressBars.add(progressBar_1);
        contentPane.add(progressBar_1);
        JTextArea progressBarTxt_1 = new JTextArea();
        progressBarTxt_1.setEditable(false);
        progressBarTxt_1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        progressBarTxt_1.setLineWrap(true);
        progressBarTxt_1.setText("Hunger Level");
        progressBarTxt_1.setBounds(590, 173, 142, 22);
        contentPane.add(progressBarTxt_1);
        /* Finished Eating */
        JLabel lblFinishedEating1 = new JLabel("Finished eating");
        lblFinishedEating1.setOpaque(true);
        lblFinishedEating1.setVisible(false);
        lblFinishedEating1.setBackground(Color.GREEN);
        lblFinishedEating1.setBounds(732, 240, 108, 20);
        finishedList.add(lblFinishedEating1);
        contentPane.add(lblFinishedEating1);

        /*Creating Philosopher 2: René_Descartes.*/
        ImageIcon icon2 = new ImageIcon("/diningphil/resource/René_Descartes.png");
        JLabel lblPhilosopher_2 = new JLabel(icon2, JLabel.CENTER);
        lblPhilosopher_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/René_Descartes.png")));
        lblPhilosopher_2.setOpaque(true);
        lblPhilosopher_2.setForeground(Color.WHITE);
        lblPhilosopher_2.setBackground(Color.BLACK);
        lblPhilosopher_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhilosopher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPhilosopher_2.setBounds(640, 460, 142, 70);
        philosopherLabelList.add(lblPhilosopher_2);
        contentPane.add(lblPhilosopher_2);
        /* Thinking... */
        JLabel Thinking2 = new JLabel("Thinking...");
        Thinking2.setVisible(false);
        Thinking2.setBounds(782, 470, 65, 14);
        thinkList.add(Thinking2);
        contentPane.add(Thinking2);
        /*Progress bar*/
        JProgressBar progressBar_2 = new JProgressBar();
        progressBar_2.setForeground(Color.RED);
        progressBar_2.setBackground(new Color(51, 204, 255));
        progressBar_2.setMaximum(50);
        progressBar_2.setBounds(640, 415, 142, 22);
        progressBars.add(progressBar_2);
        contentPane.add(progressBar_2);
        JTextArea progressBarTxt_2 = new JTextArea();
        progressBarTxt_2.setEditable(false);
        progressBarTxt_2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        progressBarTxt_2.setLineWrap(true);
        progressBarTxt_2.setText("Hunger Level");
        progressBarTxt_2.setBounds(640, 393, 142, 22);
        contentPane.add(progressBarTxt_2);
        /* Finished eating */
        JLabel lblFinishedEating2 = new JLabel("Finished eating");
        lblFinishedEating2.setOpaque(true);
        lblFinishedEating2.setVisible(false);
        lblFinishedEating2.setBackground(Color.GREEN);
        lblFinishedEating2.setBounds(792, 490, 108, 20);
        finishedList.add(lblFinishedEating2);
        contentPane.add(lblFinishedEating2);

        /* Creating Philosopher 3: John_Lock. */
        ImageIcon icon3 = new ImageIcon("/diningphil/resource/John_Lock.jpng");
        JLabel lblPhilosopher_3 = new JLabel(icon3, JLabel.CENTER);
        lblPhilosopher_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/John_Lock.png")));
        lblPhilosopher_3.setOpaque(true);
        lblPhilosopher_3.setForeground(Color.WHITE);
        lblPhilosopher_3.setBackground(Color.BLACK);
        lblPhilosopher_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhilosopher_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPhilosopher_3.setBounds(420, 645, 142, 70);
        philosopherLabelList.add(lblPhilosopher_3);
        contentPane.add(lblPhilosopher_3);
        /* Thinking .. */
        JLabel Thinking3 = new JLabel("Thinking...");
        Thinking3.setVisible(false);
        Thinking3.setBounds(572, 645, 65, 14);
        thinkList.add(Thinking3);
        contentPane.add(Thinking3);
        /*Progress bar*/
        JProgressBar progressBar_3 = new JProgressBar();
        progressBar_3.setForeground(Color.RED);
        progressBar_3.setBackground(new Color(51, 204, 255));
        progressBar_3.setMaximum(50);
        progressBar_3.setBounds(417, 603, 142, 22);
        progressBars.add(progressBar_3);
        contentPane.add(progressBar_3);
        JTextArea progressBarTxt_3 = new JTextArea();
        progressBarTxt_3.setEditable(false);
        progressBarTxt_3.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        progressBarTxt_3.setLineWrap(true);
        progressBarTxt_3.setText("Hunger Level");
        progressBarTxt_3.setBounds(417, 583, 142, 22);
        contentPane.add(progressBarTxt_3);
        /* Finished eating */
        JLabel lblFinishedEating3 = new JLabel("Finished eating");
        lblFinishedEating3.setOpaque(true);
        lblFinishedEating3.setVisible(false);
        lblFinishedEating3.setBackground(Color.GREEN);
        lblFinishedEating3.setBounds(572, 665, 108, 20);
        finishedList.add(lblFinishedEating3);
        contentPane.add(lblFinishedEating3);

        /*Creating Philosopher 4: Mandeville */
        ImageIcon icon4 = new ImageIcon("/diningphil/resource/Mandeville.png");
        JLabel lblPhilosopher_4 = new JLabel(icon4, JLabel.CENTER);
        lblPhilosopher_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/Mandeville.png")));
        lblPhilosopher_4.setOpaque(true);
        lblPhilosopher_4.setForeground(Color.WHITE);
        lblPhilosopher_4.setBackground(Color.BLACK);
        lblPhilosopher_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhilosopher_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPhilosopher_4.setBounds(215, 460, 142, 70);
        philosopherLabelList.add(lblPhilosopher_4);
        contentPane.add(lblPhilosopher_4);
        /* Thinking .. */
        JLabel Thinking4 = new JLabel("Thinking...");
        Thinking4.setVisible(false);
        Thinking4.setBounds(135, 460, 65, 14);
        thinkList.add(Thinking4);
        contentPane.add(Thinking4);
        /*Progress bar*/
        JProgressBar progressBar_4 = new JProgressBar();
        progressBar_4.setForeground(Color.RED);
        progressBar_4.setBackground(new Color(51, 204, 255));
        progressBar_4.setMaximum(50);
        progressBar_4.setBounds(215, 415, 142, 22);
        progressBars.add(progressBar_4);
        contentPane.add(progressBar_4);
        JTextArea progressBarTxt_4 = new JTextArea();
        progressBarTxt_4.setEditable(false);
        progressBarTxt_4.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        progressBarTxt_4.setLineWrap(true);
        progressBarTxt_4.setText("Hunger Level");
        progressBarTxt_4.setBounds(215, 395, 142, 22);
        contentPane.add(progressBarTxt_4);
        /* Finished Eating */
        JLabel lblFinishedEating4 = new JLabel("Finished eating");
        lblFinishedEating4.setOpaque(true);
        lblFinishedEating4.setVisible(false);
        lblFinishedEating4.setBackground(Color.GREEN);
        lblFinishedEating4.setBounds(135, 480, 108, 20);
        finishedList.add(lblFinishedEating4);
        contentPane.add(lblFinishedEating4);

        /*Creating Philosopher 5: adam-smith */
        ImageIcon icon5 = new ImageIcon("/diningphil/resource/adam-smith.png");
        JLabel lblPhilosopher = new JLabel(icon5, JLabel.CENTER);
        lblPhilosopher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/adam-smith.png")));
        lblPhilosopher.setOpaque(true);
        lblPhilosopher.setBackground(Color.BLACK);
        lblPhilosopher.setForeground(Color.WHITE);
        lblPhilosopher.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhilosopher.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPhilosopher.setBounds(250, 240, 142, 70);
        philosopherLabelList.add(lblPhilosopher);
        contentPane.add(lblPhilosopher);
        /* Thinking .. */
        JLabel Thinking5 = new JLabel("Thinking...");
        Thinking5.setVisible(false);
        Thinking5.setBounds(170, 240, 65, 14);
        thinkList.add(Thinking5);
        contentPane.add(Thinking5);
        /*Progress bar*/
        JProgressBar progressBar_5 = new JProgressBar();
        progressBar_5.setForeground(Color.RED);
        progressBar_5.setBackground(new Color(51, 204, 255));
        progressBar_5.setMaximum(50);
        progressBar_5.setBounds(250, 195, 142, 22);
        progressBars.add(progressBar_5);
        contentPane.add(progressBar_5);
        JTextArea progressBarTxt_5 = new JTextArea();
        progressBarTxt_5.setEditable(false);
        progressBarTxt_5.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        progressBarTxt_5.setLineWrap(true);
        progressBarTxt_5.setText("Hunger Level");
        progressBarTxt_5.setBounds(250, 175, 142, 22);
        contentPane.add(progressBarTxt_5);
        /* Finished Eating */
        JLabel lblFinishedEating5 = new JLabel("Finished eating");
        lblFinishedEating5.setOpaque(true);
        lblFinishedEating5.setVisible(false);
        lblFinishedEating5.setBackground(Color.GREEN);
        lblFinishedEating5.setBounds(170, 260, 108, 20);
        finishedList.add(lblFinishedEating5);
        contentPane.add(lblFinishedEating5);

        JLabel lblFork_1 = new JLabel("fork 1");
        lblFork_1.setBackground(new Color(205, 92, 92));
        lblFork_1.setOpaque(true);
        lblFork_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblFork_1.setBounds(620, 350, 66, 27);
        forkLabelList.add(lblFork_1);
        contentPane.add(lblFork_1);

        JLabel lblFork_2 = new JLabel("fork 2");
        lblFork_2.setBackground(new Color(205, 92, 92));
        lblFork_2.setOpaque(true);
        lblFork_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblFork_2.setBounds(590, 550, 66, 27);
        forkLabelList.add(lblFork_2);
        contentPane.add(lblFork_2);

        JLabel lblFork_3 = new JLabel("fork 3");
        lblFork_3.setBackground(new Color(205, 92, 92));
        lblFork_3.setOpaque(true);
        lblFork_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblFork_3.setBounds(350, 550, 66, 27);
        forkLabelList.add(lblFork_3);
        contentPane.add(lblFork_3);

        JLabel lblFork_4 = new JLabel("fork 4");
        lblFork_4.setBackground(new Color(205, 92, 92));
        lblFork_4.setOpaque(true);
        lblFork_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblFork_4.setBounds(290, 350, 66, 27);
        forkLabelList.add(lblFork_4);
        contentPane.add(lblFork_4);

        JLabel lblFork_5 = new JLabel("fork 5");
        lblFork_5.setBackground(new Color(205, 92, 92));
        lblFork_5.setOpaque(true);
        lblFork_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblFork_5.setBounds(460, 280, 66, 27);
        forkLabelList.add(lblFork_5);
        contentPane.add(lblFork_5);


        startDining();
    }



    private void startDining() {
        diningApp.start();
        Timer timer = new Timer();
        /* execution is scheduled relative to the scheduled execution time of the initial execution */
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Philosopher philosopher : diningApp.getPhilosophers()) {
                    if (!philosopher.isFinished()) {
                        updateGui();
                    } else {
                        timeForBed(philosopher);
                    }
                }
            }
        }, 2000, 1000);
    }

    protected void timeForBed(Philosopher philosopher) {
        switch (philosopher.getName()) {
            case "Philosopher: 1":
                finishedList.get(0).setVisible(true);
                break;
            case "Philosopher: 2":
                finishedList.get(1).setVisible(true);
                break;
            case "Philosopher: 3":
                finishedList.get(2).setVisible(true);
                break;
            case "Philosopher: 4":
                finishedList.get(3).setVisible(true);
                break;
            case "Philosopher: 5":
                finishedList.get(4).setVisible(true);
                break;
            default:
                break;
        }
    }

    private void updateGui() {
        int philosopherCounter = 0;
        for (Philosopher philosopher : diningApp.getPhilosophers()) {
            progressBars.get(philosopherCounter).setValue(philosopher.getAmountEaten());
            ++philosopherCounter;
        }
        setPhilosopherColour();
        checkIfThinking();
    }

    private void checkIfThinking() {
        for (Philosopher philosopher : diningApp.getPhilosophers()) {
            if (philosopher.isThinking()) {
                startThinking(philosopher);
            } else {
                stopThinking(philosopher);
            }
        }
    }

    private void stopThinking(Philosopher philosopher) {
        switch (philosopher.getName()) {
            case "Philosopher: 1":
                thinkList.get(0).setVisible(false);
                break;
            case "Philosopher: 2":
                thinkList.get(1).setVisible(false);
                break;
            case "Philosopher: 3":
                thinkList.get(2).setVisible(false);
                break;
            case "Philosopher: 4":
                thinkList.get(3).setVisible(false);
                break;
            case "Philosopher: 5":
                thinkList.get(4).setVisible(false);
                break;
            default:
                break;
        }
    }

    private void startThinking(Philosopher philosopher) {
        switch (philosopher.getName()) {
            case "Philosopher: 1":
                thinkList.get(0).setVisible(true);
                break;
            case "Philosopher: 2":
                thinkList.get(1).setVisible(true);
                break;
            case "Philosopher: 3":
                thinkList.get(2).setVisible(true);
                break;
            case "Philosopher: 4":
                thinkList.get(3).setVisible(true);
                break;
            case "Philosopher: 5":
                thinkList.get(4).setVisible(true);
                break;
            default:
                break;
        }
    }

    public void setPhilosopherColour() {
        for (Philosopher philosopher : diningApp.getPhilosophers()) {
            if (philosopher.isEating()) {
                changeColourToGreen(philosopher);
            } else {
                changeColourToBlack(philosopher);
            }
        }
    }

    private void changeColourToBlack(Philosopher philosopher) {
        switch (philosopher.getName()) {
            case "Philosopher: 1":
                philosopherLabelList.get(0).setBackground(Color.BLACK);

                break;
            case "Philosopher: 2":
                philosopherLabelList.get(1).setBackground(Color.BLACK);

                break;
            case "Philosopher: 3":
                philosopherLabelList.get(2).setBackground(Color.BLACK);

                break;
            case "Philosopher: 4":
                philosopherLabelList.get(3).setBackground(Color.BLACK);

                break;
            case "Philosopher: 5":
                philosopherLabelList.get(4).setBackground(Color.BLACK);

                break;
            default:
                break;
        }
    }

    private void changeColourToGreen(Philosopher philosopher) {
        switch (philosopher.getName()) {
            case "Philosopher: 1":
                philosopherLabelList.get(0).setBackground(Color.GREEN);
                break;
            case "Philosopher: 2":
                philosopherLabelList.get(1).setBackground(Color.GREEN);
                break;
            case "Philosopher: 3":
                philosopherLabelList.get(2).setBackground(Color.GREEN);
                break;
            case "Philosopher: 4":
                philosopherLabelList.get(3).setBackground(Color.GREEN);
                break;
            case "Philosopher: 5":
                philosopherLabelList.get(4).setBackground(Color.GREEN);
                break;
            default:
                break;
        }
    }
}
