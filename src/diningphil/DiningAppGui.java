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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingConstants;
import java.awt.Color;
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
private ArrayList<JLabel> zzzList = new ArrayList<>();
private ArrayList<JLabel> finishedList = new ArrayList<>();
private DiningApp diningApp;

/**
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

/**
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
    
    //create table
    ImageIcon tableIcon = new ImageIcon("/diningphil/resource/Layer 0-250pixels.png");
    JLabel roundTable = new JLabel(tableIcon, JLabel.CENTER);
    roundTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/Layer 0-250pixels.png")));
    roundTable.setBounds(355, 316, 250 , 250); //345, 290, 250 , 250)
    roundTable.setHorizontalAlignment(SwingConstants.CENTER);
    contentPane.add(roundTable);
    
    
    ImageIcon icon = new ImageIcon("/diningphil/resource/David_Hume.png");
    JLabel lblPhilosopher_1 = new JLabel(icon, JLabel.CENTER);
    lblPhilosopher_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/David_Hume.png")));
    lblPhilosopher_1.setOpaque(true);
    lblPhilosopher_1.setForeground(Color.WHITE);
    lblPhilosopher_1.setBackground(Color.BLACK);
    lblPhilosopher_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblPhilosopher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPhilosopher_1.setBounds(560, 240, 142, 70);
    philosopherLabelList.add(lblPhilosopher_1);
    contentPane.add(lblPhilosopher_1);


    ImageIcon icon2 = new ImageIcon("/diningphil/resource/René_Descartes.png");
    JLabel lblPhilosopher_2 = new JLabel(icon2, JLabel.CENTER);
    lblPhilosopher_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/René_Descartes.png")));
    lblPhilosopher_2.setOpaque(true);
    lblPhilosopher_2.setForeground(Color.WHITE);
    lblPhilosopher_2.setBackground(Color.BLACK);
    lblPhilosopher_2.setHorizontalAlignment(SwingConstants.CENTER);
    lblPhilosopher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPhilosopher_2.setBounds(620, 460, 142, 70);
    philosopherLabelList.add(lblPhilosopher_2);
    contentPane.add(lblPhilosopher_2);

    ImageIcon icon3 = new ImageIcon("/diningphil/resource/John_Lock.jpng");
    JLabel lblPhilosopher_3 = new JLabel(icon3, JLabel.CENTER);
    lblPhilosopher_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/John_Lock.png")));
    lblPhilosopher_3.setOpaque(true);
    lblPhilosopher_3.setForeground(Color.WHITE);
    lblPhilosopher_3.setBackground(Color.BLACK);
    lblPhilosopher_3.setHorizontalAlignment(SwingConstants.CENTER);
    lblPhilosopher_3.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPhilosopher_3.setBounds(400, 625, 142, 70);
    philosopherLabelList.add(lblPhilosopher_3);
    contentPane.add(lblPhilosopher_3);

    ImageIcon icon4 = new ImageIcon("/diningphil/resource/Mandeville.png");
    JLabel lblPhilosopher_4 = new JLabel(icon4, JLabel.CENTER);
    lblPhilosopher_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/Mandeville.png")));
    lblPhilosopher_4.setOpaque(true);
    lblPhilosopher_4.setForeground(Color.WHITE);
    lblPhilosopher_4.setBackground(Color.BLACK);
    lblPhilosopher_4.setHorizontalAlignment(SwingConstants.CENTER);
    lblPhilosopher_4.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPhilosopher_4.setBounds(195, 460, 142, 70);
    philosopherLabelList.add(lblPhilosopher_4);
    contentPane.add(lblPhilosopher_4);

    ImageIcon icon5 = new ImageIcon("/diningphil/resource/adam-smith.png");
    JLabel lblPhilosopher = new JLabel(icon5, JLabel.CENTER);
    lblPhilosopher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningphil/resource/adam-smith.png")));
    lblPhilosopher.setOpaque(true);
    lblPhilosopher.setBackground(Color.BLACK);
    lblPhilosopher.setForeground(Color.WHITE);
    lblPhilosopher.setHorizontalAlignment(SwingConstants.CENTER);
    lblPhilosopher.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPhilosopher.setBounds(230, 240, 142, 70);
    philosopherLabelList.add(lblPhilosopher);
    contentPane.add(lblPhilosopher);

    JLabel lblFork_1 = new JLabel("fork 1");
    lblFork_1.setBackground(new Color(205, 92, 92));
    lblFork_1.setOpaque(true);
    lblFork_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblFork_1.setBounds(600, 370, 66, 27);
    forkLabelList.add(lblFork_1);
    contentPane.add(lblFork_1);

    JLabel lblFork_2 = new JLabel("fork 2");
    lblFork_2.setBackground(new Color(205, 92, 92));
    lblFork_2.setOpaque(true);
    lblFork_2.setHorizontalAlignment(SwingConstants.CENTER);
    lblFork_2.setBounds(570, 550, 66, 27);
    forkLabelList.add(lblFork_2);
    contentPane.add(lblFork_2);

    JLabel lblFork_3 = new JLabel("fork 3");
    lblFork_3.setBackground(new Color(205, 92, 92));
    lblFork_3.setOpaque(true);
    lblFork_3.setHorizontalAlignment(SwingConstants.CENTER);
    lblFork_3.setBounds(320, 550, 66, 27);
    forkLabelList.add(lblFork_3);
    contentPane.add(lblFork_3);

    JLabel lblFork_4 = new JLabel("fork 4");
    lblFork_4.setBackground(new Color(205, 92, 92));
    lblFork_4.setOpaque(true);
    lblFork_4.setHorizontalAlignment(SwingConstants.CENTER);
    lblFork_4.setBounds(270, 370, 66, 27);
    forkLabelList.add(lblFork_4);
    contentPane.add(lblFork_4);

    JLabel lblFork_5 = new JLabel("fork 5");
    lblFork_5.setBackground(new Color(205, 92, 92));
    lblFork_5.setOpaque(true);
    lblFork_5.setHorizontalAlignment(SwingConstants.CENTER);
    lblFork_5.setBounds(440, 280, 66, 27);
    forkLabelList.add(lblFork_5);
    contentPane.add(lblFork_5);

    JProgressBar progressBar_1 = new JProgressBar();
    progressBar_1.setMaximum(50);
    progressBar_1.setBounds(560, 195, 142, 22);
    progressBars.add(progressBar_1);
    contentPane.add(progressBar_1);

    JProgressBar progressBar_2 = new JProgressBar();
    progressBar_2.setMaximum(50);
    progressBar_2.setBounds(620, 415, 142, 22);
    progressBars.add(progressBar_2);
    contentPane.add(progressBar_2);

    JProgressBar progressBar_3 = new JProgressBar();
    progressBar_3.setMaximum(50);
    progressBar_3.setBounds(397, 583, 142, 22);
    progressBars.add(progressBar_3);
    contentPane.add(progressBar_3);

    JProgressBar progressBar_4 = new JProgressBar();
    progressBar_4.setMaximum(50);
    progressBar_4.setBounds(195, 415, 142, 22);
    progressBars.add(progressBar_4);
    contentPane.add(progressBar_4);

    JProgressBar progressBar_5 = new JProgressBar();
    progressBar_5.setMaximum(50);
    progressBar_5.setBounds(230, 195, 142, 22);
    progressBars.add(progressBar_5);
    contentPane.add(progressBar_5);

    JTextArea txtrObserveTheDining = new JTextArea();
    txtrObserveTheDining.setEditable(false);
    txtrObserveTheDining.setFont(new Font("Yu Gothic", Font.BOLD, 13));
    txtrObserveTheDining.setLineWrap(true);
    txtrObserveTheDining.setText("- 5 philosophers sit at a table\r\n- There are only 5 forks on the table \r\n- They are all hungry & want to eat\r\n- They can only eat when the fork to the left & right of them are both available\r\n- After eating for a period, they then take a nap");
    txtrObserveTheDining.setBounds(40, 11, 843, 141);
    contentPane.add(txtrObserveTheDining);

    JLabel Thinking = new JLabel("Thinking...");
    Thinking.setVisible(false);
    Thinking.setBounds(700, 206, 65, 14);
    zzzList.add(Thinking);
    contentPane.add(Thinking);

    JLabel lblZzz2 = new JLabel("Thinking...");
    lblZzz2.setVisible(false);
    lblZzz2.setBounds(785, 402, 65, 14);
    zzzList.add(lblZzz2);
    contentPane.add(lblZzz2);

    JLabel lblZzz3 = new JLabel("Thinking...");
    lblZzz3.setVisible(false);
    lblZzz3.setBounds(535, 501, 65, 14);
    zzzList.add(lblZzz3);
    contentPane.add(lblZzz3);

    JLabel lblZzz4 = new JLabel("Thinking...");
    lblZzz4.setVisible(false);
    lblZzz4.setBounds(337, 402, 65, 14);
    zzzList.add(lblZzz4);
    contentPane.add(lblZzz4);

    JLabel lblZzz5 = new JLabel("Thinking...");
    lblZzz5.setVisible(false);
    lblZzz5.setBounds(382, 206, 65, 14);
    zzzList.add(lblZzz5);
    contentPane.add(lblZzz5);

    JLabel lblFinishedEating1 = new JLabel("Finished eating");
    lblFinishedEating1.setOpaque(true);
    lblFinishedEating1.setVisible(false);
    lblFinishedEating1.setBackground(new Color(255, 20, 147));
    lblFinishedEating1.setBounds(668, 235, 108, 20);
    finishedList.add(lblFinishedEating1);
    contentPane.add(lblFinishedEating1);

    JLabel lblFinishedEating2 = new JLabel("Finished eating");
    lblFinishedEating2.setOpaque(true);
    lblFinishedEating2.setVisible(false);
    lblFinishedEating2.setBackground(new Color(255, 20, 147));
    lblFinishedEating2.setBounds(712, 431, 108, 20);
    finishedList.add(lblFinishedEating2);
    contentPane.add(lblFinishedEating2);

    JLabel lblFinishedEating3 = new JLabel("Finished eating");
    lblFinishedEating3.setOpaque(true);
    lblFinishedEating3.setVisible(false);
    lblFinishedEating3.setBackground(new Color(255, 20, 147));
    lblFinishedEating3.setBounds(529, 530, 108, 20);
    finishedList.add(lblFinishedEating3);
    contentPane.add(lblFinishedEating3);

    JLabel lblFinishedEating4 = new JLabel("Finished eating");
    lblFinishedEating4.setOpaque(true);
    lblFinishedEating4.setVisible(false);
    lblFinishedEating4.setBackground(new Color(255, 20, 147));
    lblFinishedEating4.setBounds(102, 431, 108, 20);
    finishedList.add(lblFinishedEating4);
    contentPane.add(lblFinishedEating4);

    JLabel lblFinishedEating5 = new JLabel("Finished eating");
    lblFinishedEating5.setOpaque(true);
    lblFinishedEating5.setVisible(false);
    lblFinishedEating5.setBackground(new Color(255, 20, 147));
    lblFinishedEating5.setBounds(139, 235, 108, 20);
    finishedList.add(lblFinishedEating5);
    contentPane.add(lblFinishedEating5);

    startDining();
}

private void startDining() {
    diningApp.start();
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                    for(Philosopher philosopher : diningApp.getPhilosophers()){
                            if(!philosopher.isFinished()){
                                    updateGui();
                            }
                            else {
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
    for(Philosopher philosopher : diningApp.getPhilosophers()){
            progressBars.get(philosopherCounter).setValue(philosopher.getAmountEaten());
            ++philosopherCounter;
    }
    setPhilosopherColour();
    checkIfSnoozing();
}

private void checkIfSnoozing() {
    for(Philosopher philosopher : diningApp.getPhilosophers()){
            if(philosopher.isSnoozing()){
                    putToSleep(philosopher);
            }else {
                    wakeUp(philosopher);
            }
    }
}

private void wakeUp(Philosopher philosopher) {
        switch (philosopher.getName()) {
    case "Philosopher: 1":
            zzzList.get(0).setVisible(false);
            break;
    case "Philosopher: 2":
            zzzList.get(1).setVisible(false);
            break;
    case "Philosopher: 3":
            zzzList.get(2).setVisible(false);
            break;
    case "Philosopher: 4":
            zzzList.get(3).setVisible(false);
            break;
    case "Philosopher: 5":
            zzzList.get(4).setVisible(false);
            break;
    default:
            break;
    }
}

private void putToSleep(Philosopher philosopher) {
    switch (philosopher.getName()) {
    case "Philosopher: 1":
            zzzList.get(0).setVisible(true);
            break;
    case "Philosopher: 2":
            zzzList.get(1).setVisible(true);
            break;
    case "Philosopher: 3":
            zzzList.get(2).setVisible(true);
            break;
    case "Philosopher: 4":
            zzzList.get(3).setVisible(true);
            break;
    case "Philosopher: 5":
            zzzList.get(4).setVisible(true);
            break;
    default:
            break;
    }
}

private void setPhilosopherColour() {
    for(Philosopher philosopher : diningApp.getPhilosophers()){
            if(philosopher.isEating()){
                    changeColourToGreen(philosopher);
            }else {
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
