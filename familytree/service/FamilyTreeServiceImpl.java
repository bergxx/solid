package familytree.service;

import familytree.file.FamilyTreeFileManagerImpl;
import familytree.model.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeServiceImpl implements FamilyTreeService {
    private FamilyTree tree;
    private FamilyTreeFileManagerImpl fileManager;

    public FamilyTreeServiceImpl(FamilyTree tree, FamilyTreeFileManagerImpl fileManager) {
        this.tree = tree;
        this.fileManager = fileManager;
    }

    @Override
    public void addMember(Human member) {
        tree.addMember(member);
    }

    @Override
    public List<Human> getFamily() {
        return tree.getFamily();
    }

    @Override
    public void saveToFile(String filename) {
        fileManager.saveFamilyTree(filename, tree.getFamily());
    }

    @Override
    public List<Human> loadFromFile(String filename) {
        return fileManager.loadFamilyTree(filename);
    }

    @Override
    public boolean deleteMemberByName(String name) {
        for (Iterator<Human> iterator = tree.iterator(); iterator.hasNext();) {
            Human member = iterator.next();
            if (member.getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
