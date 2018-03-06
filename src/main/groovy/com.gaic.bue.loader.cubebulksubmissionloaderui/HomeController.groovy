package com.gaic.bue.loader.cubebulksubmissionloaderui

import groovy.util.logging.Slf4j
import org.springframework.boot.Banner
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@Slf4j
@SuppressWarnings("GroovyUnusedDeclaration")
class HomeController {

    @RequestMapping("/")
    def home() {
        log.info "Going home!"
        new ModelAndView(
                "index",
                [bootVersion  : Banner.package.implementationVersion,
                 groovyVersion: GroovySystem.version,
                 details: jobDetail])
    }

    private static getJobDetail() {
        Map details = [
                'Job Name':[desc:'Job Name', default:''],
                'meta.schema':[desc:'DB schema', default:'tpollack'],
                'meta.prefix':[desc:'DB table prefix', default:'A1_'],
                'meta.status':[desc:'Quote or Submission', default:'Submission'],
                'ds_cube.schema':[desc:'CUBE schema', default:'RAMT'],
                'cube.ncube.version':[desc:'NCube UD.REF.APP version', default:'1.102.0'],
                'cube.ncube.branch':[desc:'NCube UD.REF.APP branch', default:'HEAD']
        ]
        return details
    }
}
