import java.awt.*;
import java.awt.event.*;

public class ExampleAWT extends Frame {
   private TextField TextCounter;
   private TextField TextRadio;
   private TextField TextCheck;
   private TextField TextList;
   private Button AddButton, MinusButton, ResetButton;
   private int count = 0;
   private CheckboxGroup RadioCheck;
   private Checkbox radio1;
   private Checkbox radio2;
   private Checkbox checkBox;

   public ExampleAWT() {

      // Using FlowLayout to arrange component
      setLayout(new FlowLayout());

      add(new Label("Value")); // Label component
      TextCounter = new TextField("0", 20);
      TextRadio = new TextField("Please Choose", 20);
      TextCheck = new TextField("Tick Please", 20);
      TextList = new TextField("", 20);

      TextCounter.setEditable(false); // only allow for read-only
      TextRadio.setEditable(false); // only allow for read-only
      TextList.setEditable(false); // only allow for read-only
      add(TextCounter); // add TextCounter to GUI // overwrite add in super class
      AddButton = new Button("+1");
      add(AddButton);


      // Event Handler for Add Button
      AddButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ++count;
            TextCounter.setText(count + "");
         }
      });

      MinusButton = new Button("-1");
      add(MinusButton);
      // Event Handler for Minus Button
      MinusButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            count--;
            TextCounter.setText(count + "");
         }
      });

      RadioCheck = new CheckboxGroup();
      radio1 = new Checkbox("Value1", RadioCheck, false);
      radio1.setBounds(100, 100, 50, 50);
      radio2 = new Checkbox("Value2", RadioCheck, false);
      radio2.setBounds(100, 150, 50, 50);
      add(radio1);
      // Event Handler for Radio Button 1
      radio1.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            TextRadio.setText("Value 1");
         }
      });
      add(radio2);
      // Event Handler for Radio Button 2
      radio2.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            TextRadio.setText("Value 2");
         }
      });
      add(TextRadio);

      checkBox = new Checkbox("Handsome");
      add(checkBox);

      add(TextCheck);
      // Event Handler for Check Box
      checkBox.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            TextCheck.setText(e.getStateChange() == 1 ? "Handsome" : "");

         }
      });

      // Add
      add(TextCheck);

      add(new Label("Pick Any: "));
      final Choice choice = new Choice();
      choice.setBounds(100, 100, 75, 75);
      choice.add("Software Construction");
      choice.add("Real-Time");
      choice.add("Web Technology");
      choice.add("Flutter");

      add(choice);
      add(TextList);

      // Event Handler for List
      choice.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            String data = "I choose: " + choice.getItem(choice.getSelectedIndex());
            TextList.setText(data);

         }
      });

      ResetButton = new Button("Reset");
      add(ResetButton);
      ResetButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            count = 0;
            TextCounter.setText("0");
            TextRadio.setText("");
            TextCheck.setText("");
            TextList.setText("");
         }
      });

      setTitle("Soft. Cons. Example");
      setSize(320, 200);
      setVisible(true);
      setLayout(null);

   }

   public static void main(String[] args) {
      new ExampleAWT(); 
   }
}