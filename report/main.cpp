#include <bits/stdc++.h>
using namespace std;

int main()
{
    freopen("in.txt","r",stdin);
    freopen("out.txt","w",stdout);
    vector<string> S;
    ifstream fin;
    fin.open("title.txt");
    string str;
    while (!fin.eof())
    {
        getline(fin, str);
        S.push_back(str);
    }
    fin.close();
    for(int i=0;i<S.size();i++)
    {
        for(int j=S[i].length()-8;j<=S[i].length()-1;j++)
            S[i][j]='\0';
    }
    int n;
    while(scanf("%d",&n)!=EOF)
    {
        cout<<n<<". "<<S[n-1]<<endl;
    }
    fclose(stdin);
    fclose(stdout);
    return 0;
}
