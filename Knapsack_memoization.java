// TODO : knapsack problem using memoization;
// time complexity: O(N*W);

public class Knapsack_memoization {
    public static void main(String[] args) {
       int wt[] = {10,20,30};
       int val[] = {60,100,120};
       
       int W = 50;
       int n= wt.length;

        System.out.println(knapSack(wt, val, W, n));
    }
    static int knapsackRec(int wt[], int val[], int W, int n, int t[][]){
        if(n==0||W==0)
            return 0;
        if(t[n][W] != -1)
            return t[n][W];
        else if(wt[n-1] <= W){
            return t[n][W] = max(val[n-1]+knapsackRec(wt, val, W-wt[n-1], n-1, t), knapsackRec(wt, val, W, n-1,t));
        }
        else{
            return t[n][W] = knapsackRec(wt, val, W, n-1,t );
        }
    }
    static int max(int a, int b){
        return (a>b)?a:b;
    }
    static int knapSack(int wt[], int val[], int W, int n  ){
        int t[][] = new int[n+1][W+1];
        
        // loop to assign -1 to the array

        for(int i=0; i<n+1; i++){
            for(int j=0;j<W+1; j++){
                t[i][j] = -1;
            }
        }

        return knapsackRec(wt, val, W, n, t);
    }
}
