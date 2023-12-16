package Linux;

public class Bash {
    /** The Bash command line from Linux and MacOS */
    
    // Keep the working directory
    private String pwd;

    public Bash() {
        /**
         * Create an instance of the bash command line.
         * Sets the working directory to root.
         */

        this.pwd = "/";
    }

    public String ls() {
        /**
         * Get the contents of the pwd.
         * @return the contents of the pwd.
         */

        return "The contents of " + this.pwd;
    }

    public void cd(String newPath) {
        /**
         * Navigate the pwd to a new folder.
         * @param newPath the path to navigate to.
         */

        this.pwd = newPath;
    }
} 
