package com.tr3x;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class App {


    private JPanel panelmain;
    private JButton inputButton;
    private JButton languageButton;
    private JButton back_exitButton;
    private JTextArea TextSpracheDisplay;
    private JPanel SpracheDisplay;
    private JLabel AufgabeText;
    private JTextField InputField;
    private JLabel placeholder;
    private JLabel AufgabeText2;
    private JLabel placeholder2;
    private JButton checkButton;
    private JLabel resultDisplay;
    private JLabel titel;
    private JLabel placeholder4;
    private JLabel placeholder3;
    private JLabel placeholder5;
    private JLabel placeholder6;
    private JLabel placeholder7;
    private String saveInput = null;

    public static void main(String[] args) throws IOException {
        JFrame app = new JFrame("Automat");
        app.setContentPane(new App().panelmain);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        app.setLocation(width/2-150,height/2-300);

        app.setResizable(false);
        app.pack();
        app.setVisible(true);
    }

    public App() {
        languageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titel.setText("Sprache");
                languageButton.setVisible(false);
                back_exitButton.setText("Zurück");
                TextSpracheDisplay.setVisible(true);
                AufgabeText.setVisible(false);
                AufgabeText2.setVisible(false);
                InputField.setVisible(false);
                checkButton.setVisible(false);
                resultDisplay.setText(" ");

            }
        });
        back_exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (back_exitButton.getText().equals("Beenden")) {
                    System.exit(0);
                } else if (back_exitButton.getText().equals("Zurück")) {
                    back_exitButton.setText("Beenden");
                    titel.setText("Automat");
                    languageButton.setVisible(true);
                    TextSpracheDisplay.setVisible(false);
                    AufgabeText.setVisible(true);
                    AufgabeText2.setVisible(true);
                    InputField.setVisible(true);
                    checkButton.setVisible(true);
                }

            }
        });
        InputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                resultDisplay.setText("");
                InputField.setText("");
            }
        });
        InputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                saveInput = InputField.getText();
                InputField.setText("Hier eingeben");
            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });



        InputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    saveInput = InputField.getText();
                    InputField.setText("");
                    check();
                }

            }
        });


    }

    public void check(){
        if(saveInput==null){
            resultDisplay.setText("Fehler: Eingabe kann nicht leer sein."); resultDisplay.setForeground(Color.RED);

        }
        else {
            String checkWorld = saveInput;
            char[] charCheck = checkWorld.toLowerCase(Locale.ROOT).toCharArray();
            Automat automat = new Automat();
            int result = automat.wortPruefen(charCheck);
            if(result==0 || result==3) {
                resultDisplay.setText("Das Wort ist nicht in der Sprache");
                resultDisplay.setForeground(Color.RED);
            }
            if(result==1) {
                resultDisplay.setText("Die Grammatik ist richtig, das Wort ist in der Sprache");
                resultDisplay.setForeground(Color.white);
            }

        }
    }
}

