import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        Passengers passenger=null;
        String filePath = "input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains("login"))
                {
                    if(line.contains("crew"))
                    {
                        passenger=new Crewmate();
                        passenger.login();
                    } else if (line.contains("imp"))
                    {
                        passenger=new Imposter(new Crewmate());
                        passenger.login();
                    }
                }
                else if (line.contains("work"))
                {
                    if(passenger!=null)
                    {
                        passenger.work();
                    }
                }
                else if (line.contains("repair"))
                {
                    if(passenger!=null)
                    {
                        passenger.repair();
                    }
                } else if (line.contains("logout"))
                {
                    if(passenger!=null)
                    {
                        passenger.logout();
                        passenger=null;
                        System.out.println();
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}