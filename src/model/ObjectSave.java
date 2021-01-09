package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectSave {
	public static void saveData(OrderDataStructure obj,String fileName)throws IOException{
	    FileOutputStream fos = new FileOutputStream(fileName,false);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(obj);
	    oos.close();
	}

	public static OrderDataStructure loadData(String location) throws IOException, ClassNotFoundException{
	   String fileName= location;
	   FileInputStream fin = new FileInputStream(fileName);
	   ObjectInputStream ois = new ObjectInputStream(fin);
	   OrderDataStructure data= (OrderDataStructure) ois.readObject();
	   try {
		ois.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return data;
	}
}
