package control_task2.java_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Play {
    private List<Toy> listToys = new ArrayList<>();
    private int toy_count;

    public List<Toy> getToys() {
        return listToys;
    }

    public int getToy_count() {
        System.out.println("Количеcтво игрушек = ");
        return toy_count;
    }

    public List<Toy> add_toy_in_listToy(Toy name) {
        listToys.add(name);
        toy_count++;
        return listToys;
    }

    private List<Toy> delete_toy_in_listToy(Toy name) {
        listToys.remove(name);
        toy_count--;
        return listToys;
    }

    private void saveInFile() {
        try (FileWriter writer = new FileWriter("my_toys.txt", true)) {
            String text = listToys.get(0).getToy_name();
            writer.write(text + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Возникла ошибка при записи файла");
        }
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("my_toys.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла");
        }
    }


    public void lottteryToy() {
        Scanner scan = new Scanner(System.in);
        int chance = 50;
        System.out.println("по умолчанию шанс на победу 50%");
        System.out.println("для изменения  шанса на победу - нажмите 1");
        System.out.println("если хотите оставить шанс на победу по умолчанию -  нажмите 2");
        String changeСhance = scan.next();
        if (changeСhance.equals("1")) {
            System.out.println("введите число от 1 до 100 - процентное соотношение на победу!");  
            chance = scan.nextInt();
        }
        if (chance >= 0 && chance <= 100) {
            Random rnd = new Random();
            int num = rnd.nextInt(100);
            if (num > chance) {
                System.out.println("увы,вы проиграли, попробуйте снова");
            } else if (num < chance) {
                System.out.println("ура, вы выйграли!");
                saveInFile();
                delete_toy_in_listToy(listToys.get(0));
            }
        } else {
            System.out.println("неверный ввод данных");
        }
    }
}