import java.io.*;

public class Lab5_2 {
    public static void main(String args[]) {
    	byte[] bytesReaded = new byte[500];
        try {
            byte[] bytesToWrite = new byte[500]; 
            for(int i=0; i<500;i++) {
                bytesToWrite[i]=(byte) i;
            }

            long start = System.currentTimeMillis();
            BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("file.txt")); // Создание текстового файла
            for (int i = 0; i < bytesToWrite.length; i++) {
				fos.write(bytesToWrite[i]); // Запись каждого символа в текстовый файл
			}
			fos.close();
            long end = System.currentTimeMillis();
            System.out.println(end-start);

            long start2 = System.currentTimeMillis();
            BufferedInputStream inFile = new BufferedInputStream(new FileInputStream("file.txt"));
            int bytesAvailable = inFile.available(); // сколько можно считать

			for (int j = 0; j < bytesAvailable; j++) {
				bytesReaded[j] = (byte) inFile.read();
			}

			inFile.close();
            long end2 = System.currentTimeMillis();
            System.out.println(end2-start2);
        }
        catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
    }
}