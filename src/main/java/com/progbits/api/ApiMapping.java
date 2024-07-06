package com.progbits.api;

import com.progbits.api.exception.ApiClassNotFoundException;
import com.progbits.api.exception.ApiException;
import com.progbits.api.model.ApiClasses;
import com.progbits.api.model.ApiObject;
import java.util.Map;

/**
 *
 * @author scarr
 */
public interface ApiMapping {
    String getTargetClass();
    void setTargetClass(String _targetClass);
    
    String getSourceClass();
    void setSourceClass(String _sourceClass);
    
    boolean setScript(String script) throws ApiException;
    
    ApiClasses getInModels();
    void setInModels(ApiClasses inModels);
    
    ApiClasses getOutModels();
    void setOutModels(ApiClasses outModels);
    
    ApiMapping getClone();
    
    ApiObject map(ApiObject in, Map<String, Object> args) throws ApiException, ApiClassNotFoundException;
}
