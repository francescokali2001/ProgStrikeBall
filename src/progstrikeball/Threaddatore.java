package progstrikeball;
public class Threaddatore extends Thread{
	boolean i=false;
	@Override
	public void run(){
		for(int c=5;c!=0;c-=1){
			try {
				if(i==true){
					this.interrupt();
					System.out.println("Fine");
					break;
				}
				System.out.println("Mancano "+c+" secondi");
				this.sleep(1000);
			} catch (InterruptedException ex) {
				System.err.println("ERRORE!!!!");
			}
		}
		
	}
}