import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
    	int i = 0;
    	i+= m/10;
    	m = m%10;
    	i+= m/5;
    	m=m%5;
    	i+= m;
    			
    	
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

