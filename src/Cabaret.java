import java.util.ArrayList;

public class Cabaret
{
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer performer)
    {
        if (performers.indexOf(performer) == -1)
        {
            performers.add(performer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer)
    {
        if (performers.indexOf(performer) != -1)
        {
            performers.remove(performers.indexOf(performer));
            return true;
        }
        return false;
    }

    public double averagePerformerAge()
    {
        double total = 0;
        for (Performer performer : performers)
        {
            total += performer.getAge();
        }
        return total/performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> performersOverAge = new ArrayList<Performer>();
        for (int i = 0; i < performers.size(); i++)
        {
            if (performers.get(i).getAge() >= age)
            {
                performersOverAge.add(performers.get(i));
            }
        }
        return performersOverAge;
    }

    public void groupRehearsal()
    {
        for (Performer performer : performers)
        {
            System.out.println("REHEARSAL CALL! " + performer.getName());
            if (performer instanceof Comedian)
            {
                ((Comedian) performer).rehearse(false);
            }
            else
            {
                performer.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer performer : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + performer.getName());
            if (performer instanceof Dancer)
            {
                ((Dancer) performer).pirouette(2);
            }
            performer.perform();
        }
    }
}
