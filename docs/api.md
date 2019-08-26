
# 接口文档
所有接口均采用RESTful风格<br>
[RESTful风格说明](https://blog.csdn.net/qiansg123/article/details/80130206)

## 全局响应状态码

| 状态码        | 说明   | 
| --------   | -----:  | 
| 500    | 基本异常，服务器故障| 
| 404        |   请求异常无法找到   |  
| 405        |    请求方法不支持  |
| 403    | 请求参数异常| 


## 已实现接口列表
1. 用户注册
2. 注册

## 接口

----

### 注册
#### 功能说明
用户注册，普通用户和管理员用户均采用使用同样的注册入口
#### 请求说明
> Post <br>
/user/register
#### 请求参数
字段名       |字段类型       |字段说明
------------|-----------|-----------
name       |string        |姓名
username       |string        |用户名，作为登录账号使用（学号）
password       |string        |密码
#### 返回结果
```json
{"code":0,"message":"注册失败,用户名被占用","data":null}

```
```json
{"code":1,"message":"注册成功 ","data":null}
```

----

### 登录
#### 功能说明
用户登录，登录成功后返回用户信息
#### 请求说明
> Post <br>
/user/login
#### 请求参数
字段名       |字段类型       |字段说明
------------|-----------|-----------
username       |string        |用户名，登录账号
password       |string        |密码
#### 返回结果
登录成功
```json
{
	"code": 1,
	"message": "登录成功",
	"data": {
		"username": "test",
		"name": "test",
		"role": "系统管理员",
		"roleMsg": "拥有最权限"
	}
}

```
```json
{"code":0,"message":"账号或密码错误","data":null}
```
```json
{"code":0,"message":"账号不存在","data":null}
```