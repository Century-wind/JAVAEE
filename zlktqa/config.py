# -*- coding:utf-8 -*-
# @Time : 2019/5/22 18:29
# @Author : 17895
# @File : config.py
# @Software: PyCharm
# @note：配置文件

import os


DEBUG = True

# 随机码
SECRET_KEY = os.urandom(24)

DIALECT = 'mysql'
DRIVER = 'pymysql'
USERNAME = 'root'
PASSWORD = 'hang'
HOST = '127.0.0.1'
PORT = '3306'
DATABASE = 'flask_pro'
SQLALCHEMY_DATABASE_URI = "{}+{}://{}:{}@{}:{}/{}?charset=utf8"\
    .format(DIALECT, DRIVER, USERNAME, PASSWORD, HOST, PORT, DATABASE)

SQLALCHEMY_TRACK_MODIFICATIONS = False
