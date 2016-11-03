package util;

import javax.swing.*;

public class Util {

    public void lancaExcessao(String message) {
        JOptionPane.showMessageDialog(null, message,
                "ERRO !", JOptionPane.ERROR_MESSAGE);
    }

    public void lancaMessage(String message) {
        JOptionPane.showMessageDialog(null, message,
                "Sucesso !", JOptionPane.INFORMATION_MESSAGE);
    }

    public int confirm(String message){
        return JOptionPane.showConfirmDialog(null, message);
    }
}
