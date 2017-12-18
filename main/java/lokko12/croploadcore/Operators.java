package lokko12.croploadcore;

public class Operators {
	
	public static boolean XOR (boolean a, boolean b) {
	    return (a ^ b);
	}
	public static boolean XNOR (boolean a, boolean b) {
	    return !(a ^ b);
	}
	public static boolean OR (boolean a, boolean b) {
	    return (a || b);
	} 
	public static boolean AND (boolean a, boolean b) {
	    return (a && b);
	}
	public static boolean NOR (boolean a, boolean b) {
	    return !(a || b);
	}
	public static boolean NAND (boolean a, boolean b) {
	    return !(a && b);
	}
	public static boolean NOT (boolean a) {
	    return !a;
	}
}
