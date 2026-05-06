import java.util.*;
public class pr7{
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int num = sc.nextInt();
        int[][] matrix = new int[num][num];
        int[] visited = new int[num];
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = sc.nextInt();
            }
            visited[i] = 0;
        }
        visited[0] = 1; 
        int count = 0;
        int total = 0;
        while (count < num - 1) {
            int min = 99;
            int u = -1, v = -1;                        
            for (int i = 0; i < num; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < num; j++) {
                        if (visited[j] == 0 && matrix[i][j] < min) {
                            min = matrix[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }       
            if (u != -1 && v != -1) {
                System.out.println(u + " - " + v + " -> " + min);
                total += min;
                visited[v] = 1;
                count++;
            }
        }
        System.out.println("Total cost = " + total);
    }
}
