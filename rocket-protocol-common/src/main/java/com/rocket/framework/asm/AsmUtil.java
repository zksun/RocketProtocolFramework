package com.rocket.framework.asm;

/**
 * Created by zjsun on 2019/7/11.
 */
public class AsmUtil {

    private final static AsmUtil instance = new AsmUtil();

    private AsmUtil() {
    }

    private String constructMethodDescInner(Class<?> returnType,
                                            Class<?>... paramType) {
        StringBuilder methodDesc = new StringBuilder();
        methodDesc.append('(');
        for (int i = 0; i < paramType.length; i++) {
            methodDesc.append(getDescInner(paramType[i]));
        }
        methodDesc.append(')');
        if (returnType == Void.class) {
            methodDesc.append("V");
        } else {
            methodDesc.append(getDescInner(returnType));
        }
        return methodDesc.toString();
    }

    private String getTypeInner(Class<?> type) {
        if (type.isArray()) {
            return "[" + getDesc(type.getComponentType());
        } else {
            if (!type.isPrimitive()) {
                String clsName = type.getCanonicalName();

                if (type.isMemberClass()) {
                    int lastDot = clsName.lastIndexOf(".");
                    clsName = clsName.substring(0, lastDot) + "$"
                            + clsName.substring(lastDot + 1);
                }
                return clsName.replaceAll("\\.", "/");
            } else {
                return getPrimitiveLetterInner(type);
            }
        }
    }

    private String getDescTypeInner(Class<?> type) {
        if (type.isPrimitive()) {
            if (int.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Integer.class);
            } else if (boolean.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Boolean.class);
            } else if (char.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Character.class);
            } else if (byte.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Byte.class);
            } else if (short.class.getTypeName().equals(Short.class)) {
                return getDescTypeInner(Short.class);
            } else if (float.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Float.class);
            } else if (long.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Long.class);
            } else if (double.class.getTypeName().equals(type.getTypeName())) {
                return getDescTypeInner(Double.class);
            }
            throw new IllegalArgumentException("the type is wrong");
        } else {
            return getTypeInner(type);
        }
    }

    private String getClassNameInner(Class<?> clazz) {
        String className = clazz.getCanonicalName();
        className = className.replace('.', '_');
        className += "_asm_invoker";
        return className;
    }

    private String getPrimitiveLetterInner(Class<?> type) {
        if (Integer.TYPE.equals(type)) {
            return "I";
        } else if (Void.TYPE.equals(type)) {
            return "V";
        } else if (Boolean.TYPE.equals(type)) {
            return "Z";
        } else if (Character.TYPE.equals(type)) {
            return "C";
        } else if (Byte.TYPE.equals(type)) {
            return "B";
        } else if (Short.TYPE.equals(type)) {
            return "S";
        } else if (Float.TYPE.equals(type)) {
            return "F";
        } else if (Long.TYPE.equals(type)) {
            return "J";
        } else if (Double.TYPE.equals(type)) {
            return "D";
        }

        throw new IllegalStateException("Type: " + type.getCanonicalName()
                + " is not a primitive type");
    }


    private String getDescInner(Class<?> type) {
        if (type.isPrimitive()) {
            return getPrimitiveLetter(type);
        } else if (type.isArray()) {
            return "[" + getDesc(type.getComponentType());
        } else {
            return "L" + getType(type) + ";";
        }
    }


    public static String getClassName(Class<?> clazz) {
        if (null == clazz) {
            throw new NullPointerException("clazz cannot be null");
        }
        return instance.getClassNameInner(clazz);
    }

    public static String getPrimitiveLetter(Class<?> type) {
        if (null == type) {
            throw new NullPointerException("type cannot be null");
        }
        return instance.getPrimitiveLetterInner(type);
    }

    public static String getDescType(Class<?> type) {
        if (null == type) {
            throw new NullPointerException("type cannot be null");
        }
        return instance.getDescTypeInner(type);
    }

    public static String getType(Class<?> type) {
        if (null == type) {
            throw new NullPointerException("type cannot be null");
        }
        return instance.getTypeInner(type);
    }

    public static String getDesc(Class<?> type) {
        if (null == type) {
            throw new NullPointerException("type cannot be null");
        }
        return instance.getDescInner(type);
    }


}
