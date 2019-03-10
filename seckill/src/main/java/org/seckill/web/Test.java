package org.seckill.web;
class Country { 
	String name; 
	void value(){
		name = "China";
		} 
	} 
class City extends Country { 
	String name; 
	void value() { 
		name = "Shanghai"; 
		super.value(); //调用父类的方法 
		System.out.println(name);
		System.out.println(super.name); 
		}
	
}
public class Test{
	public static void main(String[] args) { 
		City c=new City();
		c.value();
		}
	
}

//class Person { 
//		private int age = 10;
//		public Person(){ 
//			System.out.println("初始化年龄："+age); 
//			} 
//		public int GetAge(int age){
//			this.age = age; 
//			return this.age;
//		}
//}
//
//public class Test {
//	public static void main(String[] args) { 
//		Person Harry = new Person(); 
//		System.out.println("Harry's age is "+Harry.GetAge(12));
//		} 
//}