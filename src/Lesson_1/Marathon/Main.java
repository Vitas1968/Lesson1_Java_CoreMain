package Lesson_1.Marathon;

import Lesson_1.Marathon.competitors.Cat;
import Lesson_1.Marathon.competitors.Competitor;
import Lesson_1.Marathon.competitors.Dog;
import Lesson_1.Marathon.competitors.Human;
import Lesson_1.Marathon.obstacles.Cross;
import Lesson_1.Marathon.obstacles.Obstacle;
import Lesson_1.Marathon.obstacles.Wall;
import Lesson_1.Marathon.obstacles.Water;

public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Human and Animal", new Human("Боб"), new Cat("Барсик"),
                new Dog("Бобик"), new Dog("Кобелек"));
        Team team2 = new Team("Dogs", new Dog("Вольер"), new Dog("Жанет"),
                new Dog("Бобик"),new Dog("Кобелек"));
        Team team3 = new Team("Cats",  new Cat("Барсик"),  new Cat("Снежинка"),
                new Cat("Уголек"), new Cat("Рыжик"));

        Course course1 = new Course(new Cross(80), new Wall(2),
                new Wall(1), new Cross(120));
        Course course2 = new Course(new Wall(3),new Cross(50),
                new Water(10), new Cross(70));
        Course course3 = new Course(new Water(300),new Cross(500), new Wall(20));

        team1.infoAllCompetitors();
        course3.doIt(team1);
        team1.showResults();


    }
}