package Domain;

public class Logger {

    private static final Logger log = new Logger();

    private Logger() {
    }

    public static Logger getInstance(){
        return log;
    }


}
