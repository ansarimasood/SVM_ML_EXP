import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        int n = 0,m=0;
        int[][] INPUT = new int[20][20];
        int[] LABEL = new int[20];
        int[] B = new int[20];
        int[] C = new int[20];
        int[] W = new int[20];
        int[] Y = new int[20];
        int[] vector = new int[20];
        int count = 1;
        int bias = 0;
        double margin = 0.0;
        int weight = 0;
        int a ,b,c;
        System.out.print("Enter No of Input : ");
        n = scanner.nextInt();

        System.out.print("Enter No of Dimensions : ");
        m = scanner.nextInt();

        for (int i = 1,k=65; i <=n ; i++,k++) {
            String str = Character.toString((char)k);
            System.out.println("Enter value for Input "+str);
            for (int j = 1; j <= m; j++) {
                System.out.print("Enter value for dimension "+j +" for Input "+str +" : ");
                INPUT[i][j] =  scanner.nextInt();
            }
            System.out.print("Enter Labels for "+str +" : ");
            LABEL[i] = scanner.nextInt();
        }

        System.out.println("Enter Constant of Hyper Plane");
        for (int i = 1; i <=m+1 ; i++) {
            if (i<=m) {
                System.out.print("Enter value of x"+i +" : ");
                W[i] = scanner.nextInt();
            }else{
                System.out.print("Enter value of bias : ");
                W[i] = scanner.nextInt();
            }
        }
        bias = W[m+1];

        System.out.println("\nDecide Support Vectors and Calculate Margin");

        for (int i = 1; i <=n ; i++) {
            weight =weight+ W[i]*W[i];

        }
        margin = 2/Math.sqrt(weight);
        System.out.println("Margin = "+margin);

        System.out.println("\nSupport Vector");

        for (int i = 1,k=65; i <=n ; i++,k++) {
            int sum=0;
            String str = Character.toString((char)k);
            System.out.print("\nConsider Point "+str +"\n");
            for (int j = 1; j <=m ; j++) {
                sum = sum+ W[j]*INPUT[i][j];
            }
            vector[i] =   LABEL[i]*(sum+bias);
            if (vector[i]==1){
                System.out.println(vector[i]);
                System.out.println(str + " is a Support Vector of class "+LABEL[i]);
            }else {
                System.out.println(vector[i]);
                System.out.println(str + " is not a Support Vector");
            }

        }



    }
}
