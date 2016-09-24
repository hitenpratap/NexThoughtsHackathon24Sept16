package com.issue.tracker

import grails.util.GrailsUtil
import org.codehaus.groovy.grails.web.context.ServletContextHolder

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
            path = ServletContextHolder.getServletContext().getRealPath("/") + "ScrapyFiles"
        } else {
            path = '/home/ubuntu/ScrapyFiles'
        }
        return path
    }

    public static String getStaticPath() {
        return ServletContextHolder.getServletContext().getRealPath("/")
    }

}
