import csv


def hottest_city(csv_filename):
    fp = open(csv_filename)
    read = csv.reader(fp)
    lst1 = []
    lst2 = []
    maxvalue = 0
    for row in read:
        for value in row[1:]:
            print(value)
            lst2.append(value)
        maxvalue = max(lst2)
        print(maxvalue)

        if maxvalue in row:
            lst1.append(row[0])
        maxvalue = float(maxvalue)

    return maxvalue, lst1
hottest_city("max_temp.csv")