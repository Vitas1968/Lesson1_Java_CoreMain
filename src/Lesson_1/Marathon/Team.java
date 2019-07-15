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

    // информация обо всех участниках команды
    void infoAllCompetitors()
    {
        System.out.println("Team "+ name+":");
        for (Competitor c : competitors) {
            c.info();
        }

    }

    // информация об участниках прошедших дистанцию
    void showResults()
{
    for (Competitor c : competitors) {
        if (c.isOnDistance()) c.info();
    }

}
}
