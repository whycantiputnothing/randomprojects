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


#
# draw a num of shape (rectangle or triangle)
# from angle1 to angle2 using color 
#
import turtle
def fan(shape,width,height,num,angle1,angle2,color='red') : 
    b = ((angle2-angle1)/num)
    x = angle1
    aTurtle = turtle.Turtle()
    aTurtle.color(color)
    if (shape == "rectangle") :
        for i in range(num + 1) :
            rectangle(aTurtle,0, 0, width, height, x)
            x += b

    else:
        for i in range(num + 1) :
            triangle(aTurtle,0, 0, width, height, x)
            x += b
    turtle.done()


#
# draw a single rectangle 
# the height dimension is at the specified angle 
#
def rectangle(turtle, xpos, ypos, width, height, angle = 0) : 
    turtle.setpos(xpos, ypos)
    turtle.setheading(angle)
    for i in range(2):
        turtle.forward(width)
        turtle.left(90)
        turtle.forward(height)
        turtle.left(90)
      
    

#
# draw a single isoslet triangle 
# the height dimension is at the specified angle 
#
def triangle(turtle, xpos, ypos, width, height, angle=0) : 
    import math
    
    turtle.penup()
    turtle.setpos(xpos, ypos)
    turtle.setheading(angle)
    turtle.pendown()
    turtle.forward(width)
    angle = math.degrees(math.atan(height/(width/2)))
    angleRad = math.radians(angle)
    turtle.left(180-angle)
    turtle.forward(height/(math.sin(angleRad)))
    turtle.left(2*angle)
    turtle.forward(height/(math.sin(angleRad)))
    turtle.left(180-angle)
    




#
# if necessary, you can define more functions below 
#

fan("triangle", 100, 200, 20, 0, 360, "blue")
    