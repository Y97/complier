/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

public class Analysis {//分析数字串、字符串等串
	IsReserve isReserve = new IsReserve();
	IsRelationship isRelationship = new IsRelationship();
	IsOperator isOperator = new IsOperator();
	public int typenum = 0;
	public int analysis(int p,String s){
		int flag1 = 0;//标志变量
		int flag2 = 0;
		if(isReserve.isreserve(s) >= 0)//是否为保留字
		{
			//isReserve.isreserve(s);//看看
			typenum = 1;
		}
		else if(isRelationship.isrelationship(s) >= 0)
		{
			//isRelationship.isrelationship(s);
			typenum = 3;
		}
		else if(isOperator.isoperator(s) >= 0)
		{
			//isOperator.isoperator(s);
			typenum = 2;
		}
		else
		{
			for(int k = 0;k<s.length();k++)//是否为数字串
			{
				flag1 = 0;
				//String str = null;
				if(s.substring(k,k+1).compareTo("0") >= 0 && s.substring(k,k+1).compareTo("9") <= 0)
				{
					flag1 = 1;//如果一直是数字，则为真
					if(k < (s.length()-1))
					{
						//System.out.println(s.charAt(k+1));
						if(Character.isLetter(s.charAt(k+1)))
							flag2=1;
					}
				}
				else if(k < (s.length()-1))
				{
					if(Character.isLetter(s.charAt(k)) && Character.isDigit(s.charAt(k+1)))
					{

						//if(s.substring(k+1,k+2).compareTo("0") >= 0 && s.substring(k+1,k+2).compareTo("9") <= 0)
						//{
							
						//}
							flag2 = 1;
					}
				}
//				else if(s.charAt(k)>='a' && s.charAt(k)<='z')
//					flag1 = 1;
//					if(k<s.length()-1)
//					{
//						str+=s.substring(k,k+1);
//						if(Character.isLetterOrDigit(s.charAt(k+1)))
//							str += s.substring(k,k+1);
//							for(int i=0;i<100;i++)
//							{
//								if(flag.length>0)
//									if(str.equals(flag[i]))
//										flag2=1;
//								else
//									flag[tmp++]=str;
//							}
//					}
				else
				{
					flag1 = 0;
					break;//当有一个不为数字，则为假
				}
			}
			if(flag1 == 1 && flag2 == 0)
				typenum = 5;//十进制
			else if(flag1 == 0 && flag2 == 0)
				typenum = 6;//标识符
			else if(flag2 == 1)
				typenum = 7;//int36
			//System.out.println("1:"+flag1+"\t2:"+flag2);
		}
		return typenum;
	}

}
