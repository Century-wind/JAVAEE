#!project-name:汇率兑换
# -*- coding: utf-8 -*-
# author：蚢 time:2019/2/28

def moneyConvert( ):
    if money[-1] in ['￥']:
        dollar = (eval(money[0:-1]))/6
        print("{0}转换后为：{1}美元".format(money, dollar))
    elif money[-1] in ['$']:
        RMB = 6 * eval(money[0:-1])
        print("{0}转换后为:{1}人民币".format(money, RMB))
    else:
        print("输入格式错误！")

Money = input("请输入货币数值与货币符号：")
moneyConvert(Money)
