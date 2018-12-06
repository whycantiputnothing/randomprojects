import numpy as np

n = 10000 #10k simulations
x = [] #x will be our vector full of uniform R.V.'s
count = 0
for i in range(n):
    u = np.random.uniform(0,1)
    Inverse = np.tan(u * np.pi/2) #inverse function
    x.append(Inverse)
print("Inverse Function R.V.: ",x) #Geometric R.V.

for i in x:
    if(i > 2):
        count = count + 1
ProbXGrt2 = float(count)/n
print (ProbXGrt2)
