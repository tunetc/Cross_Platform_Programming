import java.util.Scanner;

class arrTest {
    public static void main(String[] args) {
        int leght = 20;
        int[] arr = new int[leght];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*10); 
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        try 
        {
            System.out.println("Введіть число:");
            int s = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (s == arr[i]) {
                    count++;
                }
            }
            System.out.println("Співпадінь у масиві: " + count);
        }

        finally 
        {
            scanner.close();
        }
    }
}