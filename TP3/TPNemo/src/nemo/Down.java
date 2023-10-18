package nemo;

public class Down {
    private String key = "d";

    private boolean applies(String command, Depth depth){
        return key==command; // && depth.command();
    }


}
