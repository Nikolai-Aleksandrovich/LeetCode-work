import pandas as pd
import numpy as np
import re
import csv
import sys




filename = 'D:/csv divide area/labelFactory/label.weighted.csv'
with open('input.csv', 'w', newline='') as g:
        writer = csv.writer(g)
        for row in datas:
                writer.writerow()

        # 还可以写入多行
        writer.writerows(datas)

with open(filename,newline='') as f:
    reader = csv.reader(f)
    first_id = 99
    second_id = 0
    first_value = 0
    second_value = 0
    for row in reader:
        second_id =  row[0]
        if first_id == second_id:
            second_value = first_value+second_value
            if second_value > 0:
                row[0]=
                writer.writerow(row)



        first_id = row[0]









        print(row)
        #print(second_row)



