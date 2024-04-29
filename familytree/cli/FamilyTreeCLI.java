package familytree.cli;

import familytree.model.Human;
import familytree.service.FamilyTreeService;

import java.util.List;
import java.util.Scanner;

public class FamilyTreeCLI {
    private final FamilyTreeService service;
    private final Scanner scanner;

    public FamilyTreeCLI(FamilyTreeService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добро пожаловать в программу родословного древа!");

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить члена семьи");
            System.out.println("2. Удалить члена семьи");
            System.out.println("3. Показать семейное древо");
            System.out.println("4. Выйти из программы");

            System.out.print("Введите номер команды: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали: Добавить члена семьи");
                    break;
                case 2:
                    System.out.println("Вы выбрали: Удалить члена семьи");
                    break;
                case 3:
                    System.out.println("Вы выбрали: Показать семейное древо");
                    printFamily(service.getFamily());
                    break;
                case 4:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
            }
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод. Введите целое число.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void printFamily(List<Human> family) {
        for (Human member : family) {
            System.out.println(member);
        }
    }
}