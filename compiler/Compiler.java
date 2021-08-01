package compiler;


public class Compiler {
	public void Test(){//词法分析主程序
		GetLetter getLetter = new GetLetter();
		IsDelimiter isDelimiter = new IsDelimiter();
		Analysis isNum = new Analysis();
		IsOperator isOperator = new IsOperator();
		IsRelationship isRelationship = new IsRelationship();

		String type[] = {" 无"," 关键字"," 算术符号"," 关系判断符"," 分界符","常数"," 标识符","常数"};
		//下标识别，0表示无种类，1代表关键字，2代表算术符号，3代表关系运算符，4代表分界符，5代表数字，6代表标识符
		getLetter.read();//读取文件
		String Str1 = null;
		int p = 0,typenum1 = 0;
		int num = 0;
		boolean flag1 = true,flag2 = false;
		int tmp=0;
		String a[]=new String[100];
		while(flag1)
		{	
			flag2 = false;//标识关系两个字节的关系运算符
			Str1 = null;//存储提取的一段字符串
			num = 0;//num为0，则没进入到循环，最后进入Analysis
			while(!getLetter.buffer.substring(p,p+1).equals(" ") && !getLetter.buffer.substring(p,p+1).equals("\n"))
			//读取buffer中的字符，直到遇到换行符或者空格
			{
				if(isDelimiter.isdelimiter(getLetter.buffer.substring(p,p+1)) > 0)//遇到分界符
				{
					typenum1 = 4;
					num = isDelimiter.isdelimiter(getLetter.buffer.substring(p,p+1));
					break;
				}
				if(isRelationship.isrelationship(getLetter.buffer.substring(p,p+1)) > 0)//遇到关系运算符
				{
					typenum1 = 3;
					if(isRelationship.isrelationship(getLetter.buffer.substring(p,p+2)) > 0)//遇到两个字节的关系运算符
					{
						flag2 = true;
						num = isRelationship.isrelationship(getLetter.buffer.substring(p,p+2));
					}
					else//一个字节的关系运算符
						num = isRelationship.isrelationship(getLetter.buffer.substring(p,p+1));
					break;
				}
				if(isOperator.isoperator(getLetter.buffer.substring(p,p+1)) > 0)//遇到算术运算符号
				{
					typenum1 = 2;
					if(isOperator.isoperator(getLetter.buffer.substring(p,p+2)) > 0)//两字节的算术运算符
					{
						flag2 = true;
						num = isOperator.isoperator(getLetter.buffer.substring(p,p+2));
					}
					else//一个字节的算术运算符
						num = isOperator.isoperator(getLetter.buffer.substring(p,p+1));
					break;
				}
				
				if(getLetter.buffer.substring(p,p+1).equals("#"))//遇到结束符号
				{			
					flag1 = false;//flag1表示着是否遇到结束符号
					break;
				}
				if(Str1 == null)//这是为了区别当Str1为null时，使用+=会造成字符串中多处一个null
					Str1 = getLetter.buffer.substring(p,p+1);//空，跳过，下一个
				else
					Str1 += getLetter.buffer.substring(p,p+1);//非空，往下读取
				p++; 
				
			}
			//System.out.println(Str1);
			if(Str1 != null)//当提取的字符串不为空时
			{
				isNum.analysis(p,Str1);//分析字符串
				if(isNum.typenum==7)//36进制，数字+字母 或者 字母+数字	识别出已有过字母+数字之后，为标识符
				{
					for(int i=0;i<tmp;i++)
					{
						if(Str1.equals(a[i]) && Character.isLetter(Str1.charAt(0)))//数字+字母肯定是int36，若字母开头且出现过，变成标识符
							isNum.typenum=6;
					}
					a[tmp++] = Str1;
				}
				System.out.println(Str1+"\t"+type[isNum.typenum]);
			}
			if(num > 0)//当为特殊符号时(分界符，算术符号，关系运算符)
			{
				if(flag2)//两个字节的关系运算符
				{
					System.out.println(getLetter.buffer.substring(p,p+2)+"\t"+type[typenum1]);
					p++;
				}
				else
					System.out.println(getLetter.buffer.substring(p,p+1)+"\t"+type[typenum1]);
			}
			p++;
		}
		//	System.out.println(getLetter.buffer);
		System.out.println("END");
	}
}
