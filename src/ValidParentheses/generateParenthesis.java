package ValidParentheses;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

	/*
	 * 二叉树的方式实现
	 * 左支－－添加左括号，右支－－添加右括号
	 * 因为要保证括号成对出现，所以当字符串中“(”数量 多于 “)”数量时候才扩展右子树
	 */
    public static List<String> generateParenthesis1(int n) {
    	List<String> rs = new ArrayList<String>();
    	generate1(rs,"",n,n);
    	return rs;
    }
	
	private static void generate1(List<String> rs, String ans, int l, int r) {
		if(l==0 && r==0){
			rs.add(ans);
			return;
		}
		if(l != 0)
			generate1(rs, ans+"(", l-1, r);//left
		if(l < r)
			generate1(rs, ans+")", l, r-1);//right
	
	}

	public static void main(String[] args) {
		List<String> rs1 = generateParenthesis1(3);
		List<String> rs2 = generateParenthesis2(3);
		
		System.out.println("rs1 : ");
		for(String tmp : rs1)
			System.out.println(tmp);
		
		System.out.println("rs2 : ");
		for(String tmp : rs2)
			System.out.println(tmp);
	}

	public static List<String> generateParenthesis2(int n) {
		List<String> rs = new ArrayList<String>();
    	generate2(rs,"",0,0,n);
    	return rs;	
    }

	private static void generate2(List<String> rs, String s, int l, int r, int n) {
		if(l==n && r==n){
			rs.add(s);
			return;
		}
		if(l<n)
			generate2(rs, s+"(", l+1, r, n);
		if(l>r)
			generate2(rs, s+")", l, r+1, n);
	}

}
