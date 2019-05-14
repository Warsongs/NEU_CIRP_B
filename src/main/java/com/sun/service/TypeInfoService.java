package com.sun.service;


import java.util.List;

public interface TypeInfoService {
    public int postTypeInfo(TypeInfo typeInfo);

    public TypeInfo getTypeInfoById(Integer id);

    public List<TypeInfo> getTypeInfosByCondition(TypeInfoExample example);

    public int putTypeInfo(TypeInfo typeInfo);

    public int deleteTypeInfo(Integer id);

}
