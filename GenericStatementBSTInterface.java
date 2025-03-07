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
        private JPanel panel;
        private JLabel label;
        private JButton searchKeyButton;
        private JButton searchKeyAndFactButton;
        private JButton addStatementButton;
        private JBUtton printKbInOrderButton;
        private JButton printKbPreOrderButton;
        private JButton printKbPostOrderButton;
        private JButton getHeightButton;
        private JTextField fileNameField;
        private JTextField keyField;
        private JTextField factField;
        private JTextField cScoreField; 
        private JButton openButton;
        private JMenuItem exitItem;
        private JMenu fileMenu;
        private JMenuBar menuBar;
        private KbaseArray knowledgeBase;
      /**
       * Constructor for the GerericStatementArrayIterface
       * @param knowledgeBase
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
       * 
       */
      public GerericStatementArrayIterface(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("Enter the file name");
        searchKeyButton = new JButton("Search by key");
        searchKeyAndFactButton = new JButton("Search by key and fact");
        addStatementButton = new JButton("Add statement");
        printKbInOrderButton = new JButton("Print knowledge base in order");
        printKbPreOrderButton = new JButton("Print knowledge base pre order");
        printKbPostOrderButton = new JButton("Print knowledge base post order");
        getHeightButton = new JButton("Get height of the tree");
        fileNameField = new JTextField();
        keyField = new JTextField();
        factField = new JTextField();
        cScoreField = new JTextField();
        openButton = new JButton("Open");
        exitItem = new JMenuItem("Exit");
        fileMenu = new JMenu("File");
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        fileMenu.add(exitItem);
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
         * @param printKBInOrderButton
         * @param printKBPreOrderButton
         * @param printKBPostOrderButton
         * @param fileNameField
         * @param keyField
         * @param factField
         * @param cScoreField
         *  @param openButton
         * @param knowledgeBase
         * 
         */
        public void createGUI(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.add(panel);
            panel.setLayout(new GridLayout(6, 2));
            panel.add(label);
            panel.add(fileNameField);
            panel.add(openButton);
            panel.add(searchKeyButton);
            panel.add(searchKeyAndFactButton);
            panel.add(keyField);
            panel.add(factField);
            panel.add(addStatementButton);
            panel.add(printKbInOrderButton);
            panel.add(printKbPreOrderButton);
            panel.add(printKbPostOrderButton);
            panel.add(getHeightButton);
            panel.add(cScoreField);
            frame.setVisible(true);
            openButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String fileName = fileNameField.getText();
                    File file = new File(fileName);
                    knowledgeBase.loadKnowledgeBase(file);
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