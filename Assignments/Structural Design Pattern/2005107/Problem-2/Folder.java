public class Folder extends Composite {
    public Folder(String name,String directory)
    {
        super(name, "Folder", 0, directory);
        System.out.println("Created a Folder "+getName()+" with directory "+getDirectory());
    }
}