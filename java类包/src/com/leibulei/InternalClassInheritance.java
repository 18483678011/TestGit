package com.leibulei;

public class InternalClassInheritance {
  
	
	class lls {
	
}
}

class but extends InternalClassInheritance.lls{
	public but(InternalClassInheritance d) {
		d.super();
	}
}