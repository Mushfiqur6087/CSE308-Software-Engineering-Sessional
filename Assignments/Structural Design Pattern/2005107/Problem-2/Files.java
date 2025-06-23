public class Files extends Component {
    public Files(String name,int size,String directory)
    {
        super(name, "File", size, directory);
        System.out.println("Created a File "+getName()+" in directory "+getDirectory());
    }
}
