//Computer Class
package za.ac.wsu.s219422648;

import java.text.DecimalFormat;

/**
 *
 * @author Bongiwe Hlatshwayo 219422648
 */
public class Computer {

    private String ipAddress;
    private float value;

    public Computer(String ipAddress, float value) {
        this.ipAddress = ipAddress;
        this.value = value;

    }

    public String getIPAddress() {
        return ipAddress;
    }

    public float getValue() {
        return value;
    }

    public void setIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setValue(float value) throws Exceptions {
        
            this.value = value;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0.00");
        return ipAddress + " " + decimalFormat.format(value )+ "\n";
    }
}
