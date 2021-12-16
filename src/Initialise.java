import java.io.*;
import java.util.ArrayList;

public class Initialise {

    static File albumFile = new File("C:/Users/charlotte.ripley/IdeaProjects/Charlotte_Store/src/albums.txt");

    public void createFileIfNotExists(){
        try {
            if (!albumFile.isFile()) {
                albumFile.createNewFile();
            }
        }
        catch(IOException ioEx){
            System.out.println("Encountered an error trying to create text file");
            ioEx.printStackTrace();
        }
    }

    public static void writeData(ArrayList<Albums> albums) {
        try {
            FileWriter writer = new FileWriter(albumFile);

            for (Albums a : albums) {
                writer.write( a.albumID + "," + a.albumTitle + "," + a.albumArtist
                        + "," + a.albumPrice + "," + a.albumStock);
                writer.write("\n");
            }
            writer.close();
        } catch (IOException ioex) {
            System.out.println("Failed to write to file");
            ioex.printStackTrace();
        }
    }

    public ArrayList<String> readFile(File file) {
        createFileIfNotExists();
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException ioex) {
            System.out.println("Failed to read the file");
            ioex.printStackTrace();
        }
        return lines;
    }

    private Albums getAlbumFromString(String albumString) {
        Albums a;
        String[] al = albumString.split(" , ");
        a = new Albums(Integer.parseInt(al[0]), (al[1]), (al[2]), Double.parseDouble(al[3]), Integer.parseInt(al[4]));
        return a;
    }

    public ArrayList<Albums> getAlbum(ArrayList<String> albumString) {
        ArrayList<Albums> albums = new ArrayList<>();
        for (String a : albumString) {
            albums.add(getAlbumFromString(a));
        }
        return albums;
    }
}