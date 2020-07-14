#!/usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Yuyuan Huang'


def is_singlee(single, age, name):
    if single == 'N':
        print("You need a women's touch");
    else:
        if int(age) < 18:
            print("you are too young to understand what the love means")
            isabove18 = False
        else:
            print(
                "For my dearest darling, treasured, cherished " + name + "whom I worship. With respect, adoration, "
                                                                         "admiration, kisses, gratitude, best wishes,"
                                                                         " and love from HYY to " + name)
            isabove18 = True
    return


age = input("input your age,my lover,eg:18     ")
single = input("Are you in a relationship? :Y/N     ")
name = input("what's your name,darling?     ")

is_singlee(single, age, name)
