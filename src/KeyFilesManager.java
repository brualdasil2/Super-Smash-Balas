import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class KeyFilesManager {
	
	public static String nameToFilename(String name) {
		return "pbControls/" + name + ".pbc";
	}
	
    public static void saveControls(int[] arr, String fileName) {
    	int len = 8;
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < len; i++) {
                dos.writeInt(arr[i]);
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readControls(String fileName) {
    	int len = 8;
        int[] arr = new int[len];
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            for (int i = 0; i < len; i++) {
                arr[i] = dis.readInt();
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }



}
