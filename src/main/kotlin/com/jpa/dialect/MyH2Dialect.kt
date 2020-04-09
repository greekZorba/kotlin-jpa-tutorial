package com.jpa.dialect

import org.hibernate.dialect.H2Dialect
import org.hibernate.dialect.function.StandardSQLFunction
import org.hibernate.type.StandardBasicTypes

class MyH2Dialect : H2Dialect() {
    init {
        registerFunction("group_concat", StandardSQLFunction("group_concat", StandardBasicTypes.STRING))
    }
}