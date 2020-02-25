package code;

public class RandomPort {

    public static int port(){

        int random = (int)Math.random() *99;
        random += 40000;
        return random;


    }

}
