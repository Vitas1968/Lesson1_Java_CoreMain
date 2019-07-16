package Lesson_1.Marathon.obstacles;

import Lesson_1.Marathon.competitors.Competitor;
import Lesson_1.Marathon.obstacles.Obstacle;

public class Wall extends Obstacle
{
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}