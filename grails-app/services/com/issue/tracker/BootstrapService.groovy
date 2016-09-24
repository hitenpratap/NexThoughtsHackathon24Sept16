package com.issue.tracker

import com.issue.tracker.label.Label
import grails.transaction.Transactional

@Transactional
class BootstrapService {

    def createLabels(){
        println "**************creating Labels**************"
    }
}
