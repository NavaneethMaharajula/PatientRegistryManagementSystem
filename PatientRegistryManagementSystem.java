import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
class Patient {
 String name;
 String phoneNumber;
 String diseaseType;
 String patientId;
 String roomNumber;
 public Patient(String name, String phoneNumber, String diseaseType, String patientId, String roomNumber) {
 this.name = name;
 this.phoneNumber = phoneNumber;
 this.diseaseType = diseaseType;
 this.patientId = patientId;
 this.roomNumber = roomNumber;
 }
}
public class PatientRegistryManagementSystem extends JFrame {
 private JTextField nameField, phoneNumberField, diseaseTypeField, patientIdField, roomNumberField;
 private DefaultTableModel tableModel;
 public PatientRegistryManagementSystem() {
 setTitle("Patient Registry Management System");
 setSize(600, 400);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 // Creating components
 nameField = new JTextField(20);
 phoneNumberField = new JTextField(20);
 diseaseTypeField = new JTextField(20);
 patientIdField = new JTextField(20);
 roomNumberField = new JTextField(20);
 JButton addButton = new JButton("Add Record");
 addButton.addActionListener(new ActionListener() {
 @Override
 public void actionPerformed(ActionEvent e) {
 addRecord();
 }
 });
 // Creating table
 String[] columnNames = {"Name", "Phone Number", "Disease Type", "Patient ID", "Room Number"};
 tableModel = new DefaultTableModel(columnNames, 0);
 JTable patientTable = new JTable(tableModel);
 // Creating and setting layout
 setLayout(new GridLayout(0, 1));
 JPanel inputPanel = new JPanel();
 inputPanel.setLayout(new GridLayout(6, 2));
 inputPanel.add(new JLabel("Name:"));
 inputPanel.add(nameField);
 inputPanel.add(new JLabel("Phone Number:"));
 inputPanel.add(phoneNumberField);
 inputPanel.add(new JLabel("Disease Type:"));
 inputPanel.add(diseaseTypeField);
 inputPanel.add(new JLabel("Patient ID:"));
 inputPanel.add(patientIdField);
 inputPanel.add(new JLabel("Room Number:"));
 inputPanel.add(roomNumberField);
 inputPanel.add(addButton);
 add(inputPanel);
 add(new JScrollPane(patientTable));
 setVisible(true);
 }
 private void addRecord() {
 String name = nameField.getText();
 String phoneNumber = phoneNumberField.getText();
 String diseaseType = diseaseTypeField.getText();
 String patientId = patientIdField.getText();
 String roomNumber = roomNumberField.getText();
 Patient patient = new Patient(name, phoneNumber, diseaseType, patientId, roomNumber);
 // Add a new row to the table
 Object[] rowData = {patient.name, patient.phoneNumber, patient.diseaseType, patient.patientId, patient.roomNumber};
 tableModel.addRow(rowData);
 // Clear input fields
 nameField.setText("");
 phoneNumberField.setText("");
 diseaseTypeField.setText("");
 patientIdField.setText("");
 roomNumberField.setText("");
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(new Runnable() {
 @Override
 public void run() {
 new PatientRegistryManagementSystem();
 }
 });
 }
}