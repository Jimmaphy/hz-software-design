package CommandLine;

public class Cmd {
    /** The commandline from Windows. */

    // Hold the current working directory of the command line.
    private String directory;

    public Cmd() {
        /**
         * Create an instance of the Windows CommandLine.
         * Sets the directory to the root of the C disk.
         */

        this.directory = "C:/";
    }

    public String dir() {
        /**
         * Return the contents of the current directory.
         * 
         * @return a string containing the contents of the current directory.
         */

        return "Contents of " + this.directory;
    }

    public void cd(String newPath) {
        /**
         * Change the current path of the CommandLine instance.
         * 
         * @param newPath the new path the command line should point to.
         */

        this.directory = newPath;
    }
}
