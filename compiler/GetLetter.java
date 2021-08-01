/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GetLetter {

    public String buffer = null;//存储读取出来的字符串

	public String read()
	{//读取文件
		String path = "E:/作业/2020秋/实践/compiler/1/text.txt";
		try//异常处理
		{
			FileReader filepath = new FileReader(path);
			
			BufferedReader bufferedreader = new BufferedReader(filepath);
			String Str;
			while((Str = bufferedreader.readLine()) != null)//按行读取
			{
				if(buffer == null)//将读取出来的信息存入buffer中，这里因为buffer原本为空，如果都用buffer += Str;则buffer中第一位为null
				{
					buffer = Str;
				}
				else
				{
					buffer += Str;
				}
				buffer += "\n";
			}
			bufferedreader.close();
		}catch(IOException e)//异常处理
		{
			e.printStackTrace();
		}
		return buffer;
	}

}
