N will be last number in the series of natural numbers. 

So if its N=5 then then series of number are 

1,2,3,4,5 

And all these numbers in the series, one by one will be passed to a method() that will return some desired result and then those results will be added. So let's assume we are iterating the above series and at point of time, we get a number X and pass it into that method(). let say X = 3.

And C will be the total number of preceding numbers for the given number at a time.

So C will decide how many preceding numbers I should take for the incoming number X in order to multiply them.

 If C is 2 (as in your example) then the preceding number will be 1 and 2 for X.
So I will multiply 1*2 and return the result 2.

Hence the above series when passed into the method the desired results will be

Number          Previous numbers             Product
1                 (-1 * 0 )                     0
2                  (0 * 1)                      0
3                  (1 * 2)                      2
4                  (2 * 3)                      6
5                  (3 * 4)                     12
