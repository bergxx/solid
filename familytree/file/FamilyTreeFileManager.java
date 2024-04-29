package familytree.file;

import familytree.model.Human;

import java.util.List;

public interface FamilyTreeFileManager {
    void saveFamilyTree(String filename, List<Human> family);
    List<Human> loadFamilyTree(String filename);
}