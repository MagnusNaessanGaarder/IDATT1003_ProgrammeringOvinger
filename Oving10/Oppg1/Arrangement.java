package Oving10.Oppg1;

public class Arrangement {
    private static int RANDOM_ID = (int) (Math.random() * 9000) + 1000;

    private static int nextID() {
        return RANDOM_ID++;
    }

    final private int ID;
    final private String name;
    final private String location;
    final private String host;
    final private Type type;
    final private long time;

    public Arrangement(String name, String location, String host, Type type, long time) {
        if (!validType(type)) {
            throw new IllegalArgumentException("Arrangementtypen er ikke gyldig");
        }

        this.ID = nextID();
        this.name = name;
        this.location = location;
        this.host = host;
        this.type = type;
        this.time = time;
    }

    private boolean validType(Type type) {
        for (Type c : Type.values()) {
            if (c.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getHost() {
        return this.host;
    }

    public Type getType() {
        return this.type;
    }

    public long getTime() {
        return this.time;
    }

    public int getDate() {
        return Integer.parseInt(Long.toString(time).substring(0,8));
    }
}
