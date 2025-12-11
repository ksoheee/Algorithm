#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int Max(int x, int y) { return x > y ? x : y; }

int T;
int arr[100000];
int dp[100000];


void Input(void)
{
    scanf("%d", &T);
    for (int i = 1; i <= T; i++) {
        scanf("%d", &arr[i]);
    }
}
void Solution()
{ 
    int ans = arr[1];
    dp[1] = arr[1];   //첫 번째 합: 첫 번째 원소 본인
    for (int i = 2; i <= T; i++) {
        dp[i] = Max(dp[i-1] + arr[i],arr[i]);
    }
    
    for (int i = 2; i <= T; i++) {
        ans = Max(ans,dp[i]);
    }
    printf("%d", ans);
}
int main(void)							
{   
    Input();
    Solution();
 
    return 0;
}
