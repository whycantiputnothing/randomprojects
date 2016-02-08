"""
BEGIN OF HEADER SECTION
"""
#    Fill in the required information, but DO NOT otherwise change or delete anything in the header
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
"""
END OF HEADER SECTION
"""


def growthModel(initPop, CC, rate, maxIter = 1000) :
    import turtle
    
    ogPop = initPop
    maxY = CC
    if (initPop > CC) :
        maxY = initPop
    
    #holds values of growth
    growthList = []
    
    for i in range (maxIter) :
        growthPop = initPop * (1 + rate * (1 - (initPop/CC)))
        if (growthPop < CC) :
            if (int((growthPop/CC) + .0001) == 1):
                break
        else :
            if (int((growthPop/CC) - .0008) == 0):
                break   
            
        growthList.append(growthPop)
        
        initPop = growthPop
        
    #sets scale in pixels
    scaleX = 850/len(growthList)
    scaleY = 650/maxY
    
    bob = turtle.Turtle()
    bob.speed(20)
    bob.penup()
    #canvas size 950 x 800
    #x axis length = 850
    #y axis length = 700
    
    #draws axis
    bob.back(450)
    bob.left(90)
    bob.back(350)
    bob.pendown()
    bob.forward(700)
    bob.write("population")
    bob.penup()
    bob.back(700)
    bob.right(90)
    bob.pendown()
    bob.forward(850)
    bob.write("time")
    bob.penup()
    bob.back(850)
    
    #draws CC line 
    bob.left(90)
    bob.forward(scaleY*CC)
    bob.color("red")
    bob.right(90)
    bob.pendown()
    bob.forward(850)
    bob.back(100)
    bob.write("carry capacity: " + str(CC))
    bob.penup()
    bob.back(750)
    bob.left(90)
    bob.back(scaleY*CC)
    
    #writes initial population, the growth rate
    bob.forward(scaleY*ogPop)
    bob.pendown()
    bob.write("initial population : " + str(ogPop) + ", growth rate: " + str(rate))
    bob.penup()
    bob.back(scaleY*ogPop)
    
    #puts turtle at starting population
    bob.forward(ogPop*scaleY)
    
    #draws the graph
    for j in range (len(growthList)) :
        bob.pendown()
        bob.color("black")
        x = bob.xcor() + scaleX
        
        y = -350 + (growthList[j]*scaleY)
        bob.goto(x, y)
    
    #if the loop iterated 1000 times this prints
    if (len(growthList) == 1000) :
        bob.penup()
        bob.setpos(0, 0)
        bob.left(90)
        bob.forward(200)
        bob.color("red")
        bob.write("maximum simulation count exceeds, simulation might not have reached the steady state")
    
    turtle.done()
    
#
# if necessary, you can define more functions below 
#

#growthModel(2, 10000, 0.01) #hits max curving up
#growthModel(7000, 5000, 0.2) #should curve downward 
growthModel(10000, 2000, 0.01)#should curve downward and not hit max
#growthModel(200, 10000, .5) #curves up
