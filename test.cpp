#include <iostream>
#include <queue>
#include <vector>
#include <cmath>
using namespace std;

int solve(int n) {
    queue<pair<int, int> > q;
    q.push(make_pair(n, 0));

    vector<bool> vis(n+1, false);
    vis[n] = true;

    while(!q.empty()){
        int num = q.front().first;
        int step = q.front().second;
        q.pop();
        
        if (num == 0) return step;

        for (int i = 1; ; i++) {
            int a = num-i*i*i;
            if (a < 0) break;
            if (a == 0) return step+1;
            if (!vis[a]) {
                q.push(make_pair(a, step+1));
                vis[a] = true;
            }
        }
    }
    return 1;
    
}

int main(int argc, char const *argv[])
{
    int n;
    // cin >> n;
    cout << solve(29825) << endl;
    
    return 0;
}
