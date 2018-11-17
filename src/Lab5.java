import java.io.*;

public class Lab5 {

	public static void main(String[] args) {
		byte[] bytesToWrite = new byte[500];
		for (int i = 0; i < 500; i++) {
			bytesToWrite[i] = (byte) i;
		}

		byte[] bytesReaded = new byte[500];
		long h = System.currentTimeMillis();
		try (OutputStream fos = new FileOutputStream("file.txt")) { // поток для записи
			for (int i = 0; i < bytesToWrite.length; i++) {
				fos.write(bytesToWrite[i]); // Запись каждого символа в текстовый файл
			}
			fos.close();
			long h2 = System.currentTimeMillis();

			long h3 = System.currentTimeMillis();
			FileInputStream inFile = new FileInputStream("file.txt"); // считывание
			int bytesAvailable = inFile.available(); // сколько можно считать

			for (int j = 0; j < bytesAvailable; j++) {
				bytesReaded[j] = (byte) inFile.read();
			}

			inFile.close();
			long h4 = System.currentTimeMillis();

			System.out.println(h2 - h);
			System.out.println(h4 - h3);

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("The file has been written  ");
	}
}