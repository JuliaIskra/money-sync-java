package juliaiskra.money.sync.domain;

/**
 * @author Julia Nemtseva
 */
public class Account {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    protected final void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected final void setName(final String name) {
        this.name = name;
    }

}
