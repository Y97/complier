/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;


public class IsDelimiter {//界符 () [] {} , ;
	public int isdelimiter(String s){//判断是否为界符，是，则返回种别码;不是，则返回0.
		String[] isdelimiter = {"{","}","(",")","[","]",";",":",","};
		for(int i = 0; i < isdelimiter.length; i++)
		{
			if(s.equals(isdelimiter[i]))
				return 1;
		}
		return -1;
	}
}
