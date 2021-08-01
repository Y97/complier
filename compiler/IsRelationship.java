/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;


public class IsRelationship {//
	public int isrelationship(String s){//判断是否为关系符,是，则返回种别码;不是，则返回0.
		String[] reserve = {"<",">",">=","<=","!=","!"};//"!"、"="，为了适配"!="和"=="
		for(int i = 0; i < reserve.length; i++)
		{
			if(s.equals(reserve[i]))
				return 1;
		}
		return -1;
	}
}
