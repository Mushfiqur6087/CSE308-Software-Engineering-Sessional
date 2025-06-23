public class Decorator implements Passengers{
    private final Passengers passengers;
    Decorator(Passengers passengers)
    {
        this.passengers=passengers;
    }
    @Override
    public void login()
    {
        passengers.login();
    }
    @Override
    public void repair()
    {
        passengers.repair();
    }
    @Override
    public void work()
    {
        passengers.work();
    }
    @Override
    public void logout()
    {
        passengers.logout();
    }
}
