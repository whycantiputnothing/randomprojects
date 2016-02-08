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

def pie_chart (fname) : 
    file = open(fname)
    mydict = {}
    list1 = ["red", "green", "blue", "yellow", "magenta", "cyan"]
    colorCounter = 0
    catchAll = 0
    heading = 0
    totalVotes = 0
    for line in file:
        lst = line.split("\t")
        gameStr = lst[0]
        popularityInt = int(lst[len(lst) - 1].lstrip())
        mydict[gameStr] = popularityInt
    file.close()
    for key in mydict:
        totalVotes += mydict[key]
    print (totalVotes)
    import turtle
    bob = turtle.Turtle()
    bob.speed(6)
    for key in mydict:
        sectorAngle = (mydict[key] / totalVotes) * 360
        if (sectorAngle < 10):
            catchAll += sectorAngle
            
        else:
            bob.color("black", list1[colorCounter])
            bob.begin_fill()
            bob.forward(100)
            bob.left(90)
            bob.circle(100, sectorAngle)
            bob.left(90)
            bob.forward(100)
            bob.end_fill()
            bob.right(180)
            heading = bob.heading()
            bob.penup()
            bob.right(sectorAngle/2)
            bob.fd(120)
            bob.pendown()
            bob.write(key, align="center")
            bob.penup()
            bob.back(120)
            bob.left(sectorAngle/2)
            bob.setheading(heading)
            
            colorCounter += 1
        
            if colorCounter == 6:
                colorCounter = 0; 
    
    if (catchAll != 0):
        bob.color("black", list1[colorCounter])
        bob.begin_fill()
        bob.forward(100)
        bob.left(90)
        bob.circle(100, catchAll)
        bob.left(90)
        bob.forward(100)
        bob.end_fill()            
        bob.right(180)
        heading = bob.heading()
        bob.penup()
        bob.right(catchAll/2)
        bob.fd(120)
        bob.pendown()
        bob.write("all others", align="center")
        bob.penup()
        bob.back(120)
        bob.left(catchAll/2)
        bob.setheading(heading)
        
    turtle.done()


#
# if necessary, you can define more functions below 
#

#pie_chart("game_catch.txt")
pie_chart("game_ball_over_net.txt")