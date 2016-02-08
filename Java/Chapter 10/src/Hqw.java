import java.util.ArrayList;


public class Hqw {
	
	interface Speakable {
		void speak(String n);
	}
	
	public class Dog implements Speakable
	{
	   private String name;

	   public Dog(String name)
	   {
	      this.name = name;
	   }

	   public String toString()
	   {
	      return "Dog:  " + name;
	   }
	public void speak(String n) {
		
	}
	}

	public class Cat implements Speakable
	{
	   private String name;

	   public Cat(String name)
	   {
	      this.name = name;
	   }

	   public void speak(String n)
	   {
	     System.out.println("Meow! Meow!");
	   }

	   public String toString()
	   {
	      return "Cat:  " + name;
	   }
	}
	   public static void main(String[] args)
	   {
	      ArrayList dogcatList = new ArrayList();
	      dogcatList.add(new Dog("Fred"));
	      dogcatList.add(new Cat("Wanda"));
	      for (Object obj : dogcatList)
	      {
	         obj.speak();
	      }
	   }
	}


}
