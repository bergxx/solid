package familytree.file;

import familytree.model.Human;

import java.io.*;
import java.util.List;

public class FamilyTreeFileManagerImpl implements FamilyTreeFileManager {
    @Override
    public void saveFamilyTree(String filename, List<Human> family) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(family);
            System.out.println("Дерево семьи успешно сохранено в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении дерева семьи в файл: " + e.getMessage());
        }
    }

    @Override
    public List<Human> loadFamilyTree(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            List<Human> family = (List<Human>) inputStream.readObject();
            System.out.println("Дерево семьи успешно загружено из файла: " + filename);
            return family;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке дерева семьи из файла: " + e.getMessage());
            return null;
        }
    }
}