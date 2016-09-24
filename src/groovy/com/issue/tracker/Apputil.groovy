package com.issue.tracker

import grails.util.GrailsUtil
import org.codehaus.groovy.grails.web.context.ServletContextHolder

import java.text.SimpleDateFormat

class AppUtil {

    static Boolean save(def object) {
        Boolean result = false
        if (object.validate() && !object.hasErrors() && object.save(flush: true)) {
            result = true
        } else {
            object.errors.allErrors.each {
                println '----------------------' + it

            }
            result = false

        }
        return result
    }

    public static String getStaticResourcesDirPath() {
        String path = '';
        if (GrailsUtil.developmentEnv) {
            path = ServletContextHolder.getServletContext().getRealPath("/") + "test-files"
        } else {
            path = '/home/ubuntu/ScrapyFiles'
        }
        return path
    }

    public static String getStaticPath() {
        return ServletContextHolder.getServletContext().getRealPath("/")
    }

    public static def customDateFormat(String format, String dateInString) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String convertCurrentDate = dateInString;
        Date date = new Date();
        date = sdf.parse(convertCurrentDate);
        return date
    }
}
