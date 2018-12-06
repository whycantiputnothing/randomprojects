# Simulate a geometric random variable 10000 times with probability
# of success p = 20%, by simulating a sequence of Bernoulli trials and
# then taking the number of the first successful trial. Compute empirical
# mean and variance using (7) and (8), and compare with theoretical values.

import numpy as np

#Simulating Geometric R.V.'s by using sequence of
#10k Bernoulli Trials

n=10000 #10k regenerations
simulation = 0
count = 1
s = []
for i in range(n):
    while (1):
        if (np.random.binomial(1,0.2,1) == 0):
            count = count + 1
        else:
            break
    s.append(count)
    count = 1
#Empirical mean, formula (7)
xbar = float(np.sum(s))/n
print ("Empirical Mean", xbar)


#Theoretical mean
print ("Theoretical Mean",np.mean(s))
#or it could be
print ("Theoretical Mean",sum(s)*0.20)


#EMpirical variance, formula (8)
minus = s
for i in range(n):
    minus[i] = minus[i] - xbar
MinusSq = np.square(minus)
SumMinusSq = sum(MinusSq)
EmpVar = SumMinusSq / (n - 1)
print ("Empirical Variance", EmpVar)

#Theoretical Variance
print ("Theoretical Variance",np.var(s))
#or it could be Var = E(x^2) - [E(x)]^2
