import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Thread;
class ThreadA extends Thread{
	
	ArrayList<String> fishesList;
	public ThreadA(ArrayList<String> fishes) {
		this.fishesList=fishes;
	}
	public void run()
	{
		try
		{
			synchronized(this)
			{
				Random random_method=new Random();
				while(!fishesList.isEmpty())
				{
					int randomIndex1=ThreadLocalRandom.current().nextInt(fishesList.size())% fishesList.size();
				    int randomIndex2=ThreadLocalRandom.current().nextInt(fishesList.size())% fishesList.size();
					int i1 = random_method.nextInt(fishesList.size());
		            int i2 = random_method.nextInt(fishesList.size());
		            if(fishesList.get(i1)=="M" && fishesList.get(i2)=="M") {
		            	fishesList.remove(fishesList.get(i1));
		            	fishesList.remove(fishesList.get(i2));
		            }
		            else if(fishesList.get(i1)=="M" && fishesList.get(i2)=="F" || fishesList.get(i1)=="F" && fishesList.get(i2)=="M") {
		            	fishesList.add(fishesList.get(random_method.nextInt(fishesList.size())));
		            	fishesList.add(fishesList.get(random_method.nextInt(fishesList.size())));
		            }
		            else if(fishesList.isEmpty()) {
		            	System.exit(1);
		            }
		            else {
		               	int randomOfTwoInts = new Random().nextBoolean() ? randomIndex1 : randomIndex2;
			    		fishesList.remove(randomOfTwoInts);
		            }
		            System.out.println(fishesList);
		        }
			}
		}
		catch(Exception e) {}
	}
}
public class FishOpThread {
	public static void main(String[] args)
	{
		ArrayList<String> fishes = new ArrayList<>(Arrays.asList("M","M","M","M","M","M","M","M","M","M","F","F","F","F","F","F","F","F","F","F"));
		ThreadA t1=new ThreadA(fishes);
		t1.start();
		ThreadA t2=new ThreadA(fishes);
		t2.start();
		ThreadA t3=new ThreadA(fishes);
		t3.start();
		ThreadA t4=new ThreadA(fishes);
		t4.start();
		ThreadA t5=new ThreadA(fishes);
		t5.start();
		
	}
}