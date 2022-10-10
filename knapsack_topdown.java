// TODO: solve th eknapsack problme using iterative method; memoization wale ko bs iterative m change krna h bs


public class knapsack_topdown {
    public static void main(String[] args) {
        int wt[] = {10,20,30};
       int val[] = {60,100,120};
       
       int W = 50;
        int n = wt.length;
        System.out.println(knapsack(wt, val, W, n));
    }
    static int knapsackTD(int wt[], int val[], int W, int n, int t[][]){
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<W+1; j++){
                if(wt[i-1] <= j)
                t[i][j] = max(val[i-1] + t[i-1][j-wt[i-1]] , t[i-1][j]);

                else
                t[i][j] = t[i-1][j];
            }
        }

        return t[n][W];
        
    }
    static int knapsack(int wt[], int val[], int W, int n){
        int t[][] = new int[n+1][W+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                t[i][j] = -1;
            }
        }

        return knapsackTD(wt, val, W, n,  t);
    }
    static int max(int a, int b){
        return (a>b)?a:b;
    }
}
