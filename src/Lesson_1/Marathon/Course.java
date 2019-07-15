package Lesson_1.Marathon;

import Lesson_1.Marathon.competitors.Competitor;
import Lesson_1.Marathon.obstacles.Obstacle;

public class Course
{

    Obstacle[] course;

    public Course(Obstacle... course)
    {
        this.course = course;
    }

    public void doIt(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : course) {
                o.doIt(c);
               // if (!c.isOnDistance()) break;
            }
        }
    }
}
