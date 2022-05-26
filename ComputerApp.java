//Computer Lab Application
package ComputerApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.wsu.s219422648.Computer;
import za.ac.wsu.s219422648.Exceptions;

/**
 *
 * @author Bongiwe Hlatshwayo 219422648
 */
public class ComputerApp extends JFrame implements ActionListener {

    private final ArrayList<Computer> computerList = new ArrayList<Computer>();
    private Computer myComputer = null;

    private final JPanel pnlone = new JPanel();
    private final JPanel pnltwo = new JPanel();
    
    JButton btnShow = new JButton("Show Computers");
    JButton btnClear = new JButton("Clear");
    JButton btnExit = new JButton("Exit App");
    JButton btnAdd = new JButton("+");
    
    private final JLabel lblComplab = new JLabel("Computer Lab");
    private final JLabel lblIPAddress = new JLabel("IP Address");
    private final JLabel lblValueAmount = new JLabel("Value");

    private final JTextField txtIpAddress = new JTextField(20);
    private final JTextField txtValue = new JTextField(10);

    public ComputerApp() {

        super("Lab App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 250, 500, 250);
        setLayout(null);

        pnlone.setBounds(0, 0, 500, 40);
        pnlone.setLayout(null);
        pnlone.add(lblComplab);
        lblComplab.setBounds(0, 0, 500, 40);
        pnlone.add(lblComplab);
        add(pnlone);

        pnltwo.setBounds(0, 30, 480, 170);
        pnltwo.setLayout(new GridLayout(5, 2, 4, 4));
        pnltwo.add(lblIPAddress);
        pnltwo.add(txtIpAddress);
        pnltwo.add(lblValueAmount);
        pnltwo.add(txtValue);

        pnltwo.add(btnAdd);
        btnAdd.addActionListener(this);
        pnltwo.add(btnShow);
        btnShow.addActionListener(this);
        pnltwo.add(btnClear);
        btnClear.addActionListener(this);
        pnltwo.add(btnExit);
        btnExit.addActionListener(this);
        add(pnltwo);

        setResizable(false);
        setVisible(true);
    }

    private void clear() {
        txtIpAddress.setText(null);
        txtValue.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnAdd) {

            try {

                String sIPAddress = txtIpAddress.getText();
                if (Float.parseFloat(txtValue.getText()) >= 0) {

                    float fValue = Float.parseFloat(txtValue.getText());

                    myComputer = new Computer(sIPAddress, fValue);
                    computerList.add(myComputer);

                    JOptionPane.showMessageDialog(null, "Computer Inserted", "Info", 1);
                    clear();
                } else {
                    throw new Exceptions("Invalid input");
                }
            } catch (NumberFormatException nfException) {
                JOptionPane.showMessageDialog(null, "Value input invalid",null, 2);
            } catch (Exceptions ex) {
                JOptionPane.showMessageDialog(null, "Negative value ",null, 2);
            }
        } else if (source == btnShow) {
            String computers = "";
            for (Computer comp : computerList) {
                computers += comp.toString();
            }
            JOptionPane.showMessageDialog(null, computers, "Computers", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == btnClear) {
            clear();
        } else if (source == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ComputerApp computerApp = new ComputerApp();
    }
}
