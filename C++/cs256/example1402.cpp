#include <iostream>
#include <cstring>
using namespace std;

int mystrcmp (const char *s1, const char *s2);

int main(){
  char s1[] = "string0";
  char s2[] = "String0";

  int val = mystrcmp(s1,s2);
  if (val < 0)
    cout << "s1 < s2" << endl;
  else if( val == 0)
    cout << "s1 == s2" << endl;
  else if(val > 0)
    cout << "s1 > s2" << endl;

  return 0;
}

int mystrcmp (const char *s1, const char *s2)
{
  char *ms1 = new char[strlen(s1) + 1];
  char *ms2 = new char[strlen(s2) + 1];

  strcpy(ms1, s1);
  strcpy(ms2,s2);

  for (int i = 0; i < strlen(ms1); i++) {
    if( ms1[i] >= 'a' && ms1[i] <= 'z')
      ms1[i] = (char)(ms1[i] - 32);
  }

  for (int i = 0; i < strlen(ms2); i++) {
    if( ms2[i] >= 'a' && ms2[i] <= 'z')
      ms2[i] = (char)(ms2[i] - 32);
  }

  return strcmp(ms1, ms2);
}
