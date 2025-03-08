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

    public class GenericStatementArrayInterface{
     private JFrame frame;
        private JPanel panel , inputPanel , buttonPanel;
        private JLabel label;
        private JButton searchKeyButton;
        private JButton searchKeyAndFactButton;
        private JButton addStatementButton;
        private JButton guessCsKb , printKBButton;
        private JTextField fileNameField;
        private JTextField keyField;
        private JTextField factField;
        private JTextField cScoreField; 
        private JButton openButton;
        private JMenuItem exitItem;
        private JMenuItem toggleThemeItem;
        private JMenu fileMenu;
        private JMenuBar menuBar;
        private KbaseArray knowledgeBase;
        private boolean isdarkMode;

      /**
       * Constructor for the GerericStatementArrayIterface
       * 
       * @param frame
       * @param panel
       * @param label
       * @param searchKeyButton
       * @param searchKeyAndFactButton
       * @param addStatementButton
       * @param guessCsKb
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
      public GenericStatementArrayInterface(){
        frame = new JFrame("GenericKBArrayApp");
        panel = new JPanel(new BorderLayout(6,6));
        inputPanel = new JPanel(new GridLayout(4,2,5,5));
        buttonPanel = new JPanel(new GridLayout(2,2,5,5));
        label = new JLabel("Enter the file name",SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 20));

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
        guessCsKb = new JButton("Print knowledge base");
        buttonPanel.add(guesssCsKb);
        printKBButton = new JButton("Print knowledge base");
        buttonPanel.add(printKBButton);
     // These are the menu items that the user will use to interact with the application
        exitItem = new JMenuItem("Exit");
        fileMenu = new JMenu("File");
        menuBar = new JMenuBar();
        toggleThemeItem = new JMenuItem("Toggle Dark Mode");
        isdarkMode = false;
        fileMenu.add(exitItem);
        fileMenu.add(toggleThemeItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        knowledgeBase = new KbaseArray();
      }
        /**
         * Method to create the GUI interface
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
         * 
         * 
         */
        public void createGUI(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.add(panel);
            panel.add(label, BorderLayout.NORTH);
            panel.add(inputPanel, BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.SOUTH);
            frame.pack(); // so that the frame is the right size and there are no conflicts
            frame.setVisible(true);
           //adding actions to the buttons
           //Collecting the file name from the user
           //Collecting the key from the user
          //Collecting the fact from the user
          //Collecting the confidence score from the user

           
            openButton.addActionListener(new ActionListener(){//This is the open button
                public void actionPerformed(ActionEvent e){
                    System.out.println("Welcome Welcome Welcome!!!!!!");
                    String fileName = fileNameField.getText();
                    knowledgeBase.kbExtractor(fileName);
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
                    knowledgeBase.updateOrAddStatement(key, fact, cScore);
                }
            });

            guessCsKb.addActionListener(new ActionListener(){//This is the print knowledge base button
                public void actionPerformed(ActionEvent e){
                    String key = keyField.getText();
                    Double cScore = Double.parseDouble(cScoreField.getText());
                    knowledgeBase.guessCsKb(key, cScore);
                    
                }
            });
            printKBButton.addActionListener(new ActionListener(){//This is the print knowledge base button
                public void actionPerformed(ActionEvent e){
                    knowledgeBase.outputKb();
                }
            });
            toggleThemeItem.addActionListener(new ActionListener(){//This is the dark mode theme
                public void actionPerformed(ActionEvent e){
                    toggleTheme();
                }  
            });
            exitItem.addActionListener(new ActionListener(){//This is the exit button
                public void actionPerformed(ActionEvent e){
                    System.out.println("Goodbye Darling :<");
                    System.exit(0);

                }
            });


            
        }
        /** Method to toggle the theme of the GUI
         * @param isdarkMode
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
            
            printKBButton.setForeground(textColor);
            printKBButton.setBackground(backgroundColor);
            
            openButton.setForeground(textColor);
            openButton.setBackground(backgroundColor);
        
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
                GenericStatementArrayInterface gsApp = new GenericStatementArrayInterface();
                gsApp.createGUI();
        }



     

        
    }

     

        
    