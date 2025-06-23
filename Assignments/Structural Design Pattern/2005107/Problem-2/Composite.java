import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Composite extends Component {
    ArrayList<Component> list;
    public Composite(String name,String type,int size,String directory)
    {
        super(name, type, size, directory);
        list=new ArrayList<>();
    }

    @Override
    public int getSize()
    {
        int size=0;
        for (Component f:list)
        {
            size+=f.getSize();
        }
        return size;
    }

    public void delete(String name) {
        for(Component f:list)
        {
            if(f.getName().equals(name))
            {
                if(f instanceof Files) {
                    System.out.println("Deleting file: " + getName());
                    list.remove(f);
                    decrementComponent();
                }
                else {
                    System.out.println("Can not delete Folder ");
                }
                return;
            }
            else
            {
                System.out.println("Not found");
            }
        }
    }

    public void deleteRecursive(String name) {
        for(Component f:list)
        {
            if(f.getName().equals(name))
            {
                if(f instanceof Files)
                {
                    System.out.println("Deleting file with warning: " + getName());
                    list.remove(f);
                    decrementComponent();
                }
                else {
                    if(f instanceof Folder)
                    {
                        System.out.println("Deleting folder: "+f.getName());
                        Composite folder=(Composite) f;
                        for(Component fo:folder.list)
                        {
                            deleteRecursive(fo.getName());
                        }
                    }
                    list.remove(f);
                    decrementComponent();
                }
                return;

            }
        }
    }

    Composite changeDirectory(String name)
    {
        for(Component f:list)
        {
            if(f.getName().equals(name))
            {
                if(f instanceof Composite)
                {
                    return (Composite) f;
                }
                else
                {
                    System.out.println("Not a directory.");
                    return this;
                }
            }
        }
        System.out.println("Folder or drive doesn't exist in the current directory.");
        return this;
    }

    public void showDetails(String name)
    {
        for(Component f:list)
        {
            if(f.getName().equals(name))
            {
                f.displayDetails();
            }
            else
            {
                System.out.println("Folder or file doesn't exist in the current directory.");
            }
        }

    }

    public void addComponent(Component component)
    {
        list.add(component);
        incrementComponent();
    }

    public void listContents()
    {
        for (Component component : list)
        {
            System.out.println(component.getName() + " \t" + component.getSize() + " kB \t" + component.getCreationTime());
        }
    }





}
