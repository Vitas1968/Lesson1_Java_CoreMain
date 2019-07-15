package Lesson_1.Marathon.obstacles;

import Lesson_1.Marathon.competitors.Competitor;
import Lesson_1.Marathon.obstacles.Obstacle;

public class Cross extends Obstacle
{
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}