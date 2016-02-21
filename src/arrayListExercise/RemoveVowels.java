package arrayListExercise;

/**
 * Created by callumgreen on 15/12/2015.
 */
public class RemoveVowels {

    public static void main(String[] args){

        String[] vowels = new String[5];

        vowels[0] = "a";
        vowels[1] = "e";
        vowels[2] = "i";
        vowels[3] = "o";
        vowels[4] = "u";

        String[] instruments = new String[4];

        instruments[0] = "cello";
        instruments[1] = "guitar";
        instruments[2] = "violin";
        instruments[3] = "double bass";

        for (int i = 0; i < instruments.length; i++) {
            String instrument = instruments[i] + " ";

            for (int j = 0; j < vowels.length; j++) {
                instrument = instrument.replace(vowels[j], "");
            }
            System.out.println(instrument);
        }


    }


}
