package familytree.service;

import familytree.model.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human> {
    private List<Human> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(Human member) {
        if (member != null) {
            this.family.add(member);
        }
    }

    public List<Human> getFamily() {
        return this.family;
    }

    @Override
    public Iterator<Human> iterator() {
        return family.iterator();
    }
}