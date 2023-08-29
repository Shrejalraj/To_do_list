package To_Do_List;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class ToDoListUI extends JFrame{
	 private ArrayList<String> todoItems;
	    private JList<String> itemList;
	    private DefaultListModel<String> listModel;
	    private JTextField addItemField;
	    private JButton addButton;
	    private JButton removeButton;

	    public ToDoListUI() {
	        todoItems = new ArrayList<>();
	        
	        setTitle("To-Do List");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        listModel = new DefaultListModel<>();
	        itemList = new JList<>(listModel);
	        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	        JScrollPane scrollPane = new JScrollPane(itemList);
	        add(scrollPane, BorderLayout.CENTER);

	        JPanel inputPanel = new JPanel();
	        inputPanel.setLayout(new BorderLayout());

	        addItemField = new JTextField();
	        inputPanel.add(addItemField, BorderLayout.CENTER);

	        addButton = new JButton("Add");
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addNewItem();
	            }
	        });
	        inputPanel.add(addButton, BorderLayout.EAST);

	        removeButton = new JButton("Remove");
	        removeButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                removeSelectedItem();
	            }
	        });
	        inputPanel.add(removeButton, BorderLayout.WEST);

	        add(inputPanel, BorderLayout.SOUTH);

	        pack();
	        setLocationRelativeTo(null);
	    }

	    private void addNewItem() {
	        String newItem = addItemField.getText();
	        if (!newItem.isEmpty()) {
	            todoItems.add(newItem);
	            listModel.addElement(newItem);
	            addItemField.setText("");
	        }
	    }

	    private void removeSelectedItem() {
	        int selectedIndex = itemList.getSelectedIndex();
	        if (selectedIndex >= 0) {
	            todoItems.remove(selectedIndex);
	            listModel.remove(selectedIndex);
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                ToDoListUI toDoList = new ToDoListUI();
	                toDoList.setVisible(true);
	            }
	        });
	    }
	}
