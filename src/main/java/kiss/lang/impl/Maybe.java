package kiss.lang.impl;

import kiss.lang.Type;

/**
 * Maybe type, represents the type of values that may be either null or non-null values of another type
 * 
 * @author Mike
 *
 */
public class Maybe extends Type{	
	private Type type;

	private Maybe(Type t) {
		this.type=t;
	}
	
	public Type create(Type t) {
		if (t instanceof NullType) {
			return NullType.INSTANCE;
		}
		return new Maybe(t);
	}

	@Override
	public boolean checkInstance(Object o) {
		return (o==null)||type.checkInstance(o);
	}

	@Override
	public Class<?> getJavaType() {
		return type.getJavaType();
	}
}
