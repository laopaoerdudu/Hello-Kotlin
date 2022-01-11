package com.hk.best;

import java.lang.reflect.Field;

import androidx.annotation.Keep;

@Keep
public class ReflectWrapper {

    // just for finding the java.lang.Class classLoader field's offset
    @Keep
    private Object classLoaderOffsetHelper;

    static {
        try {
            Class<?> VersionClass = Class.forName("android.os.Build$VERSION");
            Field sdkIntField = VersionClass.getDeclaredField("SDK_INT");
            sdkIntField.setAccessible(true);
            int sdkInt = sdkIntField.getInt(null);
            if (sdkInt >= 28) {
                Field classLoader = ReflectWrapper.class.getDeclaredField("classLoaderOffsetHelper");
                long classLoaderOffset = UnSafeWrapper.getUnSafe().objectFieldOffset(classLoader);
                if (UnSafeWrapper.getUnSafe().getObject(ReflectWrapper.class, classLoaderOffset) instanceof ClassLoader) {
                    Object originalClassLoader = UnSafeWrapper.getUnSafe().getAndSetObject(ReflectWrapper.class, classLoaderOffset, null);
                } else {
                    throw new RuntimeException("not support");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
