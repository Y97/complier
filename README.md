先运行mian.java，生成词法分析结果，然后运行SyntaxAnalyzer.java得到语法分析结果

一个简单的词法+语法分析程序
另增加了识别int36，36进制数的功能
(即类似数字+字母为常数，字母+数字为标识符，如5T为常数)
其中，各个文件的功能如文件名，SyntaxAnalyzer.java一个为语法分析，剩下为词法分析

程序运行：
解压后放到D盘根目录即可直接运行
若需换地址，则要更改文件读写的四个位置
1、GetLetter.java  20行左右
2、Write.java  9行左右
3、SyntaxAnalyzer.java 29行左右
4、SyntaxAnalyzer.java 89行左右
