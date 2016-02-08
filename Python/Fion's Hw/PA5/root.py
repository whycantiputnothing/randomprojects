#
#    You must fill in the your name, umail address, and perm number below:  
#    Partner1 first name:
#    Partner1 last  name:
#    Partner1 umail account: 
#    Partner1 perm number: 
#    Leave the following blank if you do not have a partner for this assignment. 
#    Otherwise, fill in the partner's name, umail address, and perm number below:
#    Partner2 first name:    
#    Partner2 last  name:
#    Partner2 umail account: 
#    Partner2 perm number: 
#    NOTE:    One and only one partner should turn in the codes for grading. 
#    It does not matter which partner does that; both partners will receive the same score. 
#


# 
# bi-section method 
#
def bs(coef, f, df, eps = 1.0e-10) :            # bisection 
    xUp = 1
    xMid = 0
    xLow = -1
    while (f3(coef, xUp) < 0) :
        xUp += 1
    while (f3(coef, xLow) > 0) :
        xLow -= 1
    for i in range(100) :
        xMid = (xUp + xLow)/2
        lowTuple = ("%.5f" % xLow + "  " + "%.5f" % f3(coef, xLow))
        midTuple = ("%.5f" % xMid + "  " + "%.5f" % f3(coef, xMid))
        upTuple = ("%.5f" % xUp + "  " + "%.5f" % f3(coef, xUp))
        print ("(" + str(lowTuple) + ")" + "\t" + "(" +  str(midTuple) + ")" + "\t" +  "(" + str(upTuple) + ")")
        if(-(eps) < f3(coef, xMid) < eps) :
            print("final approximate solution at: " + str(xMid))
            print("function value at final solution is: " + str(f3(coef, xMid)))       
            break
        elif (f3(coef, xMid) > 0) :
            xUp = xMid
        else :
            xLow = xMid
            
    
#
# Newton Raphson method
#
def nr(coef, f, df, eps = 1.0e-10, iGuess = 0.0) :    # newton-raphson
    guess = iGuess
    funcVal = 0
    for i in range (100) :
        funcVal = f3(coef, guess)
        print("guess and func value: \t" + str("%.5f" % guess) + "\t" + str("%.5f" % funcVal) )
        if (f3(coef, guess) == 0) :
            print("search terminated, no residual error")
            print("final approximate solution at : " + str(guess))
            print("function value at the final solution is: " + str(f3(coef, guess)))
            break
        elif(-(eps) < f3(coef, guess) < eps) :
            print("search terminated, small residual error")
            print("final approximate solution at : " + str(guess))
            print("function value at the final solution is: " + str(f3(coef, guess)))
            break
        else :
            runOverRise = 1/(df3(coef, guess))
            guess = guess - funcVal*runOverRise
#
# 3rd-order function, coefficient of x^3 is normalized to 1 
#
def f3(coef,x) :
    evaluate = (x**3) + (coef[0]*x**2) + (coef[1]*x) + coef[2];
    return evaluate

#
# derivatives of the 3rd order function
#
def df3(coef,x) :
    derivative = (3*x**2) + (2*coef[0]*x) + coef[1]
    return derivative

def main():
    coef = [1,2,3]
    guess = 0
    funcVal = f3(coef, guess)
    eps = 1.0e-10
    print("guess and func value: \t" + str(guess) + "\t" + str(funcVal) )
    if (f3(coef, guess) == 0) :
        print("search terminated, no residual error")
        print("final approximate solution at : " + str(guess))
        print("function value at the final solution is: " + str(f3(coef, guess)))
    elif(-(eps) < f3(coef, guess) < eps) :
        print("search terminated, small residual error")
        print("final approximate solution at : " + str(guess))
        print("function value at the final solution is: " + str(f3(coef, guess)))
    else :
        runOverRise = 1/(df3(coef, guess))
        guess = guess - funcVal*runOverRise
    print(guess)
#main()
#print(f3([1,2,3], -1.257))
bs([1,2,3], f3, df3, 1.0e-5)
nr([1,2,3], f3, df3, 1.0e-5)
# if necessary, you can define more functions below 
#