package org.game.avengers.helper.utility;

import org.game.avengers.domain.model.map.AbstractMap;

import java.io.*;

public final class FileOperation {
    private FileOperation() {

    }

    public static void writeObjectToFile(AbstractMap abstractMap) throws IOException {

        File avengersFile = new File("avengers.txt");
        avengersFile.createNewFile();
        FileOutputStream f = new FileOutputStream(avengersFile);
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(abstractMap);

        o.close();
        f.close();
    }

    public static void clearFileContent() {
        final File file = new File("avengers.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static AbstractMap readObjectFromFile() {
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(new File("avengers.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects from file
            AbstractMap map = (AbstractMap) oi.readObject();

            oi.close();
            fi.close();
            return map;

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
