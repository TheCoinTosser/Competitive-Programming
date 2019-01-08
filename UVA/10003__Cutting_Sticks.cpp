#include <iostream>
#include <cstdlib>
#include <map>
#include <string>
#include <math.h>
#include <limits.h>

using namespace std;
#define INF INT_MAX

bool shouldCut[1001];
int m[1001][1001];

int optimalCut(int indexStart, int indexEnd){

  int memorizedResult = m[indexStart][indexEnd];
  if(memorizedResult != INF){
    return memorizedResult;
  }

  int minSubcutCost = INF;
  for(int c=indexStart+1; c<indexEnd; c++){
    if(shouldCut[c]){
      int length = indexEnd - indexStart;
      int cost = length + optimalCut(indexStart, c) + optimalCut(c, indexEnd);

      if(cost < minSubcutCost){
        minSubcutCost = cost;
      }
    }
  }

  //There was nothing to cut. cost == 0
  if(minSubcutCost == INF) minSubcutCost = 0;

  m[indexStart][indexEnd] = minSubcutCost;

  return minSubcutCost;
}

int main(){
  for(;;){
    //Input - START
    int stickLength;
    cin >> stickLength;
    if(stickLength == 0) break;
    //Input - END

    //Preprocessing - START
    for(int i=0; i<=1000; i++){
      shouldCut[i] = false;
      for(int j=0; j<=1000; j++){
        m[i][j] = INF;
      }
    }
    //Preprocessing - END

    //Input - START
    int numberOfCuts;
    int cutIndex;
    cin >> numberOfCuts;
    for(int cut = 0; cut < numberOfCuts; cut++){
      cin >> cutIndex;
      shouldCut[cutIndex] = true;
    }
    //Input - END

    //Solution - START
    int optimalCost = optimalCut(0, stickLength);
    printf("The minimum cutting is %d.\n", optimalCost);
    //Solution - END
  }

  return 0;
}