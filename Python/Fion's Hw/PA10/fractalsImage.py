

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
import colorsys
"""
END OF HEADER SECTION
"""



"""
Mandelbrot set z <- z^2 + c includes all c, |c| < 2 such that lim|z| < 2, where z0 =(0,0)
"""
def mandelbrot(res = 600, ofile = '') :
    import cImage,math,colorsys
    myimagewindow = cImage.ImageWin("mandelbrot", res, res)
    numOfColors = 50
    scale = 1.0/(res/3)
    center = (2.2,1.5)
    image = cImage.EmptyImage(res, res)

    palette = [0] * numOfColors
    for i in range(numOfColors):
        f = 1-abs((float(i)/numOfColors-1)**15)
        r, g, b = colorsys.hsv_to_rgb(.66+f/3, 1-f/2, f)
        palette[i] = (int(r*255), int(g*255), int(b*255))

    for x in range(res):
        for y in range(res):
            re = (x * scale - center[0])
            im = (y * scale - center[1])

            c=re+im*1j
            z = 0
            v = 1
            for i in range(128):
                if abs(z) > 2.0:
                    v = i/129
                    break
                z = z * z + c
            rgb = palette[int(v * (numOfColors-1))]
            pixel = cImage.Pixel(rgb[0],rgb[1],rgb[2])
            image.setPixel(x,y,pixel)

    image.setPosition(0, 0)
    image.draw(myimagewindow)
    if ofile != '' :
        image.save(ofile)
    myimagewindow.exitOnClick()

"""
Julia set z <- z^2 + c for a given complex c, includes all z0, |z0|<2 such that lim|z|<2
e.g., try c = (-0.123, 0.745), c = (-0.75,0), c = (-0.391, -0.587)
"""
def julia(c, res = 600, ofile = '') :
    import cImage,math,colorsys
    myimagewindow = cImage.ImageWin("julia", res, res)
    numOfColors = 50
    scale = 1.0/(res/3)
    center = (1.5,1.5)
    image = cImage.EmptyImage(res, res)

    palette = [0] * numOfColors
    for i in range(numOfColors):
        f = 1-abs((float(i)/numOfColors-1)**15)
        r, g, b = colorsys.hsv_to_rgb(.66+f/3, 1-f/2, f)
        palette[i] = (int(b*255), int(g*255), int(r*255))

    c = complex(c[0], c[1])
    for x in range(res):
        for y in range(res):
            re = (x * scale - center[0])
            im = (y * scale - center[1])

            z=re+im*1j
            v = 1
            for i in range(128):
                if abs(z) > 2.0:
                    v = i/129
                    break
                z = z * z + c
            rgb = palette[int(v * (numOfColors-1))]
            pixel = cImage.Pixel(rgb[0],rgb[1],rgb[2])
            image.setPixel(x,y,pixel)

    image.setPosition(0, 0)
    image.draw(myimagewindow)
    if ofile != '' :
        image.save(ofile)
    myimagewindow.exitOnClick()



#
# if necessary, you can define more functions below
#
c = (-0.75, 0)
julia(c, res = 400)
mandelbrot(res = 400)
