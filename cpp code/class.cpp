#include <iostream>

#include <string>
using namespace std;
class mc{
    public:
    mc(string a):var(a){}
    void p(){
        cout<<var<<endl;
        cout<<(*this).var<<endl;
        cout<<this->var<<endl;
    }
    private:
    string var;

};
int main(){
    mc obj("david\n");
    obj.p();
    mc obj2("david\n");
}