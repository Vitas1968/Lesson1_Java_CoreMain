package Lesson_1.Marathon;

import Lesson_1.Marathon.competitors.Competitor;

public class Team
{
    private String name;
    private Competitor [] competitors;

    public Team(String name, Competitor... competitors)
    {
        this.name = name;
        this.competitors = competitors;
    }

    void infoAllCompetitors()
    {
        System.out.println("Team "+ name+":");
        for (Competitor c : competitors) {
            c.info();
        }

    }

    void showResults()
{
    for (Competitor c : competitors) {
        if (c.isOnDistance()) c.info();
    }

}
}
