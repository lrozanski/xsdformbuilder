package org.xsdforms.xsdformbuilder.factory;

import org.xsdforms.xsdformbuilder.exception.FormBuilderRuntimeException;

import java.lang.reflect.ParameterizedType;

public class AbstractFactory<T extends AbstractFactory> implements Singleton<T> {

    private T instance;

    protected AbstractFactory() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getInstance() {
        try {
            if (instance == null) {
                instance = (T) ((Class) ((ParameterizedType) this.getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
            }
            return instance;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new FormBuilderRuntimeException(e);
        }
    }
}
