import builder.ComputerBuildDirector;

public class ComputerBuilding {
    public static void main(String[] args) {
        ComputerBuildDirector director = new ComputerBuildDirector();
        System.out.println(director.BuildMacBook().toString());
        System.out.println(director.BuildComputer().toString());
    }
}
