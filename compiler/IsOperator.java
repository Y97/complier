/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

public class IsOperator {//操作符
	public int isoperator(String s){//判断是否为操作符,是，则返回种别码;不是，则返回0.
		String[] reserve = {"+","-","*","/","++","--","+=","-=","*=","="};
		for(int i = 0; i < reserve.length; i++)
		{
			if(s.equals(reserve[i]))
				return 1;
		}
		return -1;
	}
	
}
