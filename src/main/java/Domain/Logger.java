package Domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private static final Logger log = new Logger();
    public String logname = "simplelog";
    protected String env = System.getProperty("user.dir");
    private static File logFile;


    private Logger() {
        if (log != null){
            //Prevent Reflection
            throw new IllegalStateException("Cannot instantiate a new singleton instance of log");
        }
        this.createLogFile();
    }

    public static Logger getInstance(){
        return log;
    }

    public static Logger getInstance(String withName){
        log.logname = withName;
        log.createLogFile();
        return log;
    }

    private void createLogFile() {
        //Determine if a logs directory exists or not.
        File logsFolder = new File(env + '/' + "logs");
        if (!logsFolder.exists()) {
            //Create the directory
            System.err.println("INFO: Creating new logs directory in " + env);
            logsFolder.mkdir();
        }
        //Get the current date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        //Create the name of the file from the path and current time
        logname =  logname + '-' +  dateFormat.format(cal.getTime()) + ".log";
        Logger.logFile = new File(logsFolder.getName(),logname);
        try{
            if(logFile.createNewFile()){
                //New file made
                System.err.println("INFO: Creating new log file");
            }
        }catch(IOException e){
            System.err.println("ERROR: Cannot create log file");
            System.exit(1);
        }
    }

    public void toLog(String message){
        try{
            FileWriter out = new FileWriter(Logger.logFile, true);
            out.write(message.toCharArray());
            out.close();
        }catch(IOException e){
            System.err.println("ERROR: Could not write to log file");
        }
    }


}
