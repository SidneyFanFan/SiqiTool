package com.siqi.structure;

/**
 * Triple structure holds generic type A,B,C objects as elements.
 * 
 * @author Sidney Fan
 * 
 * @param <A>
 *            generic type A
 * @param <B>
 *            generic type B
 * @param <C>
 *            generic type C
 */
public class Triple<A, B, C> {
	private A arg1;
	private B arg2;
	private C arg3;

	/**
	 * Constructor of triple structure.
	 * 
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public Triple(A arg1, B arg2, C arg3) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}

	public A getArg1() {
		return arg1;
	}

	public B getArg2() {
		return arg2;
	}

	public C getArg3() {
		return arg3;
	}

	public void setArg1(A arg1) {
		this.arg1 = arg1;
	}

	public void setArg2(B arg2) {
		this.arg2 = arg2;
	}

	public void setArg3(C arg3) {
		this.arg3 = arg3;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s, %s)", arg1.toString(), arg2.toString(), arg3.toString());
	}

}
