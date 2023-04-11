package control_task2.java_task;

public class Main {
    public static void main(String[] args) {
        
        Toy car = new Toy(2, "Car"); //добавление игрушек
        Toy doll = new Toy(3, "Doll");
        Toy lego = new Toy(4, "Lego");
        Toy ball = new Toy(6, "Ball");
        Toy bear = new Toy(1, "Bear");

        Play Play = new Play();
        Play.add_toy_in_listToy(bear);
        Play.add_toy_in_listToy(car);
        Play.add_toy_in_listToy(doll);
        Play.add_toy_in_listToy(lego);
        Play.add_toy_in_listToy(ball);

        Play.lottteryToy();
        Play.readFile();
        Play.lottteryToy();
        Play.readFile();
        Play.getToys();
        Play.getToy_count();
    }
}

