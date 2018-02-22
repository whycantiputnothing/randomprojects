
#
# draw a num of shape (rectangle or triangle)
# from angle1 to angle2 using color
#
def fan(shape,width,height,num,angle1,angle2,color='red') :
    turtle.shape("turtle")
    turtle.pencolor(color)
    b = ((angle2-angle1)/num)
    x = angle1
    if (shape is rectangle) :
        for i in range(num + 1) :
            rectangle(turtle,0, 0, 100, 200, x)
            x += b

    elif (shape is triangle) :
        for i in range(num + 1) :
            triangle(turtle,0, 0, 100, 200, x)
            x += b

    turtle.done()


#
# draw a single rectangle
# the height dimension is at the specified angle
#
def rectangle(turtle, xpos, ypos, width, height, angle) :
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

if __name__ == '__main__':
    import turtle             # Allows us to use turtles

#    wn = turtle.Screen()      # Creates a playground for turtles
#    alex = turtle.Turtle()    # Create a turtle, assign to alex
#    alex.speed(1)
#    alex.shape("turtle")

#    rectangle(alex, 0, 0, 50, 100, 90)

#    triangle(alex, 50, 100, 100, 200, 0)

    fan(rectangle, 100, 200, 20, 0, 360, color = "blue")
 #   fan("triangle", 100, 200, 10, 0, 180, color = "red")



#    wn.mainloop()             # Wait for user to close window
