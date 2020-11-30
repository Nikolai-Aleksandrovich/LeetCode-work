import csv


def max_city_temp(csv_filename, city):
    fp1 = open(csv_filename, 'r')
    read = csv.reader(fp1)
    lst1 = []
    for row in read:
        lst1.append(row)
    print(lst1)
    temp = lst1[1:]
    lst2 = []
    for row in temp:
        newlst = []
        for index in range(1, len(row)):
            newlst.append(float(row[index]))
        maxval = max(newlst)
        tempmatch = [row[0], maxval]
        lst2.append(tempmatch)
    maxtemp = dict(lst2)

    newmaxtemp = maxtemp.get(city)
    return float(newmaxtemp)
print(max_city_temp('max_temp.csv','Perth'))