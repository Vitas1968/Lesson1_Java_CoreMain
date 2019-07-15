package Lesson_1.Marathon;

import Lesson_1.Marathon.competitors.Cat;
import Lesson_1.Marathon.competitors.Competitor;
import Lesson_1.Marathon.competitors.Dog;
import Lesson_1.Marathon.competitors.Human;
import Lesson_1.Marathon.obstacles.Cross;
import Lesson_1.Marathon.obstacles.Obstacle;
import Lesson_1.Marathon.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
        for (Competitor c : competitors) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
        for (Competitor c : competitors) {
            c.info();
        }
    }
}