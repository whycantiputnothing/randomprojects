# Simulate a geometric random variable 10000 times with probability
# of success p = 20%, by simulating a sequence of Bernoulli trials and
# then taking the number of the first successful trial. Compute empirical
# mean and variance using (7) and (8), and compare with theoretical values.

import numpy as np
np.random.seed(100)

#Simulating Geometric R.V.'s by using sequence of
#10k Bernoulli Trials

n=10000 #10k regenerations

count = 0

for (i=0 : n):
    while (simulation == 0):
    #simulate 10,000 trials with
        simulation = np.random.binomial(1)
        count += 1
#need to create a vector "x" to add all the simulations
#tbh idk how to do this


#Empirical mean, formula (7)
xbar = np.sum(x)/n
print ("Empirical Mean", xbar)

#Theoretical mean
print ("Theoretical Mean",np.mean(x))
#or it could be
print ("Theoretical Mean",sum(x)*0.20)


#EMpirical variance, formula (8)
minus = np.subtract(Xi - xbar)#to make Xi's, make array "Xi" = X1+..+Xn
MinusSq = np.square(minus)
SumMinusSq = sum(MinusSq)
EmpVar = (1/n-1) * SumMinusSq
print ("Empirical Variance", EmpVar)

#Theoretical Variance
print ("Theoretical Variance",np.var(x))
#or it could be Var = E(x^2) - [E(x)]^2
