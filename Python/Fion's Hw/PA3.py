def pie_chart (fname) : 
    file = open(fname)
    mydict = {}
    colorList = ["red", "green", "blue", "yellow", "magenta", "cyan"]
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
    import turtle
    bob = turtle.Turtle()
    bob.speed(6)
    for key in mydict:
        sectorAngle = (mydict[key] / totalVotes) * 360
        if sectorAngle < 10:
            catchAll += sectorAngle
            
        else:
            bob.color("black", colorList[colorCounter])
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
    
    if catchAll != 0:
        bob.color("black", colorList[colorCounter])
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

pie_chart("game_catch.txt")
#pie_chart("game_ball_over_net.txt")
