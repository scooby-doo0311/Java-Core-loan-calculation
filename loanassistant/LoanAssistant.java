/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
public class LoanAssistant extends JFrame
{
JLabel balanceLabel = new JLabel();
JTextField balanceTextField = new JTextField();
JLabel interestLabel = new JLabel();
JTextField interestTextField = new JTextField();
JLabel monthsLabel = new JLabel();
JTextField monthsTextField = new JTextField();
JLabel paymentLabel = new JLabel();
JTextField paymentTextField = new JTextField();
JButton computeButton = new JButton();
JButton newLoanButton = new JButton();
JButton monthsButton = new JButton();
JButton paymentButton = new JButton();
JLabel analysisLabel = new JLabel();
JTextArea analysisTextArea = new JTextArea();
JButton exitButton = new JButton();
Font myFont = new Font("Arial", Font.PLAIN, 16);
Color lightYellow;
boolean computePayment;

    /**
     *
     * @param args
     */
    public static void main(String args[])
{
// create frame
new LoanAssistant().show();
}
public LoanAssistant()
{
        this.lightYellow = new Color(255, 255, 128);
// frame constructor
setTitle("Loan Assistant");
setResizable(false);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent evt)
{
exitForm(evt);
}
});
getContentPane().setLayout(new GridBagLayout());
GridBagConstraints gridConstraints;
balanceLabel.setText("Loan Balance");
balanceLabel.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 0;
gridConstraints.gridy = 0;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 0, 0);
getContentPane().add(balanceLabel, gridConstraints);
balanceTextField.setPreferredSize(new Dimension(100, 25));
balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
balanceTextField.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 1;
gridConstraints.gridy = 0;
gridConstraints.insets = new Insets(10, 10, 0, 10);
getContentPane().add(balanceTextField, gridConstraints);
balanceTextField.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
balanceTextFieldActionPerformed(e);
}
});
interestLabel.setText("Interest Rate");
interestLabel.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 0;
gridConstraints.gridy = 1;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 0, 0);
getContentPane().add(interestLabel, gridConstraints);
interestTextField.setPreferredSize(new Dimension(100, 25));
interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
interestTextField.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 1;
gridConstraints.gridy = 1;
gridConstraints.insets = new Insets(10, 10, 0, 10);
getContentPane().add(interestTextField, gridConstraints);
interestTextField.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
interestTextFieldActionPerformed(e);
}
});
monthsLabel.setText("Number of Payments");
monthsLabel.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 0;
gridConstraints.gridy = 2;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 0, 0);
getContentPane().add(monthsLabel, gridConstraints);
monthsTextField.setPreferredSize(new Dimension(100, 25));
monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
monthsTextField.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 1;
gridConstraints.gridy = 2;
gridConstraints.insets = new Insets(10, 10, 0, 10);
getContentPane().add(monthsTextField, gridConstraints);
monthsTextField.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
monthsTextFieldActionPerformed(e);
}
});
paymentLabel.setText("Monthly Payment");
paymentLabel.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 0;
gridConstraints.gridy = 3;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 0, 0);
getContentPane().add(paymentLabel, gridConstraints);
paymentTextField.setPreferredSize(new Dimension(100, 25));
paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
paymentTextField.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 1;
gridConstraints.gridy = 3;
gridConstraints.insets = new Insets(10, 10, 0, 10);
getContentPane().add(paymentTextField, gridConstraints);
paymentTextField.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
paymentTextFieldActionPerformed(e);
}
});
computeButton.setText("Compute Monthly Payment");
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 0;
gridConstraints.gridy = 4;
gridConstraints.gridwidth = 2;
gridConstraints.insets = new Insets(10, 0, 0, 0);
getContentPane().add(computeButton, gridConstraints);
computeButton.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
computeButtonActionPerformed(e);
}
});
newLoanButton.setText("New Loan Analysis");
newLoanButton.setEnabled(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 0;
gridConstraints.gridy = 5;
gridConstraints.gridwidth = 2;
gridConstraints.insets = new Insets(10, 0, 10, 0);
getContentPane().add(newLoanButton, gridConstraints);
newLoanButton.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
newLoanButtonActionPerformed(e);
}
});
monthsButton.setText("X");
monthsButton.setFocusable(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 2;
gridConstraints.gridy = 2;
gridConstraints.insets = new Insets(10, 0, 0, 0);
getContentPane().add(monthsButton, gridConstraints);
monthsButton.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
monthsButtonActionPerformed(e);
}
});
paymentButton.setText("X");
paymentButton.setFocusable(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 2;
gridConstraints.gridy = 3;
gridConstraints.insets = new Insets(10, 0, 0, 0);
getContentPane().add(paymentButton, gridConstraints);
paymentButton.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
paymentButtonActionPerformed(e);
}
});
analysisLabel.setText("Loan Analysis:");
analysisLabel.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 3;
gridConstraints.gridy = 0;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(0, 10, 0, 0);
getContentPane().add(analysisLabel, gridConstraints);
analysisTextArea.setPreferredSize(new Dimension(250, 150));
analysisTextArea.setFocusable(false);
analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
analysisTextArea.setEditable(false);
analysisTextArea.setBackground(Color.WHITE);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 3;
gridConstraints.gridy = 1;
gridConstraints.gridheight = 4;
gridConstraints.insets = new Insets(0, 10, 0, 10);
getContentPane().add(analysisTextArea, gridConstraints);
exitButton.setText("Exit");
exitButton.setFocusable(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 3;
gridConstraints.gridy = 5;
getContentPane().add(exitButton, gridConstraints);
exitButton.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
exitButtonActionPerformed(e);
}

});
pack();
Dimension screenSize =
Toolkit.getDefaultToolkit().getScreenSize();
setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height -
getHeight())), getWidth(), getHeight());
paymentButton.doClick();
}
private void exitForm(WindowEvent evt)
{
System.exit(0);
}
private void computeButtonActionPerformed(ActionEvent e)
{
double balance, interest, payment;
int months;
double monthlyInterest, multiplier;
double loanBalance, finalPayment;
if (validateDecimalNumber(balanceTextField))
{
balance =
Double.valueOf(balanceTextField.getText()).doubleValue();
}
else
{
 JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance Input Error.\n Please correct.","Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
return;
}
if (validateDecimalNumber(interestTextField))
{
interest =
Double.valueOf(interestTextField.getText()).doubleValue();
}
else
{
JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct."," Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
return;
}
monthlyInterest = interest / 1200;
if (computePayment)
{
// Compute loan payment
if (validateDecimalNumber(monthsTextField))
{
months =
Integer.valueOf(monthsTextField.getText()).intValue();
}
else
{
JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
return;
}
if (interest == 0)
{
payment = balance / months;
}
else
{
multiplier = Math.pow(1 + monthlyInterest, months);
payment = balance * monthlyInterest * multiplier / (multiplier - 1);
}
paymentTextField.setText(new DecimalFormat("0.00").format(payment));
}
else

{
// Compute number of payments
if (validateDecimalNumber(paymentTextField))
{
payment =
Double.valueOf(paymentTextField.getText()).doubleValue();
if (payment <= (balance * monthlyInterest + 1.0))
{
if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" +new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
{
paymentTextField.setText(new DecimalFormat("0.00").format((int)(balance *
monthlyInterest + 1.0)));
payment =
Double.valueOf(paymentTextField.getText()).doubleValue();
}
else
{
paymentTextField.requestFocus();
return;
}
}
}
else
{
JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
return;
}
if (interest == 0)
{
months = (int)(balance / payment);
}
else
{
months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) /
Math.log(1 + monthlyInterest));
}
monthsTextField.setText(String.valueOf(months));
}
// reset payment prior to analysis to fix at two decimals
payment =
Double.valueOf(paymentTextField.getText()).doubleValue();
// show analysis
analysisTextArea.setText("Loan Balance: $" + new
DecimalFormat("0.00").format(balance));
analysisTextArea.append("\n" + "Interest Rate: " + new
DecimalFormat("0.00").format(interest) + "%");
// process all but last payment
loanBalance = balance;
for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
{
loanBalance += loanBalance * monthlyInterest - payment;
}
// find final payment
finalPayment = loanBalance;
if (finalPayment > payment)
{
// apply one more payment
loanBalance += loanBalance * monthlyInterest - payment;
finalPayment = loanBalance;
months++;
monthsTextField.setText(String.valueOf(months));
}
analysisTextArea.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new
DecimalFormat("0.00").format(payment));
analysisTextArea.append("\n" + "Final Payment of: $" + new
DecimalFormat("0.00").format(finalPayment));
analysisTextArea.append("\n" + "Total Payments: $" + new
DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
analysisTextArea.append("\n" + "Interest Paid $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
computeButton.setEnabled(false);
newLoanButton.setEnabled(true);
newLoanButton.requestFocus();
}
private void newLoanButtonActionPerformed(ActionEvent e)
{
// clear computed value and analysis
if (computePayment)
{
paymentTextField.setText("");
}
else
{
monthsTextField.setText("");
}
analysisTextArea.setText("");
computeButton.setEnabled(true);
newLoanButton.setEnabled(false);
balanceTextField.requestFocus();
}
private void monthsButtonActionPerformed(ActionEvent e)
{
// will compute months
computePayment = false;
paymentButton.setVisible(true);
monthsButton.setVisible(false);
monthsTextField.setText("");
monthsTextField.setEditable(false);
monthsTextField.setBackground(lightYellow);
monthsTextField.setFocusable(false);
paymentTextField.setEditable(true);
paymentTextField.setBackground(Color.WHITE);
paymentTextField.setFocusable(true);

computeButton.setText("Compute Number of Payments");
balanceTextField.requestFocus();
}
private void paymentButtonActionPerformed(ActionEvent e)
{
// will compute payment
computePayment = true;
paymentButton.setVisible(false);
monthsButton.setVisible(true);
monthsTextField.setEditable(true);
monthsTextField.setBackground(Color.WHITE);
monthsTextField.setFocusable(true);
paymentTextField.setText("");
paymentTextField.setEditable(false);
paymentTextField.setBackground(lightYellow);
paymentTextField.setFocusable(false);
computeButton.setText("Compute Monthly Payment");
balanceTextField.requestFocus();
}
private void exitButtonActionPerformed(ActionEvent e)
{
System.exit(0);
}
private void balanceTextFieldActionPerformed(ActionEvent e)
{
balanceTextField.transferFocus();
}
private void interestTextFieldActionPerformed(ActionEvent e)
{
interestTextField.transferFocus();
}
private void monthsTextFieldActionPerformed(ActionEvent e)
{
monthsTextField.transferFocus();
}
private void paymentTextFieldActionPerformed(ActionEvent e)
{
paymentTextField.transferFocus();
}
private boolean validateDecimalNumber(JTextField tf)
{
// checks to see if text field contains
// valid decimal number with only digits and a single decimal point
String s = tf.getText().trim();
boolean hasDecimal = false;
boolean valid = true;
if (s.length() == 0)
{
valid = false;
}
else
{
for (int i = 0; i < s.length(); i++)
{
char c = s.charAt(i);
if (c >= '0' && c <= '9')
{
continue;
}
else if (c == '.' && !hasDecimal)
{
hasDecimal = true;
}
else
{
// invalid character found
valid = false;
}
}
}
tf.setText(s);
if (!valid)
{
tf.requestFocus();
}
return (valid);
}
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        balanceLabel = new javax.swing.JLabel();
        interestLabel = new javax.swing.JLabel();
        monthsLabel = new javax.swing.JLabel();
        paymentLabel = new javax.swing.JLabel();
        paymentTextField = new javax.swing.JTextField();
        monthsTextField = new javax.swing.JTextField();
        interestTextField = new javax.swing.JTextField();
        balanceTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        balanceLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        balanceLabel.setText("Loan Balance");
        balanceLabel.setAlignmentX(1.0F);
        balanceLabel.setAlignmentY(0.0F);

        interestLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        interestLabel.setText("Interest Rate");

        monthsLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        monthsLabel.setText("Number of Payments");

        paymentLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        paymentLabel.setText("Monthly Payment");

        paymentTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        monthsTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        monthsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthsTextFieldActionPerformed(evt);
            }
        });

        interestTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        balanceTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jButton2.setText("Compute Monthly Payment");

        jButton3.setText("New Loan Analysis");

        jButton5.setText("Payment");

        jButton1.setText("Months");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel5.setText("Loan Analysis");

        jButton4.setText("Exit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(paymentLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(monthsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(interestLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(balanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(balanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(interestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(monthsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(99, 99, 99)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(balanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(balanceLabel)))
                        .addGap(23, 23, 23)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interestLabel)
                            .addComponent(interestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(monthsLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(monthsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paymentLabel)
                            .addComponent(paymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(51, 51, 51)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthsTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
   
        /* Create and display the form */
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField balanceTextField;
    private javax.swing.JLabel interestLabel;
    private javax.swing.JTextField interestTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel monthsLabel;
    private javax.swing.JTextField monthsTextField;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JTextField paymentTextField;
    // End of variables declaration//GEN-END:variables
}
