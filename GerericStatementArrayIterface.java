import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;        
            
        /**
         * @author Chamunorwa Mboma
         * Date 3/6/2025
         * @version 1.0
         * We are going to attamept to do a GUI for the generic statement array interface
         * This is the application that will demonstrate the use of the generic statement array interface
         * Its main purpose is to demonstrate the use of the generic statement array interface
         * Features to be included are:
         * 1 . Input a knowledge base of statements into a generic statement array
         * 2 . Search for a statement in the array by to ways 
         *     a. By key(Unique identifier of the generic statement) 
         *    b. By key and fact of the generic statemen
         * 3.Let the user input a statement into the knowledge base if the confidence score is greater than 0.5
         * 4. Print the knowledge base of statements
         * 
         */

    public class GerericStatementArrayIterface{
     private JFrame frame;
        private JPanel panel , inputPanel , buttonPanel;
        private JLabel label;
        private JButton searchKeyButton;
        private JButton searchKeyAndFactButton;
        private JButton addStatementButton;
        private JButton guesssCsKb;
        private JTextField fileNameField;
        private JTextField keyField;
        private JTextField factField;
        private JTextField cScoreField; 
        private JButton openButton;
        private JMenuItem exitItem;
        private JMenuItem togglThemeItem;
        private JMenu fileMenu;
        private JMenuBar menuBar;
        private KbaseArray knowledgeBase;
        private boolean isdarkMode;

      /**
       * Constructor for the GerericStatementArrayIterface
       * @param knowledgeBase
       * @param frame
       * @param panel
       * @param label
       * @param searchKeyButton
       * @param searchKeyAndFactButton
       * @param addStatementButton
       * @param guesssCsKb
       * @param fileNameField
       * @param keyField
       * @param factField
       * @param cScoreField
       * @param openButton
       * @param knowledgeBase
       * @param exitItem
       * @param fileMenu
       * @param menuBar
       * @param isdarkMode
       * @param togglThemeItem
       * 
       */
      public GerericStatementArrayIterface(){
        frame = new JFrame();
        we 
        panel = new JPanel(new BorderLayout(5.5,5.5));
        inputPanel = new JPanel(new GridLayout(4,2,5,5));
        buttonPanel = new JPanel(new GridLayout(2,3,5,5));
        label = new JLabel("Enter the file name",SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        frame.add(label, BorderLayout.NORTH);
        openButton = new JButton("Open");
        buttonPanel.add(openButton);
     // These are the input fields for the user to input the file name, key, fact and confidence score   
        inputPanel.add(new JLabel("File Name:"));
        fileNameField = new JTextField();
        inputPanel.add(fileNameField);
        inputPanel.add(new JLabel("Key:"));
        keyField = new JTextField();
        inputPanel.add(keyField);
        inputPanel.add(new JLabel("Fact:"));
        factField = new JTextField();
        inputPanel.add(factField);
        inputPanel.add(new JLabel("Confidence Score:"));
        cScoreField = new JTextField();
        inputPanel.add(cScoreField);
     // These are the buttons that the user will use to interact with the knowledge base
        searchKeyButton = new JButton("Search by key");
        buttonPanel.add(searchKeyButton);
        searchKeyAndFactButton = new JButton("Search by key and fact");
        buttonPanel.add(searchKeyAndFactButton);
        addStatementButton = new JButton("Add statement");
        buttonPanel.add(addStatementButton);
        guesssCsKb = new JButton("Print knowledge base");
        buttonPanel.add(guesssCsKb);
     // These are the menu items that the user will use to interact with the application
        exitItem = new JMenuItem("Exit");
        fileMenu = new JMenu("File");
        menuBar = new JMenuBar();
        togglThemeItem = new JMenuItem("Toggle Dark Mode");
        isdarkMode = false;
        fileMenu.add(exitItem);
        fileMenu.add(togglThemeItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        knowledgeBase = new KbaseArray();
      }
        /**
         * Method to create the GUI interface
         * 
         * @param frame
         * @param panel
         * @param label
         * @param searchKeyButton   
         * @param searchKeyAndFactButton
         * @param addStatementButton
         * @param guesssCsKb
         * @param fileNameField
         * @param keyField
         * @param factField
         * @param cScoreField
         * @param openButton
         * @param knowledgeBase
         * @param exitItem
         * @param fileMenu  
         * @param menuBar
         * @param isdarkMode
         * 
         * 
         */
        public void createGUI(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.add(panel);
            panel.setLayout(new GridLayout(6, 2 , 5,5));
            panel.add(label);
            panel.add(fileNameField);
            panel.add(openButton);
            panel.add(searchKeyButton);
            panel.add(searchKeyAndFactButton);
            panel.add(keyField);
            panel.add(factField);
            panel.add(addStatementButton);
            panel.add(guesssCsKb);
            panel.add(cScoreField);
            panel.add(exitItem);
            panel.add(fileMenu);
            panel.add(menuBar);
            frame.setVisible(true);
            openButton.addActionListener(new ActionListener(){//This is the open button
                public void actionPerformed(ActionEvent e){
                    System.out.println("Welcome Welcome Welcome!!!!!!");
                    String fileName = fileNameField.getText();
                    File file = new File(fileName);
                    knowledgeBase.loadKnowledgeBase(file);
                }
            });
            searchKeyButton.addActionListener(new ActionListener(){//This is the search key button
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    knowledgeBase.searchByKey(key);
                }
            });
            searchKeyAndFactButton.addActionListener(new ActionListener(){//This is the search key and fact button
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    String fact = factField.getText();
                    knowledgeBase.searchByKeyAndFact(key, fact);
                }
            });
            addStatementButton.addActionListener(new ActionListener(){//This is the add statement button
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    String fact = factField.getText();
                    double cScore = Double.parseDouble(cScoreField.getText());
                    knowledgeBase.addStatement(key, fact, cScore);
                }
            });
            guesssCsKb.addActionListener(new ActionListener(){//This is the print knowledge base button
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    Double cScore = Double.parseDouble(cScoreField.getText());
                    knowledgeBase.guessCsKb(key, cScore);
                    
                }
            });
            togglThemeItem.addActionListener(new ActionListener(){//This is the dark mode theme
                public void actionPerformed(ActionEvent e){
                    if(isdarkMode){
                        panel.setBackground(Color.GRAY);
                        isdarkMode = false;
                    }else{
                        panel.setBackground(Color.BLACK);
                        isdarkMode = true;
                    }
                }
            });
            exitItem.addActionListener(new ActionListener(){//This is the exit button
                public void actionPerformed(ActionEvent e){
                    System.out.println("Goodbye Darling :<");
                    System.exit(0);

                }
            });

            
        }
            /**
             * Main method to run the GUI
             * @param args
             * 
             */
            public static void main(String[] args){
                GerericStatementArrayIterface gsa = new GerericStatementArrayIterface();
                gsa.createGUI();
        }



     

        
    }

     

        
    