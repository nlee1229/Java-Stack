public class Test {
    public static void main(String[] args) {
        //Google is the name/description coming from line 24 
        
        //constructor for name & description constructor
        Project project1 = new Project("Google", "Literally the internet");
        String aName = project1.getName();
        String aDescription = project1.getDescription();
        System.out.println(aName + ": " + aDescription);
        System.out.println(project1.elevatorPitch());


        //empty 
        Project project2 = new Project();
        
        //constructor for name only. get.
        Project project3 = new Project("Eden");
        String aName2 = project3.getName();
        System.out.println("Name: " + aName2);

        //set and get the description.. then use the elevatorPitch to print
        
        project3.setDescription("Here is a description.");
        System.out.println(project3.elevatorPitch());
        
    }
}