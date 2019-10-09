# -*- coding:utf-8 -*-
# @Time : 2019/5/22 18:41
# @Author : 17895
# @File : exts.py
# @Software: PyCharm
# @note：数据库对应框架


# 一套ORM框架。 ORM的好处：可以让我们操作数据库跟操作对象是一样的，非常方便
from flask_sqlalchemy import SQLAlchemy
from flask import Flask

app = Flask(__name__)
db = SQLAlchemy()
