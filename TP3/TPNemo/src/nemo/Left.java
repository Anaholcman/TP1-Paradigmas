package nemo;

public class Left extends Command {

    private String key = "l";

    private boolean applies(String command, Depth depth){
        return key==command; // && depth.command();
    }

}
