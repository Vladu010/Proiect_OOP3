public class ID {
    private int id=-1;
    private static ID instance;

    public static ID getInstance() {
        if (instance == null) {
            instance = new ID();
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id=newId;
    }
}
