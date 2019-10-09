# -*- coding:utf-8 -*-
# @Time : 2019/5/22 18:53
# @Author : 17895
# @File : manage.py
# @Software: PyCharm
# @note：命令


from flask_script import Manager
# 数据库的迁移与映射，将我们修改过的ORM模型映射到数据库中
from flask_migrate import Migrate, MigrateCommand
from zlktqa import app
from exts import db
from models import User, Question, Answer
# manage连接数据库

# 初始化
manager = Manager(app)

# 使用Migrate绑定
migrate = Migrate(app, db)

# 添加迁移脚本命令
manager.add_command('db', MigrateCommand)

if __name__ == '__main__':
    manager.run()
