#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int Max(int x, int y)
{
    return x > y ? x : y;
}
int main(void)							
{
    int T, ans=0;
    int dp[10000];
    int arr[10000];
  
    scanf("%d", &T);

    for (int i = 1; i <= T; i++) {
        scanf("%d", &arr[i]);
    }
    
    for (int i = 1; i <= T; i++) {
        dp[i] = 1;
        for (int j = i - 1; j >= 1; j--) {
            if (arr[i] > arr[j]) {
                dp[i] = Max(dp[i], dp[j] + 1);
            }
        }
        ans = Max(dp[i], ans);
    }
    printf("%d\n", ans);
 
    return 0;
}