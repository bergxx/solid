package familytree.service;

import familytree.model.Human;

import java.util.List;

public interface FamilyTreeService {
    void addMember(Human member);
    List<Human> getFamily();
    void saveToFile(String filename);
    List<Human> loadFromFile(String filename);
    boolean deleteMemberByName(String name);
}
