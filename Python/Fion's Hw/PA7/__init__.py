
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


"""
process move database 
"""
def query(fname) :
    validIO = False
    while (not validIO) :
        try :
            file = open(fname)
        except FileNotFoundError:
                print(fname + " cannot be opened")
        else :
            validIO = True
    actorDict = {}
    movieDict = {}
    for line in file:
        lst = line.split(",") #splits each new line by commas
        str1 = lst[len(lst) - 1]
        str2 = str1.replace("\n", "") #removes \n the new line command from the last element of the list
        lst[len(lst) - 1] = str2
        lst2 = lst[1:] #makes a new list that doesn't include the first element which was the actor's name
        actorDict[lst[0]] = lst2 #makes dictionary with actor's name as key and movies as values
         
    for keys in actorDict :
        lst3 = actorDict[keys] #retrieves movies that an actor has been in
        for movie in lst3 :
            lst4 = movieDict.get(movie, []) #retrieves actors that an existing movie in the moviesDict or returns an empty list if the movie doesn't exist
            lst4.append(keys) #adds the actor to the movie
            movieDict[movie] = lst4 #sets the movieDictionary with a movie as the key and actors as values
    
    while True :
        s = input("movies [1] or actresses/actors search [2], or quit [0]: ")
        try :
            i = int(s)
        except ValueError :
            print("choice not recognized, default to movie search")
            i = 1
        if (i < 0 or i > 2) :
            print("choice not recognized, default to movie search")
            i = 1
        if (i == 1) :
            movieKeysList = movieDict.keys()
            movieList = []
            s = input("enter the name of the movie: ")
            s = s.lower()
            for movies in movieKeysList :
                s1 = str(movies).lower()
                if (s in s1) :
                    movieList.append(movies)
            if not movieList:
                print("sorry, no movie with such a name found")
            else :
                for movies in movieList :
                    print ("the following actresses/actors are in the movie " + movies + ": " + str(movieDict[movies]))
        elif (i == 2) :
            actorKeysList = actorDict.keys()
            actorList = []
            s = input("enter the name of the actor/actress: ")
            s = s.lower()
            for actors in actorKeysList :
                s1 = str(actors).lower()
                if (s in s1) :
                    actorList.append(actors)
            if not actorList :
                print("sorry, no actress/actor with such a name found")
            else :
                for actors in actorList :
                    print ("the following movies :" + str(actorDict[actors]) + "starred " + actors)
        elif (i == 0) :
            break
                
    
    


query("movies.txt")
#
# if necessary, you can define more functions below 
#