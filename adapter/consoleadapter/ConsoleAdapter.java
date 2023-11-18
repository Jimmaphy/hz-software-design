import Linux.Bash;
import CommandLine.Cmd;
import CmdAdapter.CmdAdapter;

public class ConsoleAdapter {
    /** The main class of the application */

    public static void main(String[] args) {
        /** The entry point of the application */
        
        // The Windows command line has a certain set of actions
        Cmd windowsCmd = new Cmd();
        windowsCmd.cd("C:/Users/user/Downloads");
        System.out.println(windowsCmd.dir());

        // The Bash command line also has a set of actions
        Bash linuxBash = new Bash();
        linuxBash.cd("/home/user/Downloads");
        System.out.println(linuxBash.ls());

        // The Adapter allows the Windows cmd to behave like bash
        // The class uses an instance of CMD to perfom actions.
        // While being of type Bash. 
        CmdAdapter cmdAsBash = new CmdAdapter();
        System.out.println(cmdAsBash.ls());
    }
}