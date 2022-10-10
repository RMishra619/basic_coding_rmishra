class knapsack_Recursive{
    static int  knapsack(int val[], int wt[], int W, int n){
        if(n==0|| W == 0)
        return 0;

        if(wt[n-1] <= W)
        return max(val[n-1]+knapsack(val, wt, W-wt[n-1], n-1) , knapsack(val, wt, W, n-1));

        else
        return knapsack(val, wt, W, n-1);
    }
    static int max(int a, int b){
        return (a>b) ?a:b;
    }


    public static void main(String[] args) {
        int val[] = {1,3,5,6,7};
        int wt[] =  {1,2,3,4,5};
        int W = 10;
        int n = wt.length;
        int maxProfit = knapsack(val, wt, W, n);

        System.out.println("maximum is : "+ maxProfit);

    }

}