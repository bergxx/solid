import familytree.cli.FamilyTreeCLI;
import familytree.file.FamilyTreeFileManagerImpl;
import familytree.service.FamilyTree;
import familytree.service.FamilyTreeService;
import familytree.service.FamilyTreeServiceImpl;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        FamilyTreeFileManagerImpl fileManager = new FamilyTreeFileManagerImpl();

        FamilyTreeService service = new FamilyTreeServiceImpl(familyTree, fileManager);

        FamilyTreeCLI cli = new FamilyTreeCLI(service);
        cli.start();
    }
}