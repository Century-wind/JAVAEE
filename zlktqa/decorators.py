# -*- coding:utf-8 -*-
# @Time : 2019/5/24 15:45
# @Author : 17895
# @File : decorators.py
# @Software: PyCharm
# @note：装饰器

from functools import wraps
from flask import session, redirect, url_for


#登录限制装饰器
def login_required(func):

    @wraps(func)
    def wrapper(*args, **kwargs):
        if session.get('user_id'):
            return func(*args, **kwargs)
        else:
            return redirect(url_for('login'))

    return wrapper
