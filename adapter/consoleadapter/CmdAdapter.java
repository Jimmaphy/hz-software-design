package CmdAdapter;

import CommandLine.Cmd;
import Linux.Bash;

public class CmdAdapter extends Bash {
    /** Convert the Windows commandline to be compatible with Linux commands. */

    // Keep an instance of the Windows Commandline for interaction
    private Cmd commandLine;

    public CmdAdapter() {
        /**
         * Create a new instance of the Adapter.
         * Instantiates an instance of the Windows CommandLine.
         */

        this.commandLine = new Cmd();
    }

    @Override
    public String ls() {
        /**
         * Get the contents of the current directory.
         * Uses the dir() command of the Windows commandline.
         * 
         * @return the contents of the current directory.
         */

        return this.commandLine.dir();
    }

    @Override
    public void cd(String newPath) {
        /**
         * Change the directory of the command line.
         * Uses the cd() command from the Windows commandline.
         *
         * @param newPath the directory to navigate to.
         */

        this.commandLine.cd(newPath);
    }
}
