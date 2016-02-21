package arrayListExercise;

import java.util.ArrayList;

/**
 * Created by callumgreen on 15/12/2015.
 */
public class ListExercise {
    public static void main(String[] args){

        String[] singers = new String[6];

        singers[0] = "Beyonce (f)";
        singers[1] = "David (m)";
        singers[2] = "Elvis (m)";
        singers[3] = "Madonna(f)";
        singers[4] = "Elton (m)";
        singers[5] = "Charles (m)";

        int singer_male = 0;
        int singer_female = 0;

        for (int i = 0; i < singers.length; i++) {
            if(singers[i].indexOf("(m)") != -1){
                singer_male++;
            }
            if(singers[i].indexOf("(f)") != -1){
                singer_female++;
            }
        }
        System.out.println(singer_female);
        System.out.println(singer_male);

    }
}
