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
         * This is the application that will demonstrate the use of the generic statement binary search tree interface
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
        private JPanel panel,inputPanel,buttonPanel;
        private JLabel label;
        private JButton searchKeyButton;
        private JButton searchKeyAndFactButton;
        private JButton addStatementButton;
        private JTextField fileNameField;
        private JTextField keyField;
        private JTextField factField;
        private JTextField cScoreField; 
        private JButton openButton;
        private JMenuItem exitItem;
        private JMenu fileMenu;
        private JMenuBar menuBar;
        private KbaseBST knowledgeBase;
        private JMenuItem toggleThemeItem;
        private boolean isdarkMode;
      /**
       * Constructor for the GerericStatementArrayIterface
       * @param knowledgeBase
       * @param frame
       * @param panel
       * @param inputPanel
       * @param buttonPanel
       * @param label
       * @param searchKeyButton
       * @param searchKeyAndFactButton
       * @param addStatementButton
       * @param cScoreButton
       * @param fileNameField
       * @param keyField
       * @param factField
       * @param cScoreField
       * @param openButton
       * @param knowledgeBase
       * @param exitItem
       * @param fileMenu
       * @param menuBar
       * 
       */
      public GerericStatementArrayIterface(){
        frame = new JFrame("genericsKBArrayApp");
        panel = new JPanel(new BoarderLayout(5.5,5.5));
        inputPanel = new JPanel(new GridLayout(4,2,5,5));   
        buttonPanel = new JPanel(new GridLayout(2,3,5,5));
        label = new JLabel("Enter the file name",SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(label,BoarderLayout.NORTH);
        openButton= new JButton("Open");
        openButton.setFont(new Font("Arial", Font.BOLD, 24));
        buttonPanel.add(openButton);
        //These are the input filed for the user to enter the key, fact and confidence score
        fileNameField = new JTextField();
        inputPanel.add(JLabel("File Name:"));
        inputPanel.add(fileNameField);
        keyField = new JTextField();
        inputPanel.add(JLabel("Key:"));
        inputPanel.add(keyField);
        factField = new JTextField();
        inputPanel.add(JLabel("Fact:"));
        inputPanel.add(factField);
        cScoreField = new JTextField();
        inputPanel.add(JLabel("Confidence Score:"));
        inputPanel.add(cScoreField);
        //These are the buttons for the user to search by key, search by key and fact, add a statement and print the knowledge base
        searchKeyButton = new JButton("Search by key");
        buttonPanel.add(searchKeyButton);
        searchKeyAndFactButton = new JButton("Search by key and fact");
        buttonPanel.add(searchKeyAndFactButton);
        addStatementButton = new JButton("Add statement");
        buttonPanel.add(addStatementButton);
    //Menu items for the user to exit the application and toggle the theme
        exitItem = new JMenuItem("Exit");
        toggleThemeItem = new JMenuItem("Toggle Theme");
        fileMenu = new JMenu("File");
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        fileMenu.add(exitItem);
        fileMenu.add(toggleThemeItem);
        frame.setJMenuBar(menuBar);
        knowledgeBase = new KbaseBST();
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
         * @param printKBInOrderButton
         * @param printKBPreOrderButton
         * @param printKBPostOrderButton
         * @param fileNameField
         * @param keyField
         * @param factField
         * @param cScoreField
         * @param openButton
         * @param knowledgeBase
         * @param exitItem
         * @param fileMenu
         * @param menuBar
         * 
         */
        public void createGUI(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            frame.add(panel);
            panel.setLayout(new BoarderLayout(10, 10));// Boarder layout with 10 by 10 spacing
            panel.add(label);
            panel.add(fileNameField);
            panel.add(openButton);
            panel.add(searchKeyButton);
            panel.add(searchKeyAndFactButton);
            panel.add(keyField);
            panel.add(factField);
            panel.add(addStatementButton);
            panel.add(cScoreField);
            panel.add(exitItem);
            panel.add(fileMenu);
            panel.add(menuBar);
            frame.setVisible(true);
            openButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String fileName = fileNameField.getText();
                    File file = new File(fileName);
                    knowledgeBase.kbExtractor(file);
                }
            });
            searchKeyButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    knowledgeBase.searchByKey(key);
                }
            });
            searchKeyAndFactButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    String fact = factField.getText();
                    knowledgeBase.searchByKeyAndFact(key, fact);
                }
            });
            addStatementButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    String fact = factField.getText();
                    double cScore = Double.parseDouble(cScoreField.getText());
                    knowledgeBase.addStatement(key, fact, cScore);
                }
            });
            printKbInOrderButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    knowledgeBase.printInOrder();
                }
            });
            printKbPostOrderButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    knowledgeBase.printPostOrder();
                }
            });
            printKbPreOrderButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    knowledgeBase.printPreOrder();
                }
            });
            getHeightButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    knowledgeBase.getHeight();
                }
            });
            exitItem.addActListener(new ActionListner(){
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