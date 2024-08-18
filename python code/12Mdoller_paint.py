# import colorgram
# colour=colorgram.extract('hirst.jpg',12)
# print(colour)
# rgb_colour=[]
# for c in colour:
#     r=c.rgb.r
#     g=c.rgb.g
#     b=c.rgb.b
#     rgb_colour.append((r,g,b))
    
# print(rgb_colour)
import turtle as t
colorL = [(201, 161, 112), (128, 168, 193), (69, 101, 138),  (186, 147, 165), (221, 203, 128), (149, 81, 62)]

import random
t.colormode(255)
tim=t.Turtle()
tim.speed('fastest')
tim.setheading(225)
tim.penup()
tim.hideturtle()
tim.forward(360)
tim.setheading(0)
for j in range(5):
    for i in range(10):
        tim.dot(20,random.choice(colorL))
        tim.forward(50)
    tim.setheading(90)
    tim.forward(50)
    tim.setheading(180)
    
    tim.forward(50)
    for i in range(10):
        tim.dot(20, random.choice(colorL))
        tim.forward(50)
    tim.setheading(90)
    tim.forward(50)
    tim.setheading(0)
    tim.forward(50)



screen=t.Screen()
screen.exitonclick()