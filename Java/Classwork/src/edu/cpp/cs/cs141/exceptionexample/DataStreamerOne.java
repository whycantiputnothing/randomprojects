package edu.cpp.cs.cs141.exceptionexample;

import java.io.*;

public class DataStreamerOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			prepareFile("file.dat");

			RandomAccessFile raf = new RandomAccessFile("file.dat", "rw");
			raf.seek(4);
			System.out.println(raf.readBoolean());
			raf.skipBytes(8);
			System.out.println(raf.readChar());
			System.out.println(raf.skipBytes(100));
			raf.seek(0);
			System.out.println(raf.readInt());
			raf.skipBytes(11);
			System.out.println(raf.length());
			System.out.println(raf.getFilePointer());

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void prepareFile(String fileName) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(42);
			dos.writeBoolean(true);
			dos.writeLong(42);
			dos.writeChar('N');
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
