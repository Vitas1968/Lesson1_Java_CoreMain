package Lesson3.Game;

import java.util.HashSet;
import java.util.Random;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;
    protected static int count;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой " + this.name+" уже мертвый!");
        } else {
            health -= damage;
        }

    }

    public int getHealth()
    {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health < 0 ? "Герой " + this.name+" мертвый" : health) + " " + damage);
    }
}

class Warrior extends Hero {

    public Warrior(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой " + this.name+" погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
                System.out.println(this.name + " нанес урон " + hero.name);
            }

        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Воины не умеют лечить!");
    }


}

class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой " + this.name+"  погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
                System.out.println(this.name + " нанес урон " + hero.name);
            }

        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }

}

class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
        System.out.println("Доктор подкинул "+addHeal+" здоровья "+hero.name);
    }


}


class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        int round = 3;



        Hero[] team1 = new Hero[]{
                new Warrior(250, "Тигрил", 50, 0)
                , new Assasin(150, "Акали", 70, 0)
                , new Doctor(120, "Жанна", 0, 60)};

        Hero[] team2 = new Hero[]{
                new Warrior(290, "Минотавр", 60, 0)
                , new Assasin(160, "Джинкс", 90, 0)
                , new Doctor(110, "Зои", 0, 80)};

        // счетчик членов команды(бойцов) не считая доктора
        int countTeam1=team1.length-1;
        int countTeam2=team2.length-1;
        boolean endGame=false;


       /* for (int j = 0; j < round; j++)*/
        while (!endGame){
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0) {
                    if(team1[i] instanceof Doctor)
                    {
                        team1[i].healing(team1[randomHealing.nextInt(2)]);
                    } else {
//                        int tmp=i;
//                        HashSet<String> morgue = new HashSet <>();
//                        while (team2[tmp].getHealth()<0)
//                        { morgue.add(team2[tmp].name);
//                            countTeam2--;
//                            System.out.println(team2[tmp].name + " из команды Team2 сдох маленько." +
//                                    " В живых из Team2 осталось-> "+countTeam2 );
//                            if (countTeam2==0){
//                                endGame=true;
//                                System.out.println("В команде Team2 не осталось живых  бойцов");
//                                System.out.println("Победила команда Team1");
//                                break;}
//
//                            if(morgue.contains(team2[tmp].name))
//                            {
//                                tmp=tmp>0 ? --tmp : ++tmp;
//                            }
//                        }
//                        if (endGame) break;

                       team1[i].hit(team2[i]);
                        // проверяем здоровье бойца,если он мертв
                        // уменьшаем счетчик команды
                        if(team2[i].getHealth()<0) countTeam2--;
                        // если все бойцы погибли меняем значение
                        // endGame(завершить игру) и выходим из внутренего цикла
                        // и завершаем игру
                        if (countTeam2==0)
                        {
                            endGame=true;
                            System.out.println(" В команде Team2 погибли все бойцы");
                            break;
                        }

                    }
                } else {

                        if (team2[i] instanceof Doctor)
                        {
                            team2[i].healing(team2[randomHealing.nextInt(2)]);
                        } else {

//                        int tmp=i;
//                        HashSet<String> morgue = new HashSet <>();
//                        while (team1[tmp].getHealth()<0)
//                        {
//                            countTeam1--;
//                            System.out.println(team1[tmp].name + " из команды Team1 сдох маленько." +
//                                    " В живых из Team1 осталось-> "+countTeam1 );
//                            if (countTeam1==0){
//                                endGame=true;
//                                System.out.println("В команде Team1 не осталось живых  бойцов");
//                                System.out.println("Победила команда Team2");
//                                break;}
//                            morgue.add(team2[tmp].name);
//                            if(morgue.contains(team2[tmp].name))
//                            {
//                                tmp=tmp>0 ? --tmp : ++tmp;
//                            }
//
//
//                        }
//                        if (endGame) break;

                             team2[i].hit(team1[i]);
                             // проверяем здоровье бойца,если он мертв
                            // уменьшаем счетчик команды
                            if(team1[i].getHealth()<0) countTeam1--;
                            // если все бойцы погибли меняем значение
                            // endGame(завершить игру) и выходим из внутренего цикла
                            // и завершаем игру
                            if (countTeam1==0)
                            {
                                endGame=true;
                                System.out.println(" В команде Team1 погибли все бойцы");
                                break;
                            }

                        }

                }
            }
        }

        System.out.println("---------------");

        for (Hero t1: team1) {
            t1.info();
        }
        System.out.println("---------------");

        for (Hero t2: team2) {
            t2.info();
        }

    }


    
}