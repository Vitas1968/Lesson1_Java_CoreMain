package Lesson_1.Marathon;

import Lesson_1.Marathon.competitors.Competitor;

public class Team
{
    private String name; // название команды
    private Competitor [] competitors; //массив участников

    public Team(String name, Competitor... competitors)
    {
        this.name = name;
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors()
    {
        return competitors;
    }

    // информация обо всех участниках команды
    void infoAllCompetitors()
    {

        System.out.println("Team "+ name+":");
        for (Competitor c : competitors) {
            c.info();
        }
        System.out.println();
    }

    // информация об участниках прошедших дистанцию
    void showResults()
{
    System.out.println();
    System.out.println("Team "+ name+" - "+"прошли дистанцию:");
    for (Competitor c : competitors) {
        if (c.isOnDistance()) c.info();
    }
    System.out.println();

}
}
