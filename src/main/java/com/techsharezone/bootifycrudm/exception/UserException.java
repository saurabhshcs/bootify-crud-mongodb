package com.techsharezone.bootifycrudm.exception;
/*
 * @created 12/11/2020 -14:38
 * @project bootify-crud-mongodb
 * @author  saurabhshcs
 */

public class UserException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public UserException(String s) {
        super((s));
    }
}
