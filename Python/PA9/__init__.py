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
#    general image filter operation using filter operation supplied by op
#    arguments are given in paraam supplied as a dictionary data structure 
#
def filter(ifile, op, param = {}, ofile='') : 
    import cImage 
    OldImage      = cImage.FileImage(ifile)
    width         = OldImage.getWidth()
    height        = OldImage.getHeight()
    myimagewindow = cImage.ImageWin(str(op),width*2,height)
    OldImage.setPosition(0,0)
    OldImage.draw(myimagewindow)
    NewImage = op(OldImage,width,height,param)         # filer function call
    NewImage.setPosition(width,0)
    NewImage.draw(myimagewindow)
    if ofile != '' : 
        NewImage.save(ofile)
    myimagewindow.exitOnClick()


#
# grayscale filter 
#
def grayScale(im, width, height, param=()):
    import cImage
    newImage = cImage.EmptyImage(width,height)

    for row in range(height):
        for col in range(width):
            old_pixel=im.getPixel(col,row)
            red=old_pixel.getRed()
            green=old_pixel.getGreen()
            blue=old_pixel.getBlue()
            gray=(red+green+blue)//3
            new_pixel=cImage.Pixel(gray,gray,gray)
            newImage.setPixel(col,row,new_pixel)
        
    return newImage


#
# color negative filter 
#
def negative(im, width, height, param={}) : 
    import cImage
    newImage = cImage.EmptyImage(width,height)

    for row in range(height):
        for col in range(width):
            old_pixel=im.getPixel(col,row)
            red=255 - old_pixel.getRed()
            green=255 - old_pixel.getGreen()
            blue=255 - old_pixel.getBlue()
            new_pixel=cImage.Pixel(red,green,blue)
            newImage.setPixel(col,row,new_pixel)
        
    return newImage

#
# add noise
#
def noise (im, width, height, param={}) : 
    import cImage, random
    newImage = cImage.EmptyImage(width,height)
    
    mag = param.get('Mag', 0.05)
    magType = param.get('Type', "multiplicative")
    for row in range(height):
        for col in range(width):
            old_pixel=im.getPixel(col,row)
            if magType == "additive" :
                red=old_pixel.getRed() + (random.random() - 0.5) * mag * 255 
                green=old_pixel.getGreen() + (random.random() - 0.5) * mag * 255
                blue=old_pixel.getBlue() + (random.random() - 0.5) * mag * 255
            else :
                red=old_pixel.getRed() * (1 + (random.random() - 0.5) * mag)
                green=old_pixel.getGreen() * (1 + (random.random() - 0.5) * mag)
                blue=old_pixel.getBlue() * (1 + (random.random() - 0.5) * mag)
            rgbList = [int(red), int(green), int(blue)]
            for i in range(len(rgbList)) :
                rgb = rgbList[i]
                if rgb < 0 :
                    rgb = 0
                elif rgb > 255 :
                    rgb = 255
                rgbList[i] = rgb
            new_pixel=cImage.Pixel(rgbList[0], rgbList[1], rgbList[2])
            newImage.setPixel(col,row,new_pixel)
    return newImage


#
#
# average filter 
#
def average (im, width, height, param={}) :
    import cImage
    newImage = cImage.EmptyImage(width,height)
    
    filterWidth = param.get('FilterWidth', 3)
    filterHeight = param.get('FilterHeight', 3)
    heightBuffer = height - filterHeight
    widthBuffer = width - filterWidth
    for row in range(height):
        for col in range(width):
            if col < filterWidth or col > widthBuffer or row < filterHeight or row > heightBuffer:
                old_pixel = im.getPixel(col, row)
                newImage.setPixel(col, row, old_pixel)
            else :
                minWidth = col - filterWidth//2
                maxWidth = col + filterWidth//2
                minHeight = row - filterHeight//2
                maxHeight = row + filterHeight//2
                rlist = []
                glist = []
                blist = []
                for width in range(minWidth, maxWidth) :
                    pixel = im.getPixel(width, row)
                    rlist.append(pixel.getRed())
                    glist.append(pixel.getGreen())
                    blist.append(pixel.getBlue())
                for height in range(minHeight, maxHeight) :
                    pixel = im.getPixel(col, height)
                    rlist.append(pixel.getRed())
                    glist.append(pixel.getGreen())
                    blist.append(pixel.getBlue())
                r = 0
                g = 0
                b = 0
                for i in rlist :
                    r += i
                for i in glist :
                    g += i
                for i in blist:
                    b += i
                r = r//len(rlist)
                g = g//len(glist)
                b = b//len(blist)
                new_pixel=cImage.Pixel(r, g, b)
                newImage.setPixel(col,row,new_pixel)
                
    return newImage



#
# median filter 
#
def median (im, width, height, param={}) : 
    import cImage
    newImage = cImage.EmptyImage(width,height)
    
    filterWidth = param.get('FilterWidth', 3)
    filterHeight = param.get('FilterHeight', 3)
    heightBuffer = height - filterHeight
    widthBuffer = width - filterWidth
    for row in range(height):
        for col in range(width):
            if col < filterWidth or col > widthBuffer or row < filterHeight or row > heightBuffer:
                old_pixel = im.getPixel(col, row)
                newImage.setPixel(col, row, old_pixel)
            else :
                minWidth = col - filterWidth//2
                maxWidth = col + filterWidth//2
                minHeight = row - filterHeight//2
                maxHeight = row + filterHeight//2
                rlist = []
                glist = []
                blist = []
                for width in range(minWidth, maxWidth) :
                    pixel = im.getPixel(width, row)
                    rlist.append(pixel.getRed())
                    glist.append(pixel.getGreen())
                    blist.append(pixel.getBlue())
                for height in range(minHeight, maxHeight) :
                    pixel = im.getPixel(col, height)
                    rlist.append(pixel.getRed())
                    glist.append(pixel.getGreen())
                    blist.append(pixel.getBlue())
                rlist = sorted(rlist)
                glist = sorted(glist)
                blist = sorted(blist)
                r = int(sum(rlist[(len(rlist)//2)-1:(len(rlist)//2)+1]))//2
                g = int(sum(glist[(len(glist)//2)-1:(len(glist)//2)+1]))//2
                b = int(sum(blist[(len(blist)//2)-1:(len(blist)//2)+1]))//2
                
                new_pixel=cImage.Pixel(r, g, b)
                newImage.setPixel(col,row,new_pixel)
                
    return newImage
#filter("observatory.gif", grayScale, {}, "grayScale.gif")
#filter("ucsb256.gif", negative, {}, "negative2.gif")
#filter("ucsb256.gif", noise, {'Mag' : .5}, "noise.gif")
#filter("ucsb256.gif", average, {'FilterWidth' : 5, 'FilterHeight' : 5}, "avergae.gif")
#filter("ucsb256.gif", median, {'FilterWidth' : 5, 'FilterHeight' : 5}, "median.gif")
# if necessary, you can define more functions below 
def copy(im, width, height, param={}) :
    import cImage
    NewImage = cImage.EmptyImage(width,height)
    for row in range(height) :
        for col in range(width) :
            NewImage.setPixel(col, row, cImage.Pixel(im.getPixel(col,row).getRed(),
            im.getPixel(col,row).getGreen(), 
            im.getPixel(col,row).getBlue()))
    return NewImage

filter("observatory.gif", copy, {}, "copy.gif")