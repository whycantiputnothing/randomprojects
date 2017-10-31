def grayScale(im, width, height, param=()):
    import cImage
    newImage = cImage.EmptyImage(width,height)

    for row in range(height):
        for col in range(width):
            old_pixel=im.getpixel(col,row)
            red=old_pixel.getRed()
            green=old_pixel.getgreen()
            blue=old_pixel.getblue()
            gray=(red+green+blue)//3
            new_pixel=cImage.pixel(gray,gray,gray)
            newImage.setpixel(col,row,new_pixel)
        return newImage
