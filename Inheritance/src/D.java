
/*
 * public class D extends InheritNonStaticmenbers{
 * 
 * public static void main(String[] args) { D d=new D();
 * System.out.println(d.i); d.test(); } }
 */

/*
 * public class D extends Staticmemberdonotinherit{
 * 
 * public static void main(String[] args) { D d=new D();
 * System.out.println(d.i);//It give us feel of (Staticmemberdonotinherit.i)
 * Converson takes place
 * 
 * } }
 */

/*
 * public class D{
 * 
 * public static void main(String[] args) { 
 * SubClass d=new SubClass();
 * System.out.println(d.i);
 * 
 * } }
 */

/*
 * public class D extends InheritMethods{
 * 
 * public static void main(String[] args) { D d=new D(); d.Test(); d.Xray();
 * 
 * } }
 */

/*
 * public class D extends MultipleClass{
 * 
 * 
 * }
 */

public class D extends ParentChildMethod{
	
	public void Test1()
	{
		System.out.println("Test1");
	}
	public static void main(String[] args) {
		D d=new D();
		d.Test();
		d.Test1();
	}
}