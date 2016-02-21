package arrayListExercise;

import javax.swing.*;

/**
 * Created by callumgreen on 15/12/2015.
 */
public class DivisbleBy3 {

    public static void main(String[] args){

        int count = 0;

        for (int i = 0; i < 1000; i++) {
            if(i % 3 == 0){
                count++;
            }
        }
        JOptionPane.showMessageDialog(null, count);
        System.exit(0);


    }
}
