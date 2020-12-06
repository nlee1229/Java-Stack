public class Project {
    private String name;
    private String description;
    
    //getter
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //setter
    public void setName(String inputName) {
        this.name = inputName;
    } 

    public void setDescription(String inputDescription) {
        this.description = inputDescription;
    }

    // This is the default constructor
    public Project() {
        
    }

    public Project(String name) {
        this.name = name;
    }
    public Project(String name, String description) {
        //the name & description that the user passes in
        this.name = name;
        this.description = description;
    }

    public String elevatorPitch() {
        return (name + ": " + description);
    }

    public void tellJoke(){
        System.out.println("Why did the chicken cross the road?");
    }
}

