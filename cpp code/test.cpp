// #include <bits/stdc++.h>
#include <iostream>
using namespace std;

string StringConvert(string s, int n)
{
    int newstr;
    string s1;
    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
        {
            n = n + 2;
        }
        else
        {
            n++;
        }
        newstr = (int)s[i] * n;
        s1.append(to_string(newstr));
        s1.append(" ");
    }
    return s1;
}