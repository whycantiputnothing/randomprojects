

def rectangle (turtle,xpos,ypos,width,height,angle):
    import turtle
    turtle.speed(20)
    turtle.penup()
    turtle.setpos(xpos,ypos)
    turtle.setheading(angle)
    turtle.pendown()
    turtle.forward(.5*width)
    turtle.left(90)
    turtle.forward(height)
    turtle.left(90)
    turtle.forward(width)
    turtle.left(90)
    turtle.forward(height)
    turtle.left(90)
    turtle.forward(.5*width)

def triangle (turtle,xpos,ypos,width,height,angle):
    import turtle
    import math
    turtle.speed(20)
    turtle.penup()
    turtle.setpos(xpos, ypos)
    turtle.setheading(angle)
    turtle.pendown()
    turtle.shape("turtle")
    turtle.forward(width/2)
    angle = math.degrees(math.atan(height/(width/2)))
    angleRad = math.radians(angle)
    turtle.left(180-angle)
    turtle.forward(height/(math.sin(angleRad)))
    turtle.left(2*angle)
    turtle.forward(height/(math.sin(angleRad)))
    turtle.left(180-angle)
    turtle.forward(width/2)


def fan(shape,width,height,num=10,angle1=0,angle2=180,color='red') :
    import turtle
    
    turtle.clearscreen()
    turtle.color(color)
    angle1=angle1-90
    angle2=angle2-90
    b = ((angle2-angle1)/num)
    x = angle1
    if (shape is rectangle) :
        for i in range(num + 1) :
            rectangle(turtle,0, 0, width, height, x)
            x += b
    else:
        if (shape is triangle):
            for i in range(num+1):
                triangle(turtle,0,0,width,height,x)
                x+=b
    turtle.done()
#fan(rectangle, 10, 200)
fan(triangle, 20, 100, 5, 180, 270, 'blue')
fan(shape, width, height, num, angle1, angle2, color)
