import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
        FileSystem f=new FileSystem("User");
//        f.makeDrive("C");
//        f.changeDirectory("C:\\");
//        f.makeDirectory("Music");
//        f.changeDirectory("Music");
//        f.createFile("rainbow.mp3",40);
//        f.list();
//        f.moveToRoot();
//        f.changeDirectory("C:\\");
//        f.showDetails("Music");
//        f.delete("Music");
//        f.deleteRecursive("Music");
        String filePath = "input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String []out=line.split(" ");
                if(out[0].equals("mkdrive"))
                {
                    f.makeDrive(out[1]);
                }
                else if (out[0].equals("cd"))
                {
                    if(out[1].equals("~"))
                    {
                        f.moveToRoot();
                    }
                    else
                    {
                        f.changeDirectory(out[1]);
                    }
                }
                else if (out[0].equals("mkdir"))
                {
                    f.makeDirectory(out[1]);
                }
                else if (out[0].equals("touch"))
                {
                    f.createFile(out[1],40);
                }
                else if (out[0].equals("list"))
                {
                    f.list();
                }
                else if (out[0].equals("ls"))
                {
                    f.showDetails(out[1]);
                } else if (out[0].equals("delete"))
                {
                    if(out[1].equals("-r"))
                    {
                        f.deleteRecursive(out[2]);
                    }
                    else
                        f.delete(out[1]);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
