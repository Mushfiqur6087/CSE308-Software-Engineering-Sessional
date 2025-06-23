

public class FileSystem {
    Composite root;
    Composite currentDirectory;
    FileSystem(String name)
    {
        root=new Root(name);
        currentDirectory=root;
    }

    public void makeDrive(String name)
    {
        if(currentDirectory instanceof Root)
        {
            ((Root) currentDirectory).addComponent(new Drive(name));
        }
        else
        {
            System.out.println("Can not create drive here");
        }
    }

    public void makeDirectory(String name)
    {
        if(currentDirectory instanceof Root)
        {
            System.out.println("Can not create folder here");
        }
        else
        {
            if(currentDirectory instanceof Drive) {
                currentDirectory.addComponent(new Folder(name, currentDirectory.getDirectory()  + name));
            }
            else {
                currentDirectory.addComponent(new Folder(name, currentDirectory.getDirectory() + "\\" + name));
            }

        }
    }

    public void changeDirectory(String name)
    {
        currentDirectory=currentDirectory.changeDirectory(name);
        System.out.println("Changed directory to " +currentDirectory.getDirectory());
    }

    public void createFile(String name,int size)
    {
        if(currentDirectory instanceof Root)
        {
            System.out.println("Can't create File here");
        }
        else
        {
                currentDirectory.addComponent(new Files(name,size, currentDirectory.getDirectory()));
        }

    }

    public void list ()
    {
        currentDirectory.listContents();
    }
    public void moveToRoot()
    {
        currentDirectory=root;
        System.out.println("Moved to root");
    }
    public void showDetails(String name)
    {
        currentDirectory.showDetails(name);
    }

    public void delete(String name)
    {
        currentDirectory.delete(name);
    }

    public void deleteRecursive(String name)
    {
        currentDirectory.deleteRecursive(name);
    }






}
