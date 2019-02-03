#include <iostream>
#include <istream>
#include <cstdlib>
#include <string>
#include <list>

using namespace std;

int numberOfTestCases;
int missiles[1001];
int lis[1001];
int parent[1001];

int main(){

  cin >> numberOfTestCases;
  string line;
  getline(cin, line);
  getline(cin, line);
  for(int n=1; n<=numberOfTestCases; n++){
    int numberOfMissiles = 0;

    //Read an empty line
    while(getline(cin, line) && !line.empty()){
      int missileHeight = atoi(line.c_str());
      missiles[numberOfMissiles] = missileHeight;

      lis[numberOfMissiles] = 1;
      parent[numberOfMissiles] = -1;
      numberOfMissiles++;
    }

    int largestLis = 1;
    int lastIndexOfLargestLis = 0;
    for(int i=0; i<numberOfMissiles; i++){

      int maxListSoFar = 1;
      int parentIndex = -1;
      for(int j=0; j<i; j++){
        if(missiles[j] < missiles[i]){
          int localMax = lis[j] + 1;
          if(localMax > maxListSoFar){
            maxListSoFar = localMax;
            parentIndex = j;
          }
        }
      }
      parent[i] = parentIndex;
      lis[i] = maxListSoFar;

      if(maxListSoFar > largestLis){
        largestLis = maxListSoFar;
        lastIndexOfLargestLis = i;
      }
    }

    printf("Max hits: %d\n", largestLis);

    list<int> reverseList;
    reverseList.push_back(missiles[lastIndexOfLargestLis]);
    while((lastIndexOfLargestLis = parent[lastIndexOfLargestLis]) != -1){
      reverseList.push_back(missiles[lastIndexOfLargestLis]);
    }

    reverseList.reverse();
    for (int &missileHeight : reverseList) {
      printf("%d\n", missileHeight);
    }

    //This problem has very strict output requirements...
    if(n!=numberOfTestCases){
      printf("\n");
    }
  }

  return 0;
}