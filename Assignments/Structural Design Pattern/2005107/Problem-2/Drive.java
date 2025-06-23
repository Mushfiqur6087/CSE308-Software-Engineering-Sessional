public class Drive extends Composite{
    public Drive(String name)
    {
        super(name+":\\", "Drive", 0,name+":\\");
        System.out.println("Created a Drive "+getName()+" with directory "+getDirectory());
    }
}
