install.packages('HistData')
data(GaltonFamilies, package = "HistData")
menheight <- subset(GaltonFamilies,GaltonFamilies$gender=="male")
hist(menheight$childHeight, xlab ='Child Height', main = 'Histogram of Child Height')
hist(menheight$father, xlab ='Fathers Height', main = 'Histogram of Father Height')
mean(menheight$childHeight)
sd(menheight$childHeight)
mean(menheight$father)
sd(menheight$father)
plot (menheight$father, menheight$childHeight, xlab = 'Father height', ylab = 'Child Height', main = 'Scatterplot of Father Height and Child Height')
fit1=lm(childHeight~father, data = menheight)
summary(fit1)
abline(fit1)
