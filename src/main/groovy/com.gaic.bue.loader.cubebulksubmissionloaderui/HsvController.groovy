package com.gaic.bue.loader.cubebulksubmissionloaderui

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@SuppressWarnings("GroovyUnusedDeclaration")
class HsvController implements ApplicationListener<ApplicationReadyEvent> {

    @Value('${com.gaic.bue.loader.cubebulksubmissionloaderui.url}')
    String serviceUrl

    @Value('${com.gaic.bue.loader.cubebulksubmissionloaderui.jobStartUrl}')
    String jobStartUrl

    @Value('${com.gaic.bue.loader.cubebulksubmissionloaderui.jobStatusUrl}')
    String jobStatusUrl

    @Value('${com.gaic.bue.loader.cubebulksubmissionloaderui.jobInfoUrl}')
    String jobInfoUrl

    @Override
    void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
        log.info "Using Historical Session Validator at: $serviceUrl"
        log.info "Start jobs at: $jobStartUrl"
        log.info "Query job status at: $jobStatusUrl"
        log.info "Query job info at: $jobInfoUrl"
    }

    @RequestMapping(path = '/apply', method = RequestMethod.POST)
    ResponseEntity applyForJob(@RequestBody Map<String, Object> jobDetail) {
        log.debug("Building: $jobDetail")
    }

    @RequestMapping(path = '/jobStatus', method = RequestMethod.POST)
    ResponseEntity jobStatus(@RequestBody Map<String, Object> jobDetail) {
        log.debug("Query job status for: $jobDetail")
    }

    @RequestMapping(path = '/jobInfo', method = RequestMethod.POST)
    ResponseEntity jobInfo(@RequestBody Map<String, Object> jobDetail) {
        log.debug("Query job info for: $jobDetail")
    }
}