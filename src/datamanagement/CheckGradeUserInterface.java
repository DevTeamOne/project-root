package datamanagement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.Font;

/**
 * CheckGradeUserInterface renders the main user interface for the 
 * application.
 */
public class CheckGradeUserInterface extends javax.swing.JFrame implements
    IUnitLister, IStudentLister {
  private StudentController studentControl_;
  private javax.swing.DefaultComboBoxModel<String> unitModel_;
  private javax.swing.DefaultComboBoxModel<String> studentModel_;
  float assignment1Result;
  float assignment2Result;
  float assignment3Result;
  Integer studentId;

  
  
  /**
   * Constructor, is passed the student control to be rendered.
   * 
   * @param studentControl, student control to be rendered.
   */
  public CheckGradeUserInterface(StudentController studentControl) {
    this.studentControl_ = studentControl;
    unitModel_ = new javax.swing.DefaultComboBoxModel(new String[0]);
    studentModel_ = new javax.swing.DefaultComboBoxModel(new String[0]);
    initComponents();
    unitComboBox.setModel(unitModel_);
    studentComboBox.setModel(studentModel_);
    errorLabel.setText("");
  }

  
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed"
  // desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    titleLabel = new javax.swing.JLabel();
    unitPanel = new javax.swing.JPanel();
    unitComboBox = new javax.swing.JComboBox<String>();
    studentPanel = new javax.swing.JPanel();
    studentComboBox = new javax.swing.JComboBox<String>();
    marksPanel = new javax.swing.JPanel();
    assignment1Label = new javax.swing.JLabel();
    assignment2Label = new javax.swing.JLabel();
    examLabel = new javax.swing.JLabel();
    assignment1Field = new javax.swing.JTextField();
    assignment2Field = new javax.swing.JTextField();
    examField = new javax.swing.JTextField();
    changeButton = new javax.swing.JButton();
    gradePanel = new javax.swing.JPanel();
    gradeLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
    titleLabel.setText("Check Grade UI");

    unitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit"));

    unitComboBox.setModel(unitModel_);
    unitComboBox.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent event) {
        jComboBox1ItemStateChanged(event);
      }
    });

    javax.swing.GroupLayout gl_unitPanel = new javax.swing.GroupLayout(
        unitPanel);
    gl_unitPanel.setHorizontalGroup(gl_unitPanel.createParallelGroup(
        Alignment.LEADING).addGroup(
        Alignment.TRAILING,
        gl_unitPanel
            .createSequentialGroup()
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(unitComboBox, GroupLayout.PREFERRED_SIZE, 185,
                GroupLayout.PREFERRED_SIZE).addContainerGap()));
    gl_unitPanel.setVerticalGroup(gl_unitPanel.createParallelGroup(
        Alignment.LEADING).addGroup(
        gl_unitPanel
            .createSequentialGroup()
            .addComponent(unitComboBox, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    unitPanel.setLayout(gl_unitPanel);

    studentPanel.setBorder(javax.swing.BorderFactory
        .createTitledBorder("Student"));

    studentComboBox.setModel(studentModel_);
    studentComboBox.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jComboBox2ItemStateChanged(evt);
      }
    });

    javax.swing.GroupLayout gl_studentPanel = new javax.swing.GroupLayout(
        studentPanel);
    studentPanel.setLayout(gl_studentPanel);
    gl_studentPanel.setHorizontalGroup(gl_studentPanel.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        gl_studentPanel
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(studentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)));
    gl_studentPanel.setVerticalGroup(gl_studentPanel.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        gl_studentPanel
            .createSequentialGroup()
            .addComponent(studentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)));

    marksPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Marks"));

    assignment1Label.setText("Asg1:");

    assignment2Label.setText("Asg2:");

    examLabel.setText("Exam:");

    assignment1Field.setEditable(false);
    assignment1Field.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);
      }
    });

    assignment2Field.setEditable(false);
    assignment2Field.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);
      }
    });

    examField.setEditable(false);
    examField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);
      }
    });

    changeButton.setText("Change");
    changeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    checkGradeButton = new javax.swing.JButton();

    checkGradeButton.setText("Check Grade");
    checkGradeButton.setActionCommand("checkGrade");
    checkGradeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout gl_marksPanel = new javax.swing.GroupLayout(
        marksPanel);
    gl_marksPanel.setHorizontalGroup(gl_marksPanel.createParallelGroup(
        Alignment.LEADING).addGroup(
        gl_marksPanel
            .createSequentialGroup()
            .addGroup(
                gl_marksPanel
                    .createParallelGroup(Alignment.LEADING)
                    .addGroup(
                        gl_marksPanel
                            .createSequentialGroup()
                            .addContainerGap()
                            .addComponent(assignment1Label)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(assignment1Field,
                                GroupLayout.PREFERRED_SIZE, 59,
                                GroupLayout.PREFERRED_SIZE).addGap(18)
                            .addComponent(assignment2Label))
                    .addGroup(
                        gl_marksPanel
                            .createSequentialGroup()
                            .addGap(85)
                            .addComponent(changeButton,
                                GroupLayout.PREFERRED_SIZE, 84,
                                GroupLayout.PREFERRED_SIZE)))
            .addGap(18)
            .addGroup(
                gl_marksPanel
                    .createParallelGroup(Alignment.TRAILING)
                    .addGroup(
                        gl_marksPanel
                            .createSequentialGroup()
                            .addComponent(assignment2Field,
                                GroupLayout.PREFERRED_SIZE, 59,
                                GroupLayout.PREFERRED_SIZE).addGap(18)
                            .addComponent(examLabel))
                    .addComponent(checkGradeButton))
            .addGap(18)
            .addComponent(examField, GroupLayout.PREFERRED_SIZE, 59,
                GroupLayout.PREFERRED_SIZE).addGap(15)));
    gl_marksPanel.setVerticalGroup(gl_marksPanel.createParallelGroup(
        Alignment.LEADING).addGroup(
        gl_marksPanel
            .createSequentialGroup()
            .addGroup(
                gl_marksPanel
                    .createParallelGroup(Alignment.BASELINE)
                    .addComponent(assignment1Label)
                    .addComponent(assignment1Field, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignment2Label)
                    .addComponent(assignment2Field, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(examLabel)
                    .addComponent(examField, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(ComponentPlacement.UNRELATED)
            .addGroup(
                gl_marksPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(changeButton).addComponent(checkGradeButton))
            .addContainerGap()));
    marksPanel.setLayout(gl_marksPanel);

    gradePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));

    gradeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    gradeLabel.setForeground(new java.awt.Color(255, 0, 0));
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeLabel.setText("grade");

    javax.swing.GroupLayout gl_gradePanel = new javax.swing.GroupLayout(
        gradePanel);
    gradePanel.setLayout(gl_gradePanel);
    gl_gradePanel.setHorizontalGroup(gl_gradePanel.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(gradeLabel,
        javax.swing.GroupLayout.Alignment.TRAILING,
        javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE));
    gl_gradePanel.setVerticalGroup(gl_gradePanel.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        gl_gradePanel.createSequentialGroup().addGap(34, 34, 34)
            .addComponent(gradeLabel).addContainerGap(43, Short.MAX_VALUE)));

    errorLabel = new JLabel();
    errorLabel.setText("Error message");
    errorLabel.setForeground(Color.RED);
    errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    saveButton = new javax.swing.JButton();

    saveButton.setText("Save");
    saveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
        getContentPane());
    layout
        .setHorizontalGroup(layout
            .createParallelGroup(Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(errorLabel,
                                        GroupLayout.DEFAULT_SIZE, 400,
                                        Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                Alignment.LEADING, false)
                                            .addComponent(marksPanel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                Alignment.LEADING)
                                                            .addComponent(
                                                                unitPanel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(
                                                                studentPanel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18)
                                                    .addComponent(
                                                        gradePanel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE))))
                            .addGroup(
                                layout.createSequentialGroup().addGap(157)
                                    .addComponent(titleLabel))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(165)
                                    .addComponent(saveButton,
                                        GroupLayout.PREFERRED_SIZE, 86,
                                        GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()));
    layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
        .addGroup(
            layout
                .createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(13)
                .addGroup(
                    layout
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                            layout
                                .createSequentialGroup()
                                .addComponent(unitPanel,
                                    GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(studentPanel,
                                    GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE))
                        .addComponent(gradePanel, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED,
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(marksPanel, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addGap(11)
                .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 30,
                    GroupLayout.PREFERRED_SIZE).addContainerGap()));
    getContentPane().setLayout(layout);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  
  
 
  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent event) {// GEN-FIRST:event_jComboBox1ItemStateChanged
    
    String selectedUnit = (String) unitComboBox.getSelectedItem();
    clearAndDisableValueFields();
    clearStudents();
    
    if (event.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
      if (selectedUnit.equals(unitComboBox.getItemAt(0))) 
        selectedUnit = "NONE";

      studentControl_.selectUnit(selectedUnit);
    }
  }// GEN-LAST:event_jComboBox1ItemStateChanged
  
  

  private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent event) {// GEN-FIRST:event_jComboBox2ItemStateChanged
    clearAndDisableValueFields();
    
    String selectedStudent = (String) studentComboBox.getSelectedItem();
    
    if (event.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
      if (selectedStudent.equals(studentComboBox.getItemAt(0))) {
        
        studentId = new Integer(0);
        studentControl_.selectStudent(studentId);
        
      } else {
        studentId = new Integer(selectedStudent.split("\\s")[0]);
      }
      
      studentControl_.selectStudent(studentId);
    }
  }// GEN-LAST:event_jComboBox2ItemStateChanged
  
  

  private void jButton3ActionPerformed(java.awt.event.ActionEvent event) {// GEN-FIRST:event_jButton3ActionPerformed
    
    assignment1Result = new Float(assignment1Field.getText()).floatValue();
    assignment2Result = new Float(assignment2Field.getText()).floatValue();
    assignment3Result = new Float(examField.getText()).floatValue();
    
    try {
      
      String studentsGrade = studentControl_.checkGrade(assignment1Result, assignment2Result, assignment3Result);
      gradeLabel.setText(studentsGrade);
      
    } catch (RuntimeException exception) {
      errorLabel.setText(exception.getMessage());
    }
  }// GEN-LAST:event_jButton3ActionPerformed
  
  

  
  private void jButton1ActionPerformed(java.awt.event.ActionEvent event) {// GEN-FIRST:event_jButton1ActionPerformed
    studentControl_.enableChangeMarks();
    gradeLabel.setText("");
  }// GEN-LAST:event_jButton1ActionPerformed

  
  
  private void jTextFieldKeyTyped(java.awt.event.KeyEvent event) {// GEN-FIRST:event_jTextField1KeyTyped
    gradeLabel.setText("");
    errorLabel.setText("");
  }// GEN-LAST:event_jTextField1KeyTyped

  
  
  private void jButton2ActionPerformed(java.awt.event.ActionEvent event) {// GEN-FIRST:event_jButton2ActionPerformed
    
    float assignment1Result = new Float(assignment1Field.getText()).floatValue();
    float assignment2Result = new Float(assignment2Field.getText()).floatValue();
    float examResult = new Float(examField.getText()).floatValue();
    
    errorLabel.setText("");
    
    try {
      studentControl_.saveGrade(assignment1Result, assignment2Result, examResult);
    } catch (RuntimeException exception) {
      errorLabel.setText(exception.getMessage());
    }
  }// GEN-LAST:event_jButton2ActionPerformed

  
  
  /*
   * Removes all unit elements from the unit model.
   * (non-Javadoc)
   * @see datamanagement.IUnitLister#clearUnits()
   */
  public void clearUnits() {
    unitModel_.removeAllElements();
    unitModel_.addElement("<none selected>");
    clearStudents();
  }

  
  
  /*
   * adds a unit to the unit model.
   * (non-Javadoc)
   * @see datamanagement.IUnitLister#addUnit(datamanagement.IUnit)
   */
  public void addUnit(IUnit unit) {
    unitModel_.addElement(unit.getUnitCode());
  }

  
  
  /**
   * Enable/Disable The Combo box..
   * @param isEnabled : If true the combo box is enabled.
   */
  public void enableUnitComboBox(boolean isEnabled) {
    unitComboBox.setEnabled(isEnabled);
    errorLabel.setText("");
  }

  
  
  /**
   * Remove all elements from the student model.
   */
  public void clearStudents() {
    studentModel_.removeAllElements();
    studentModel_.addElement("<none selected>");
  }

  
  
/**
 * Adds a student to the student model.
 * 
 * @param IStudent: The student record to add to the model.
 */
  public void addStudent(IStudent student) {
    studentModel_.addElement(student.getID().toString() + " : " + student.getFirstName()
        + " " + student.getLastName());
  }

  
  
  /**
   * Populates the user interface with data from a student.
   * 
   * @param studentUnitRecord
   */
  public void addStudentRecord(IStudentUnitRecord studentUnitRecord) {
    assignment1Field.setText(new Float(studentUnitRecord.getAssignment1Result()).
        toString());
    assignment2Field.setText(new Float(studentUnitRecord.getAssignment2Result()).
        toString());
    examField.setText(new Float(studentUnitRecord.getExamResult()).toString());
    gradeLabel.setText("");
  }

  
  
  /**
   * Clears the value fields and combo boxes and sets their
   * state to disabled.
   */
  public void clearAndDisableValueFields() {
    assignment1Field.setText("");
    assignment2Field.setText("");
    examField.setText("");
    gradeLabel.setText("");
    errorLabel.setText("");
    assignment1Field.setEditable(false);
    assignment2Field.setEditable(false);
    examField.setEditable(false);
  }

  
  
  /**
   * Enables/Disables the check grade button on the form.
   * 
   * @param isEnabled: true to enable the button.
   */
  public void enableCheckGradeButton(boolean isEnabled) {
    checkGradeButton.setEnabled(isEnabled);
  }

  
  
  /**
   * Enable the change buttons on the form.
   * 
   * @param isEnabled: true to enable the button.
   */
  public void enableChangeButton(boolean isEnabled) {
    changeButton.setEnabled(isEnabled);
  }

  
  
  /**
   * Enable/Disable the student combo box on the form.
   * 
   * @param isEnabled
   */
  public void enableStudentCombo(boolean isEnabled) {
    studentComboBox.setEnabled(isEnabled);
    errorLabel.setText("");
  }

  
  
  /**
   * Enable/Disable value fields on the form.
   * 
   * @param isEnabled: Set to true to enable the value fields.
   */
  public void enableValueFields(boolean isEnabled) {
    assignment1Field.setEditable(isEnabled);
    assignment2Field.setEditable(isEnabled);
    examField.setEditable(isEnabled);
  }

  
  
  /**
   * Sets the enabled/disabled state fgor the button.
   * 
   * @param isEnabled: Set to true to enable the save button.
   */
  public void enableSave(boolean isEnabled) {
    saveButton.setEnabled(isEnabled);
  }

  
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton changeButton;
  private javax.swing.JButton checkGradeButton;
  private javax.swing.JButton saveButton;
  private javax.swing.JComboBox<String> unitComboBox;
  private javax.swing.JComboBox<String> studentComboBox;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JLabel assignment1Label;
  private javax.swing.JLabel assignment2Label;
  private javax.swing.JLabel examLabel;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JLabel errorLabel;
  private javax.swing.JPanel unitPanel;
  private javax.swing.JPanel studentPanel;
  private javax.swing.JPanel marksPanel;
  private javax.swing.JPanel gradePanel;
  private javax.swing.JTextField assignment1Field;
  private javax.swing.JTextField assignment2Field;
  private javax.swing.JTextField examField;
}
