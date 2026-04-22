package serializace;

import java.io.*;

public class basics {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Coordinates coords = new Coordinates(10, 5 ,95);
        System.out.println("exportuju: " + coords);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/coords.ser"));
        oos.writeObject(coords);
        oos.close();

        Coordinates toRead = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/coords.ser"));
        toRead = (Coordinates) ois.readObject();

        System.out.println("importovano: " + toRead);
    }
}

class Coordinates implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    int x,y,z;

    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ", " + z + "]";
    }
}