public class ParentingAgeException extends Exception {
    private final Person parent, child;
    public ParentingAgeException(Person parent, Person child) {
        super(parent+" is less 15yo or dead at birth of: "+child);
        this.parent = parent;
        this.child = child;
    }

    public Person getParent() {
        return parent;
    }

    public Person getChild() {
        return child;
    }
}
