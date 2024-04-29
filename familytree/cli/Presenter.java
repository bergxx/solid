package familytree.cli;

import familytree.model.Gender;
import familytree.model.Human;
import familytree.service.FamilyTreeService;

import java.util.List;

public class Presenter {
    private final FamilyTreeCLI view;
    private final FamilyTreeService service;

    public Presenter(FamilyTreeCLI view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
    }

    public void showMenu() {
        view.printMessage("1. Добавить члена семьи");
        view.printMessage("2. Удалить члена семьи");
        view.printMessage("3. Показать семейное древо");
        view.printMessage("4. Выйти");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                view.printMessage("Введите детали нового члена семьи:");
                break;
            case 2:
                view.printMessage("Введите имя члена семьи для удаления:");
                String name = view.getInput();
                boolean deleted = service.deleteMemberByName(name);
                if (deleted) {
                    view.printMessage(name + " успешно удален из семьи.");
                } else {
                    view.printMessage("Член семьи не найден.");
                }
                break;
            case 3:
                view.printFamily(service.getFamily());
                break;
            case 4:
                view.printMessage("Выход...");
                System.exit(0);
                break;
            default:
                view.printMessage("Неверная опция.");
                break;
        }
    }
}
