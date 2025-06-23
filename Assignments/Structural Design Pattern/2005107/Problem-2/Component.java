import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Component {
    private final String name;
    private final int size;
    private final String type;
    private final String directory;
    private final String creationTime;
    private  int componentCount;

    public Component(String name,String type,int size,String directory)
    {
        this.name=name;
        this.size=size;
        this.directory=directory;
        this.type=type;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy h:mm a");
        creationTime= currentDateTime.format(formatter);
        componentCount=0;
    }
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getType());
        System.out.println("Size: " + getSize() + " kB");
        System.out.println("Directory: \"" + getDirectory() + "\"");
        System.out.println("Component Count: "+getComponentCount());
        System.out.println("Creation Time: " + getCreationTime());
    }
    public String getName()
    {
        return this.name;

    }

    public int getSize()
    {
        return this.size;
    }
    public String getType()
    {
        return this.type;
    }

    public String getDirectory()
    {
        return this.directory;
    }
    public String getCreationTime()
    {
        return this.creationTime;
    }
    public int getComponentCount()
    {
        return componentCount;
    }
    public void incrementComponent()
    {
        componentCount++;
    }

    public void decrementComponent()
    {
        componentCount--;
    }



}