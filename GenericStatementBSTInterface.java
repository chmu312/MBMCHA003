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

    public class GenericStatementBSTInterface{
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
        private JButton loadButton;
        private JMenuItem exitItem;
        private JMenu fileMenu;
        private JMenuBar menuBar;
        private KbaseBST knowledgeBase;
        private JMenuItem toggleThemeItem;
        private boolean isdarkMode;
      /**
       * Constructor for thenGerericStatementBSTIterface
       * @param knowledgeBase
       * @param frame
       * @param panel
       * @param inputPanel
       * @param buttonPanel
       * @param label
       * @param searchKeyButton
       * @param searchKeyAndFactButton
       * @param addStatementButton
       * @param fileNameField
       * @param keyField
       * @param factField
       * @param cScoreField
       * @param loadButton
       * @param knowledgeBase
       * @param exitItem
       * @param fileMenu
       * @param menuBar
       * 
       */
      public GenericStatementBSTInterface(){
        frame = new JFrame("genericsKB-BST-App");
        panel = new JPanel(new BorderLayout(5,5));
        panel.setLayout(new BorderLayout(10,10));
        inputPanel = new JPanel(new GridLayout(4,2,5,5));   
        buttonPanel = new JPanel(new GridLayout(2,3,5,5));
        label = new JLabel("Enter the file name",SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
      
        loadButton= new JButton("Load text file");
        buttonPanel.add(loadButton);
        //These are the input filed for the user to enter the key, fact and confidence score
        fileNameField = new JTextField();
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(fileNameField);
        keyField = new JTextField();
        inputPanel.add(new JLabel("Key:"));
        inputPanel.add(keyField);
        factField = new JTextField();
        inputPanel.add(new JLabel("Fact:"));
        inputPanel.add(factField);
        cScoreField = new JTextField();
        inputPanel.add(new JLabel("Confidence Score:"));
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
        isdarkMode = false;
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
         * @param fileNameField
         * @param keyField
         * @param factField
         * @param cScoreField
         * @param loadButton
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
            panel.setLayout(new BorderLayout(10, 10));// Boarder layout with 10 by 10 spacing
            frame.add(label,BorderLayout.NORTH);
            panel.add(inputPanel, BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.SOUTH);    
            frame.pack();
            frame.setVisible(true);
            loadButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String fileName = fileNameField.getText();
                    knowledgeBase.kbExtractor(fileName);
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
                    knowledgeBase.searchByKeyFact(key, fact);
                }
            });
            addStatementButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    String fact = factField.getText();
                    double cScore = Double.parseDouble(cScoreField.getText());
                    knowledgeBase.updateOrAddStatement(key, fact, cScore);
                }
            });
            
            
           
            toggleThemeItem.addActionListener(new ActionListener(){//This is the dark mode theme
                public void actionPerformed(ActionEvent e){
                    toggleTheme();
                }  
            });
            exitItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("Goodbye Darling :<");
                    System.exit(0);
                }
            });
            
        }
        /** Method to toggle the theme of the GUI
         * 
         */
        
         public void toggleTheme(){

            if(isdarkMode){
                // Switch the app to light mode
                panel.setBackground(Color.LIGHT_GRAY);
                inputPanel.setBackground(Color.LIGHT_GRAY);
                buttonPanel.setBackground(Color.LIGHT_GRAY);
                label.setForeground(Color.BLACK);//Sets all filed to black
                setComponentColors(Color.BLACK,Color.WHITE);
                isdarkMode = false;
            }
            else{//Switch the app to dark mode
                panel.setBackground(Color.DARK_GRAY);
                inputPanel.setBackground(Color.DARK_GRAY);
                buttonPanel.setBackground(Color.DARK_GRAY);
                label.setForeground(Color.WHITE);//Sets text fileds and buttons to white
                setComponentColors(Color.WHITE,Color.BLACK);
                isdarkMode = true;
            }
            frame.repaint();//to update the frame
        }
        /**
         * Method to set the colors of the components
         * @param textColor the text color of the components
         * @param backgroundColor the background color of the components
         */

        public void setComponentColors(Color textColor, Color backgroundColor){
                                                    
            label.setForeground(textColor);
    
            fileNameField.setForeground(textColor);
            fileNameField.setBackground(backgroundColor);
            
            keyField.setForeground(textColor);
            keyField.setBackground(backgroundColor);
            
            factField.setForeground(textColor);
            factField.setBackground(backgroundColor);
            
            cScoreField.setForeground(textColor);
            cScoreField.setBackground(backgroundColor);
        
            searchKeyButton.setForeground(textColor);
            searchKeyButton.setBackground(backgroundColor);
            
            searchKeyAndFactButton.setForeground(textColor);
            searchKeyAndFactButton.setBackground(backgroundColor);
            
            addStatementButton.setForeground(textColor);
            addStatementButton.setBackground(backgroundColor);
            
            loadButton.setForeground(textColor);
            loadButton.setBackground(backgroundColor);
        
            menuBar.setBackground(backgroundColor);
            
            fileMenu.setForeground(textColor);
            fileMenu.setBackground(backgroundColor);
        
            toggleThemeItem.setForeground(textColor);
            toggleThemeItem.setBackground(backgroundColor);
            
            exitItem.setForeground(textColor);
            exitItem.setBackground(backgroundColor);
        } 
            /**
             * Main method to run the GUI
             * @param args
             * 
             */
            public static void main(String[] args){
                GenericStatementBSTInterface gBSTAPP = new GenericStatementBSTInterface();
                gBSTAPP.createGUI();
        }   
    }